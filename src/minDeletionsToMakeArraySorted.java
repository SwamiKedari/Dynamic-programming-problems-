public class minDeletionsToMakeArraySorted {
    // we have to delete the minimum elements from the array so that the array that we get will have the elements in the strictly increasing order
    public int minDeletions(int arr[], int n)
    {
        //code here.
        // the answer for this problem will be the array length - the longest increasing subsequeunce
        int pre=1000;
        int[][] dp=new int[n][1001];
        return n-getMax(arr,n-1,pre,dp);
    }

    public int getMax(int[] arr,int i,int pre,int[][] dp){
        if(i==0 && arr[i]<pre){
            return 1;
        }
        else if (i==0) {
            return 0;
        }
        if(dp[i][pre]>0){
            return dp[i][pre];
        }
        int notTake=getMax(arr,i-1,pre,dp);
        int take=Integer.MIN_VALUE;
        if(arr[i]<pre){
            take=getMax(arr,i-1,arr[i],dp) +1 ;
        }
        dp[i][pre]= Math.max(notTake,take);
        return dp[i][pre];
    }
}
