public class minimumCostToFillBags {

    public int minimumCost(int[] cost ,int n,int w)
    {
        // Your code goes here
        // we have to minimise the cost to fill the weight in the bag
        int[][] dp=new int[n][w+1];
        int k= getMin(cost,dp,n-1,w);
        if(k>=(int)(Math.pow(10,8))){
            return -1;
        }
        return k;
        // this is the question submitted in gfg
        // we can further optimise it using the tabulation and space optimisation


    }
    public int getMin(int[] a,int[][] dp,int i,int w){

        if(i==0){
            if(w==0){
                return 0;
            }
            if(w%(i+1)==0 && a[0]>0){
                return w*a[0];
            }
            return (int)(Math.pow(10,9));
        }
        if(dp[i][w]>0){
            return dp[i][w];
        }

        int notTake=getMin(a,dp,i-1,w);
        int take=(int)(Math.pow(10,9));
        if(w>=(i+1) && a[i]>0){
            take=getMin(a,dp,i,w-i-1)+a[i];
        }
        dp[i][w]=Math.min(take,notTake);
        return dp[i][w];
    }
}
