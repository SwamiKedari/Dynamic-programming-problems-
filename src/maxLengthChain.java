import java.util.*;
public class maxLengthChain {
    int maxChainLength(Pair arr[], int n)
    {
        // your code here
        // this problem is similar to the longest increasing subsequence problem
        // we will store the value of prev pair value so that we can perform comparisons between the current value and the previous value
        // in this question , they have not asked us about the subsequence , we can take the pairs in order or not in order
        // so we first sort the array using a custom comparator as below so that we can get the maximum length using the longest increasing subsequence method

        Arrays.sort(arr,(a,b)->(a.y-b.y));
        int[][] dp=new int[n][n+1];
        return getLong(arr,0,-1,n,dp);
    }

    int getLong(Pair[] a,int i,int pre,int n,int[][] dp){
        if(i==n){
            return 0;
        }

        if(pre>=0 && dp[i][pre+1]>0){
            return dp[i][pre+1];
        }

        int notTake=getLong(a,i+1,pre,n,dp);
        int take=Integer.MIN_VALUE;
        if(pre==-1 || a[i].x>a[pre].y){
            take=1+getLong(a,i+1,i,n,dp);
        }
        dp[i][pre+1]=Math.max(take,notTake);
        return dp[i][pre+1];
    }
}

class Pair{
    int x,y;
}
