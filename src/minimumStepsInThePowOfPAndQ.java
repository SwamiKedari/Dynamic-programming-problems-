import java.util.*;
public class minimumStepsInThePowOfPAndQ {
    public long moves(long n, long p, long q)
    {
        // Your code goes here
        /*
        Anuj has challenged Arun to climb N stairs but at only in powers of P and Q. Now Arun being a lazy guy wants to do this in minimum number of steps possible. So he has asked for your help to calculate the minimum number of steps he requires to take for climbing N stairs ( 1 step = some power of P or Q stairs (including zeroth power) ).
         */
        // the solution can be as following :
        /*
        we can store the powers of 2 and 3 in the array which have value less than the given n
        then we can travel from the back and subtract values to get the answer
        */
        ArrayList<Long> a2=new ArrayList<>();
        ArrayList<Long> a3=new ArrayList<>();
        long a=1;
        int count=1;
        if(p==1){
            a2.add((long)1);
        }
        else{
            while(a<=n){
                a=(long)Math.pow(p,count);
                count++;
                a2.add(a);
            }

        }
        if(q==1){
            a3.add((long)1);
        }
        else{
            count=1;
            a=1;
            while(a<=n){
                a=(long)Math.pow(q,count);
                count++;
                a3.add(a);
            }
        }


        //System.out.println(a2);
        //System.out.println(a3);
        ArrayList<Long> ar=new ArrayList<>();
        int i=0;
        int j=0;
        int n1=a2.size();
        int n2=a3.size();
        if(p!=1 && q!=1){
            ar.add((long)1);
        }
        while(i<n1 && j<n2){
            if(a2.get(i)<a3.get(j)){
                ar.add(a2.get(i));
                i++;
            }
            else{
                ar.add(a3.get(j));
                j++;
            }
        }
        while(i<n1){
            ar.add(a2.get(i));
            i++;
        }
        while(j<n2){
            ar.add(a3.get(j));
            j++;
        }
        // now we will use this ar to pass to the dp array and get the answer
        //System.out.println(ar);
        long[][] dp=new long[(int)n1+n2][(int)n+1];
        return getmin(n,ar,n1+n2-1,dp);

    }

    public long getmin(long n,ArrayList<Long> ar,int i,long[][] dp){
        if(n==0){
            return 0;
        }
        if(i==0){
            if(n%ar.get(i)==0){
                return n/ar.get(i);
            }
            return (long)Math.pow(10,9);
        }
        if(dp[i][(int)n]>0){
            return dp[i][(int)n];
        }
        long notTake=getmin(n,ar,i-1,dp);
        long take=Long.MAX_VALUE;
        if(ar.get(i)<=n){
            take=getmin(n-ar.get(i),ar,i,dp)+1;
            //System.out.println(n-ar.get(i));
        }
        dp[i][(int)n]=Math.min(take,notTake);
        return dp[i][(int)n];
    }
}
