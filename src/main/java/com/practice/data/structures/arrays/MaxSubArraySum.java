package com.practice.data.structures.arrays;

public class MaxSubArraySum {

    public int[] getMaxSubArraySumIndexes(int[] inputArray){
        int[] outputArray = new int[2];
        int maximumValue = Integer.MIN_VALUE;
        int currentMax = 0, startIndex = 0, endIndex = 0, s = 0;

        for (int i = 0; i < inputArray.length; i++) {
            currentMax = currentMax + inputArray[i];
            if(maximumValue < currentMax){
                maximumValue = currentMax;
                startIndex = s;
                endIndex = i;
            }

            if (currentMax < 0){
                currentMax = 0;
                s = i + 1;
            }
        }
        outputArray[0] = startIndex;
        outputArray[1] = endIndex;
        return outputArray;
    }

    public int getMaxSubArraySum(int[] inputArray){
        int maximumValue = Integer.MIN_VALUE;
        int currentMax = 0;

        for (int j : inputArray) {
            currentMax = currentMax + j;
            if (maximumValue < currentMax) {
                maximumValue = currentMax;
            }

            if (currentMax < 0) {
                currentMax = 0;
            }
        }
        return maximumValue;
    }

    public static void main(String[] args) {
        int[] inputArray = {5,4,-1,7,8};
        MaxSubArraySum maxSubArraySum = new MaxSubArraySum();
        int[] outputArray = maxSubArraySum.getMaxSubArraySumIndexes(inputArray);
        System.out.println("Maximum Subarray sum : " + outputArray[0] + " " + outputArray[1]);
        System.out.println("Maximum Subarray sum : " + maxSubArraySum.getMaxSubArraySum(inputArray));
    }
}
