public class pathsToReachOrigin {
    // we want to find the total number of paths that can be taken from the point (n,m) to the point (0,0) such that the traversal can be only to the points n-1,m and n,m-1
    public static int ways(int n, int m)
    {
        // complete the function
        // we will use dp to solve this problem
        int[][] dp=new int[n+1][m+1];
        for(int i=0;i<=n;i++){
            dp[i][0]=1;
        }
        for(int j=0;j<=m;j++){
            dp[0][j]=1;
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                dp[i][j]=dp[i-1][j]%1000000007 + dp[i][j-1]%1000000007;

            }
        }
        return dp[n][m]%1000000007;
    }
    public static int getcount(int[][] dp,int i,int j){
        if(i==0 && j==0){
            return 1;
        }
        if(dp[i][j]>0){
            return dp[i][j];
        }
        if(i>0 && j>0){
            dp[i][j]= getcount(dp,i-1,j)+getcount(dp,i,j-1);
            return dp[i][j];
        }
        else if(i==0){
            dp[i][j]=1;
            return dp[i][j];
        }
        else{
            dp[i][j]=1;
            return dp[i][j];
        }

    }
}
