import java.util.*;

public class frogKJumps {
    // this questions is similar to the previous question , except that we will have to do the recursion for the k steps rather than 2 steps
    // we will look at the memoization and the tabulation solution of this problem
    public static void main(String[] swami){
        Scanner s =new Scanner(System.in);
        int n=s.nextInt();
        int[] stairs=new int[n];
        for(int i=0;i<n;i++){
            stairs[i]=s.nextInt();
        }
        int k=s.nextInt();
        int[] dp=new int[n];
        System.out.println(getMin(stairs,dp,k,n-1));
    }
    public static int getMin(int[] stairs,int[] dp,int k,int n){
        if(n==0){
            return 0;
        }
        if(dp[n]!=0){
            return dp[n];
        }
        int min=Integer.MAX_VALUE;
        for(int i=0;i<k;i++){
            if(n-i-1<0){
                break;
            }
            int l=getMin(stairs,dp,k,n-i-1)+Math.abs(stairs[n]-stairs[n-i-1]);
            min=Math.min(l,min);
        }
        dp[n]=min;
        return min ;
    }
}
