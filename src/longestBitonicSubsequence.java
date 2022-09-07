import java.util.*;

public class longestBitonicSubsequence {// doubt
    public static void main(String[] swami){
        // the below function is the solution submitted in gfg
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=s.nextInt();
        }

        int[][][] dp=new int[n][n+1][2];

        System.out.println("This is the recursion + memoization solution :");
        System.out.println(getLong(a,0,-1,0,n,dp));
        dp=new int[n+1][n+1][2];
        for(int i=n-1;i>-1;i--){
            for(int pr=i-1;pr>=-1;pr--){
                for(int sign=0;sign<2;sign++){
                    int notTake=dp[i+1][pr+1][sign];
                    int take=Integer.MIN_VALUE;
                    if(sign==0 && (pr==-1 || a[i]>a[pr])){
                        int change=1+dp[i+1][i+1][1];
                        int notChange=1+dp[i+1][i+1][0];
                        take=Math.max(change,notChange);
                    }
                    else if(sign==1 && (pr==-1 || a[i]<a[pr])){
                        take=1+dp[i+1][i+1][1];

                    }

                    dp[i][pr+1][sign]=Math.max(notTake,take);
                }
            }
        }

        System.out.println("This is the tabulation solution :");
        System.out.println(dp[0][0][0]);

        // space optimised solution

        int[][] prev=new int[n+1][2];
        int[][] curr=new int[n+1][2];

        for(int i=n-1;i>-1;i--){
            for(int pr=i-1;pr>=-1;pr--){
                for(int sign=0;sign<2;sign++){
                    int notTake=prev[pr+1][sign];
                    int take=Integer.MIN_VALUE;
                    if(sign==0 && (pr==-1 || a[i]>a[pr])){
                        int change=1+prev[i+1][1];
                        int notChange=1+prev[i+1][0];
                        take=Math.max(change,notChange);
                    }
                    else if(sign==1 && (pr==-1 || a[i]<a[pr])){
                        take=1+prev[i+1][1];
                    }
                    curr[pr+1][sign]=Math.max(take,notTake);
                }
            }
            prev=curr;
            curr=new int[n+1][2];
        }

        System.out.println("this is the space optimised solution :");
        System.out.println(prev[0][0]);



    }

    public static int getLong(int[] a,int i,int pr,int sign,int n,int[][][] dp){
        if(i==n){
            return 0;
        }
        if(dp[i][pr+1][sign]>0){
            return dp[i][pr+1][sign];
        }
        int notTake=getLong(a,i+1,pr,sign,n,dp);
        int take=Integer.MIN_VALUE;
        if(sign==0 && (pr==-1 || a[i]>a[pr])){
            int change=1+getLong(a,i+1,i,1,n,dp);
            int notChange=1+getLong(a,i+1,i,0,n,dp);
            take=Math.max(change,notChange);
        }
        else if(sign==1 && (pr==-1 || a[i]<a[pr])){
            take=1+getLong(a,i+1,i,1,n,dp);
        }
        dp[i][pr+1][sign]=Math.max(notTake,take);
        return dp[i][pr+1][sign];
    }

}
