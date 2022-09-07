import java.util.*;
public class matrixChainMultiplication { // doubt
    /*
    In this problem , we have to find the minimum operations required to multiply n matrices , this can be done by partitioning the n matrices in to a particular way and then multiplying the partitions first
    We will be given with the array which has the adjacent elements equal to the dimensions of a particular matrix
    using this dimensions we have to find the minimum number of operations to multiply the matrix

     */
    public static void main(String[] swami){
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=s.nextInt();
        }

        System.out.println("This is the recursion + memoization ");
        System.out.println(matrixMultiplication(n,a));
        //we can find the tabulation and the space optimised solution using the dp array

        // for the tabulation code ,see the matrix chain multiplication bottom up problem







    }

    static int matrixMultiplication(int n,int[] arr)
    {
        // code here
        // in this problem , we will use two variables in the recursion parameters
        // first one will be the left index which is the value of the left most matrix rows
        // second one will be the right index which is the value of the right most matrix columns
        // then we will use the memoization and space optimisation to optimise the solution
        int i=1, j=n-1;
        int[][] dp=new int[n][n];
        return getMin(arr,1,j,dp);
    }

    static int getMin(int[] a,int i,int j,int[][] dp){
        if(i==j){
            return 0;
        }
        if(dp[i][j]>0){
            return dp[i][j];
        }
        int min=Integer.MAX_VALUE;
        int steps=0;
        for(int k=i;k<j;k++){
            steps=getMin(a,i,k,dp)+getMin(a,k+1,j,dp)+(a[i-1]*a[k]*a[j]);

            if(steps<min){
                min=steps;
            }
        }
        dp[i][j]= min;
        return dp[i][j];
    }

}
