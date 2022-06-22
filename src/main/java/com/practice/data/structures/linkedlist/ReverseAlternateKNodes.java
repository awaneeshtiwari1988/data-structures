package com.practice.data.structures.linkedlist;

public class ReverseAlternateKNodes {

    public LinkedListNode reverseAlternateKNodes(LinkedListNode head, int k){

        if(k <= 1  || head == null || head.next == null){
            return head;
        }

        LinkedListNode reversed = null;
        LinkedListNode previousTail = null;

        while (head != null){
            LinkedListNode currentHead = null;
            LinkedListNode currentTail = head;

            int n = k;

            while(head != null && n > 0){
                LinkedListNode temp = head.next;
                head.next = currentHead;
                currentHead = head;
                head = temp;
                n--;
            }

            if(reversed == null){
                reversed = currentHead;
            }

            if(previousTail != null){
                previousTail.next = currentHead;
            }

            previousTail = currentTail;
        }

        return reversed;
    }
}
