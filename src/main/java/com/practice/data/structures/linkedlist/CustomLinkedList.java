package com.practice.data.structures.linkedlist;

import java.util.*;

public class CustomLinkedList {

    private LinkedListNode head;

    public CustomLinkedList(){
        this.head = null;
    }

    public void insertAtHead(int data){
        LinkedListNode linkedListNode = new LinkedListNode(data);
        if (this.head != null) {
            linkedListNode.next = this.head;
        }
        this.head = linkedListNode;
    }

    public void insertAtTail(int data){
        LinkedListNode linkedListNode = new LinkedListNode(data);
        if(this.head == null){
            this.head = linkedListNode;
        } else {
            LinkedListNode temporaryNode = this.head;
            while (temporaryNode.next != null){
                temporaryNode = temporaryNode.next;
            }
            temporaryNode.next = linkedListNode;
        }
    }

    public void createLinkedList(List<Integer> lst){
        lst.stream().sorted(Collections.reverseOrder()).forEach(this::insertAtHead);
    }

    public void displayLinkedList(){
        LinkedListNode linkedListNode = this.head;
        List<Integer> integerList = new ArrayList<>();
        while(linkedListNode != null){
            integerList.add(linkedListNode.data);
            linkedListNode = linkedListNode.next;
        }

        System.out.println(integerList);
    }

    public LinkedListNode reverseLinkedList(LinkedListNode head){
        if(head == null || head.next == null){
            return head;
        }

        LinkedListNode oldHead = head.next;
        LinkedListNode reversedLinkedList = head;
        reversedLinkedList.next = null;

        while (oldHead != null) {
            LinkedListNode temp = oldHead;
            oldHead = oldHead.next;
            temp.next = reversedLinkedList;
            reversedLinkedList = temp;
        }

        return reversedLinkedList;
    }

    public LinkedListNode removeDuplicates(LinkedListNode head){
        if(head == null || head.next == null){
            return head;
        }

        Set<Integer> set = new HashSet<>();
        set.add(head.data);
        LinkedListNode temp = head;

        while(temp.next != null){
            if(set.contains(temp.data)){
                temp.next = temp.next.next;
            } else {
                set.add(temp.next.data);
                temp = temp.next;
            }
        }

        return head;
    }

    public LinkedListNode deleteAllKeyInLinkedList(LinkedListNode head, int key){
        if(head == null){
            return null;
        }

        LinkedListNode currentNode = head;
        LinkedListNode previousNode = null;
        while (currentNode != null) {
            if(currentNode.data == key){
                if(currentNode == head){
                    head = head.next;
                    currentNode = head;
                } else {
                    previousNode.next = currentNode.next;
                    currentNode = currentNode.next;
                }
            } else {
                previousNode = currentNode;
                currentNode = currentNode.next;
            }
        }

        return head;
    }

    public LinkedListNode sortLinkedListByInsertionSort(LinkedListNode head, LinkedListNode node){
        if(head == null || node.data <= head.data){
            node.next = head;
            return node;
        }

        LinkedListNode currentHead = head;
        while (currentHead.next != null && (currentHead.next.data < node.data)){
            currentHead = currentHead.next;
        }

        node.next = currentHead.next;
        currentHead.next = node;

        return head;
    }

    public LinkedListNode insertionSort(LinkedListNode head){
        LinkedListNode sorted = null;
        LinkedListNode current = head;

        while (current != null){
            LinkedListNode temp = current.next;
            sorted = sortLinkedListByInsertionSort(sorted, current);
            current = temp;
        }

        return sorted;
    }

    public LinkedListNode getIntersectionPoint(LinkedListNode head1, LinkedListNode head2){
        LinkedListNode currentNode1 = null;
        LinkedListNode currentNode2 = null;

        int head1Length = getLengthOfLinkedList(head1);
        int head2Length = getLengthOfLinkedList(head2);

        int lengthDifference = 0;
        if(head1Length >= head2Length){
            lengthDifference = head1Length - head2Length;
            currentNode1 = head1;
            currentNode2 = head2;
        } else {
            lengthDifference = head2Length - head1Length;
            currentNode1 = head2;
            currentNode2 = head1;
        }

        while(lengthDifference >= 0){
            currentNode1 = currentNode1.next;
            lengthDifference--;
        }


        while (currentNode1 != null && currentNode2 != null){
            if(currentNode1 == currentNode2){
                return currentNode1;
            }

            currentNode1 = currentNode1.next;
            currentNode2 = currentNode2.next;
        }

        return null;
    }

    public int getLengthOfLinkedList(LinkedListNode linkedListNode){
        int linkedListLength = 0;
        LinkedListNode temp = linkedListNode;
        while (temp != null){
            temp = temp.next;
            linkedListLength++;
        }

        return linkedListLength;
    }

    public LinkedListNode getIntersectingNodeByHashTable(LinkedListNode head1, LinkedListNode head2){
        Set<LinkedListNode> set = new LinkedHashSet<>();

        while(head2 != null){
            set.add(head2);
            head2 = head2.next;
        }

        while(head1 != null){
            if(set.contains(head1)){
                return head1;
            }
            head1 = head1.next;
        }

        return null;
    }

    public LinkedListNode getNthNodeFromEnd(LinkedListNode head, int n){
        LinkedListNode tail = head;

        // Move Tail n nodes apart from head
        while (tail != null && n > 0){
            tail = tail.next;
            n--;
        }

        if(n != 0){
            return null;
        }

        while(tail != null){
            tail = tail.next;
            head = head.next;
        }

        return head;
    }

    public LinkedListNode swapNthNodeWithHead(LinkedListNode head, int n){
        LinkedListNode previousNode = null;
        LinkedListNode currentNode = head;

        if(head == null || n == 1){
            return head;
        }

        for (int nodePosition = 0; nodePosition < n - 1; nodePosition++) {
            previousNode = currentNode;
            currentNode = currentNode.next;
        }

        previousNode.next = head;
        LinkedListNode temp = head.next;
        head.next = currentNode.next;
        currentNode.next = temp;

        return currentNode;
    }

    public LinkedListNode swapNthNodeFromBegEnd(LinkedListNode head, int n){
        int lengthOfList = 0;
        LinkedListNode temp = head;
        while(temp != null){
            lengthOfList++;
            temp = temp.next;
        }

        // Get the previous and current element from beginning
        LinkedListNode previousNodeFromBeginning = null;
        LinkedListNode currentNodeFromBeginning = head;
        for (int nodePosition = 1; nodePosition < n; nodePosition++) {
            previousNodeFromBeginning = currentNodeFromBeginning;
            currentNodeFromBeginning = currentNodeFromBeginning.next;
        }

        // Get the previous and current element from end
        LinkedListNode previousNodeFromEnd = null;
        LinkedListNode currentNodeFromEnd = head;
        for (int nodePosition = 1; nodePosition < lengthOfList - n + 1; nodePosition++) {
            previousNodeFromEnd = currentNodeFromEnd;
            currentNodeFromEnd = currentNodeFromEnd.next;
        }

        if(previousNodeFromBeginning != null){
            previousNodeFromBeginning.next = currentNodeFromEnd;
        }

        if(previousNodeFromEnd != null){
            previousNodeFromEnd.next = currentNodeFromBeginning;
        }

        LinkedListNode tempNode = currentNodeFromBeginning.next;
        currentNodeFromBeginning.next = currentNodeFromEnd.next;
        currentNodeFromEnd.next = tempNode;

        return head;
    }
}
