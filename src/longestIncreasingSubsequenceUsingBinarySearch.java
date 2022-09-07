import java.util.*;
public class longestIncreasingSubsequenceUsingBinarySearch {// doubt
    public static void main(String[] swami){
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=s.nextInt();
        }
        System.out.println(longestSubsequence(n,a));
    }
    //Function to find length of longest increasing subsequence.
    static int longestSubsequence(int n, int a[])
    {
        // code here
        // we will try to solve this question using non-dynamic array traversal
        // the idea is to maintain a arraylist and insert the new elements while traversing in it according to the sorted indexes of the elements
        // then we will just return the size of the arraylist at the end of the traversal
        ArrayList<Integer> ar=new ArrayList<>();
        for(int i=0;i<n;i++){
            int s=ar.size();
            if(s==0 || a[i]>ar.get(s-1)){
                ar.add(a[i]);
                //System.out.println(ar);
                continue;
            }
            else if(a[i]<=ar.get(0)){
                ar.set(0,a[i]);
                //System.out.println(ar);
                continue;
            }
            int h=getActualIndex(ar,a[i],0,s-1,s);

            ar.set(h,a[i]);
            //System.out.println(ar);

        }
        return ar.size();

    }
    static int getActualIndex(ArrayList<Integer> a,int k,int l,int h,int n){
        if(l<=h){
            int mid=(l+h)/2;

            if(mid+1<n && a.get(mid+1)>=k && a.get(mid)<k){
                return mid+1;
            }
            else if(a.get(mid)==k){
                return mid;
            }
            else if(a.get(mid)>k){
                return getActualIndex(a,k,l,mid-1,n);
            }
            else{
                return getActualIndex(a,k,mid+1,h,n);
            }
        }
        return -1;
    }
}
