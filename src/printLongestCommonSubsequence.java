import java.util.*;

public class printLongestCommonSubsequence {
    /*
    in this question , we need to print the longest common subsequence in the string using dp , we will use the dp array of longest common subsequence to get this answer
    This can be done by traversing back the dp array and appending the characters that occur in common , where we move diagonally , and moving the index to the place where the subsequence has big common subsequence

// the traversal cant be done in the recursion + memoization solution as it will not contain all the values in it , only the tabulation dp array is useful to get the answer of the printing the longest common subsequence



     */
    public static void main(String[] swami){
        Scanner s = new Scanner(System.in);
        String s1=s.nextLine();
        String s2=s.nextLine();
        int n1=s1.length();
        int n2=s2.length();
        int[][] dp=new int[n1+1][n2+1];
        for(int i=1;i<=n1;i++){
            for(int j=1;j<=n2;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else{
                    dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        // printing dp last index will give the longest common subsequence of the strings
        System.out.println("This is the longest common subsequence : ");
        System.out.println(dp[n1][n2]);

        StringBuilder b=new StringBuilder();
        int i=n1 , j=n2;
        while(i>0 && j>0){
            if(s1.charAt(i-1)==s2.charAt(j-1)){
                b.append(s1.charAt(i-1));
                i--;
                j--;
            }
            else if(dp[i-1][j]>dp[i][j-1]){
                i--;
            }
            else{
                j--;
            }
        }

        // then finally we will reverse the string we got appended to the stringbuilder
        StringBuilder c=new StringBuilder();
        String rev=String.valueOf(b);
        int n=rev.length();
        for(i=n-1;i>-1;i--){
            c.append(rev.charAt(i));
        }
        System.out.println("This is the longest common subsequence in the two strings :");
        System.out.println(String.valueOf(c));
    }

    public static int getCommon(String s1,String s2,int i,int j){
        if(i<0 || j<0){
            return 0;
        }
        if(s1.charAt(i)==s2.charAt(j)){
            return 1+getCommon(s1,s2,i-1,j-1);
        }
        return Math.max(getCommon(s1,s2,i,j-1),getCommon(s1,s2,i-1,j));
    }
}
