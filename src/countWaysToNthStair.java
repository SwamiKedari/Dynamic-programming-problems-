public class countWaysToNthStair {
    //Function to count number of ways to reach the nth stair
    //when order does not matter.
    Long countWays(int n)
    {
        // your code here
        // we will use a algorithm which is very similar to the coin change problem with the coins as 1 and 2 only to get answer for this problem
        // since the order does not matter in this case we will treat this problem as the coin change problem with the coins having value 1 and 2 only and we will assume the infinite supply of this coins to get the answer
        // since the order do not matter, we will use the 2 steps first and then one step , ie we will start from the back of the array {1,2} and treat it as the coin change problem 
        long[][] dp=new long[n+1][2];
        int[] coins={1,2};
        return getcount(n,coins,1,dp);
    }

    long getcount(int n,int[] coins,int i,long[][] dp){
        if(n==0){
            return 1;
        }
        if(n<0 || i<0){
            return 0;
        }
        if(dp[n][i]>0){
            return dp[n][i];
        }
        long notTake= getcount(n,coins,i-1,dp);
        long take=0;
        if(n>=coins[i]){
            take = getcount(n-coins[i],coins,i,dp);
        }
        dp[n][i]=take + notTake;
        return dp[n][i];
    }
}
