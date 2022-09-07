import java.util.*;
public class printingLongestIncreasingSubsequence{
    public static void main(String[] swami){
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=s.nextInt();
        }
        // the printing the longest increasing subsequence will involve travelling back again from the dp array that we use in the tabulation code
        int[][] dp=new int[n+1][n+1];
        for(int i=n-1;i>-1;i--){
            for(int j=i-1;j>=-1;j--){
                int notTake=dp[i+1][j+1];
                int Take=Integer.MIN_VALUE;
                if(j==-1 || a[i]>a[j]){
                    Take=1+dp[i+1][j+1];
                }
                dp[i][j+1]=Math.max(notTake,Take);
            }
            System.out.println(Arrays.toString(dp[i]));
        }

        System.out.println("This is the tabulation solution :");
        System.out.println(dp[0][0]);

        // now we will travel through this dp array in the reverse order to get the all the elements in the longest increasing subsequence
        ArrayList<Integer> arr=new ArrayList<>(dp[0][0]);

        int ind=0, j=0;
        while(ind<n){
            int k=dp[ind][j];
            if(k==dp[ind+1][j]){
                ind++;
            }
            else{
                arr.add(a[ind]);
                j=ind+1;
                ind++;
            }
        }

        System.out.println("One of the possible Longest increasing subsequence is :");
        System.out.println(arr);


    }
}
