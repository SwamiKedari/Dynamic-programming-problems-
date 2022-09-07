public class unboundedKnapSack {
    static int knapSack(int n,int w,int[] val,int[] wt)
    {
        // code here
        // this problem is similar to the combination of the knapsack and the coin change problem
        // we will use the dynamic programming to solve this problem
        // we have to find the total value of the knapsack if each value is supplied infinite number of times


        // the space optimised version of this code will satisfy the complexities
        int[] prev=new int[w+1];
        int[] curr=new int[w+1];

        for(int i=wt[0];i<=w;i++){
            prev[i]=(i/wt[0])*val[0];
        }
        for(int i=1;i<n;i++){
            for(int k=0;k<=w;k++){
                int notTake=prev[k];
                int take=Integer.MIN_VALUE;
                if(k>=wt[i]){
                    take=curr[k-wt[i]]+val[i];
                }
                curr[k]=Math.max(take,notTake);
            }

            prev=curr;
            curr=new int[w+1];
        }


        // we can further optimise the space optimization to use just one array rather than using 2 arrays
        // since prev[k-wt[i]] was updated already during the traversal , the answer will not change
        // we are converting the prev to current in the same loop and using it for next computations simultaneously
        prev=new int[w+1];
        for(int i=wt[0];i<=w;i++){
            prev[i]=(i/wt[0])*val[0];
        }
        for(int i=1;i<n;i++){
            for(int k=0;k<=w;k++){
                int notTake=prev[k];
                int take=Integer.MIN_VALUE;
                if(k>=wt[i]){
                    take=prev[k-wt[i]]+val[i];
                }
                prev[k]=Math.max(take,notTake);
            }


        }

        return prev[w];

    }

    // the below code will be used as a template to use it in the iterative part

    static int getMax(int[] val,int[] wt,int i,int w,int[][] dp){
        if(i==0){
            if(w>=wt[i]){
                return (w/wt[i])*val[i];
            }
            return 0;
        }
        if(dp[i][w]>0){
            return dp[i][w];
        }
        int notTake=getMax(val,wt,i-1,w,dp);
        int take=Integer.MIN_VALUE;
        if(w>=wt[i]){
            take=getMax(val,wt,i,w-wt[i],dp)+val[i];
        }
        dp[i][w]= Math.max(take,notTake);
        return dp[i][w];
    }
}
