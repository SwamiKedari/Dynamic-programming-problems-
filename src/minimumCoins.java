import java.util.* ;
public class minimumCoins {
    /*
    you are given an array denoting the denomination of coins
    you are also given the target which is needed to be formed from the denominations
    we need to find the minimum number of coins which will be needed to form the target
    greedy approach to solve this problem fails , see the youtube video again if you want to know about this
    one reoson why greedy approach fails over here is that there is no uniformity in the problem
     */

    /*
    The recursion will contain the target value and the index as the parameters
    The value of the function at a particular value will be the value which will give the target at that particular index
    whenever there is infinite supply , multiple use in the question , the recursion will stand at the same index after taking the value
    The time complexity for the recursion part will be more than o(2^n) and the space complexity will also be more than o(n) as the stack will not have just indexes but repeated indexes on it
    We use the memoization process to reduce the time complexity
    The dp array will be a 2d array of size o(n*(target+1))
    The memoization is same as the other problems

     */



    public static void main(String[] swami){
        Scanner s = new Scanner(System.in);
        int n=s.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=s.nextInt();
        }
        int ta=s.nextInt();
        int[][] dp=new int[n][ta+1];
        System.out.println("This is the recursion + memoization solution:");

        System.out.println(getMinCoins(n-1,ta,a,dp));

        // tabulation code;
        dp=new int[n][ta+1];
        for(int i=0;i<=ta;i++){
            if(i%a[0]==0){
                dp[0][i]=i/a[0];
            }
            else{
                dp[0][i]=Integer.MAX_VALUE;
            }
        }

        for(int i=1;i<n;i++){
            for(int k=0;k<=ta;k++){
                int notTake=dp[i-1][k];
                int take=(int)Math.pow(10,9);
                if(a[i]<=k){
                    take=1+dp[i][k-a[i]];
                }
                dp[i][k]=Math.min(take,notTake);

            }
        }
        System.out.println("This is the tabulation solution:");
        System.out.println(dp[n-1][ta]);

        // space optimized code
        int[] prev=new int[ta+1];
        int[] curr=new int[ta+1];
        for(int i=0;i<=ta;i++){
            if(i%a[0]==0){
                prev[i]=i/a[0];
            }
            else{
                prev[i]=(int)Math.pow(10,9);
            }
        }
        for(int i=1;i<n;i++){
            for(int k=0;k<=ta;k++){
                int notTake=prev[k];
                int take=(int)Math.pow(10,9);
                if(k>=a[i]){
                    take=curr[k-a[i]]+1;
                }
                curr[k]=Math.min(notTake,take);
            }
            prev=curr;
            curr=new int[ta+1];
        }
        System.out.println("This is the space optimized solution in o(n) :");
        System.out.println(prev[ta]);

    }

    public static int getMinCoins(int i,int t,int[] coins,int[][] dp){
        if(i==0){
           if(t%coins[0]==0){
               return t/coins[0];
           }
           return (int)Math.pow(10,9);
           // we use a higher value rather than the largest value to avoid memory overflow outside the integer in any way

        }

        if(dp[i][t]>0){
            return dp[i][t];
        }

        int notTake=getMinCoins(i-1,t,coins,dp);
        int take=Integer.MAX_VALUE;
        if(t>=coins[i]){
            take=1+getMinCoins(i,t-coins[i],coins,dp);
        }
        dp[i][t]=Math.min(take,notTake);
        return dp[i][t];
    }





}
