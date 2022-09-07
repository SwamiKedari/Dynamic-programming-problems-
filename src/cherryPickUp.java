import java.util.*;
public class cherryPickUp {
    /*
    we have a fixed starting point , a variable ending point
    alice starts at (0,0) and bob starts at (0,m-1)
    both move and collect the chocolates that are there in each cell
    chocolates become zero when they are picked
    they move to the down , diagonally to the left, diagonally to the right to down
    we have to find the maximum chocolates collected by adding both of them

    rules :
    express everything in terms of (i1,j1) and (i2,j2)
    explore all the paths
    get the maximum sum possible
    we will start from the top in recursion  since we have fixed starting point and variable ending point

     */
    public static void main(String[] swami){
        Scanner s = new Scanner(System.in);
        int n=s.nextInt();
        int m=s.nextInt();
        int[][] a =new int[n][m];
        int[][][] dp=new int[n][m][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                a[i][j]=s.nextInt();
            }
        }
        System.out.println("This is the recursion + memoization solution :");

        System.out.println(getCherry(a,dp,0,0,m-1,n,m));

        // now we will use tabulation to solve this problem

         dp=new int[n][m][m];
        for(int j1=0;j1<m;j1++){
            for(int j2=0;j2<m;j2++){
                if(j1==j2){
                    dp[n-1][j1][j2]=a[n-1][j1];
                }
                else{
                    dp[n-1][j1][j2]=a[n-1][j2]+a[n-1][j1];
                }
            }
        }

        for(int i=n-2;i>-1;i--){
            for(int j1=0;j1<m;j1++){
                for(int j2=0;j2<m;j2++){
                  int maxi=0;
                    for(int dj1=-1;dj1<2;dj1++){
                        for(int dj2=-1;dj2<2;dj2++){
                            int k=0;
                            if(j1==j2){
                                k=a[i][j1];
                            }
                            else{
                                k=a[i][j1]+a[i][j2];

                            }
                            if(j1+dj1<0 || j1+dj1>=m || j2+dj2<0 || j2+dj2>=m){
                                k+=Integer.MIN_VALUE;
                            }
                            else{
                                k+=dp[i+1][dj1+j1][dj2+j2];
                            }
                            if(maxi<k){
                                maxi=k;
                            }
                        }
                    }
                    dp[i][j1][j2]=maxi;
                }
            }
        }

        System.out.println("This is the tabulation based answer :");
        System.out.println(dp[0][0][n-1]);


        // now we will do the space optimization for the code
        // for this , we will use 2 2d arrays and then we will keep on transferring data from one array to the next array

        int[][] sp=new int[m][m];
        int[][] sp1=new int[m][m];

        for(int j1=0;j1<m;j1++){
            for(int j2=0;j2<m;j2++){
                if(j1==j2){
                    sp[j1][j2]=a[n-1][j1];
                }
                else{
                    sp[j1][j2]=a[n-1][j2]+a[n-1][j1];
                }
            }
        }


        for(int i=n-2;i>-1;i--){
            for(int j1=0;j1<m;j1++){
                for(int j2=0;j2<m;j2++){
                    int maxi=0;
                    for(int dj1=-1;dj1<2;dj1++){
                        for(int dj2=-1;dj2<2;dj2++){
                            int k=0;
                            if(j1==j2){
                                k=a[i][j1];
                            }
                            else{
                                k=a[i][j1]+a[i][j2];

                            }
                            if(j1+dj1<0 || j1+dj1>=m || j2+dj2<0 || j2+dj2>=m){
                                k+=Integer.MIN_VALUE;
                            }
                            else{
                                k+=sp[dj1+j1][dj2+j2];
                            }
                            if(maxi<k){
                                maxi=k;
                            }
                        }
                    }
                    sp1[j1][j2]=maxi;
                }

            }
            sp=sp1;
            sp1=new int[m][m];
        }
        System.out.println("This is the space optimized solution of the problem : ");
        System.out.println(sp[0][m-1]);









    }
    // the time complexity for the recursion will be o(3^n * 3^n)
    // we will improve the performance by eliminating the overlapping subproblems
    // since we have 3 variables to deal with , in the recursion , we will need a 3d array to store the dp array
    // so the space complexity of this solution is o(n*m*m)
    // we turn the recursive solution to the dp solution by using an extra 3d array
    // this will transform the recursive solution to the dp solution with time complexity of o(n*m*m)*9
    // space complexity is o(n*m*m) + o(n)


    public static int getCherry(int[][] a,int[][][] dp,int i,int j1,int j2,int m,int n){
        if(j1<0 || j1>=m || j2<0 || j2>=m){
            return Integer.MIN_VALUE;
        }
        // both alice and bob will reach to the end at the same time as both move to bottom in each step
        // so we need only one index for the row that is the i , and not i1 and i2
        if(i==n-1){
            if(j1==j2){
                return a[i][j1];
            }
            else{
                return a[i][j2]+a[i][j1];
            }
        }
        // for every moment of alice , we have 3 moments of bob
        // so , we have 9 combinations in total
        // explore all the paths alice and bob can go together
        if(dp[i][j1][j2]>0){
            return dp[i][j1][j2];
        }

        int maxi=0;
        for(int dj=-1;dj<2;dj++){
            for(int dj1=-1;dj1<2;dj1++){
                if(j1==j2){
                    int k=a[i][j1]+getCherry(a,dp,i+1,j1+dj,j2+dj1,m,n);
                    if(maxi<k){
                        maxi=k;
                    }
                }
                else{
                    int k=a[i][j1]+a[i][j2]+getCherry(a,dp,i+1,j1+dj,j2+dj1,m,n);
                    if(maxi<k){
                        maxi=k;
                    }
                }

            }
        }
        dp[i][j1][j2]=maxi;

        return maxi;
    }
}
