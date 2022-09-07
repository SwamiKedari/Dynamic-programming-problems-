import java.util.*;

public class editDistance {
    /*
    This problem consists of converting of one string to the other string by using one of the following operations :
    1) insert a character in the first string
    2) replace a character in the first string
    3) delete the character in the first string
    We need to find the minimum number of operations to do this
    it is always possible to convert the first string to the second string as the one way to do that is to delete all the characters of the first string and then insert the characters of the second string in it

     */
    /*
    we will use the recursion and in that we will do string matching and if the 2 characters do not match , then we have 3 options , we can either delete it , replace it or insert it
    f(n-1,m-1) will signify that what is the minimum number of operations needed to convert string s1 to s2 till the indexes n-1 and m-1

     */

    public static void main(String[] swami){
        Scanner s=new Scanner(System.in);
        String s1=s.next();
        String s2=s.next();
        int n=s1.length();
        int m=s2.length();
        int[][] dp=new int[n][m];
        System.out.println("This is the recursion +memoization solution :");
        System.out.println(getMin(s1,s2,n-1,m-1,dp));

        // tabulation code :
        dp=new int[n+1][m+1];
        for(int i=0;i<=n;i++){
            dp[i][0]=i;
        }
        for(int i=0;i<=m;i++){
            dp[0][i]=i;
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }
                else{
                    int del=dp[i-1][j]+1;
                    int ins=dp[i][j-1]+1;
                    int rep=dp[i-1][j-1]+1;
                    dp[i][j]=Math.min(Math.min(del,ins),rep);
                }
            }
        }

        System.out.println("This is the tabulation solution :");
        System.out.println(dp[n][m]);

        // space optimisation
        int[] prev=new int[m+1];
        int[] curr=new int[m+1];
        for(int i=0;i<=m;i++){
            prev[i]=i;
        }
        curr[0]=1;

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    curr[j]=prev[j-1];
                }
                else{
                    int del=prev[j]+1;
                    int ins=curr[j-1]+1;
                    int rep=prev[j-1]+1;
                    curr[j]=Math.min(Math.min(del,ins),rep);
                }
            }
            prev=curr;
            curr=new int[m+1];
            curr[0]=i;

        }

        System.out.println("This is the space optimised solution :");
        System.out.println(prev[m]);








    }

    public static int getMin(String s1,String s2, int n,int m,int[][] dp){
        if(m<0){
            return n+1; // the total characters that i need to delete when all the characters of s2 are matched
        }
        if(n<0){
            return m+1; // total characters that i need to insert when the length of s1 is zero but s2 has some length

        }

        if(dp[n][m]>0){
            return dp[n][m];
        }

        if(s1.charAt(n)==s2.charAt(m)){
            dp[n][m]= getMin(s1,s2,n-1,m-1,dp);
            return dp[n][m];
        }
        else{
            int del=getMin(s1,s2,n-1,m,dp)+1; // when we delete , we will move the index of the s1 for matching
            int ins=getMin(s1,s2,n,m-1,dp)+1; // when we insert , we will move the index of s2 for matching of next character
            int rep=getMin(s1,s2,n-1,m-1,dp)+1; // when we replace a character , we will move both the indexes of the s1 and s2
            dp[n][m]= Math.min(Math.min(del,ins),rep);
            return dp[n][m];
        }
    }
}
