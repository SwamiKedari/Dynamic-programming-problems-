import java.util.*;
public class knapsack01 {
    // this is the 0-1 knapsack problem
    // you are given an weight array and an value array
    // you are also given an weight w
    // we have steal the things in such a way that the value of the stolen thing is maximum
    /*
    rules of the recursion :
    1) express in terms of index
    2) the criteria will be the weight
    3) so the recursion function will have to parameters index and weight
    4) explore all the possibilities -which are pick and non-pick
    5) find the maximum

     */

    // f(n-1,w) means what is the maximum value we can generate till the index n-1

    public static void main(String[] swami){
        Scanner s = new Scanner(System.in);
        int n=s.nextInt();
        int[] a=new int[n];
        int[] b=new int[n];
        for(int i=0;i<n;i++){
            b[i]=s.nextInt();
            a[i]=s.nextInt();
        }
        int w=s.nextInt();
        System.out.println("This is the recursion + memoization solution ");
        int[][] dp=new int[n][w+1];
        System.out.println(getMax(a,b,dp,n-1,w));

        // tabulation code :
        System.out.println("This is the tabulation solution :");
        dp=new int[n][w+1];
        for(int i=b[0];i<=w;i++){
            dp[0][i]=a[0];
        }
        for(int i=1;i<n;i++){
            for(int k=0;k<=w;k++){
                int notTake=dp[i-1][k];
                int take=Integer.MIN_VALUE;
                if(k>=b[i]){
                    take=dp[i-1][k-b[i]]+a[i];
                }

                dp[i][k]=Math.max(notTake,take);

            }
        }

        System.out.println(dp[n-1][w]);

        // space optimized code :
        // here we use 2 arrays to solve the problem rather than the 2d matrix which we used in tabulation

        int[] prev=new int[w+1];
        int[] curr=new int[w+1];
        for(int i=b[0];i<=w;i++){
            prev[i]=a[0];
        }

        for(int i=1;i<n;i++){
            for(int k=0;k<=w;k++){
                int notTake=prev[k];
                int take=Integer.MIN_VALUE;
                if(k>=b[i]){
                    take=a[i]+prev[k-b[i]];
                }
                curr[k]=Math.max(notTake,take);
            }
            //System.out.println(Arrays.toString(prev));
            prev=curr;
            curr=new int[w+1];
        }

        System.out.println("This is the space optimized solution :");
        System.out.println(prev[w]);

        // now we further space optimize the solution such that the total space will be just o(n) and not o(n+n)
        // we will eliminate the curr array in the previous code and assign the values to the same values in prev
        prev=new int[w+1];
        for(int i=b[0];i<=w;i++){
            prev[i]=a[0];
        }

        for(int i=1;i<n;i++){
            for(int k=w;k>-1;k--){
                int notTake=prev[k];
                int take=Integer.MIN_VALUE;
                if(k>=b[i]){
                    take=prev[k-b[i]]+a[i];

                }
                prev[k]=Math.max(notTake,take);
            }
        }
        System.out.println("This is the space optimised solution op :");
        System.out.println(prev[w]);






    }

    // a[i]->val array
    // b[i]->weight array

    /*
    we use the memoization to solve this in less time complexity

     */

    public static int getMax(int[] a,int[] b,int[][] dp,int i,int w){
        if(i==0){
            if(w>=b[i] && a[i]>0){
                return a[i];
            }
            return 0;
        }

        if(dp[i][w]>0){
            return dp[i][w];
        }

        int take=getMax(a,b,dp,i-1,w);
        int notTake=Integer.MIN_VALUE;
        if(w>=b[i]){
            notTake=getMax(a,b,dp,i-1,w-b[i])+a[i];
        }

        dp[i][w]=Math.max(take,notTake);

        return dp[i][w];

    }
}
