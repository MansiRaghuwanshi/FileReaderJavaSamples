package com.tech.practice;

interface PracticeSearchPerformance {
    public int searchLinear(int[] arr, int num);

    public int searchBinary(int[] arr, int num);
}

class PracticeSearchProxy implements PracticeSearchPerformance {
    PracticeSearch practiceSearch;

    @Override
    public int searchLinear(int[] arr, int num) {
        practiceSearch = new PracticeSearch();
        long start = System.currentTimeMillis();
        int result = practiceSearch.searchLinear(arr, num);
        long requiredTime = System.currentTimeMillis() - start;
        System.out.println( "Performance of Linear search -->" +"" + requiredTime );
        return result;
    }

    @Override
    public int searchBinary(int[] arr, int num) {
        practiceSearch = new PracticeSearch();
        long start = System.currentTimeMillis();
        int result = practiceSearch.searchBinary(arr, num);
        long requiredTime = System.currentTimeMillis() - start;
        System.out.println("The performance of binary search --> " + requiredTime );
        return result;
    }


}

public class PracticeSearch implements PracticeSearchPerformance {


    public int searchLinear(int[] arr, int num) {

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == num) {
                System.out.println("The element was found at index -->" + i);
                return i;
            }
        }
        return -1;
    }

    public int searchBinary(int[] arr, int num) {

        int left = 0;
        int right = arr.length -1;

        while(left <= right){
            int middle = left + (right -left)/2 ;
            // Check if num is present at mid
            if(arr[middle] == num){
                System.out.println("Element found at index -->" + middle);
                return middle;
            }
            // If num greater than middle, ignore left half
            if (num > arr[middle]){
                left = middle + 1;
            }// If num greater than middle, ignore left half
            else {
                right = middle -1;
            }
        }
        // if we reach here, then element was not found
        return -1;

    }
}


class Usage {
    public static void main(String[] args) {
        PracticeSearchPerformance practiceSearchProxy = new PracticeSearchProxy();
        int[] array = new int[6];
        array[0] = 2;
        array[1] = 4;
        array[2] = 5;
        array[3] = 100;
        array[4] = 200;
        array[5] = 1000;


        practiceSearchProxy.searchLinear(array, 100);
        practiceSearchProxy.searchBinary(array, 100);
    }
}