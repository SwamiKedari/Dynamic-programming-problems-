import java.util.*;
public class countSubsetsWithSumK {
    // we have to count the subsets with the sum K
    // the problem is similar to the subset with sum K
    // the only difference is that we have to calculate the total subsets rather than checking whether it is present
    /*
    here f(n-1,sum) means the total subsequences that we get till the index n-1 which has the sum equal to K
    This code is valid if all the array elements have value greater than 0
    This code is not valid for cases where the array elements have value equal to 0
    To convert the code such that it also works for zeros, we will remove the first line of the recursion which tells that we must return if sum is zero



     */
    public static void main(String[] swami){
        Scanner s = new Scanner(System.in);
        int n=s.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=s.nextInt();
        }
        int sum=s.nextInt();
        int[][] dp=new int[n][sum+1];
        System.out.println("This is the recursion + memoization solution :");
        System.out.println(getCount(a,n-1,sum,dp));

        // tabulation code below
        dp=new int[n][sum+1];
        dp[0][a[0]]=1;
        for(int i=0;i<n;i++){
            dp[i][0]=1;
        }
        for(int i=1;i<n;i++){
            for(int t=0;t<=sum;t++){
                int notTake=dp[i-1][t];
                int take=0;
                if(t>=a[i]){
                    take=dp[i-1][t-a[i]];
                }
                dp[i][t]=take+notTake;
            }
        }

        System.out.println("This is the tabulation code for the problem :");
        System.out.println(dp[n-1][sum]);

        // then we space optimize the solution
        int[] prev=new int[sum+1];
        int[] curr=new int[sum+1];
        prev[a[0]]=1;
        prev[0]=1;
        for(int i=1;i<n;i++){
            for(int t=0;t<=sum;t++){
                int notTake=prev[t];
                int take=0;
                if(t-a[i]>=0){
                    take=prev[t-a[i]];

                }
                curr[t]=notTake+take;
            }
            System.out.println(Arrays.toString(curr));
            curr[0]=1;
            prev=curr;
            curr=new int[sum+1];
        }

        // the time complexity for the space optimized solution is o(n*sum) and space complexity is o(n)

        System.out.println("This is the space optimized solution");
        System.out.println(prev[sum]);
    }
    public static int getCount(int[] a,int i,int t,int[][] dp){
        if(t==0){
            return 1;
        }
        // remove the uppercase when you want to use the code for a[i] which can have zero values

        if(i==0){
            if( t==a[0]){
                return 1;
            }
            return 0;
        }

        // use the below code rather than the upper code for the base case i==0
        /*
        if(i==0){
        if(t==0 && a[0]==0){
        return 2;
        }
        if(t==0 || t==a[0]){
        return 1;
        }
        return 0;
        }
         */
        if(dp[i][t]>0){
            return dp[i][t];
        }
        int notPick=getCount(a,i-1,t,dp);
        int pick=0;
        if(t-a[i]>=0){
            pick=getCount(a,i-1,t-a[i],dp);
        }
        dp[i][t]=notPick+pick;
        return dp[i][t];
    }

}
