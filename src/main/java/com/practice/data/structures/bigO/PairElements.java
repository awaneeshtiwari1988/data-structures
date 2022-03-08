package com.practice.data.structures.bigO;

import java.util.HashSet;

public class PairElements {

    public static void main(String[] args) {
        PairElements pairElements = new PairElements();
        int[] inputArray = {1,2,3,9};
        int sum = 8;
        System.out.println(pairElements.isPairPresentWithSum(inputArray,sum));
    }

    public boolean isPairPresentWithSum(int[] inputArray, int sum){
        HashSet<Integer> complementsSet = new HashSet<>();
        int complementElement = 0;
        for(int element : inputArray){
            complementElement = sum - element;
            if(complementsSet.contains(complementElement)){
                return true;
            }
            complementsSet.add(complementElement);
        }

        return false;
    }
}
