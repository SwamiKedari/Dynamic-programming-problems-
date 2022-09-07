public class countingWaysToClimbTheStairs {
    // we find the total number of ways to climb the stairs from 0 to n , here the shortcut method to solve this problem is as follows
    // represent the numbers in form of indexes
    // then do the stuff asked in the problem statement
    // for sum of all the ways , count the total ways ,
    // for max ,make comparisons and find the largest , and similar for min

    public static void main(String[] swami){

        System.out.println(countWays(10));
    }

    public static int countWays(int n){
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }

        int h=countWays(n-1); // countways of the index which is 1 less than the current index
        int h1=countWays(n-2); // countways of the index which is 2 less than the current index
        return h+h1; // add the both values to get the total

    }
}
