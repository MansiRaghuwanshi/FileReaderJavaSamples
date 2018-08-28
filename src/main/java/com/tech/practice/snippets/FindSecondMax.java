package com.tech.practice;

public class FindSecondMax {

    public static int finMax(int [] a){
        int max = a[0];
        int max2 = a[0];

        for(int i =1; i<a.length;i++){
            if(a[i] > max ){
                max = a[i];
            }

        }
        System.out.println("the first max-->" + max );
        for (int i=1;i<a.length;i++){
            if(a[i]>a[i-1] && a[i]< max){
                max2 = a[i];
            }
        }
        System.out.println("The sec max -->" + max2);
        return max;
    }

    public static void main(String[] args) {
        int [] a ={-1,57,6,7};
       int returnedMax= finMax(a);
    // int secMax = finMax(a,returnedMax);
     //   System.out.println("first Max-->" + returnedMax);
     //   System.out.println("sec Max-->" + secMax);
    }
}
