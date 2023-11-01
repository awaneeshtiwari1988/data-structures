package com.practice.data.structures.arrays;

import java.util.Arrays;
import java.util.HashSet;

public class MaxContiguousSubarray {

    public static int countOfMaxContiguousSubArray(int[] nums){
        if(nums == null || nums.length == 0){
            return 0;
        }

        int maxLength = 0;
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }

        for(int num : nums){
            int ascendingLength = 0;
            int descendingLength = 0;

            int current = num;
            while(set.contains(current)){
                ascendingLength++;
                current++;
            }

            current = num - 1;
            while(set.contains(current)){
                descendingLength++;
                current--;
            }

            maxLength = Math.max(maxLength, Math.max(ascendingLength, descendingLength));
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 3, 2, 8, 4, 8, 10};
        int maxLength = countOfMaxContiguousSubArray(nums);
        System.out.println("Length of the longest contiguous subarray: " + maxLength);
    }
}
