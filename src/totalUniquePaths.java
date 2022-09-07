import java.util.*;
public class totalUniquePaths {
    /*
    the indexes here will be (i,j) which are the cell nos
    we then explore all the paths
    and then keep a count of all the paths from the top left to the bottom right

     */
    public static void main(String[] args){
        // we will show the tabulation part of the code over here
        Scanner s = new Scanner(System.in);
        int m=s.nextInt() ,n=s.nextInt();

        int[][] dp=new int[m][n];
        dp[0][0]=1;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int k1=0 , k2=0;
                if(i==0 && j==0){
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
        dp=new int[m][n];
        System.out.println("Ans due to memoization : ");
        System.out.println(countPaths(dp,m-1,n-1)+"\n");

        // tabulation time complexity o(m*n)
        // space complexity o(m*n)

        System.out.println("Ans due to tabulation : ");
        System.out.println(dp[m-1][n-1]+"\n");

        // the space optimization code for the following problem is as follows
        // for space optimization , we will require 1 variable storing the last column cell and one variable which stores the entire previous row array

        int c=1,ans=0;
        int[] prevRow=new int[n];
        // for
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                ans=prevRow[j]+c;
                c=ans;
                prevRow[j]=ans;
            }
            c=0;
        }
        System.out.println("Ans due to space optimization :");
        System.out.println(prevRow[n-1]);
        // the time complexity in space optimization will be o(m*n)
        // the space complexity in space optimization is o(n)


    }
    // this function is the recursive function which computes the total paths ,
    // now we will use memoization to remove overlapping subproblems

    public static int countPaths(int[][] dp,int i,int j){
        if(i==0 && j==0){
            return 1;
        }
        if(i<0 || j<0){
            return 0;
        }
        if(dp[i][j]>0){
            return dp[i][j];
        }
        int up=countPaths(dp,i-1,j);
        int left=countPaths(dp,i,j-1);
        dp[i][j]=up+left;
        return up+left;
    }
}
