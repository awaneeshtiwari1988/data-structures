package com.practice.data.structures.chapter1;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {
        SelectionSort selectionSort = new SelectionSort();
        int[] inputArray = {2,5,1,7,9,8};
        System.out.println(Arrays.toString(selectionSort.sortElementsBySelection(inputArray)));
    }

    public int[] sortElementsBySelection(int[] originalArray){
        if(originalArray.length == 0){
            return originalArray;
        }

        int min, temp;
        for(int i=0; i < originalArray.length - 1;i++){
            min = i;
            for (int j = i+1; j < originalArray.length; j++) {
                if(originalArray[j] < originalArray[min]){
                    min = j;
                }
            }
            temp = originalArray[i];
            originalArray[i] = originalArray[min];
            originalArray[min] = temp;
        }

        return originalArray;
    }
}
