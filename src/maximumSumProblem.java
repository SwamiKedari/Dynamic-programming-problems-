public class maximumSumProblem {
    // in this problem, we have to find the maximum sum that is obtained when the number n is divided by 2, 3 or 4 and this parts are added
    // geeks for geeks link : https://practice.geeksforgeeks.org/problems/maximum-sum-problem2211/1?page=2&difficulty[]=0&category[]=Dynamic%20Programming&sortBy=submissions
    public int maxSum(int n)
    {
        //code here.
        // if the numbers are divisible by 2 , 3 and 4 , that means that the number will be divided into the smaller number than that number
        int[] dp=new int[n+1];
        if(n==0){
            return 0;
        }
        return sum(n,dp);
    }
    public int sum(int n,int[] dp){
        if(n==1){
            return 1;
        }
        if(n==2 || n==3 || n==4){
            return n;
        }
        if(dp[n]>0){
            return dp[n];
        }

        dp[n]=Math.max(sum(n/2,dp)+sum(n/4,dp)+sum(n/3,dp),n);
        return dp[n];
    }
    public boolean isDiv(int n){
        return n%2==0 && n%3==0 && n%4==0;
    }
}
