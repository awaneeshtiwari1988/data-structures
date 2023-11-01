package com.practice.data.structures.arrays;

import java.util.Arrays;

public class MaximizeCircularArraySum {

    public static int maximizeSum(int[] nums){

        Arrays.sort(nums);

        int n = nums.length;
        int maxSum = 0;

        for (int i = 0; i < n/2; i++)
        {
            maxSum -= (2 * nums[i]);
            maxSum += (2 * nums[n - i - 1]);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {9, 8, 4, 2};

        int maxSum = maximizeSum(arr);
        System.out.println("Maximum sum of consecutive differences: " + maxSum);
    }
}
