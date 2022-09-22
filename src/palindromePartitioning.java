import java.util.*;
public class palindromePartitioning {
    // in this problem , we have to find the minimum number of partitions required to divide the given string into the substrings such that all the substrings inside the string that are partitioned are palindromes
    // the partitions are always possible, as the worst case scenario for the string of length n will have n-1 partitions and 1 character palindromes
    // we will use the recurrence from the front end and then we will optimize it using the dp techniques ...
    public static void main(String[] swami){

        Scanner s=new Scanner(System.in);
        String a=s.nextLine();

        System.out.println("the total ways to partition the string are :"+palindromicPartition(a));

        // the tabulation code will have the indexes for the partitioning from the last end and not from the front
        int n=a.length();
        int[] dp=new int[n+1];

        for(int i=n-1;i>-1;i--){
            int min=Integer.MAX_VALUE;
            int cost = 0;
            for(int k=i+1;k<=n;k++){
                if(isPalindrome(a.substring(i,k))){

                    cost=1+dp[k];

                    if(min>cost){

                        min=cost;
                    }
                }
            }

            dp[i]=min;
        }

        System.out.println("The tabulation answer for the solution is: "+(dp[0]-1)); // we subtract 1 from the dp[0] as the partitions that we get are one more due to the partitioning at the end of string after the last character



    }

    /*
    rules for writing the recurrence :
    express everything in terms of the index
    express all possibilities
    take the minimum
     */
    static int palindromicPartition(String str)
    {
        // code here
        int n=str.length();
        int[] dp=new int[n];
        return getMin(str,0,n,dp)-1; // we subtract one because in the code, by default it gives an extra partition at the end of the string after the last character, this issue is solved by subtracting one from the value of the total partitions

    }

    static int getMin(String s,int i,int n,int[] dp){
        if(i==n){
            return 0;
        }
        int min=10000000;
        int cost=0;
        if(dp[i]>0){
            return dp[i];
        }
        for(int k=i+1;k<=n;k++){
            if(isPalindrome(s.substring(i,k))){

                cost=1+getMin(s,k,n,dp);

                if(min>cost){

                    min=cost;
                }
            }
        }
        dp[i]=min;
        return min;

    }

    // the time complexity of the problem with out the memoization will be exponential, and in the case of the memoization, since we are using the one d array, and a forloop inside the recurrence,
    // the time complexity of memoization will be o(n*n)


    static boolean isPalindrome(String k){
        int n=k.length()-1;
        int i=0;
        while(n>=i){
            if(k.charAt(n)!=k.charAt(i)){
                return false;
            }
            n--;
            i++;
        }
        return true;
    }
}
