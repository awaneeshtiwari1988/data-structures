package com.practice.data.structures.linkedlist;

public class RotateList {

    public LinkedListNode rotateLinkedList(LinkedListNode head, int numberOfRotations){

        if(head == null || head.next == null || numberOfRotations == 0){
            return head;
        }

        int lengthOfList = findLength(head);
        numberOfRotations = adjustNumberOfRotations(numberOfRotations, lengthOfList);

        if(numberOfRotations == 0){
            return head;
        }

        int rotationCount = lengthOfList - numberOfRotations - 1;

        LinkedListNode temp = head;
        while (rotationCount > 0){
            temp = temp.next;
            rotationCount--;
        }

        LinkedListNode newHead = temp.next;

        temp.next = null;
        temp = newHead;

        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = head;

        return newHead;
    }

    private int adjustNumberOfRotations(int numberOfRotations, int lengthOfList) {
        numberOfRotations = numberOfRotations % lengthOfList;

        if(numberOfRotations < 0){
            numberOfRotations = numberOfRotations + lengthOfList;
        }

        return numberOfRotations;
    }

    private int findLength(LinkedListNode head) {
        int lengthOfList = 0;

        LinkedListNode temp = head;
        while(temp != null){
            ++lengthOfList;
            temp = temp.next;
        }
        return lengthOfList;
    }
}
