
import java.util.*;
public class gridObstacles {
    // in this question , we will find the total ways in the grid when we have obstacles in middle
    /* this question is similar to the last question totalUniquePaths
    only difference is that it has the dead cell which has value -1

     */


    public static void main(String[] args){
        Scanner s = new Scanner(System.in );
        int m=s.nextInt();
        int n=s.nextInt();
        int[][] a = new int[m][n];
        System.out.println("Enter the indexes which have a dead cell : ");
        int t = s.nextInt();
        while(t-->0){
            int i=s.nextInt();
            int j=s.nextInt();
            a[i][j]=-1;
        }
        int[][] dp = new int[m][n];
        System.out.println("Ans using memoization : ");
        System.out.println(countPathsWithObstacles(a,dp,m-1,n-1)+"\n");

        // tabulation code for this question
        dp=new int[m][n];
        dp[0][0]=1;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int k1=0,k2=0;
                if(i==0 && j==0){
                    continue;
                }
                if(a[i][j]==-1){
                    dp[i][j]=0;
                    continue;
                }
                if(i!=0){
                    k1=dp[i-1][j];
                }
                if(j!=0){
                    k2=dp[i][j-1];
                }
                dp[i][j]=k1+k2;
            }
        }
        System.out.println("Ans using tabulation :");
        System.out.println(dp[m-1][n-1]+"\n");


        // the space optimization code for this question
        int[] prev=new int[n];
        int c=1;
        int ans = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){

                ans=prev[j]+c;
                if(a[i][j]==-1){
                    ans=0;
                }
                c=ans;
                prev[j]=ans;
            }
            c=0;
        }
        System.out.println("Ans using space optimization :");
        System.out.println(ans);

    }

    // this function below is the memoization + recursion code for the array

    public static int countPathsWithObstacles(int[][] a,int[][] dp,int i,int j){
        if(i>=0 && j>=0 && a[i][j]==-1){
            dp[i][j]=0;
            return 0;
            // here all the paths from the dead cell should be considered as not counted since it is a dead cell

        }
        if(i==0 && j==0){
            return 1;
        }
        if(i<0 || j<0){
            return 0;
        }
        if(dp[i][j]>0){
            return dp[i][j];
        }
        int up=countPathsWithObstacles(a,dp,i-1,j);
        int left=countPathsWithObstacles(a,dp,i,j-1);
        dp[i][j]=up+left;
        return up+left;
    }
}
