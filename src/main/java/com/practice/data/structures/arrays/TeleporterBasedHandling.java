package com.practice.data.structures.arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**String[] teleporters2 = {"5,10", "6,22", "39,40", "40,49", "47,29"};
 String[] teleporters3 = {"6,18", "36,26", "41,21", "49,55", "54,52",
 "71,58", "74,77", "78,76", "80,73", "92,85"};
 String[] teleporters4 = {"97,93", "99,81", "36,33", "92,59", "17,3",
 "82,75", "4,1", "84,79", "54,4", "88,53",
 "91,37", "60,57", "61,7", "62,51", "31,19"};
 String [] teleporters5 = {"3,8", "8,9", "9,3"};
 */

public class TeleporterBasedHandling {
    public static void main(String[] argv) {
        String[] teleporters1 = {"3,1", "4,2", "5,10"};

        TeleporterBasedHandling solution = new TeleporterBasedHandling();
        Set<Integer> set = solution.destinations(teleporters1,6, 0, 20);
        for(Integer i : set){
            System.out.print(i + " ");
        }
    }

    public Set<Integer> destinations(String[] teleporterArray, int numberOfSidesInDice, int startIndex, int endIndex){
        if(teleporterArray == null || teleporterArray.length == 0){
            return null;
        }

        Set<Integer> result = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(String ports : teleporterArray){
            String[] inputPort = ports.split(",");
            map.put(Integer.valueOf(inputPort[0]),Integer.valueOf(inputPort[1]));
        }

        for(int i = 1; i <= numberOfSidesInDice; i++){
            int destination = destinationPort(map,i);
            result.add(destination);
        }

        return result;
    }

    private int destinationPort(Map<Integer, Integer> map, int rolledDiceNum){
        return map.getOrDefault(rolledDiceNum, rolledDiceNum);
    }
}