package com.practice.data.structures.chapter2;

public class Array {

    private final long[] longArrayReference;
    private int numberOfElements;

    public Array(int max){
        longArrayReference = new long[max];
        numberOfElements = 0;
    }

    public void insertElementsInArray(int value){
        longArrayReference[numberOfElements] = value;
        numberOfElements++;
    }

    public void displayElements(){
        for (int i = 0; i < numberOfElements; i++) {
            System.out.print(longArrayReference[i] + " ");
        }
        System.out.println("");
    }

    public boolean findElements(long searchKey){
        for (int i = 0; i < numberOfElements; i++) {
            if(longArrayReference[i] == searchKey){
                return true;
            }
        }

        return false;
    }

    public void deleteItem(long itemToBeDeleted){
        int indexOfElementToBeDeleted = 0;
        for (int i = 0; i < numberOfElements; i++) {
            if(longArrayReference[i] == itemToBeDeleted){
                indexOfElementToBeDeleted = i;
                break;
            }
        }

        if(indexOfElementToBeDeleted > 0){
            for (int k = indexOfElementToBeDeleted; k < numberOfElements -1; k++) {
                longArrayReference[k] = longArrayReference[k+1];
            }
            numberOfElements--;
        } else {
            System.out.println("Element to be deleted is not found.");
        }
    }


}
