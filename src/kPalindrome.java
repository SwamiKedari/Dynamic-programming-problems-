public class kPalindrome {
    static int kPalindrome(String s , int n, int k)
    {
        // code here
        // this is an easy problem in which we will have to find the longest palindromic subsequence in the string and then we will check whether the length of the given string - length of the palindromic subsequence is less than k or not
        StringBuilder st=new StringBuilder();
        for(int i=n-1;i>-1;i--){
            st.append(s.charAt(i));
        }
        String s1=String.valueOf(st);
        int[][] dp=new int[n][n];
        int h=getMax(s,s1,n-1,n-1,dp);
        //System.out.println(h);
        if(n-h<=k){
            return 1;
        }
        return 0;
    }

    static int getMax(String s,String s1,int i,int j,int[][] dp){
        if(i<0 || j<0){
            return 0;
        }
        if(dp[i][j]>0){
            return dp[i][j];
        }
        if(s.charAt(i)==s1.charAt(j)){
            dp[i][j]=1+getMax(s,s1,i-1,j-1,dp);
            return dp[i][j];
        }
        else{
            dp[i][j]=Math.max(getMax(s,s1,i-1,j,dp),getMax(s,s1,i,j-1,dp));
            return dp[i][j];
        }
    }
}
