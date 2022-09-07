import java.util.*;

public class partitionEqualSubsetSumII {
    // this question  can be also solved using the subset sum equal to k problem , as the partition which divides the subsets in equal parts will have both sums equal to half of the total sum
    // so the problem reduces to getting the subset which has the sum equal to k/2
    //in this question , we need to see whether any subset has its sum equal to k
    /*
    first comes to mind is getting all the subsequences and then finding out the subsequences with value k
    we need to check the value of subset sum and see if sums to k
    rules of recursion :
    1) express in terms of index (ind , target)
    2) explore possibilities of that index
    3) return 1 if sum is equal to target , else not

     */
    public static void main(String[] swami){
        Scanner s = new Scanner(System.in);
        int n=s.nextInt();

        int[] a = new int[n];
        int sum=0;
        for(int i=0;i<n;i++){
            a[i]=s.nextInt();
            sum+=a[i];
        }
        if(sum%2==1){
            System.out.println("The partition is not possible as the total sum is odd ");
        }
        else {
            boolean[][] dp = new boolean[n][sum/2 + 1];
            boolean[][] visited = new boolean[n][sum/2 + 1];
            System.out.println("This is the recursion + memoization solution :");
            System.out.println(getSubset(n - 1, sum/2, a, dp, visited));

            // tabulation code below :
        /* steps for the tabulation
        1) consider always the base case scenario of the recursion
        2) consider the dp array and assign the base case value to the array

         */
            dp = new boolean[n][sum/2 + 1];
            visited = new boolean[n][sum/2 + 1];

            for (int i = 0; i < n; i++) {
                dp[i][0] = true;

            }
            if (a[0] == sum/2) {
                dp[0][a[0]] = true;

                System.out.println("This is the tabulation solution :");
                System.out.println(true);
            } else {


                int k = sum/2;

                for (int i = 1; i < n; i++) {
                    for (int j = 1; j <= sum/2; j++) {
                        boolean notTake = dp[i - 1][j];
                        boolean take = false;
                        if (j >= a[i]) {
                            take = dp[i - 1][j - a[i]];

                        }
                        dp[i][j] = take | notTake;


                    }
                    // System.out.println(Arrays.toString(dp[i]));
                    //t = k;
                }
                System.out.println("This is the tabulation solution :");
                System.out.println(dp[n - 1][k]);

            }

            boolean[] prev = new boolean[sum/2 + 1];
            boolean[] curr = new boolean[sum/2 + 1];

            curr[0] = true;
            for (int i = 1; i < n; i++) {
                for (int j = 1; j <= sum/2; j++) {
                    boolean notTake = prev[j];
                    boolean take = false;
                    if (j >= a[i]) {
                        take = prev[j - a[i]];
                    }
                    curr[j] = take | notTake;

                }
                 //System.out.println(Arrays.toString(prev));
                prev = curr;
                curr[0]=true;
                curr = new boolean[sum/2 + 1];
            }

            System.out.println("This is the space optimized solution :");
            System.out.println(prev[sum/2]);


            // further we convert the tabulation to the space optimization
        }

    }
    // We need to find that in the entire array , till the index n-1 , does there exist the subsequence which has value equal to k
    // i-> index , t->target
    // the time complexity for the recursion is o(2^n)
    // we use dynamic programming to reduce the time complexity to o(n)
    // this is because the recursion has overlapping subproblems
    // we apply memoization to solve this problem
    // for the memoization solution of this problem , we will need a 2d array of size n*target ,
    // along with the dp array , we will also use the visited array which will be used to keep a track whether the indexes are visited or not
    // the time complexity will be o(n*target)
    // the space complexity will be o(n*target) for the memoization solution




    public static boolean getSubset(int i,int t,int[] a,boolean[][] dp,boolean[][] visited){
        if(t==0){
            return true;
        }
        if(i==0){
            return a[0]==t;
        }
        if(visited[i][t]){
            return dp[i][t];
        }

        boolean notTake=getSubset(i-1,t,a,dp,visited);
        boolean take=false;
        if(t>=a[i]){
            take = getSubset(i - 1, t - a[i], a,dp,visited);
        }
        dp[i][t]= take|notTake;
        visited[i][t]=true;
        return dp[i][t];

    }
}
