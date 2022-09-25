public class maximiseDotProduct {
    public int maxDotProduct(int n, int m, int[] a,int[] b)
    {
        // Your code goes here
        // we will make an new array which will contain the elements of the b array along with some zeros
        int k=n-m;
        int[][] c=new int[n][m];
        return getmax(a,b,n-1,m-1,n-m,c);
    }

    public int getmax(int[] a,int[] b,int j,int i,int k,int[][] dp){
        if(i<0 || j<0){
            return 0;
        }
        if(dp[j][i]>0){
            return dp[j][i];
        }
        int take= a[j]*b[i]+getmax(a,b,j-1,i-1,k,dp);
        int notTake=Integer.MIN_VALUE;
        if(k>0){
            notTake=getmax(a,b,j-1,i,k-1,dp);
        }
        dp[j][i]= Math.max(notTake,take);
        return dp[j][i];
    }
}
