package com.practice.data.structures.arrays;

public class MaxLengthOfRepeatedSubArray {

    public static int maximumLemgthOfRepeatedSubArray(int[] arr1, int[] arr2){
        int length1 = arr1.length;
        int length2 = arr2.length;

        // Create 2 D array using dynamic programmming
        int[][] mergedArray = new int[length1+1][length2+1];
        int maxLength = 0;

        for(int i = 1; i <= length1; i++){
            for(int j = 1; j <= length2;j++){
                if(arr1[i-1] == arr2[j-1]) {
                    mergedArray[i][j] = mergedArray[i - 1][j - 1] + 1;
                    maxLength = Math.max(maxLength,mergedArray[i][j]);
                }
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 2, 1};
        int[] B = {3, 2, 1, 4, 7};

        int maxLength = maximumLemgthOfRepeatedSubArray(A, B);
        System.out.println("Maximum length of repeated subarray: " + maxLength);
    }
}
