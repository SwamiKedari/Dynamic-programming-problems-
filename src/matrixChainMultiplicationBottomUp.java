import java.util.*;
public class matrixChainMultiplicationBottomUp {
    public static void main(String[] swami){
        // this is the tabulation code for the matrix chain multiplication problem
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=s.nextInt();
        }

        int[][] dp=new int[n][n];
        // the base case for the recursion + memoization code was that if(i==j) return 0
        // so for converting the memoization to the tabulation , we will first have to write the base case
        for(int i=1;i<n;i++){
            dp[i][i]=0;
        }
        // this was the base case in the case of the memoization

        // next we set the starting points and the ending points of the variables such that they are opposite to the memoization
        // so our i will start from n-1 to 1 and the j will start from i+1 to n-1

        for(int i=n-1;i>0;i--){
            for(int j=i+1;j<n;j++){
                // now we will just copy the recurrence from the memoization
                int min=Integer.MAX_VALUE;
                int steps=0;
                for(int k=i;k<j;k++){
                    steps=dp[i][k]+dp[k+1][j]+a[i-1]*a[k]*a[j];
                    if(min>steps){
                        min=steps;
                    }
                }
                dp[i][j]=min;
            }
        }

        System.out.println("This is the tabulation solution for the problem :");
        System.out.println(dp[1][n-1]);

    }
}
