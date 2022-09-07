import java.util.*;
public class maximumSumOfNonAdjacentElements {
    // in this question , we will find the maximum of the non adjacent elements
    public static void main(String[] swami){
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int[] a =new int[n];
        for(int i=0;i<n;i++){
            a[i]=s.nextInt();
        }
        int[] dp=new int[n];
        int i=0;
        System.out.println(getMax(a,n-1,n,dp));
        System.out.println(Arrays.toString(dp)); // this is the recursion + memoization part of the code

        // now we will look at the tabulation and the space optimization parts of the codes
        // tabulation code
        dp=new int[n];
        dp[0]=a[0];
        for( i=1;i<n;i++){
            int n1=dp[i-1];
            int n2=0;
            if(i>1){
                n2=dp[i-2];
            }
            int t1=a[i]+n2;
            int t2=n1;

            dp[i]=Math.max(t1,t2);


        }
        System.out.println(dp[n-1]);
        // space optimization
        int dp1=a[0];
        int dp2=0;
        for(i=1;i<n;i++){
            int t1=dp2+a[i];
            int t2=dp1;
            int k=Math.max(t1,t2);
            dp1=k;
            dp2=t2;
        }

        System.out.println(dp1);


    }
    public static int getMax(int[] a,int i,int n,int[] dp){
        // we will return a[0] , if i=0 , this is because for n==1 , only one subsequence is present which is a[0]
        if(i==0){
            dp[0]=a[0];
            return a[0];
        }
        // we will return 0 if i values is less than 0
        if(i<0){
            return 0;
        }
        if(dp[i]>0){
            return dp[i];
            // since recursion already computed the value of dp[i] , we will use it
        }
        // either we will take that element and not take the adjacent one
        int n1=a[i]+getMax(a,i-2,n,dp);
        int n2=getMax(a,i-1,n,dp);
        // or we will not take the element and take the adjacent one

        dp[i]=Math.max(n1,n2);
        return dp[i];
    }
}
