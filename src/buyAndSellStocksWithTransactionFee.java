import java.util.*;

public class buyAndSellStocksWithTransactionFee {
    /*
    here , we will also have a transaction fee which will be charged when we do a transaction

     */
    public static void main(String[] swami){
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=s.nextInt();
        }
        int[][] dp=new int[n][2];
        int fee=s.nextInt();
        System.out.println("This is the recursion + memoization solution");
        System.out.println(getMax(a,0,n,fee,1,dp));
        // for the tabulation and the other code look into other problems


    }

    public static int getMax(int[] a,int i,int n,int fee,int buy,int[][] dp){
        if(i==n){
            return 0;
        }
        if(buy==1){
            int take=-1*a[i]+getMax(a,i+1,n,fee,0,dp);
            int notTake=getMax(a,i+1,n,fee,1,dp);
            dp[i][buy]=Math.max(take,notTake);
            return dp[i][buy];
        }
        else{
            int take=a[i]+getMax(a,i+1,n,fee,1,dp)-fee;
            int notTake=getMax(a,i+1,n,fee,0,dp);
            dp[i][buy]=Math.max(take,notTake);
            return dp[i][buy];
        }

    }
}
