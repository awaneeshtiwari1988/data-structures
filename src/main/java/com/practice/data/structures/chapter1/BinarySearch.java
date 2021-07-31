package com.practice.data.structures.chapter1;

public class BinarySearch {

    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        int[] originalArray = {1,2,5,7,8,9};
        System.out.println(binarySearch.binarySearch(originalArray,0, originalArray.length-1,6));
    }

    /**
     * @param originalArray
     * @param left
     * @param right
     * @param searchNum
     * @return int
     */
    public int binarySearch(int[] originalArray, int left, int right, int searchNum){
        int middle;
        while (left <= right) {
            middle = (left + right)/2;
            if(originalArray[middle] > searchNum){
                right = middle - 1;
                return binarySearch(originalArray,left,right,searchNum);
            } else if (originalArray[middle] < searchNum){
                left = middle + 1;
                return binarySearch(originalArray,left,right, searchNum);
            } else if (originalArray[middle] == searchNum) {
                return middle;
            }
        }
        return -1;
    }
}
