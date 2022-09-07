
import java.util.*;
public class bestTimeToBuyAndSellStock {
    /*
    we have to tell the best time to buy and sell the stock
    We will try to buy the stock when it has the minimum possible value and sell it when it has the maximum value
    if you are selling on the ith day , you will try to buy it on the day from 0th to i-1th index which has the minimum value

     */

    /*
    we have to just keep the track of the minimum value of the array to the left of a particular index

     */
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n=s.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=s.nextInt();
        }

        int profit=0;
        int min=a[0];

        for(int i=1;i<n;i++){
            int cost=a[i]-min;
            if(profit<cost){
                profit=cost;
            }
            min=Math.min(a[i],min);
        }

        System.out.println("The maximum profit we get by buying and selling the stocks is :");
        System.out.println(profit);

    }

}
