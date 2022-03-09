package com.practice.data.structures.arrays;

public class RotateArray {

    public void rotate(int[] nums, int k) {
        if(k > nums.length){
            k = k % nums.length;
        }
        int numsLength = nums.length;
        int tempArrayLength = Math.abs(numsLength - k);
        int[] tempArray = new int[tempArrayLength];
        for(int i=0; i < tempArrayLength; i++){
            tempArray[i] = nums[i];
        }

        for(int i = tempArrayLength, j =0; i < nums.length; i++,j++){
            nums[j] = nums[i];
        }

        for(int i = k, j = 0; j < tempArrayLength; i++, j++){
            nums[i] = tempArray[j];
        }
    }

    public static void main(String[] args) {
        int[] inputArray = {-1};
        RotateArray rotateArray = new RotateArray();
        rotateArray.rotate(inputArray,2);
        for(int i : inputArray){
            System.out.println(i);
        }
    }
}
