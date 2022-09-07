public class longestAlternatingSubsequence {
    // this is the question submitted in gfg satisfying 100 outof 110 test cases
    public int AlternatingaMaxLength(int[] a)
    {
        // code here
        // this question is similar to the longest increasing subsequence problem
        int n=a.length;
        // we will store the previous value and the int value of whether the comparison is < or >
        int[][][] dp=new int[n][n+1][2];
        return Math.max(getLong(a,0,-1,0,n,dp),getLong(a,0,-1,1,n,dp));

    }
    public int getLong(int[] a,int i,int pr,int cp,int n,int[][][] dp){
        if(i==n){
            return 0;
        }
        if(dp[i][pr+1][cp]>0){
            return dp[i][pr+1][cp];
        }
        int take=Integer.MIN_VALUE;
        int notTake=getLong(a,i+1,pr,cp,n,dp);
        if(pr==-1 || comp(a,i,pr,cp)){
            take=1+getLong(a,i+1,i,Math.abs(cp-1),n,dp);
        }
        dp[i][pr+1][cp]= Math.max(notTake,take);
        return dp[i][pr+1][cp];
    }

    public boolean comp(int[] a,int i,int pr,int cp){
        if(cp==0 && a[i]<a[pr]){
            return true;
        }
        if(cp==1 && a[i]>a[pr]){
            return true;
        }
        return false;
    }
}
