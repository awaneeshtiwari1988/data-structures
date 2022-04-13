package com.practice.data.structures.bigO;

import java.util.HashMap;
import java.util.Map;

public class SingleOccurrence {

    public int singleNumber(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }

        int number = 0;
        Map<Integer,Integer> frequencyMap = new HashMap<>();
        for(int i : nums){
            if(!frequencyMap.containsKey(i)){
                frequencyMap.put(i, 1);
            } else {
                frequencyMap.put(i, frequencyMap.get(i) + 1);
            }
        }

        for(Integer input : frequencyMap.keySet()){
            if(frequencyMap.get(input) < 2){
                number = input;
            }
        }

        return number;
    }

    public static void main(String[] args) {
        SingleOccurrence singleOccurrence = new SingleOccurrence();
        int[] inputArray = {2,2,1};
        System.out.println(singleOccurrence.singleNumber(inputArray));
    }
}
