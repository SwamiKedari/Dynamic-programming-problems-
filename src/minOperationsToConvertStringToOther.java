
public class minOperationsToConvertStringToOther {
    /*
    We are given 2 strings str1 and str2
    The operations allowed in this question are to delete any character from str1 or insert any character in the str1
    We have to find the minimum number of operations to convert the string1 to string2
    We can always convert the str1 to str2 , as the worst case can be to delete all the characters in str1 and replace them by characters in str2

     */

    public int minOperations(String str1, String str2)
    {
        // Your code goes here
        // we will need to find the minimum characters in str1 that are not to be touched
        // we will find the maximum characters that are common by value and order in both the strings ie the longest common subsequence and then we will perform the following operation
        // since we got the len of the lcs , we will need to delete remaining characters from the str1
        // also we need to insert the characters which are in str2 but not in the lcs
        // so the total operations will be (str1.len-lcs)+(str2.len-lcs)

        int n=str1.length();
        int m=str2.length();
        int[][] dp=new int[n][m];

        int lcs=getLong(str1,str2,n-1,m-1,dp);

        return (n-lcs)+(m-lcs);

    }

    // function that gives the len of the lcs
    public int getLong(String s1, String s2,int n,int m,int[][] dp){
        if(n<0 || m<0){
            return 0;
        }
        if(dp[n][m]>0){
            return dp[n][m];
        }
        if(s1.charAt(n)==s2.charAt(m)){
            dp[n][m]= 1+getLong(s1,s2,n-1,m-1,dp);
            return dp[n][m];
        }

        dp[n][m]=Math.max(getLong(s1,s2,n-1,m,dp),getLong(s1,s2,n,m-1,dp));
        return dp[n][m];

    }
}
