public class letterWriter {
    static int minHours(int n){
        // code here
        // this question is very similar to the coin change problem
        int[] a={10,12};
        int[][] dp=new int[n+1][2];
        int k=findhours(n,1,a,dp);
        if(k==Math.pow(10,7)){
            return -1;
        }
        return k;
    }

    static int findhours(int n,int i,int[] a,int[][] dp){
        if(n==0){
            return 0;
        }
        if(i==0){
            if(n%a[i]==0){
                return n/a[i];
            }
            return (int)Math.pow(10,7);
        }
        if(dp[n][i]>0){
            return dp[n][i];
        }
        int notTake=findhours(n,i-1,a,dp);
        int take=(int)Math.pow(10,7);
        if(a[i]<=n){
            take=1+findhours(n-a[i],i,a,dp);
        }
        dp[n][i]=Math.min(take,notTake);
        return dp[n][i];
    }
}
