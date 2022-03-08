package com.practice.data.structures.arrays;

import java.util.HashMap;
import java.util.Map;

public class TwoSums {

    public int[] twosSumPairs(int[] inputArray, int sum){
        int[] outputArray = new int[2];
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < inputArray.length; i++) {
            int complement = sum - inputArray[i];
            if(map.containsKey(inputArray[i])){
                outputArray[0] = map.get(inputArray[i]);
                outputArray[1] = i;
            } else {
                map.put(complement,i);
            }
        }

        return outputArray;
    }

    public static void main(String[] args) {
        TwoSums twoSums = new TwoSums();
        int[] inputArray1 = {3,3};
        int sum = 6;
        int[] twoSumsOutput = twoSums.twosSumPairs(inputArray1,sum);
        for (int i = 0; i < twoSumsOutput.length; i++) {
            System.out.println(twoSumsOutput[i]);
        }
    }
}
