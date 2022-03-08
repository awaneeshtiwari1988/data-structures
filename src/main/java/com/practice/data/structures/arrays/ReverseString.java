package com.practice.data.structures.arrays;

import java.util.Arrays;

public class ReverseString {

    public String reverseString(String inputString){
        if (inputString == null || inputString.length() < 2){
            return inputString;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = inputString.length() - 1; i >=0; i--) {
            sb.append(inputString.charAt(i));
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        ReverseString reverseString = new ReverseString();
        System.out.println(reverseString.reverseString("Hi, My name is Awaneesh"));
    }
}
