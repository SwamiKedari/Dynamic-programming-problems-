public class minimumCostToMakeStringsIdentical {
    // in this question, we have to find the minimum cost required to make the both strings identical by deleting the characters from the both the strings
    // we will delete all the characters except that are there in the longest common subsequence
    public int findMinCost(String X, String Y, int costX, int costY)
    {
        // Your code goes here
        // find the length of the longest common subsequence in the two strings and then subtract the values of x and y from them to get the answer
        int n=X.length();
        int m=Y.length();
        int[][] dp=new int[n][m];
        int lcs= getLong(X,Y,n-1,m-1,dp);

        return (n-lcs)*costX + (m-lcs)*costY;
    }

    public int getLong(String x,String y,int i,int j,int[][] dp){
        if(i<0 || j<0){
            return 0;
        }
        if(dp[i][j]>0){
            return dp[i][j];
        }
        if(x.charAt(i)==y.charAt(j)){
            dp[i][j]= 1+ getLong(x,y,i-1,j-1,dp);
            return dp[i][j];
        }
        else{
            dp[i][j]= Math.max(getLong(x,y,i-1,j,dp),getLong(x,y,i,j-1,dp));
            return dp[i][j];
        }
    }
}
