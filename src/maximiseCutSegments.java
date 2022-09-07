
import java.util.*;
public class maximiseCutSegments {
    //Function to find the maximum number of cuts.
    public int maximizeCuts(int n, int x, int y, int z)
    {
        // Your code here
        // we need to find the maximum cuts we can get using the given number as the total length
        // this problem is very similar to the coin change problem
        // the time complexity and the space complexity are o(n) because one of the dimension of the dp array will always have the length equal to 3
        // this is the solution submitted in gfg
        
        HashSet<Integer> b=new HashSet<>();
        b.add(x);
        b.add(y);
        b.add(z);
        int len=b.size();
        int[] a=new int[len];
        int k=0;
        for(int i : b){
            a[k]=i;
            k++;
        }
        int[][] dp=new int[len][n+1];
        int ans= getMax(n,len-1,dp,a);

        if(ans<0){
            return 0;
        }
        return ans;
    }

    // further we can get the tabulation and the space optimised form of the solution easily

    public int getMax(int n,int i,int[][] dp,int[] a){
        if(i==0){
            if(n%a[i]==0){
                return n/a[i];
            }
            return (int)Math.pow(-10,9);
        }
        if(dp[i][n]>0){
            return dp[i][n];
        }
        int notTake=getMax(n,i-1,dp,a);
        int take=Integer.MIN_VALUE;
        if(n>=a[i]){
            take=getMax(n-a[i],i,dp,a)+1;
        }
        dp[i][n]= Math.max(take,notTake);
        return dp[i][n];
    }
}
