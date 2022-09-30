public class minimumFourSubsequenceSum {
    // the logic of this problem is in : https://www.geeksforgeeks.org/minimum-sum-subsequence-least-one-every-four-consecutive-elements-picked/
    public static int minSum(int arr[], int n)
    {
        //add code here.
        //main thing is to find the recurrence relation ship
        if(n<=4){
            int min=arr[0];
            for(int i=1;i<n;i++){
                min=Math.min(arr[i],min);

            }
            return min;
        }

        for(int i=4;i<n;i++){
            arr[i]=arr[i]+Math.min(Math.min(arr[i-1],arr[i-2]),Math.min(arr[i-3],arr[i-4]));
        }
        return Math.min(Math.min(arr[n-1],arr[n-2]),Math.min(arr[n-3],arr[n-4]));
    }
}
