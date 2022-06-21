package com.practice.data.structures.linkedlist;

import java.util.Arrays;
import java.util.List;

public class SortLinkedList {

    public LinkedListNode sortLinkedListByMergeSort(LinkedListNode head){
        if(head == null || head.next == null){
            return head;
        }

        Pair<LinkedListNode, LinkedListNode> linkedListNodePair = new Pair<>(null, null);

        partition(head,linkedListNodePair);
        linkedListNodePair.currentNode = sortLinkedListByMergeSort(linkedListNodePair.currentNode);
        linkedListNodePair.nextNode = sortLinkedListByMergeSort(linkedListNodePair.nextNode);

        return mergeSortedLinkedLists(linkedListNodePair.currentNode, linkedListNodePair.nextNode);
    }

    public void partition(LinkedListNode head, Pair<LinkedListNode, LinkedListNode> pair){
        if(head == null){
            return;
        }

        if(head.next == null){
            pair.currentNode = head;
            pair.nextNode = null;
        } else {
            LinkedListNode slow, fast;
            slow = head;
            fast = head.next;

            while(fast != null){
                fast = fast.next;
                if(fast != null){
                    fast = fast.next;
                    slow = slow.next;
                }
            }

            pair.currentNode = head;
            pair.nextNode = slow.next;

            slow.next = null;
        }
    }

    public LinkedListNode mergeSortedLinkedLists(LinkedListNode currentNode, LinkedListNode nextNode){

        if(currentNode == null){
            return nextNode;
        } else if(nextNode == null){
            return currentNode;
        }

        LinkedListNode mergeHead = null;
        if(currentNode.data <= nextNode.data){
            mergeHead = currentNode;
            currentNode = currentNode.next;
        } else {
            mergeHead = nextNode;
            nextNode = nextNode.next;
        }

        LinkedListNode mergeTail = mergeHead;
        while(currentNode != null && nextNode != null){
            LinkedListNode temp = null;
            if(currentNode.data <= nextNode.data){
                temp = currentNode;
                currentNode = currentNode.next;
            } else {
                temp = nextNode;
                nextNode = nextNode.next;
            }

            mergeTail.next = temp;
            mergeTail = temp;
        }

        if(currentNode != null){
            mergeTail.next = currentNode;
        } else if(nextNode != null){
            mergeTail.next = nextNode;
        }

        return mergeHead;
    }

    class Pair<K, T>{
        K currentNode;
        T nextNode;

        public Pair(K currentNode, T nextNode) {
            this.currentNode = currentNode;
            this.nextNode = nextNode;
        }
    }

    public static void main(String[] args) {

        // Declaring and creating a linked list
        CustomLinkedList obj1 = new CustomLinkedList();
        List<Integer> ll = Arrays.asList(29, 23, 82, 11, 4, 3, 21);
        obj1.createLinkedList(ll);
        System.out.print("1. Unsorted list: " + ll);

        // Display Merge Sorted List
        SortLinkedList sortLinkedList = new SortLinkedList();
        sortLinkedList.sortLinkedListByMergeSort(obj1.getHead());
        System.out.print("   Sorted list:   ");
        obj1.displayLinkedList();

        System.out.print(
                "-----------------------------------------------------------------------------------------------------\n\n");
    }
}
