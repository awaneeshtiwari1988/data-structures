package com.practice.data.structures.arrays;

import java.util.Arrays;

public class MergeSortedArrays {

    // Given:
    //          1. Two sorted arrays
    //          2. Merge these arrays.
    //          3. Ex: [0,3,4,31] and [4,6,30]

    // Check input
    // New array sie = size of array 1 + size of array 2
    // declare variables

    public int[] sortedArray(int[] array1, int[] array2){
        if(array1.length == 0){
            return array2;
        }

        if(array2.length == 0){
            return array1;
        }

        int outputLength = array1.length + array2.length;
        int[] outputArray = new int[outputLength];
        int i=0,j=0,k=0;
        while (i < array1.length && j < array2.length){
            if(array1[i] < array2[j]){
                outputArray[k++] = array1[i++];
            } else {
                outputArray[k++] = array2[j++];
            }
        }

        while(i < array1.length){
            outputArray[k++] = array1[i++];
        }

        while(j < array2.length){
            outputArray[k++] = array2[j++];
        }

        return outputArray;
    }

    public static void main(String[] args) {
        MergeSortedArrays mergeSortedArrays = new MergeSortedArrays();
        int[] inputArray1 = {0,3,4,31};
        int[] inputArray2 = {4,6,30};
        int[] outputArray = mergeSortedArrays.sortedArray(inputArray1,inputArray2);
        for (int j : outputArray) {
            System.out.println(j);
        }
    }
}
