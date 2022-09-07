public class shortestCommonSupersequence {
    //Function to find length of shortest common supersequence of two strings.
    // this is the code submitted in gfg which gives the shortest common supersequence of the 2 strings


    public static int shortestCommon(String x,String y,int n,int m)
    {
        //Your code here
        //we will the len of the longest common subsequence
        // the shortest common supersequence will have longest common subsequence of the 2 strings in common
        // then the len of the shortest common supersequence will be (len(x)+len(y))-len(lcs)
        // the common guys between the 2 strings must be taken once


        //return (n+m)-getShort(x,y,n-1,m-1,dp);
        // recursive +memoization approach did not satisfy the time complexity so we use the tabulation
        int[][] dp=new int[n+1][m+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(x.charAt(i-1)==y.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }

        }
        // you can space optimise it using the 2 arrays rather than using 2d array

        return (n+m)-dp[n][m];
    }

    public static int getShort(String x,String y,int n,int m,int[][] dp){
        if(n<0 || m<0){
            return 0;
        }
        if(dp[n][m]>0){
            return dp[n][m];
        }
        if(x.charAt(n)==y.charAt(m)){
            dp[n][m]= 1+getShort(x,y,n-1,m-1,dp);
            return dp[n][m];
        }
        dp[n][m]= Math.max(getShort(x,y,n-1,m,dp),getShort(x,y,n,m-1,dp));
        return dp[n][m];
    }
}
