import java.util.*;

public class countPartitionsWithGivenDifference {
    // this problem is very similar to the min absolute difference between 2 partitions problem
    /*
    Algo:
    we will find the total sum
    then we will do the tabulation with dp array n*((sum-d)/2 +1)
    then we will get the count value of the index which has value (sum-d)/2 where d is the given difference in the last row of the dp array


     */
    public static void main(String[] swami){
        Scanner s = new Scanner(System.in);
        int n=s.nextInt();
        int[] a = new int[n];
        int sum1=0;
        for(int i=0;i<n;i++){
            a[i]=s.nextInt();
            sum1+=a[i];
        }
        int d=s.nextInt();

        // the tabulation code below
        // here sum1 must be greater than d and value of sum1-d must be positive always

        int sum=(sum1-d)/2;
        int[][] dp=new int[n][sum+1];
        for(int i=0;i<n;i++){
            dp[i][0]=1;
        }
        dp[0][a[0]]=1;
        for(int i=1;i<n;i++){
            for(int t=0;t<=sum;t++){
                int notTake=dp[i-1][t];
                int take=0;
                if(t-a[i]>=0){
                    take=dp[i-1][t-a[i]];
                }
                dp[i][t]=notTake+take;
            }
            System.out.println(Arrays.toString(dp[i]));
        }

        System.out.println(dp[n-1][sum]);

    }

    // we can further optimize the solution by applying space optimization

}
