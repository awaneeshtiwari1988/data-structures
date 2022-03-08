package com.practice.data.structures.bigO;

public class BigOOverview {

    public static void main(String[] args) {
        String[] nemo = {"nemo"};
        BigOOverview bigOOverview = new BigOOverview();
        bigOOverview.findNemo(nemo);
    }

    private void findNemo(String[] inputArray) {
        for (int i = 0; i < inputArray.length; i++) {
            if (inputArray[i].equalsIgnoreCase("nemo")) {
                System.out.println("Found NEMO!");
            }
        }
    }
}
