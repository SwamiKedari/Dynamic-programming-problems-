public class reachAGivenScore {
    public long count(int n) {
        // we have to find the total distinct combinations of forming n using the numbers 3 , 5 , 10
        // we will do it using the getComb function which is the memoization part of the recursion
        // The tabulation and space optimisation part remaining
        // we can use the coin change problem to solve this question
        int[] a={3,5,10};
        long[][] dp=new long[3][n+1];
        return getComb(a,dp,2,n);
    }
    public long getComb(int[] a,long[][] dp,int i,int n){
        if(i==0){
            if(n%a[i]==0){
                return 1;
            }
            return 0;
        }
        if(dp[i][n]>0){
            return dp[i][n];
        }
        long notTake=getComb(a,dp,i-1,n);
        long take=0;
        if(n>=a[i]){
            take=getComb(a,dp,i,n-a[i]);
        }
        dp[i][n]=take+notTake;
        return dp[i][n];
    }
}
