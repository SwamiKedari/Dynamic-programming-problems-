import java.util.*;
public class maxFallingPathSum {
    // in this problem , we travel from the any cell in the first row to any cell in the last row
    // the path sum must be maximum in any path which we take like this
    /*
    we can not use the greedy approach over here as it do not work
    we are going to try out all the paths and use dynamic programming to solve this problem


     */
    public static void main(String[] swami){
        Scanner s = new Scanner(System.in);
        int n=s.nextInt();
        int[][] a = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                a[i][j]=s.nextInt();
            }
        }
        int[][] dp=new int[n][n];
        System.out.println("this is the recursion + memoization solution of this problem : ");
        int max=0;
        for(int i=0;i<n;i++){
            int h=getMax(a,dp,n-1,i,n);
            if(h>max){
                max=h;
            }
        }
        System.out.println(max);

        // for the space optimized solution , we will store the previous row elements in the array
        // we will also store the current elements in an array called ans1
        // then we will transfer the values of the curr array to the previous array

        int[] prev=new int[n];
        int[] ans1=new int[n];

        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int a1=arrayValue(prev,j-1);
                int a2=arrayValue(prev,j);
                int a3=arrayValue(prev,j+1);
                ans=Math.max(a1,Math.max(a2,a3))+a[i][j];
                if(ans==Integer.MIN_VALUE){
                    ans=a[i][j];
                }
                ans1[j]=ans;

            }
            prev=ans1;
            ans1=new int[n];


        }
        System.out.println("This is the space optimized solution of this problem : ");
         max=0;

        for(int i=0;i<n;i++){
            if(prev[i]>max){
                max=prev[i];
            }
        }

        System.out.println(max);






    }

    public static int arrayValue(int[] prev,int i){
        if(i<0 || i>=prev.length){
            return Integer.MIN_VALUE;
        }
        return prev[i];
    }
    public static int getMax(int[][] a,int[][] dp,int i,int j,int n){
        if(i==0 && j>-1 && j<n){
            return a[i][j];
        }
        if(i<0 || j<0 || i>=n || j>=n){
            return Integer.MIN_VALUE;
        }
        if(dp[i][j]>0){
            return dp[i][j];
        }

        int a1=getMax(a,dp,i-1,j,n);
        int a2=getMax(a,dp,i-1,j+1,n);
        int a3=getMax(a,dp,i-1,j-1,n);
        dp[i][j]=Math.max(a1,Math.max(a2,a3))+a[i][j];
        return dp[i][j];
    }

}
