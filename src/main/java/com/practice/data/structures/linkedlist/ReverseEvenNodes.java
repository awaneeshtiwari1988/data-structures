package com.practice.data.structures.linkedlist;

public class ReverseEvenNodes {

    public LinkedListNode reverseEvenNodes(LinkedListNode head){
        LinkedListNode evenNodeLinkedList = null;
        LinkedListNode currentNode = head;

        while(currentNode != null && currentNode.next != null){
            LinkedListNode evenNode = currentNode.next;
            currentNode.next = evenNode.next;

            evenNode.next = evenNodeLinkedList;
            evenNodeLinkedList = evenNode;
            currentNode = currentNode.next;
        }

        return mergeAlternatingNodes(head, evenNodeLinkedList);
    }

    public LinkedListNode mergeAlternatingNodes(LinkedListNode head1, LinkedListNode head2){
        if(head1 == null){
            return head2;
        }

        if(head2 == null){
            return head1;
        }

        LinkedListNode head = head1;
        while (head1.next != null && head2 != null){
            LinkedListNode temp = head2;
            head2 = head2.next;

            temp.next = head1.next;
            head1.next = temp;
            head1 = temp.next;
        }

        return head;
    }
}
