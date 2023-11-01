package com.practice.data.structures.arrays;

import java.util.HashMap;
import java.util.Map;

public class CountSubArrays {

    public static int countSubArrays(int[] arr){
        int count = 0;
        int diff = 0;
        Map<Integer,Integer> countMap = new HashMap<>();
        countMap.put(0, 1);

        for (int num: arr) {
            if(num == 0){
                diff--;
            } else {
                diff++;
            }

            if(countMap.containsKey(diff)){
                count += countMap.get(diff);
                countMap.put(diff, countMap.get(diff) + 1);
            } else {
                countMap.put(diff,1);
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 0};
        int result = countSubArrays(nums);
        System.out.println("Number of subarrays with equal 0s and 1s: " + result);
    }
}
