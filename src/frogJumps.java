import java.util.*;

public class frogJumps {
    // in this question , we have the stairs represented by the array
    // the frog can move 1 step or 2 steps
    // we need to find the minimum cost to go to the end from the 0th index
    // cost is equal to the absolute difference between the steps


    public static void main(String[] swami){
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int[] stairs=new int[n];
        for(int i=0;i<n;i++){
            stairs[i]=s.nextInt();
        }
        System.out.println(calMin(stairs,n-1));
        int[] cal=new int[n];
        System.out.println(calMin(stairs,n-1,cal));

        // now we will implement the tabulation solution for this problem
        // this solution is better than the other 2 solutions because it reduces the stack space that is required in the first two solutions

        int[] dp=new int[n];
        dp[0]=0;
        for(int i=1;i<n;i++){
            int left=dp[i-1]+Math.abs(stairs[i]-stairs[i-1]);
            int right=Integer.MAX_VALUE;
            if(i>1){
                right=dp[i-2]+Math.abs(stairs[i]-stairs[i-2]);
            }

            dp[i]=Math.min(left,right);
        }

        System.out.println(dp[n-1]);

        // further we can also do space optimization and reduce the space complexity to O(1) by not storing the arary of dp array and just storing last 2 in variables


    }

    public static int calMin(int[] stairs , int n){

        // this is the recursive solution
        // it can be improved by using an extra array to solve the question
        if(n==0){
            return 0;
        }
        int left=calMin(stairs,n-1)+Math.abs(stairs[n-1]-stairs[n]);
        int right=0;
        if(n==1){
            right=Integer.MAX_VALUE;
        }
        else{
            right=calMin(stairs,n-2)+Math.abs(stairs[n-2]-stairs[n]);
        }

        return Math.min(left,right);
    }

    public static int calMin(int[] stairs ,int n,int[] cal){
        // this is also a recursive solution but it involves the use of extra array which is used to store the values of the computed recursions
        // this is the memoization solution
        if(n==0){
            return 0;
        }
        int left=0;
        int right=0;
        if(cal[n-1]==0){
            cal[n-1]=calMin(stairs,n-1,cal);
            left=cal[n-1]+Math.abs(stairs[n-1]-stairs[n]);

        }
        else{
            left=cal[n-1]+Math.abs(stairs[n-1]-stairs[n]);
        }

        if(n==1){
            right=Integer.MAX_VALUE;

        }
        else if(cal[n-2]==0){
            cal[n-2]=calMin(stairs,n-2,cal);
            right=cal[n-2]+Math.abs(stairs[n-2]-stairs[n]);
        }
        else{
            right=cal[n-2]+Math.abs(stairs[n-2]-stairs[n]);
        }

        return Math.min(left,right);

    }


}
