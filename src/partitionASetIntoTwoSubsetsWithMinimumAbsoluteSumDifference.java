
import java.util.*;
public class partitionASetIntoTwoSubsetsWithMinimumAbsoluteSumDifference {
    /*
    in this question , we find the partition in the array which makes the 2 subsets such that they have minimum absolute sum difference
    this question is also based on the subsetSumEqualToK problem
    # for every target value from 1 to target in dp[n-1] in dp[][] , we know whether we can achieve that target in tabulation or not


     */
    public static void main(String[] swami){
        /*
        The algorithm is as follows :
        we will get the dp array using the recursion and memoization with the value of target equal to the total sum of the array
        then we will check from the target/2 to the one side and get the first index which has the value equal to true
        since we are told to get the minimum value of the partition , it will be the first value from the middle of the last row of the dp array

         */
        Scanner s = new Scanner(System.in);
        int n=s.nextInt();
        int[] a=new int[n];
        int sum=0;
        for(int i=0;i<n;i++){
            a[i]=s.nextInt();
            sum+=a[i];
        }
        boolean[][] dp=new boolean[n][sum+1];
        // the dp array that we get from the recursion + memoization will not work as the all the values of the dp array are not filled in case of memoization
        // incase of the tabulation , we fill all the array elements one by one and thus we have values for the all elements
        for(int i=0;i<n;i++){
            dp[i][0]=true;
        }
        dp[0][a[0]]=true;
        for(int i=1;i<n;i++){
            for(int t=0;t<=sum;t++){
                boolean notTake=dp[i-1][t];
                boolean take=false;
                if(a[i]<=t){
                    take=dp[i-1][t-a[i]];
                }
                dp[i][t]=notTake|take;
            }
        }

        // by using tabulation , we make sure that all the elements of the dp array are correctly filled and no element of the dp array was left behind
        // we then travel from the sum/2 to the sum and find the first index which has the value equal to true
        int sum1=0;
        for(int i=sum/2;i<=sum;i++){
            if(dp[n-1][i]){
                sum1=i;
                break;
            }
        }

        System.out.println((sum-sum1)+" "+sum1);

        // keep in mind that the dp calculated from the recursive part dont have all the elements filled in it and only have the required elements according to the recursion indexes provided

        // you can get the space optimized solution for this problem in the same way as the subset with sum k




    }

    public static boolean hasSubsetWithSumK(int[] a,int i,int t,boolean[][] dp,boolean[][] visited){
        if(t==0){
            return true;
        }
        if(i==0){
            return a[i]==t;
        }
        if(visited[i][t]){
            return dp[i][t];
        }
        boolean notTake=hasSubsetWithSumK(a,i-1,t,dp,visited);
        boolean take=false;
        if(t>=a[i]){
            take=hasSubsetWithSumK(a,i-1,t-a[i],dp,visited);
        }
        dp[i][t]=take|notTake;
        visited[i][t]=true;
        return dp[i][t];
    }
}
