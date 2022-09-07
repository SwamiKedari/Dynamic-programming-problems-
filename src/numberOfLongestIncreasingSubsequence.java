import java.util.*;
public class numberOfLongestIncreasingSubsequence {
    public int findNumberOfLIS(int[] a) {
        // along with the dp array , we will also keep a count array which will help use to get the answer
        // this solution will be similar to the longest increasing subsequence problem using the iterative solution
        // we will keep the count array which keeps the count of the longest increasing subsequences till that index
        // whenever we find the lis till that index to be bigger , we update the value of the count to the new lis
        // watch dp 47 for the more clarity from striver

        int n=a.length;
        int[] dp=new int[n];
        int[] count=new int[n];
        Arrays.fill(dp,1);
        Arrays.fill(count,1);
        int maxi=1;
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(a[i]>a[j] && dp[i]<dp[j]+1){
                    dp[i]=dp[j]+1;
                    count[i]=count[j];
                }
                else if(a[i]>a[j] && dp[i]==dp[j]+1){
                    count[i]+=count[j];
                }
                if(dp[i]>maxi){
                    maxi=dp[i];
                }

            }
        }
        System.out.println(Arrays.toString(dp));
        System.out.println(maxi);

        int num=0;
        for(int i=0;i<n;i++){
            if(dp[i]==maxi){
                num+=count[i];
            }
        }

        return num;


    }
}

