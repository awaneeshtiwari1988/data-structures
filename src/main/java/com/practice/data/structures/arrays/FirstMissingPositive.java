package com.practice.data.structures.arrays;

public class FirstMissingPositive {

    public static int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0 && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i]) {
                int correctPos = nums[i] - 1;
                int temp = nums[correctPos];
                nums[correctPos] = nums[i];
                nums[i] = temp;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != i+1){
                return i+1;
            }
        }

        return nums.length;
    }

    private static void cyclicSort(int[] nums){
        int i =0;
        while(i < nums.length && nums[i] >= 0){
            int numPosition = nums[i] - 1;
            if(nums[i] != nums[numPosition]){
                swap(nums, i, numPosition);
            } else {
                i++;
            }
        }
    }

    private static void swap(int[] nums, int currentIndex, int newIndex){
        int temp = nums[currentIndex];
        nums[currentIndex] = nums[newIndex];
        nums[newIndex] = temp;
    }

    public static void main(String[] args) {
        int[] input = {3,4,-1,1};
        int i = firstMissingPositive(input);
        System.out.println(i);
    }
}
