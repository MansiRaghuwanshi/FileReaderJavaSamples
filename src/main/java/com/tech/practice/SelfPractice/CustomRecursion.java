package com.tech.practice.SelfPractice;

import javax.swing.undo.CannotUndoException;

public class CustomRecursion {

    //Sum calculation Without Recursion

    public static int  calSum(int n){
        int sum =0;
        for(int i =0;i<=n;i++){
            sum = sum +i;
        }
        return sum;
    }


    //Sum calculation with Recursion

    public static int  calSumRecursive(int startNo,int endNo,int sum){
        sum = sum + startNo;
        if(startNo >= endNo){
            return sum;
        }
        return calSumRecursive(++startNo,endNo,sum);
    }

    //Sum calculation with Recursion using just one formal parameter
    public static int  sumRecursive(int n) {

        if(n ==1){
            return 1;
        }
        int x = n+ sumRecursive(n-1);
        return x;

        //or return n+ sumRecursive(n-1)  few instrcution are getting executed before the return statement and since you are
        // on stack you are maintaning the state of your local
        // variables . Only with stack this is possible.;
    }


    //Online :Sum calculation with Recursion
    public static int sumR(int num) {
        int sum;
        if (num == 1) return (1);

        else sum = num + sumR(num - 1); // function calls itself
        return sum;
    }
    // Multiplication using recursion

    public static int  calMulRecursive(int startNo,int endNo,int mul){
        mul = mul * startNo;
        if(startNo >= endNo){
            return mul;
        }
        return calMulRecursive(++startNo,endNo,mul);
    }

    //Recursive factorial

    public static int calFact(int n){
        if(n<0){
            n = n* (-1);
        }
        if(n == 0){
            return 1;
        }
        return n* calFact(n-1);
    }
    public static void main(String[] args) {
//        System.out.println("Sum calculation Without Recursion  -->" + CustomRecursion.calSum(5) );
//        System.out.println("Sum calculation with Recursion  -->" + CustomRecursion.calSumRecursive(1,100,0) );
//        System.out.println("Mulplication calculation with Recursion  -->" + CustomRecursion.calMulRecursive(1,5,1) );
//        System.out.println("Mulplication calculation with Recursion  -->" + CustomRecursion.calFact(-5) );
        System.out.println("Mulplication calculation with Recursion  -->" + CustomRecursion.sumRecursive(5 ));
    }

}
