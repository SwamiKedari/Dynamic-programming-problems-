import java.util.*;
public class longestStringChain {
    public int longestStrChain(String[] a) { // doubt
        // this question is similar to the longest increasing subsequence problem
        // just the comparison operation over here will be different with string character comparisons
        // you can make the tabulation and the space optimised code using the longest increasing subsequence problem
        // we first sort the string array based on the length as the order is not important in this case and we can take the longest string chain of all the possible chains
        Arrays.sort(a,new Comparator<String>(){
            public int compare(String s1,String s2){
                return s1.length()-s2.length();
            }
        });

        int n=a.length;
        int[][] dp=new int[n][n+1];
        return getLong(a,0,-1,n,dp);

    }

    public int getLong(String[] a,int i,int pr,int n,int[][] dp){
        if(i==n){
            return 0;
        }
        if(dp[i][pr+1]>0){
            return dp[i][pr+1];
        }

        int notTake=getLong(a,i+1,pr,n,dp);
        int take=Integer.MIN_VALUE;
        if(pr==-1 || comp(a,pr,i)){
            take=1+getLong(a,i+1,i,n,dp);
        }
        dp[i][pr+1]=Math.max(take,notTake);
        return dp[i][pr+1];
    }

    public boolean comp(String[] a,int i,int j){
        int n1=a[j].length();
        int n2=a[i].length();
        if(n1-n2!=1){
            return false;
        }
        int count=0;
        int k=0,l=0;
        while(k<n1 && l<n2){
            if(a[j].charAt(k)==a[i].charAt(l)){
                k++;
                l++;
            }
            else if(count<1){
                k++;
                count++;
            }
            else{
                return false;
            }
        }
        return true;
    }
}

