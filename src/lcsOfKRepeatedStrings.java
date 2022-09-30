public class lcsOfKRepeatedStrings {
    static int lcsK(int k, String st){
        // code here
        // link : https://practice.geeksforgeeks.org/problems/lcs-of-0-k-repeated-string5642/1?page=4&difficulty[]=0&category[]=Dynamic%20Programming&sortBy=submissions
        boolean isdiff=false;
        int n=st.length();
        int startlen=0;
        int endlen=0;
        int sInd=0;
        int eInd=n-1;
        if(st.charAt(0)=='0' && st.charAt(n-1)=='0'){
            isdiff=true;
            for(int i=0;i<n;i++){
                if(st.charAt(i)=='1'){
                    startlen=i;
                    sInd=i;
                    break;
                }
            }
            for(int i=n-1;i>-1;i--){
                if(st.charAt(i)=='1'){
                    endlen=n-i-1;
                    eInd=i;
                    break;
                }
            }
        }
        if(startlen==0 && isdiff){
            return n*k;
        }
        int count=0;
        int maxcount=0;
        for(int i=sInd;i<=eInd;i++){
            if(st.charAt(i)=='1'){
                maxcount=Math.max(count,maxcount);
                count=0;
            }
            else{
                count++;
            }

        }

        if(!isdiff){
            return maxcount;
        }
        else{
            return Math.max((startlen+endlen),maxcount);
        }


    }
}
