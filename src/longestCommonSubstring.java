import java.util.*;

public class longestCommonSubstring {
    // this question is very similar to the longest common subsequence problem , but with the constraint that the subsequence must be a substring ,
    // here , we just change the else part in the recursion and set it to zero because if the previous element didnot match we had the longest substring of zero which had that particular element
    // here , we need to use the tabulation code only , and we can use the recursive approach to solve this question
    public static void main(String[] swami){
        Scanner s = new Scanner(System.in);
        String s1=s.nextLine();
        String s2=s.nextLine();
        int n1=s1.length();
        int n2=s2.length();
        int[][] dp=new int[n1+1][n2+1];
        int max=0;
        for(int i=1;i<=n1;i++){
            for(int j=1;j<=n2;j++){
                // if there is a match , we will add the diagonally previous element to 1 and that will be the current element
                // else we will set the current element value to 0
                // we will also keep a variable for the max substring that occurs in the strings
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                    if(dp[i][j]>max){
                        max=dp[i][j];
                    }
                }
                else{
                    dp[i][j]=0;
                }
            }
        }

        System.out.println("The tabulation answer will be :");
        System.out.println(max);

        // we can further optimize the code by using the space optimisation

    }


}
