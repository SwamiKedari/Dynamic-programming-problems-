import java.util.*;
public class ninjasTraining {
    //three steps to solve a problem using recursion
    //represent the problem in terms of a index
    //identify all the variables that the each step of recursion takes
    //do all the stuffs that the problem says
    // find the max or get the sum during the recursion
    // f(2,1) means what is the maximum points the ninja can get when he takes the first task on the third index
    // base case will be zero
    // when the index is equal to zero , we will take the maximum of the valid tasks
    // then we will go from all the cases on a particular index and then we will take the maximum of them
    // we will return this max
    // we will also pass the index of task which was performed currently
    // returning max from each index will give us the maximum points that the ninja gets till each day
    // recursion will solve this problem but there are overlapping subproblems in this recursion
    // we will use memoization to solve this
    // the size of the dp array used for the memoization will be n*4 , the 4th value will have the parameter which tells that all the values are not filled
    public static void main(String[] args){
        // we have the function below which shows the maximum points that the ninja can get
        // we use memoization to decrease the overlapping subproblems in it
        Scanner s =new Scanner(System.in);
        int day=s.nextInt();
        ArrayList<ArrayList<Integer>> points=new ArrayList<>();
        for(int i=0;i<day;i++){
            points.add(new ArrayList<Integer>());
        }

        for(int i=0;i<day;i++){
            for(int j=0;j<3;j++) {
                points.get(i).add(s.nextInt());
            }
        }
        ArrayList<ArrayList<Integer>> dp=new ArrayList<>(day);
        for(int i=0;i<day;i++){
            ArrayList<Integer> a=new ArrayList<>(3);
            dp.add(a);
        }
        // the time complexity for the memoization is o(n)
        // we can get the tabulation code by using an array instead of the recursion and then going from bottom to the top
        // further we can get the code for the space optimization by storing the previous values of the elements we need in variables and updating the value of this variables



        //dp.get(0).get(0)=Math.max(points.get(0).get(1),points.get(0).get(2));




        System.out.println(getMaxPoints(day,4,points));

    }

    public static int getMaxPoints(int day,int ind ,ArrayList<ArrayList<Integer>> points){
        if(day==0){
            int maxi=0;
            for(int i=0;i<3;i++){
                if(i!=ind){
                    if(points.get(day).get(i)>maxi){
                        maxi=points.get(day).get(i);
                    }
                }
            }
            return maxi ;
        }

        int max=0;
        for(int i=0;i<3;i++){
            if(i!=ind){
                int h=points.get(day).get(i)+getMaxPoints(day-1,i,points);
                if(h>max){
                    max=h;
                }
            }


        }

        return max;

    }


    public static int getMaxPointsMemo(int day,int ind ,ArrayList<ArrayList<Integer>> dp,ArrayList<ArrayList<Integer>> points){
        if(day==0){
            int maxi=0;
            for(int i=0;i<3;i++){
                if(i!=ind){
                    if(points.get(day).get(i)>maxi){
                        maxi=points.get(day).get(i);
                    }
                }
            }
            return maxi ;
        }

        if(dp.get(day).get(ind)>0){
            return dp.get(day).get(ind);
        }

        int max=0;
        for(int i=0;i<3;i++){
            if(i!=ind){
                int h=points.get(day).get(i)+getMaxPoints(day-1,i,points);
                if(h>max){
                    max=h;
                }
            }


        }

        dp.get(day).set(ind,max);

        return max;

    }



}
