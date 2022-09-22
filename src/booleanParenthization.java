public class booleanParenthization {
    // in this problem , we have to find the total number of ways in which the boolean expression evaluates to true
    // this problem is very similar to the matrix chain multiplication problem
    // the number of such ways can be very large , so we use mod 1003 for the question
    

    static int countWays(int n , String s ){
        // code here
        // the expression is given in the string format
        // we want to find the total number of ways which make this boolean parenthization true
        // this is a dp problem
        int[][][] dp = new int[n][n][2];
        boolean[][][] visited=new boolean[n][n][2];
        return getTotal(s,0,n-1,true,dp ,visited)%1003;
    }

    static int getTotal(String s,int i,int j,boolean isTrue,int[][][] dp,boolean[][][] visited){
        if(i>j){
            return 0;
        }
        if(isTrue && visited[i][j][1]){
            return dp[i][j][1];
        }
        else if(!isTrue && visited[i][j][0]){
            return dp[i][j][0];
        }
        if(i==j){
            if(isTrue && s.charAt(i)=='T'){
                dp[i][j][1]=1;
                visited[i][j][1]=true;
                return 1;
            }
            else if(!isTrue && s.charAt(i)=='F'){
                dp[i][j][0]=1;
                visited[i][j][0]=true;
                return 1;
            }
            else{
                return 0;
            }
        }

        int ways = 0;

        for(int k=i+1;k<=j-1;k+=2){
            //System.out.println(s.charAt(k));
            if(s.charAt(k)=='&'){
                if(isTrue){
                    ways+=getTotal(s,i,k-1,true,dp,visited)*getTotal(s,k+1,j,true,dp,visited);
                    ways=ways%1003;
                }
                else{
                    ways+=getTotal(s,i,k-1,false,dp,visited)*getTotal(s,k+1,j,true,dp,visited) + getTotal(s,i,k-1,true,dp,visited)*getTotal(s,k+1,j,false,dp,visited)+getTotal(s,i,k-1,false,dp,visited)*getTotal(s,k+1,j,false,dp,visited);
                    ways=ways%1003;
                }
            }
            else if(s.charAt(k)=='|'){
                if(isTrue){
                    ways+=getTotal(s,i,k-1,true,dp,visited)*getTotal(s,k+1,j,true,dp,visited) + getTotal(s,i,k-1,false,dp,visited)*getTotal(s,k+1,j,true,dp,visited) + getTotal(s,i,k-1,true,dp,visited)*getTotal(s,k+1,j,false,dp,visited);
                    ways=ways%1003;
                }
                else{
                    ways+=getTotal(s,i,k-1,false,dp,visited)*getTotal(s,k+1,j,false,dp,visited);
                    ways=ways%1003;
                }
            }
            else{
                if(isTrue){
                    ways+=getTotal(s,i,k-1,true,dp,visited)*getTotal(s,k+1,j,false,dp,visited) + getTotal(s,i,k-1,false,dp,visited)*getTotal(s,k+1,j,true,dp,visited);
                    ways=ways%1003;

                }
                else{
                    ways+=getTotal(s,i,k-1,true,dp,visited)*getTotal(s,k+1,j,true,dp,visited) + getTotal(s,i,k-1,false,dp,visited)*getTotal(s,k+1,j,false,dp,visited);
                    ways=ways%1003;
                }
            }
        }

        if(isTrue){
            dp[i][j][1]=ways;
            visited[i][j][1]=true;
        }
        else{
            dp[i][j][0]=ways;
            visited[i][j][0] =true;
        }

        return ways%1003 ;
    }
}
