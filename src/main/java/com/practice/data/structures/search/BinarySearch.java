package com.practice.data.structures.search;

/**
 * Problem statement: We are given an array of integers, nums, sorted in ascending order, and an integer value, target.
 * If the target exists in the array, return its index. If the target does not exist, then return -1.
 */
public class BinarySearch {

    public int findElementInArray(int[] inputArray,int targetElement){
        int index = -1;
        int left = 0;
        int right = inputArray.length - 1;
        int middle = left + ((right-left)/2);
        while(left <= right){
            if(inputArray[middle] == targetElement){
                index = middle;
                break;
            } else if(inputArray[middle] > targetElement){
                right = middle - 1;
                middle = left + ((right-left)/2);
            } else if(inputArray[middle] < targetElement){
                left = middle + 1;
                middle = left + ((right-left)/2);
            }
        }

        return index;
    }

    public static void main(String[] args) {
        int[] inputArray = {1, 2, 3};
        int targetElement = 3;
        BinarySearch binarySearch = new BinarySearch();
        System.out.println(binarySearch.findElementInArray(inputArray,targetElement));
    }

}
