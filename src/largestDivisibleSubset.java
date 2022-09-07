import java.util.*;
public class largestDivisibleSubset {
    public List<Integer> largestDivisibleSubset(int[] a) {
        // one way to solve this problem is that we can sort the array and then pass the previous element indexes to the next
        // for finding the answer , we will have to traverse through the dp array ,and then we can store the answer in the arraylist
        // the answer involves storing the elements back in the arraylist for printing
        int n=a.length;
        Arrays.sort(a);
        int[][] dp=new int[n+1][n+1];
        for(int i=n-1;i>-1;i--){
            for(int pr=i-1;pr>=-1;pr--){
                int notTake=dp[i+1][pr+1];
                int take=Integer.MIN_VALUE;
                if(pr==-1 || a[i]%a[pr]==0){
                    take=1+dp[i+1][i+1];
                }
                dp[i][pr+1]=Math.max(take,notTake);
            }
        }
        System.out.println(dp[0][0]);

        ArrayList<Integer> arr=new ArrayList<>();

        int ind=0 , pr=0;

        while(ind<n){
            if(dp[ind][pr]==dp[ind+1][pr]){
                ind++;
            }
            else{
                arr.add(a[ind]);
                pr=ind+1;
                ind++;
            }
        }

        return arr;

    }

    public int getLong(int[] a,int i,int n,int pr,int[][] dp){
        if(i==n){
            return 0;
        }
        if(pr>=0 && dp[i][pr]>0){
            return dp[i][pr];
        }
        int notTake=getLong(a,i+1,n,pr,dp);
        int take=Integer.MIN_VALUE;
        if(pr==-1 || a[i]%a[pr]==0){
            take=1+getLong(a,i+1,n,i,dp);
        }
        dp[i][pr]=Math.max(take,notTake);
        return dp[i][pr];
    }

}
