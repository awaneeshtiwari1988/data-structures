package com.practice.data.structures.linkedlist;

public class FoldListOnItSelf {

    public LinkedListNode foldListOnItSelf(LinkedListNode head){
        if(head == null || head.next == null){
            return head;
        }

        LinkedListNode slow = head;
        LinkedListNode fast = head;
        while(fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        LinkedListNode previousNode = null;
        LinkedListNode current = head;
        LinkedListNode temp;

        while(current != null){
            temp = current.next;
            current.next = previousNode;
            previousNode = current;
            current = temp;
        }

        LinkedListNode first = head;
        LinkedListNode second = previousNode;
        while (second.next != null){
            temp = first.next;
            first.next = second;
            first = temp;

            temp = second.next;
            second.next = first;
            second = temp;
        }

        return head;
    }

}
