import java.util.Scanner;

public class longestPalindromeSubsequence
{ /*
in this question , we find the longest palindrome subsequence which is present in the string
This question is very similar to the longest common subsequence problem
We will find the longest common subsequence in the given string and the reverse of the given string
This longest common subsequence will be the longest palindrome subsequence

 */
    public static void main(String[] swami){
        Scanner s = new Scanner(System.in);
        String st=s.nextLine();
        // first we will reverse this string and then use the longest common subsequence problem to solve this problem

        System.out.println(longestPalinSubseq(st)) ;



    }

    public static  int longestPalinSubseq(String s)
    {
        //code here
        // we will use the longest common subsequence problem to solve this question
        // the common subsequence between the present string and its reverse will be the longest palindromic subsequence
        StringBuilder s1=new StringBuilder();
        int n=s.length();
        for(int i=n-1;i>-1;i--){
            s1.append(s.charAt(i));
        }
        String st=String.valueOf(s1);
        int[][] dp=new int[n][n];
        return getLong(s,st,dp,n-1,n-1);
        // getLong finds the longest common subsequence in the 2 strings
    }

    public static int getLong(String s,String st,int[][] dp,int x,int y){
        if(x<0 || y<0){
            return 0;
        }
        if(dp[x][y]>0){
            return dp[x][y];
        }
        if(s.charAt(x)==st.charAt(y)){
            dp[x][y]= 1+getLong(s,st,dp,x-1,y-1);
            return dp[x][y];
        }
        dp[x][y]= Math.max(getLong(s,st,dp,x-1,y),getLong(s,st,dp,x,y-1));
        return dp[x][y];
    }

}
