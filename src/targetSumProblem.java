public class targetSumProblem {
    /*
    We assign minus or plus value to all the elements in the array and we want to tell the number of ways to get the target using the different assignments
    if we look the problem clearly , the assignments of the values to the minus and plus values actually is like splitting the entire array into 2 partitions and then taking the difference of it
    so , the problem reduces to counting the subsets with sum equal to totalsum- 2* sumOfFirstPartition
    so , the problem is to count the subsets which have the partition difference equal to totalsum- 2* sumOfFirstPartition

     */
    static int findTargetSumWays(int[] a , int n, int t) {
        // code here
        // we need to partition the array
        // if the total sum is k , then the difference between the partitions will be sum-2*s1
        //sum-2*s1=k
        // therefore the problem reduces to getting the subset with sum equal to (sum-k)/2
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=a[i];
        }
        int k=(sum-t);
        if(k<0){
            return 0;
        }
        if(k%2==1){
            return 0;
        }
        k=k/2;

        // now we will find the subsets which have the sum equal to k
        // this will give the count of the total ways in which we can split the main array into 2 arrays such that the absolute differene is equal to target
        //return getTotal(a,n-1,k);
        int[] prev=new int[k+1];
        int[] curr=new int[k+1];
        if(a[0]==0){
            prev[0]=2;
        }
        else{
            if(a[0]<k+1){
                prev[a[0]]=1;
            }
            prev[0]=1;
        }
        for(int i=1;i<n;i++){
            for(int g=0;g<=k;g++){
                int notTake=prev[g];
                int take=0;
                if(g>=a[i]){
                    take=prev[g-a[i]];
                }
                curr[g]=take+notTake;
            }
            prev=curr;
            curr=new int[k+1];
        }
        return prev[k];
    }

    // this code is a template which helps build the iterative code

    static int getTotal(int[] a,int i,int t){

        if(i==0){
            if(t==0 && a[i]==0){
                return 2;
            }
            if(t==0 || t==a[i]){
                return 1;
            }
            return 0;
        }

        int notTake=getTotal(a,i-1,t);
        int take=0;
        if(t>=a[i]){
            take=getTotal(a,i-1,t-a[i]);
        }
        return take+notTake;
    }

}
