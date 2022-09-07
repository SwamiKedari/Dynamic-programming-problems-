import java.util.*;
public class buyAndSellStocksIII {
    /*
    The part three of the buy and sell stocks says that we can have at max 2 transactions ie we can buy and sell the stocks at most 2
    buy variable is the variable whose value is one when we can buy the new stock , else its value is 0

     */
    public static void main(String[] swami){
        Scanner s = new Scanner(System.in);
        int n=s.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=s.nextInt();
        }
        int cap=s.nextInt();
        int[][][] dp=new int[n][2][cap+1];

        System.out.println("This is the recursion + memoization solution :");
        System.out.println(getMax(a,0,n,1,cap,dp));

        dp=new int[n+1][2][cap+1];
        for(int i=n-1;i>-1;i--){
            for(int j=0;j<2;j++){
                for(int k=1;k<=cap;k++){
                    if(j==1){
                        int take=-1*a[i]+dp[i+1][0][cap];
                        int notTake=dp[i+1][1][cap];
                        dp[i][j][k]=Math.max(take,notTake);
                    }
                    else{
                        int take=a[i]+dp[i+1][1][cap-1];
                        int notTake=dp[i+1][0][cap];
                        dp[i][j][k]=Math.max(take,notTake);
                    }
                }
            }
        }

        System.out.println("This is the tabulation solution :");
        System.out.println(dp[0][1][2]);

        //space optimised solution
        int[][] prev=new int[2][cap+1];
        int[][] curr=new int[2][cap+1];

        for(int i=n-1;i>-1;i--){
            for(int j=0;j<2;j++){
                for(int k=1;k<=cap;k++){
                    if(j==1){
                        int take=-1*a[i]+prev[0][cap];
                        int notTake=prev[1][cap];
                        curr[j][k]=Math.max(take,notTake);
                    }
                    else{
                        int take=a[i]+prev[1][cap-1];
                        int notTake=prev[0][cap];
                        curr[j][k]=Math.max(take,notTake);
                    }
                }
            }
            prev=curr;
            curr=new int[2][cap+1];
        }

        System.out.println("This is the space optimised solution :");
        System.out.println(prev[1][cap]);



    }
    // cap is the variable used to keep a upperlimit to the number of transactions
    public static int getMax(int[] a,int i,int n,int buy,int cap,int[][][] dp) {
        if (i == n) {
            return 0;
        }
        if(cap<=0){
            return 0;
        }
        if(dp[i][buy][cap]>0){
            return dp[i][buy][cap];
        }
        if (buy == 1) {
            int take = -1 * a[i] + getMax(a, i + 1, n, 0, cap,dp);
            int notTake = getMax(a, i + 1, n, 1, cap,dp);
            dp[i][buy][cap]= Math.max(take, notTake);
            return dp[i][buy][cap];
        } else{
            int take = a[i] + getMax(a, i + 1, n, 1, cap - 1,dp);
            int notTake = getMax(a, i + 1, n, 0, cap,dp);
            dp[i][buy][cap]= Math.max(take, notTake);
            return dp[i][buy][cap];
        }

    }
}
