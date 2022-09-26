public class totalIncreasingSubsequencesInArray {
    // in this question, we are asked to find the total increasing subsequences in the array with the numbers equal to between 0 and 9
    // this can be solved in the similar way we used to find the longest increasing subsequence in the arary
    // the only difference is an extra index which is 0 when array dont have any element and 1 when the array has atleast one element
    // link: https://practice.geeksforgeeks.org/problems/count-increasing-subsequences3134/1?page=3&difficulty[]=0&category[]=Dynamic%20Programming&sortBy=submissions
    public static long countSub(int arr[], int n)
    {
        // Your code goes here
        // we need to find the increasing subsequences in the array
        long[][][] dp=new long[n][11][2];

        return count(arr,n-1,10,0,dp);
    }
    public static long count(int[] a,int i,int pr,int taken, long[][][] dp){
        if(i<0 && taken==1){
            return 1;
        }
        else if(i<0 && taken==0){
            return 0;
        }
        if(dp[i][pr][taken]>0){
            return dp[i][pr][taken];
        }
        long notTake = count(a,i-1,pr,taken,dp);
        long take=0;
        if(pr>a[i]){
            take=count(a,i-1,a[i],1,dp);
        }
        dp[i][pr][taken]=notTake + take;
        return dp[i][pr][taken];
    }
}
