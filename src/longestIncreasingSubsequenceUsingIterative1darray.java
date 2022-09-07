import java.util.*;
public class longestIncreasingSubsequenceUsingIterative1darray {
    public static void main(String[] swami){
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=s.nextInt();
        }

        int[] dp=new int[n];
        int maxi=0;
        for(int i=0;i<n;i++){
            dp[i]=1;
        }
        // we assign 1 to the all values of dp array as the single number has maximum value of the lis equal to 1

        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(a[j]<a[i]){
                    dp[i]=Math.max(dp[i],1+dp[j]);
                }
                if(dp[i]>maxi){
                    maxi=dp[i];
                }
            }
        }

        System.out.println(Arrays.toString(dp));

        System.out.println("This is the answer :");
        System.out.println(maxi);

    }

}
