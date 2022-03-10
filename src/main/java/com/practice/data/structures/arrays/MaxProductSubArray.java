package com.practice.data.structures.arrays;

public class MaxProductSubArray {

    public long maxProduct(int[] arr, int n) {
        if(n == 1){
            return arr[n-1];
        }

        long product = arr[0];
        long maxValue = arr[0];
        long minValue = arr[0];
        long prevMax;

        for(int i = 1; i < n ; i++){
            if(arr[i] < 0){
                prevMax = maxValue;
                maxValue = minValue;
                minValue = prevMax;
            }

            maxValue = Math.max(arr[i],maxValue*arr[i]);
            minValue = Math.min(arr[i],minValue*arr[i]);

            product = Math.max(product, maxValue);
        }

        return product;
    }

    public static void main(String[] args) {
        MaxProductSubArray maxProductSubArray = new MaxProductSubArray();
        int[] inputArray = {6, -3, -10, 0, 2};
        System.out.println(maxProductSubArray.maxProduct(inputArray,inputArray.length));
    }
}
