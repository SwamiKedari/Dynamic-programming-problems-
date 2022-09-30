public class optimalWalk {
    // the question is to take the minimum path from the n to the zero where to go one step a cost is required and to go to n/2, b cost is required and he can go either to n-1,n+1,n/2

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
