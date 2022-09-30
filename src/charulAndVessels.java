public class charulAndVessels {
    // Function for finding maximum and value pair
    /*Charul has been given a task by Ishaan. He challenges him to fill a large container of capacity K liters. Charul has N vessels with him with different capacities.
    The capacities of the vessels are given by an array A. The condition is that the container should be filled up to the brim but no water should be wasted in overflowing. Also, the vessels can't be filled partially.
    Determine if Charul can fill up the container with the given conditions or not.
    Assume that Charul has an unlimited supply of water.*/


    public static boolean vessel (int arr[], int n, int k) {
        //Complete the function
        // this question is similar to the knapsack or the minimum coin change problem
        boolean[][] dp=new boolean[n][k+1];
        boolean[][] visited=new boolean[n][k+1];
        return isfilled(arr,n-1,k,dp,visited);
    }
    public static boolean isfilled(int[] a,int i,int k,boolean[][] dp,boolean[][] visited){
        if(k==0){
            return true;
        }
        if(i==0){
            if(k%a[i]==0){
                return true;
            }
            return false;
        }
        if(visited[i][k]){
            return dp[i][k];
        }
        boolean nottake=isfilled(a,i-1,k,dp,visited);
        boolean take=false;
        if(a[i]<=k){
            take=isfilled(a,i,k-a[i],dp,visited);
        }
        dp[i][k]= take | nottake;
        visited[i][k]=true;
        return dp[i][k];
    }
}
