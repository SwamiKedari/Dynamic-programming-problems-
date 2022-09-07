import java.util.*;

public class partitionEqualSubsetSum {
    // this problem is very similar to the subsetSumEqualToK problem
    // we will use 2 variables and check the sum at the end
    /*
    In this problem , every element can either be part of first or can be part of second
    we will move from the start , keep on adding the variable either to the first or to the second
    if at the end , both the variables first and second are equal , then we can declare that the partition is possible

     */

    public static void main(String[] swami){
        Scanner s = new Scanner(System.in);
        int n=s.nextInt();
        int[] a = new int[n];
        int sum=0;
        for(int i=0;i<n;i++){
            a[i]=s.nextInt();
            sum+=a[i];
        }

        boolean[][][] dp=new boolean[n][sum+1][sum+1];
        boolean[][][] visited=new boolean[n][sum+1][sum+1];

        System.out.println(hasPartition(a,dp,visited,0,0,0,n));

    }

    // below is the code for the recursive code of hasPartition
    /*
    we convert the recursive code into memoization + recursion by adding extra dp array
    as in the subset problem , we will also require an extra visited array which will be used to keep the track of whether the index was visited or not
    the dp array will be 3 dimensional as we require to store the first sum and second sum along with the index
    the visited array will also be 3 dimensional
    The time complexity of memoization will be

     */
    public static boolean hasPartition(int[] a,boolean[][][] dp,boolean[][][] visited , int i,int f,int s,int n){
        if(i==n){
            if(f==s){
                return true;
            }
            return false;
        }
        if(visited[i][f][s]){
            return dp[i][f][s];
        }
        boolean inFirst=false ;
        boolean inSecond=false;


        inFirst=hasPartition(a,dp,visited,i+1,f+a[i],s,n);
        inSecond=hasPartition(a,dp,visited,i+1,f,s+a[i],n);

        dp[i][f][s]=inFirst | inSecond;
        visited[i][f][s]=true;
        return dp[i][f][s];
    }
}
