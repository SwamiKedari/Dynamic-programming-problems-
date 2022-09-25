public class adjacentsNotAllowed {
    // in this question , we have to find the maximum sum when the elements are not adjacent in any way left,right,diagonally
    // link : https://practice.geeksforgeeks.org/problems/adjacents-are-not-allowed3528/1?page=2&difficulty[]=0&category[]=Dynamic%20Programming&sortBy=submissions
    static int maxSum(int n, int mat[][])
    {
        // code here
        // we need to change the index by 2 and for the each column in the matrix , we will take the max element among the 2
        int[] dp=new int[n];
        return getMax(mat,n-1,dp);
    }

    static int getMax(int[][] mat,int i,int[] dp){
        if(i<0){
            return 0;
        }
        if(i==0){
            return Math.max(mat[0][0],mat[1][0]);
        }
        if(dp[i]>0){
            return dp[i];
        }
        int notTake = getMax(mat,i-1,dp);
        int take = Math.max(mat[0][i],mat[1][i]) + getMax(mat,i-2,dp);
        dp[i]=Math.max(notTake,take);
        return dp[i];
    }
}
