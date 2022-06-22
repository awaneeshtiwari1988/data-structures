package com.practice.data.structures.linkedlist;

public class ReorderList {

    public void reorderList(LinkedListNode head){
        if(head == null){
            return;
        }

        LinkedListNode slow = head;
        LinkedListNode fast = head;

        // Find the middle of the list which will be pointed by slow.
        while(fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse the second half of the list
        LinkedListNode previousNode = null;
        LinkedListNode currentNode = slow;
        LinkedListNode temp = null;
        while(currentNode != null){
            temp = currentNode.next;
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = temp;
        }

        // Merge the teo lists alternatively
        LinkedListNode first = head;
        LinkedListNode second = previousNode;
        while(second != null){
            temp = first.next;
            first.next = second;
            first = temp;

            temp = second.next;
            second.next = first;
            second = temp;
        }
    }
}
