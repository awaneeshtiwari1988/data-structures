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
}
