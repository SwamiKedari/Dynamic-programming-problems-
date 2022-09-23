import java.util.*;

public class maxSquaresInTheMatrix {
    // in this problem, we have to find the total number of squares that can  are present in the matrix which has the every element equal to one in the cell
    // we solve this question using the dp on partition and using the tabulation form of the code
    public static void main(String[] swami){
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int m=s.nextInt();
        int[][] a=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                a[i][j]=s.nextInt();
            }
        }

        System.out.println("The total number of squares in the matrix are :"+countSquares(a));

    }
    // dp[i][j] means the total number of squares which have the right bottom equal to the cell i-j
    public static int countSquares(int[][] m) {
        // in this question, we have to count the total submatrices with all ones in it
        // we will use the tabulation part of the dp to solve this problem
        // dp[i][j] will be equal to the number of squares with the right most bottom corner as the matrix[i][j] as the value
        int r=m.length;
        int c=m[0].length;
        int[][] dp=new int[r][c];
        for(int i=0;i<c;i++){
            dp[0][i]=m[0][i];

        }

        for(int i=0;i<r;i++){
            dp[i][0]=m[i][0];
        }

        for(int i=1;i<r;i++){
            for(int j=1;j<c;j++){
                if(m[i][j]==1){
                    dp[i][j]=Math.min(dp[i-1][j],Math.min(dp[i][j-1],dp[i-1][j-1]))+1;
                }
                else{
                    dp[i][j]=0;
                }
            }

            System.out.println(Arrays.toString(dp[i]));
        }
        return sum(dp);
    }

    public static int sum(int[][] dp){
        int r=dp.length;
        int c=dp[0].length;
        int sum=0;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                sum+=dp[i][j];
            }
        }
        return sum;
    }
}
