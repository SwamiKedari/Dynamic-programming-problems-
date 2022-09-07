public class minInsertionsToMakeStringPalindrome {
    /*
    In this problem , we find the minimum insertions that are required to make the string a palindrome
    Every string can be converted to the palindrome as it will be a palindrome , if we attach the string in the reverse order in the back of the string
    but this may not be the palindrome that we get using the minimum number of insertions though
    Approach :
    The approach to solve this problem is to find the number of characters in the longest palindromic subsequence and then the minimum number of insertions will be equal to the total characters - characters in the longest palindromic subsequence
    This is because the longest palindromic subsequence with the remaining characters in the string will make a palindrome
    so , we can proceed in this manner to solve this question



     */

    static int countMin(String str)
    {
        // code here
        // the approach to solve this problem is simple , we need to find the characters in the longest palindromic subsequence and the difference between the len of that subsequence and the main string will be the answer
        StringBuilder a=new StringBuilder();
        int n=str.length();
        for(int i=n-1;i>-1;i--){
            a.append(str.charAt(i));
        }
        String st=String.valueOf(a);
        int[][] dp=new int[n][n];
        int palLen=getPalLength(str,st,dp,n-1,n-1);
        return n-palLen;
        // we can further optimise the code by using tabulation and space optimisation
        // check the lcs and longest palindromic subsequence questions for the space optimisation and the tabulation
    }

    static int getPalLength(String st,String str,int[][] dp,int x,int y){
        if(x<0 || y<0){
            return 0;
        }
        if(dp[x][y]>0){
            return dp[x][y];
        }
        if(st.charAt(x)==str.charAt(y)){
            dp[x][y]= 1+getPalLength(st,str,dp, x-1,y-1);
            return dp[x][y];
        }

        dp[x][y]=Math.max(getPalLength(st,str, dp,x-1,y),getPalLength(st,str,dp, x,y-1));
        return dp[x][y];

    }

}
