package com.practice.data.structures.arrays;

import java.util.HashSet;
import java.util.Set;

public class FirstRecurringElement {

    public int getFirstRecurringElement(int[] inputArray){
        int firstRecurringElement = -1;
        Set<Integer> set = new HashSet<>();
        for(int input : inputArray){
            if(set.contains(input)){
                return firstRecurringElement = input;
            } else {
                set.add(input);
            }
        }

        return firstRecurringElement;
    }

    public static void main(String[] args) {
        FirstRecurringElement firstRecurringElement = new FirstRecurringElement();
        int[] inputArray = {2,3,4,5};
        System.out.println(firstRecurringElement.getFirstRecurringElement(inputArray));
    }
}
