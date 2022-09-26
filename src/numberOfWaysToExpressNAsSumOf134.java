public class numberOfWaysToExpressNAsSumOf134 {
    // we need to find the number of ways in which we can split n as the sum of 1, 3 ,and 4 considering the order as well
    static Long countWays(int n) {
        // code here
        // we want to find the number of ways to express n as the sum of 1 , 3,and 4
        long[] dp=new long[n+1];
        // return getcount(n,dp);
        if(n==0 || n==1 || n==2){
            return (long)1;
        }
        if(n==3){
            return (long)2;
        }
        if(n==4){
            return (long)3;
        }
        dp[0]=1;
        dp[1]=1;
        dp[2]=1;
        dp[3]=2;
        dp[4]=4;
        for(int i=5;i<=n;i++){
            dp[i]=dp[i-1]%1000000007+dp[i-3]%1000000007+dp[i-4]%1000000007;
        }
        return dp[n]%1000000007;
    }
    static long getcount(int n,long[] dp){
        if(n==0){
            return 1;
        }
        if(n==1 || n==2){
            return 1;
        }
        if(n==3){
            return 2;
        }
        if(n<0){
            return 0;
        }
        if(dp[n]>0){
            return dp[n];
        }

        long take = getcount(n-1,dp) + getcount(n-3,dp) + getcount(n-4,dp);
        dp[n]=take;
        return dp[n];
    }
}
