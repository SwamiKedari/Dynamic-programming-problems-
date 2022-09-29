public class minimuStepsToMinimizeN {
    public int minSteps(int n)
    {
        // link: https://practice.geeksforgeeks.org/problems/minimum-steps-to-minimize-n-as-per-given-condition0618/1?page=2&difficulty[]=0&category[]=Dynamic%20Programming&sortBy=submissions
        // Your code goes here
        // for every step we have three options, either we can reduce it by 1, divide it by 2 or divide it by 3
        int[] dp=new int[n+1];
        return getmin(n,dp);
    }

    public int getmin(int n,int[] dp){
        if(n==1){
            return 0;
        }
        if(dp[n]>0){
            return dp[n];
        }
        int take2=Integer.MAX_VALUE;
        int take3=Integer.MAX_VALUE;
        if(n%2==0){
            take2=getmin(n/2,dp)+1;
        }
        if(n%3==0){
            take3=getmin(n/3,dp)+1;
        }
        int take1=getmin(n-1,dp)+1;

        dp[n]=Math.min(take1,Math.min(take2,take3));
        return dp[n];
    }
}
