public class highEffortVsLowEffort {
    // link: https://practice.geeksforgeeks.org/problems/high-effort-vs-low-effort0213/1?page=3&difficulty[]=0&category[]=Dynamic%20Programming&sortBy=submissions
    public int maxAmt(int n , int hi[] , int li[])
    {
        //code here.
        // we will use dp to solve this problem
        int[][] dp=new int[n][2];
        return getmax(hi,li,0,0,n,dp);
    }

    public int getmax(int[] h,int[] l,int i,int prev,int n,int[][] dp){
        if(i==n-1){
            if(prev==0){
                if(h[i]>l[i]){
                    return h[i];
                }
                return l[i];
            }
            return l[i];
        }
        if(dp[i][prev]>0){
            return dp[i][prev];
        }
        if(prev==0){
            int take=getmax(h,l,i+1,1,n,dp)+Math.max(l[i],h[i]);
            int notTake=getmax(h,l,i+1,0,n,dp);
            dp[i][prev]=Math.max(take,notTake);
        }
        else{
            int take= getmax(h,l,i+1,1,n,dp)+l[i];
            int notTake = getmax(h,l,i+1,0,n,dp);
            dp[i][prev]=Math.max(take,notTake);

        }
        return dp[i][prev];

    }
}
