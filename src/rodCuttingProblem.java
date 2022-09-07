public class rodCuttingProblem {
    /*
    we will be given the price array and values in it
    we need to find the total sum that we can obtain using the price array
    This problem is very similar to the knapsack with duplicate items or the unbounded knapsack problem
    the weights over here is the index+1 value and the value of the item is the item in the price array
    the total amount of weight is the value n which the total size of the rod
     */

    public int cutRod(int a[], int n) {
        //code here
        // we need to find the total maximum value that one can earn by cutting the rod and then selling the pieces according to the price array
        // this problem is very similar to the knapsack with duplicate items problem with the weight equal to the size of the array n and items equal to pieces
        // first we will use a function to solve the problem using recursion and then optimise it
        int[] prev=new int[n+1];
        int[] curr=new int[n+1];
        for(int i=1;i<=n;i++){
            prev[i]=i*a[0];
        }
        for(int i=1;i<n;i++){
            for(int k=0;k<=n;k++){
                int notTake=prev[k];
                int take=Integer.MIN_VALUE;
                if(k>=i+1){
                    take=curr[k-i-1]+a[i];
                }
                curr[k]=Math.max(take,notTake);
            }
            prev=curr;
            curr=new int[n+1];
        }
        return prev[n];
    }

    public int getMax(int[] a,int i,int w){
        if(i==0){
            return w*a[i];
        }
        int notTake=getMax(a,i-1,w);
        int take=Integer.MIN_VALUE;
        if(w>=i+1){
            take=getMax(a,i,w-i-1)+a[i];
        }
        return Math.max(take,notTake);
    }
}
