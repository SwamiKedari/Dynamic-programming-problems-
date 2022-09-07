import java.util.*;
public class longestCommonSubsequence {
    /*
    we have to find all the subsequences in the 2 strings and then find the longest common occuring subsequence
    This will give us the answer
    The algorithm :
    1) generate all the subsequences and compare on way
    2) recursion will be used which will give the answer through the way
    Rules of recursion :
    express in terms of index , explore the possibilities among them , take the best among them
    # here since we have 2 strings , we will need 2 indexes
    # f(2,5) will mean lcs from string one till index 2 and string two till index 5
     */
    //Function to find the length of longest common subsequence in two strings.

    public static void main(String[] swami){
        Scanner s = new Scanner(System.in);
        String s1=s.nextLine();
        String s2=s.nextLine();
        // for the tabulation code ,we need the base case but the index of the base case over here is -1
        // so we shift the indexes by one and the base case will be 0th index
        // so we declare the dp array of size n+1 * m+1 as we are shifting the indexes by 1
        int n=s1.length();
        int m=s2.length();
        int[][] dp=new int[n+1][m+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        System.out.println("This is the tabulation solution: ");
        System.out.println(dp[n][m]);
        // similarly we can space optimise the solution as we did in the previous problems
        int[] prev=new int[m+1];
        int[] curr=new int[m+1];

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    curr[j]=1+prev[j-1];
                }
                else{
                    curr[j]=Math.max(prev[j],curr[j-1]);
                }
            }
            prev=curr;
            curr=new int[m+1];
        }

        System.out.println("This is the space optimise solution :");
        System.out.println(prev[m]);

    }
    // the below 2 functions were submitted in the gfg

    static int lcs(int x, int y, String s1, String s2)
    {
        // your code here
        // we are given with 2 strings , we need to find the longest common subsequence present in both of them
        // we can use the recursion and then convert it to the dynamic programming solution
        int n1=x ,n2=y;

        int[][] dp=new int[n1][n2];

        // return getLong(s1,s2,dp,n1-1,n2-1);
        // the memoization solution dont work in the time complexity so we further optimise to tabulation
        int h=Integer.MAX_VALUE , h1=Integer.MAX_VALUE;
        char c1=s1.charAt(0);
        char c2=s2.charAt(0);
        for(int i=0;i<n1;i++){
            if(c2==s1.charAt(i)){
                h=i;
                break;
            }

        }
        for(int i=0;i<n2;i++){
            if(c1==s2.charAt(i)){
                h1=i;
                break;
            }
        }
        for(int i=h;i<n1;i++){
            dp[i][0]=1;
        }
        for(int j=h1;j<n2;j++){
            dp[0][j]=1;

        }

        for(int i=1;i<n1;i++){
            for(int j=1;j<n2;j++){
                if(s1.charAt(i)==s2.charAt(j)){
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[n1-1][n2-1];
        // we can further space optimise the solution by using just one 1d array rather than 2d array in the tabulation
    }

    static int getLong(String s1,String s2,int[][] dp,int x,int y){
        if(x<0 || y<0){
            return 0;
        }
        if(dp[x][y]>0){
            return dp[x][y];
        }
        if(s1.charAt(x)==s2.charAt(y)){
            dp[x][y]= 1+getLong(s1,s2,dp,x-1,y-1);
            return dp[x][y] ;
        }
        dp[x][y]= Math.max(getLong(s1,s2,dp,x-1,y),getLong(s1,s2,dp,x,y-1));
        return dp[x][y];
    }




}
