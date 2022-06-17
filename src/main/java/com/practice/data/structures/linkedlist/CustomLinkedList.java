package com.practice.data.structures.linkedlist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
}
