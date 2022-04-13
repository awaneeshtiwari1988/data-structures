package com.practice.data.structures.arrays;

public class ShuffleArray {

    public static void main(String[] args) {
        int[] nums = {2,5,1,3,4,7};
        int[] output = shuffle(nums,3);
        for(int i : output){
            System.out.print(i + " ");
        }
    }

    private static int[] shuffle(int[] nums, int n) {
        // Create two arrays
        int[] x = new int[n];
        int[] y = new int[n];

        // Populate the arrays
        for(int i=0; i < n; i++){
            x[i] = nums[i];
        }

        for(int i=0; i< n;i++){
            y[i] = nums[i+n];
        }

        // Populate alternate elements in odd and even positions from x and y
        int i = 0, j = 0, k=0;
        while(k < 2*n) {
            if(k % 2 == 0){
                nums[k] = x[i];
                i++;
            } else {
                nums[k] = y[j];
                j++;
            }
            k++;
        }

        return nums;
    }
}
