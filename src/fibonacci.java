

public class fibonacci {

    // by using memoization , we reduce the overlapping sub problems in the fibonacci question
    // this is also an example of dynamic programming

    public static void main(String[] swami){
        int[] fibo=new int[10];
        fibonacciAns(9,fibo);
        for(int i=0;i<10;i++){
            System.out.println(fibo[i]);
        }

        // fibonacciAns() will have time complexity o(n) and space complexity o(n)
        // we can use the iterative method which also reduces the space complexity to o(1) in the following way
        System.out.println("Below is the iterative method to solve the problem ");
        int fibon =0;
        int fibon1=1;
        System.out.println(fibon);
        System.out.println(fibon1);
        int n=10;
        for(int i=2;i<10;i++){
            System.out.println(fibon+fibon1);
            int k=fibon1;
            int h=fibon;
            fibon=k;
            fibon1+=h;
        }


    }

    public static int fibonacciAns(int n,int[] fibo ){
        if(n<=1){
            fibo[n]=n;
            return n;
        }
        if(fibo[n]!=0){
            return fibo[n];
        }
        fibo[n]=fibonacciAns(n-1,fibo)+fibonacciAns(n-2,fibo);
        return fibo[n];
    }
}
