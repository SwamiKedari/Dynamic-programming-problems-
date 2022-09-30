public class optimalWalk {
    static long optimalWalkFromNToZero(long n,long a,long b)
    {
        long[] dp=new long[(int)n+1];
        dp[0]=0;
        dp[1]=a;
        for(int i=2;i<=n;i++){
            dp[i]=Math.min(dp[(i+1)/2]+b+i%2*a,dp[i-1]+a);
            // System.out.println(dp[i]);
        }
        return dp[(int)n];

    }
}
