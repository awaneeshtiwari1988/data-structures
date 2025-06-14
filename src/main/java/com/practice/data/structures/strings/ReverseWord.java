package com.practice.data.structures.strings;

public class ReverseWord {

    public static String reverseWords(String s) {
        String originalWord = s.trim();

        String[] originalStringArray = originalWord.split(" ");
        StringBuilder sb = new StringBuilder();
        int index = originalStringArray.length - 1;
        while(index >= 0){
            if(!sb.toString().isEmpty()){
                sb.append(" ");
            }

            sb.append(originalStringArray[index]);
            index--;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("the sky is blue"));
    }
}
