import java.util.*;
public class minimumCostToCutTheStick {
    // in this problem , we cut the stick at the indexes given and then find the minimum cut to cut the stick , this minimum cut depends on the order in which the stick is being cut and if we kept the cuts in a proper order , the cut will be minimum
    // this is a problem on dp on partition
    // cut is the length of the string you are cutting
    // the cuts can be given in any order , the minimum cut depends on the order in which we cut this stick
    // we want to find this minimum cut to cut the stick
    // To get the minimum cut to cut the stick , we first add the zero value at the beginning and the length value at the end
    // then we sort the cut array
    // then we get the minimum cut of all the cuts that we do either from the beginning to the end
    // this will give the answer
    // the answer will be optimised by using the memoization , tabulation and the space optimization

    public static void main(String[] swami){

        Scanner s=new Scanner(System.in);
        int n = s.nextInt();
        int m=s.nextInt();
        int[] a=new int[m];
        for(int i=0;i<m;i++){
            a[i]=s.nextInt();
        }
        int[] cut= new int[m+2];
        cut[0]=0;
        for(int i=1;i<=m;i++){
            cut[i]=a[i-1];
        }
        cut[m+1]=n;

        Arrays.sort(cut);
        int[][] dp=new int[m+2][m+2];
        // we will write the tabulation code over here
        /*
        the steps to compute the tabulation code are as follows
        1) copy the base case
        2) copy the changing parameter with the values changing opposite to the memoization
        3) copy the recursion part of the problem


         */
        // base case is already satisfied as the value of the arrays are initially zero

        for(int i=m;i>0;i--){
            for(int j=1;j<=m;j++){
                if(i>j){
                    continue;
                }
                int mini=Integer.MAX_VALUE;
                for(int k=i;k<=j;k++){
                    mini=Math.min(mini,dp[i][k-1]+dp[k+1][j]+cut[j+1]-cut[i-1]);
                }
                dp[i][j]=mini;
            }
        }

        System.out.println("The tabulation answer for the question is :"+dp[1][m]);


    }

    public int minCost(int n, int[] cuts) {
        // we have to cut the stick into the parts such that the cost to cut the stick would be minimum
        int[] cut=new int[cuts.length+2];
        int m=cuts.length;
        cut[0]=0;
        for(int i=0;i<m;i++){
            cut[i+1]=cuts[i];
        }
        cut[m+1]=n;
        Arrays.sort(cut);
        int[][] dp=new int[m+2][m+2];
        return getMin(cut,1,m,dp);

    }

    public int getMin(int[] cut,int i,int j,int[][] dp){
        if(i>j){
            return 0;
        }
        if(dp[i][j]>0){
            return dp[i][j];
        }
        int mini=Integer.MAX_VALUE;
        for(int k=i;k<=j;k++){
            mini=Math.min(getMin(cut,i,k-1,dp) + getMin(cut,k+1,j,dp) + cut[j+1]-cut[i-1], mini);
        }

        dp[i][j]=mini;
        return dp[i][j];
    }
    // the time complexity for the memoization solution is O(m*m) * m , out side m is the for loop and o(m*m) is due to the dp array that is used
    // the space complexity for the memoization solution is o(m*m) for the dp array along with the auxillary stack space

}
