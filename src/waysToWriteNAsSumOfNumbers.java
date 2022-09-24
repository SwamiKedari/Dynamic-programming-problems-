public class waysToWriteNAsSumOfNumbers {
    // expressed as the sum of two or more integers
    // in this problem , we have to find the total number of ways in which we can express the number n eg 5->1+4 , 1+1+3 etc ,
    int countWays(int n)
    {

        // your code here
        // we need to find the total number of ways to write n as the sum
        // this problem is the dp based problem which includes the coin change with infinite supply
        // first we will start from the end and we will store the elements in the dp array
        if(n==1){
            return 0;
        }
        int[][] dp=new int[n][n+1];
        return getcount(n-1,n,dp);
    }

    int getcount(int i,int n,int[][] dp){
        if(i==1){
            return 1;
        }
        if(dp[i][n]>0){
            return dp[i][n];
        }
        int notTake=getcount(i-1,n,dp);
        int take=0;
        if(i<=n){
            take=getcount(i,n-i,dp);
        }
        dp[i][n]= take+notTake;
        return dp[i][n];
    }
}
