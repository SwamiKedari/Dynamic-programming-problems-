import java.util.*;
public class longestIncreasingSubsequence {
    /*
    This is a type of pattern , where we need to find the maximum length of the subsequence which has the increasing arrangement
    In all the questions on the subsequences , we followed the pattern of take or notTake
    subsequence is a contiguous sequence of elements in the array
    The subsequences should be strictly increasing and can not contain equal elements
     */

    /*
    The brute force will not work because it will have the higher time complexity
    We will use recursion :
    Rules of recursion :
    1) Express everything in terms of index
    2) Explore all the possibilities
    3) Take the required thing
     */

    /*
    This recursion will have the parameters as the index and the prevInd as both are required for the next element
    We will start the recursion from the front rather than the back

     */
    public static void main(String[] swami){
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=s.nextInt();
        }
        int[][] dp=new int[n][n+1];
        System.out.println("This is the recursion + memoization solution :");
        System.out.println(getLong(a,0,n,-1,dp));


        // tabulation code
        dp=new int[n+1][n+1];

        for(int i=n-1;i>-1;i--){
            for(int j=i-1;j>=-1;j--){
                int notTake=dp[i+1][j+1];
                int take=Integer.MIN_VALUE;
                if(j==-1 || a[i]>a[j]){
                    take=1+dp[i+1][i+1];
                }

                dp[i][j+1]=Math.max(take,notTake);
            }
        }

        System.out.println("This is the tabulation solution :");
        System.out.println(dp[0][0]);

        // space optimised solution :
        int[] prev=new int[n+1];
        int[] curr=new int[n+1];
        for(int i=n-1;i>-1;i--){
            for(int j=i-1;j>=-1;j--){
                int notTake=prev[j+1];
                int take=Integer.MIN_VALUE;
                if(j==-1 || a[i]>a[j]){
                    take=1+prev[i+1];
                }
                curr[j+1]=Math.max(take,notTake);
            }
            prev=curr;
            curr=new int[n+1];
        }

        System.out.println("This is the space optimised solution :");
        System.out.println(prev[0]);


    }
    // pr->previous element index of that subsequence
    // i-> current element index
    public static int getLong(int[] a,int i,int n,int pr,int[][] dp){
        int take=Integer.MIN_VALUE;
        if(i==n){
            return 0;
        }
        if(pr >=0 && dp[i][pr+1]>0){
            return dp[i][pr+1];
        }
        int notTake=getLong(a,i+1,n,pr,dp);
        if(pr==-1 || a[i]>a[pr]){
            take=1+getLong(a,i+1,n,i,dp);
        }
        dp[i][pr+1]=Math.max(take,notTake);
        return dp[i][pr+1];

    }
}
