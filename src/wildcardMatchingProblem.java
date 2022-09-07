import java.util.*;
public class wildcardMatchingProblem {// doubt
    /*
    we have to find whether the st1 matches with the st2 when we replace the characters :
    ? -> can be replaced by any number of characters
    * -> can be replaced by the group of characters rather than a single character

     */

    public static void main(String[] swami){
        Scanner s=new Scanner(System.in);
        String s1=s.next();
        String s2=s.next();
        int n=s1.length();
        int m=s2.length();
        boolean[][] dp=new boolean[n][m];
        System.out.println("This is the recursion + memoization answer :");
        System.out.println(ismatch(s1,s2,n-1,m-1,dp));

        dp=new boolean[n+1][m+1];
        dp[0][0]=true;
        for(int i=1;i<=n;i++){
            dp[i][0]=isstar(s1,i-1);
        }
        for(int i=1;i<=m;i++){
            dp[0][i]=false;
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1) || s1.charAt(i-1)=='?'){
                    dp[i][j]=dp[i-1][j-1];
                }
                else if(s1.charAt(i-1)=='*'){
                    dp[i][j]=dp[i-1][j] || dp[i][j-1];
                }
                else{
                    dp[i][j]=false;
                }
            }
        }
        System.out.println("This is the tabulation solution :");
        System.out.println(dp[n][m]);

        // the space optimised part of the solution :
        boolean[] prev=new boolean[m+1];
        boolean[] curr=new boolean[m+1];

        prev[0]=true;
        for(int i=1;i<=m;i++){
            prev[i]=false;
        }
        curr[0]=isstar(s1,1);
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1) || s1.charAt(i-1)=='?'){
                    curr[j]=prev[j-1];
                }
                else if(s1.charAt(i-1)=='*'){
                    curr[j]=prev[j] || curr[j-1];
                }
                else{
                    curr[j]=false;
                }
            }
            prev=curr;
            curr=new boolean[m+1];
            curr[0]=isstar(s1,i);
        }

        System.out.println("This is the space optimised solution :");
        System.out.println(prev[m]);

    }
    public static boolean isstar(String a,int i){
        for(int j=0;j<=i;j++){
            if(a.charAt(j)!='*'){
                return false;
            }
           // return true;
        }
        return true;
    }

    public static boolean ismatch(String s1,String s2,int n,int m,boolean[][] dp){
        /*
        the base case for the recursion is as follows :
        1) if the string s1 gets exhausted
        2) if the string s2 gets exhausted
        if both the strings get exhausted  , we return true
        if s1 gets exhausted and s2 didnot exhaust , in this case we will return false
        if s2 gets exhausted and s1 didnot exhaust , we will check if the s1 will have all the stars , if it have all the stars , we will return true , else we will return false

         */

        if(n<0 && m<0){
            return true;
        }
        if(n<0 && m>=0){
            return false;
        }
        if(m<0 && n>=0){
            for(int i=0;i<=n;i++){
                if(s1.charAt(i)!='*'){
                    return false;
                }
            }
            return true;
        }

        if(dp[n][m]){
            return dp[n][m];
        }

        if(s1.charAt(n)==s2.charAt(m) || s1.charAt(n)=='?'){
            dp[n][m]= ismatch(s1,s2,n-1,m-1,dp);
            return dp[n][m];
        }
        else if(s1.charAt(n)=='*'){
            dp[n][m]=ismatch(s1,s2,n-1,m,dp) || ismatch(s1,s2,n,m-1,dp);
            return dp[n][m];
        }
        else{
            dp[n][m]= false;
            return dp[n][m];
        }
    }
}
