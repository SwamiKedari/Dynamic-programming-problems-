import java.util.*;
public class minimumPathSumFromTopLeftToBottomRight{
    /*
    in this question , we have to find the minimum path sum that can be get if we travel from top left to bottom right
    the minimum possible path sum for a particular index will occur when we take the minimum sum till that index plus that index
    We will use a dynamic programming based function to solve this problem

     */
    public static void main(String[] swami){
        Scanner s = new Scanner(System.in);
        int n=s.nextInt();
        int m=s.nextInt();
        int[][] a =new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                a[i][j]=s.nextInt();
            }
        }
        int[][] dp = new int[n][m];
        System.out.println("This is the memoization solution :");
        System.out.println(getMinPath(a,dp,n-1,m-1));
        // this was the memoization solution

        // the tabulation + space optimization solution for this problem is as follows :
        int[] prev=new int[m]; // this is a array which stores the entire previous row in it
        // we use this row to get access to i-1 indexes
        int c=a[0][0];
        int ans=0;
        System.out.println();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 && j==0){
                    prev[j]=c;
                    continue;
                }
                if(i==0){
                    ans=c+a[i][j];
                }
                else {
                    ans = Math.min(prev[j], c) + a[i][j];
                }
                prev[j]=ans;
                c=ans;

            }
            System.out.println(Arrays.toString(prev));
            c=a[i][0];
        }
        System.out.println("This is the space optimized answer for the problem : ");
        System.out.println(ans);


    }
    public static int getMinPath(int[][] a,int[][] dp,int i,int j){
        if(i==0 && j==0){
            dp[i][j]=a[i][j];
            return a[i][j];
        }
        if(i==-1 || j==-1){
            return Integer.MAX_VALUE;
        }
        if(dp[i][j]>0){
            return dp[i][j];
        }
        int a1=getMinPath(a,dp,i-1,j);
        int a2=getMinPath(a,dp,i,j-1);
        dp[i][j]= Math.min(a1,a2)+a[i][j];

        return dp[i][j];
    }
}
