package com.practice.data.structures.strings;

public class IsSubsequence {

    public static boolean isSubsequence(String s, String t) {
        for (int i = 0; i < s.length(); i++) {
            if(!t.contains(String.valueOf(s.charAt(i)))){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isSubsequence("axc","ahbgdc"));
    }
}
