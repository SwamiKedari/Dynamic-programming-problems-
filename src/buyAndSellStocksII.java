import java.util.*;
public class buyAndSellStocksII {
    /*
    we are given the prices of the stocks on each day
    In this question , we can buy stocks as many times as i want , also sell it as many times as i want
    we need to find the maximum profit that we can get by doing such operation
    also the buy sell operation must be done next to each other
     */

    /*
    the recursion has the following rule :
    1) express everything in terms of index
    2) explore all the possibilities , and take the best thing you want
    3) write the base case
     */
    public static void main(String[] swami){
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=s.nextInt();
        }

        int[][] dp=new int[n][2];


        System.out.println("This is the recursion + memoization  solution :");
        System.out.println(getMax(a,n,0,1,dp));

        // tabulation code :
        dp=new int[n+1][2];
        for(int i=n-1;i>-1;i--){
            for(int j=0;j<2;j++){
                if(j==1){
                    int take=-1*a[i]+dp[i+1][0];
                    int notTake=dp[i+1][1];
                    dp[i][j]=Math.max(take,notTake);
                }
                else{
                    int take=a[i]+dp[i+1][1];
                    int notTake=dp[i+1][0];
                    dp[i][j]=Math.max(take,notTake);
                }
            }
        }

        System.out.println("This is the tabulation solution :");
        System.out.println(dp[0][1]);

        // space optimised solution
        // this will work in o(1) space

        int[] prev=new int[2];
        int[] curr=new int[2];

        for(int i=n-1;i>-1;i--){
            for(int j=0;j<2;j++){
                if(j==1){
                    int take=-1*a[i]+prev[0];
                    int nottake=prev[1];
                    curr[j]=Math.max(take,nottake);
                }
                else{
                    int take=a[i]+prev[1];
                    int nottake=prev[0];
                    curr[j]=Math.max(take,nottake);
                }

            }
            prev=curr;
            curr=new int[2];
        }

        System.out.println("This is the space optimised solution :");
        System.out.println(prev[1]);




    }

    // for the recursion , the time complexity is o(2^n)
    // space complexity is o(n)
    // we can apply the memoization technique to reduce time complexity
    public static int getMax(int[] a,int n,int i,int buy,int[][] dp){
        // buy variable is to verify that we dont sell or buy the stock when it is already bought or sold
        if(i==n){
            return 0;

        }
        if(dp[i][buy]>0){
            return dp[i][buy];
        }
        if(buy==1){
            int take=-1*a[i]+getMax(a,n,i+1,0,dp);
            int notTake=getMax(a,n,i+1,1,dp);
            dp[i][buy]= Math.max(notTake,take);
            return dp[i][buy];
        }
        else{
            int take=a[i]+getMax(a,n,i+1,1,dp);
            int notTake=getMax(a,n,i+1,0,dp);
            dp[i][buy]= Math.max(notTake,take);
            return dp[i][buy];
        }

    }
}
