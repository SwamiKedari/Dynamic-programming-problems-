import java.util.*;

public class partitionArrayForMaximumSum {
    public static void main(String[] swami){
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=s.nextInt();
        }
        int k=s.nextInt();
        System.out.println("The maximum sum occured by partitioning in the maximum size of k and replacing the values by the maximum value is: "+maximumSubarray(a,k));

        int[] dp=new int[n+1];

        for(int i=n-1;i>-1;i--){
            int max=Integer.MIN_VALUE;
            int cost = 0;
            int count=0;
            int mVal=a[i];
            for(int j=i;j<i+k&& j<n;j++){
                mVal=Math.max(a[j],mVal);
                count++;
                cost=mVal*count+getMax(a,j+1,k,n,dp);
                max=Math.max(cost,max);
            }
            dp[i]=max;
        }

        System.out.println("The tabulation solution for this problem is :"+dp[0]);


        // finding the answer using the tabulation form


    }
    public static int maximumSubarray(int[] a, int k) {
        // Write your code here..
        // this is a dp problem, we have to find the maximum sum that we get after partitioning the array into the parts such that all the parts will give the sum which is equal to the maximum sum
        int n=a.length;
        int[] dp=new int[n];
        return getMax(a,0,k,n,dp);

    }

    public static int getMax(int[] a,int i,int k,int n,int[] dp){
        if(i==n){
            return 0;
        }
        if(dp[i]>0){
            return dp[i];
        }
        int max=Integer.MIN_VALUE;
        int cost=0;
        int count=0;
        int mVal=a[i];
        for(int j=i;j<i+k&& j<n;j++){
            mVal=Math.max(a[j],mVal);
            count++;
            cost=mVal*count+getMax(a,j+1,k,n,dp);
            max=Math.max(cost,max);
        }
        dp[i]=max;
        return dp[i];
    }

}

