public class maximumSumInBitonicSequence {
    public static int maxSumBS(int arr[], int n)
    {
        // in every case you have to take the maximum of the 4 conditions
        // take and change the bit
        // nottake and change the bit
        // take and do not change the bit
        // nottake and do not change the bit
        // we can further improve this solution using the shifting of the indexes for the pre variable by 1 
        int[][][] dp=new int[n][n][2];
        return getmax(arr,n-1,-1,0,dp);
    }

    public static int getmax(int[] a,int i,int pre,int bit,int[][][] dp){
        if(i==0){
            if(bit==1 && (pre==-1 || a[i]<a[pre])){
                return a[i];
            }
            else if(bit==0){
                return a[i];
            }
            return 0;
        }
        if(pre!=-1 && dp[i][pre][bit]>0){
            return dp[i][pre][bit];
        }
        int take=Integer.MIN_VALUE;
        int notTake=Integer.MIN_VALUE;
        if(bit==1 && (pre==-1 || a[i]<a[pre])){
            int take1=getmax(a,i-1,i,bit,dp)+a[i];
            take=Math.max(take1,take);
        }
        else if(bit==0 && (pre==-1 || a[i]>a[pre])){
            int take1=getmax(a,i-1,i,1,dp)+a[i];
            int take2=getmax(a,i-1,i,0,dp)+a[i];
            take=Math.max(take1,take2);
        }

        if(bit==1){
            notTake=getmax(a,i-1,pre,1,dp);

        }
        else{
            notTake=Math.max(getmax(a,i-1,pre,1,dp),getmax(a,i-1,pre,0,dp));
        }
        if(pre!=-1){
            dp[i][pre][bit]=Math.max(notTake,take);
            return dp[i][pre][bit];
        }
        return Math.max(notTake,take);
    }

}
