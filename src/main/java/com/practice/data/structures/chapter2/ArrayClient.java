package com.practice.data.structures.chapter2;

public class ArrayClient {

    public static void main(String[] args) {
        Array array = new Array(10);

        // Insert Elements to the Array
        array.insertElementsInArray(77);
        array.insertElementsInArray(99);
        array.insertElementsInArray(44);
        array.insertElementsInArray(55);
        array.insertElementsInArray(22);
        array.insertElementsInArray(88);
        array.insertElementsInArray(11);
        array.insertElementsInArray(0);
        array.insertElementsInArray(66);
        array.insertElementsInArray(33);

        // Display Elements of the array
        array.displayElements();

        // Search Item
        if(array.findElements(35)){
            System.out.println("Found Item " + 35);
        } else {
            System.out.println("Did not found " + 35);
        }

        // Delete Items
        array.deleteItem(0);
        array.deleteItem(55);
        array.deleteItem(99);

        // Display Items
        array.displayElements();
    }
}
