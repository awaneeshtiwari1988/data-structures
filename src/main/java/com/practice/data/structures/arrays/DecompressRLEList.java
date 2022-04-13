package com.practice.data.structures.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DecompressRLEList {

    public int[] decompressRLElist(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int count = 0;
        for(int i = 0, j =0; i < nums.length; i= i + 2,j++){
            int pair_0 = nums[i];
            int pair_1 = nums[i+1];
            count = count + pair_0;
            // create 1-d array
            List<Integer> lst = new ArrayList<>();
            while(pair_0 > 0){
                lst.add(pair_1);
                pair_0--;
            }

            map.put(j, lst);
        }

        int[] output = new int[count];
        int k =0;
        for(Integer position : map.keySet()){
            List<Integer> outputList = map.get(position);
            for(int i =0; i < outputList.size(); i++){
                output[k] = outputList.get(i);
                k++;
            }
        }

        return output;
    }
}
