package com.practice.data.structures.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;


class Main {
    public static void main(String args[] ) throws Exception {
        String inputData = "";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputLine = "";
        int numberOfDataSets = Integer.MIN_VALUE;
        int n = 0, k = 0;
        String kNumbers = "";
        while((inputLine = br.readLine()) != null) {
            if (numberOfDataSets < 0) {
                numberOfDataSets = Integer.valueOf(inputLine);
            } else {
                String[] input = inputLine.split(" ");
                n = Integer.valueOf(input[0]);
                k = Integer.valueOf(input[1]);
                kNumbers = br.readLine();
                System.out.println(getNumberOfSquareBrackets(n, k));
            }
        }
    }

    public static void codeHere(String inputData) throws Exception {
    }

    public static int getNumberOfSquareBrackets(int n, int k){
        int val = getMax(2*n, k);
        return val/(n+1);
    }

    public static int getMax(int n, int k){
        int output = 1;

        if(k > n -k){
            k = n - k;
        }

        for(int i =0; i < k ; ++i){
            output *= n -i;
            output /= i + 1;
        }

        return output;
    }
}