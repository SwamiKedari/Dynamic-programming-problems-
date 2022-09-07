
import java.util.*;
public class distinctSubsequences {// doubt
    /*
    In this problem , we have to find the total subsequences of the first string that are equal to the second string
    whenever we have the problems to count all the ways , we return 1 or 0 in base case and add all the possible function calls
    the logic for this problem is as follows :
    1) if the characters of both the strings match with each other the total subsequences will be due to including that character and not including that character
    2) if the characters of both the strings do not match , then we only consider the subsequences with indexes i-1 and j-1
     */

    public static void main(String[] swami){
        Scanner s = new Scanner(System.in);
        String s1=s.nextLine();
        String s2=s.nextLine();
        int n=s1.length() , m=s2.length();
        int[][] dp=new int[n][m];
        int ans=getTotalSubsequences(s1,s2,n-1,m-1,dp);
        System.out.println("This is the recursion+memoization solution :");
        System.out.println(ans);

        // tabulation code:
        dp=new int[n+1][m+1];
        // we shift the indexes by 1 as the base case is negative
        for(int i=0;i<=n;i++){
            dp[i][0]=1;
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j]+dp[i-1][j-1];
                }
                else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }

        System.out.println("This is the tabulation solution :");
        System.out.println(dp[n][m]);

        // space optimized solution:
        int[] prev=new int[m+1];
        int[] curr=new int[m+1];
        prev[0]=1;
        curr[0]=1;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    curr[j]=prev[j]+prev[j-1];
                }
                else{
                    curr[j]=prev[j];
                }
            }
            prev=curr;
            curr=new int[m+1];
            curr[0]=1;
        }

        System.out.println("This is the space optimised solution :");
        System.out.println(prev[m]);

    }
    public static int getTotalSubsequences(String s1,String s2,int n,int m,int[][] dp){
        if(m<0){
            return 1;
        }
        if(n<0){
            return 0;
        }
        if(dp[n][m]>0){
            return dp[n][m];
        }

        if(s1.charAt(n)==s2.charAt(m)){
            dp[n][m]= getTotalSubsequences(s1,s2,n-1,m-1,dp)+getTotalSubsequences(s1,s2,n-1,m,dp);
        }
        else{
            dp[n][m]= getTotalSubsequences(s1,s2,n-1,m,dp);
        }
        return dp[n][m];
    }
}
