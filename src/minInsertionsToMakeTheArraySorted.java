public class minInsertionsToMakeTheArraySorted {
    // in this question, we want to find the maximum insertions that we need to make in the array of the elements such that the resulting array is sorted
    // link : https://practice.geeksforgeeks.org/problems/minimum-insertions-to-sort-an-array0535/1?page=3&difficulty[]=0&category[]=Dynamic%20Programming&sortBy=submissions
    public int minInsertions(int arr[], int n)
    {
        //code here.
        // find the longest increasing subsequence
        // then get the value of the ans as the N - lis
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            max=Math.max(arr[i],max);

        }
        int[][] dp=new int[n][max+2];
        return n- getmin(arr,n-1,max+1,dp);
    }

    public int getmin(int[] a,int i,int pre,int[][] dp){
        if(i==0){
            if(a[i]<=pre){
                return 1;
            }
            return 0;
        }
        if(dp[i][pre]>0){
            return dp[i][pre];
        }

        int notTake = getmin(a,i-1,pre,dp);
        int take=Integer.MIN_VALUE;
        if(pre>=a[i]){
            take=1+ getmin(a,i-1,a[i],dp);
        }
        dp[i][pre]=Math.max(take,notTake);
        return dp[i][pre];
    }
}
