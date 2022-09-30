public class IncreasingSubsequenceString {
    // this problem is same as the longest increasing subsequence with the values of the characters of the string as a=1 to z=26
    // we first use the arrays of the characters and then use the lcs algorithm to get the answer for the strings

    static int maxLength(String s){
        // code here
        // this question is similar to the longest increasing subsequence problem
        int aAsc=(int)('a');
        int n=s.length();
        int[] a=new int[s.length()];
        for(int i=0;i<n;i++){
            a[i]=(int)s.charAt(i) - aAsc + 1;
        }
        // then after getting the new array , we have to just use the longest increasing subsequence
        int[][] dp=new int[n][n+1];
        dp[0][0]=1;
        for(int i=1;i<=n;i++){
            if(a[0]<a[i-1]){
                dp[0][i]=1;
            }
        }

        for(int i=1;i<n;i++){
            for(int j=-1;j<n;j++){
                int take=Integer.MIN_VALUE;
                if(j==-1 || a[i]<a[j]){
                    take=1+dp[i-1][i+1];
                }
                int notTake=dp[i-1][j+1];
                dp[i][j+1]=Math.max(notTake,take);

            }
        }
        return dp[n-1][0];
    }

    static int getLong(int[] a,int i,int pre,int[][] dp){
        if(i==0){
            if(pre==-1 || a[0]<a[pre]){
                return 1;
            }
            return 0;
        }
        if( dp[i][pre+1]>0){
            return dp[i][pre+1];
        }
        int take=Integer.MIN_VALUE;
        if(pre==-1 || a[i]<a[pre]){
            take=1+getLong(a,i-1,i,dp);
        }
        int notTake=getLong(a,i-1,pre,dp);
        dp[i][pre+1] = Math.max(notTake,take);
        return dp[i][pre+1];

    }
}
