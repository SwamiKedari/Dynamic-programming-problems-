import java.util.*;
public class minimumPathsFromTopToBottomRowInTriangle {
    // greedy solution will not work in this condition
    /*
    in this question , we can go from the top index to either the bottom in the column or diagonally to the next column in the next bottom row

    try out all the paths and then get the minimum
    in this problem , we will start in recursion from the start and then move on to the last
    there will be overlapping sub-problems in this question
    so we will be optimizing the solution using the memoization
    the tabulation will be opposite to the memoization , here since we have memoization from the top , we will have tabulation from the bottom in the triangle

     */

    public static void main(String[] swami){
        Scanner s = new Scanner(System.in);
        int n=s.nextInt();
        int m=s.nextInt();
        int[][] a=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<i+1;j++){
                a[i][j]=s.nextInt();
            }
        }
        // in this problem , m>=n is always satisfied


        int[][] dp=new int[n][m];
        System.out.println("This is the recursion + memoization code for the problem");
        System.out.println(getMin(a,dp,0,0,n)+"\n");

        // now we will write the tabulation code for the problem
        dp=new int[n][m];
        for(int j=0;j<n;j++){
            dp[n-1][j]=a[n-1][j];
        }
        for(int i=n-2;i>-1;i--){
            for(int j=0;j<i+1;j++){
                dp[i][j]=a[i][j]+Math.min(dp[i+1][j+1],dp[i+1][j]);

            }
        }
        System.out.println("This is the tabulation solution of this problem :");
        System.out.println(dp[0][0]+"\n");

        // space optimization code below :
        // for space optimization , we will need to store each prev row in the array
        int[] prev=new int[n];
        for(int i=0;i<n;i++){
            prev[i]=a[n-1][i];
        }

        for(int i=n-2;i>-1;i--){
            for(int j=0;j<i+1;j++){
                prev[j]=Math.min(prev[j],prev[j+1])+a[i][j];
            }
        }
        System.out.println("This is the space optimized solution for the problem :");
        System.out.println(prev[0]);

    }
    public static int getMin(int[][] a,int[][] dp,int i,int j,int n){
        if(i==n-1){
            return a[i][j];
        }
        if(dp[i][j]>0){
            return dp[i][j];
        }
        int a1=getMin(a,dp,i+1,j,n);
        int a2=getMin(a,dp,i+1,j+1,n);
        dp[i][j]=Math.min(a1,a2)+a[i][j];
        return dp[i][j];
    }



}
