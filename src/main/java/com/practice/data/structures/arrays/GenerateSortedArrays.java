package com.practice.data.structures.arrays;

import java.util.ArrayList;
import java.util.List;

public class GenerateSortedArrays {

    public static List<List<Integer>> generateSortedArrays(int[] arr1, int[] arr2) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        generateSortedArraysHelper(arr1, arr2, 0, 0, true, current, result);
        generateSortedArraysHelper(arr1, arr2, 0, 0, false, current, result);
        return result;
    }

    private static void generateSortedArraysHelper(int[] arr1, int[] arr2, int index1, int index2, boolean pickFromArr1, List<Integer> current, List<List<Integer>> result) {
        if (pickFromArr1) {
            for (int i = index1; i < arr1.length; i++) {
                if (current.isEmpty() || current.get(current.size() - 1) <= arr1[i]) {
                    current.add(arr1[i]);
                    generateSortedArraysHelper(arr1, arr2, i + 1, index2, !pickFromArr1, current, result);
                    current.remove(current.size() - 1);
                } else {
                    break;
                }
            }
        } else {
            for (int i = index2; i < arr2.length; i++) {
                if (current.isEmpty() || current.get(current.size() - 1) <= arr2[i]) {
                    current.add(arr2[i]);
                    generateSortedArraysHelper(arr1, arr2, index1, i + 1, !pickFromArr1, current, result);
                    current.remove(current.size() - 1);
                } else {
                    break;
                }
            }
        }

        if (current.size() == arr1.length + arr2.length) {
            result.add(new ArrayList<>(current));
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {9, 12, 66};
        int[] arr2 = {10, 15, 25};

        List<List<Integer>> sortedArrays = generateSortedArrays(arr1, arr2);

        for (List<Integer> array : sortedArrays) {
            System.out.println(array);
        }
    }
}
