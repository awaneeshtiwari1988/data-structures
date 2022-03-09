package com.practice.data.structures.arrays;

public class MoveZeroes {

    public int[] moveZeroes(int[] nums) {
        int[] outputArray = new int[nums.length];
        int index = 0;
        for(int i : nums){
            if(i != 0){
                outputArray[index] = i;
                index++;
            }
        }

        while(index < nums.length){
            outputArray[index] = 0;
            index++;
        }

        return outputArray;
    }

    public static void main(String[] args) {
        int[] inputArray = {0,1,0,3,12};
        MoveZeroes moveZeroes = new MoveZeroes();
        int[] output = moveZeroes.moveZeroes(inputArray);
        for (int j : output) {
            System.out.println(j);
        }
        System.out.println();
    }
}
