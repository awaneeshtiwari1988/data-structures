package com.practice.data.structures.arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class RemoveDuplicates {


    public static void main(String[] args) {
        int[] nums1 = {1, 1, 2};
        int k1 = removeDuplicates(nums1);
        System.out.println("Number of unique elements: " + k1);
        for (int i = 0; i < k1; i++) {
            System.out.print(nums1[i] + " ");
        }
        // Output: Number of unique elements: 2, 1 2

        int[] nums2 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int k2 = removeDuplicates(nums2);
        System.out.println("\nNumber of unique elements: " + k2);
        for (int i = 0; i < k2; i++) {
            System.out.print(nums2[i] + " ");
        }

        removeDuplicate(new int[]{2, 2, 3, 3, 7, 5});
    }

    public static int removeDuplicates(int[] nums){
        if(nums.length == 0){
            return 0;
        }

        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if(nums[j] != nums[i]){
                i++;
                nums[i] = nums[j];
            }
        }

        return i+1;
    }

    public static ArrayList<Integer> removeDuplicate(int arr[]) {

        if(arr.length == 0){
            return new ArrayList<>();
        }


        LinkedHashSet<Integer> uniqueElements = new LinkedHashSet<>();

        for(int element : arr){
            uniqueElements.add(element);
        }

        return new ArrayList<>(uniqueElements);

    }
}
