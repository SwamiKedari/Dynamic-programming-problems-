public class minDeletionsToMakePalindrome {
    static int minimumNumberOfDeletions(String s) {
        //your code here
        // just find the length of the longest palindromic subsequence between that string and the reverse of that string and then find the difference with the current str.len
        // this will give the minimum deletions needed to make string s a palindrome

        StringBuilder a=new StringBuilder();
        int n=s.length();
        for(int i=n-1;i>-1;i--){
            a.append(s.charAt(i));
        }
        String s1=String.valueOf(a);
        int[][] dp=new int[n][n];
        int h=getLong(s,s1,n-1,n-1,dp);
        return n-h;
    }

    static int getLong(String s,String s1,int n,int m,int[][] dp){
        if(n<0 || m<0){
            return 0;
        }
        if(dp[n][m]>0){
            return dp[n][m];
        }
        if(s.charAt(n)==s1.charAt(m)){
            dp[n][m]=getLong(s,s1,n-1,m-1,dp)+1;
            return dp[n][m];
        }
        dp[n][m]=Math.max(getLong(s,s1,n,m-1,dp),getLong(s,s1,n-1,m,dp));
        return dp[n][m];
    }
}
