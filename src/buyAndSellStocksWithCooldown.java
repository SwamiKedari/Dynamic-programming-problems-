import java.util.*;
public class buyAndSellStocksWithCooldown {
    /*
    Cooldown means that if you have sold on the previous day , today you can not buy
    We have to find the maximum profit with the cooldown Precaution
     */
    public static void main(String[] swami){
        Scanner s = new Scanner(System.in);
        int n=s.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=s.nextInt();
        }
        int[][] dp=new int[n][2];
        System.out.println("This is the recursion +memoization solution :");
        System.out.println(getMax(a,0,n,1,dp));

        // the tabulation and the space optimised code is similar to the other problem in buy and sell stocks


    }

    public static int getMax(int[] a,int i,int n,int buy,int[][] dp){
        if(i>=n){
            return 0;
        }
        if(dp[i][buy]>0){
            return dp[i][buy];
        }
        if(buy==1){
            int take=-1*a[i]+getMax(a,i+1,n,0,dp);
            int notTake=getMax(a,i+1,n,1,dp);
            dp[i][buy]=Math.max(take,notTake);
            return dp[i][buy];
        }
        else{
            int take=a[i]+getMax(a,i+2,n,1,dp);
            // the change between the buyandsellII and this code is over here , since we can not buy from the next day to the selling day , we change the index to i+2 and not i+1
            int notTake=getMax(a,i+1,n,0,dp);
            dp[i][buy]=Math.max(take,notTake);
            return dp[i][buy];
        }
    }

}
