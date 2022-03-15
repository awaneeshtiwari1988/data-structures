package com.practice.data.structures.linkedlist;

import org.w3c.dom.Node;

import java.util.LinkedList;

public class SinglyLinkedList<T> {

    private SingleHeadedNode<T> head;
    private int length;

    public SinglyLinkedList<T> append(T value) {
        SingleHeadedNode<T> singleHeadedNode = new SingleHeadedNode<>(value);
        if (this.head == null) {
            this.head = singleHeadedNode;
        } else {
            SingleHeadedNode<T> tail = this.head;
            while (tail.tail != null){
                tail = tail.tail;
            }
            tail.tail = singleHeadedNode;
        }
        this.length++;
        return this;
    }

    public SinglyLinkedList<T> prepend(T value){
        SingleHeadedNode<T> singleHeadedNode = new SingleHeadedNode<>(value);
        if(this.head == null){
            this.head = singleHeadedNode;
        } else {
            singleHeadedNode.tail = this.head;
            this.head = singleHeadedNode;
        }
        this.length++;
        return this;
    }

    public SinglyLinkedList<T> insert(int index, T value) {
        if(index >= this.length){
            return this.append(value);
        }

        SingleHeadedNode<T> singleHeadedNode = new SingleHeadedNode<>(value);
        SingleHeadedNode<T> leaderSingleHeadedNode = this.traverse(index -1);
        SingleHeadedNode<T> nextSingleHeadedNode = leaderSingleHeadedNode.tail;
        leaderSingleHeadedNode.tail = singleHeadedNode;
        singleHeadedNode.tail = nextSingleHeadedNode;
        this.length++;
        return this;
    }

    public SingleHeadedNode<T> reverse(SingleHeadedNode<T> head){
        if(head.tail == null){
            return head;
        }

        SingleHeadedNode<T> primary = head;
        SingleHeadedNode<T> secondary = primary.tail;
        while(secondary != null){
            SingleHeadedNode<T> temp = secondary.tail;
            secondary.tail = primary;
            primary = secondary;
            secondary = temp;
        }

        head.tail = null;
        head = primary;
        return head;
    }

    public SingleHeadedNode<T> rotateLinkedList(SingleHeadedNode<T> head, int k){
        if(head.tail == null || k == 0){
            return head;
        }

        SingleHeadedNode<T> primary = head;
        int length = 1;
        while(length < k && primary != null) {
            primary = primary.tail;
            length++;
        }

        if (primary == null){
            return head;
        }

        SingleHeadedNode<T> kthNode = primary;
        while(primary.tail != null){
            primary = primary.tail;
        }

        primary.tail = head;
        head = kthNode.tail;
        kthNode.tail = null;
        return head;
    }


    public SinglyLinkedList<T> remove(int index){
        SingleHeadedNode<T> headSingleHeadedNode = this.traverse(index - 1);
        SingleHeadedNode<T> singleHeadedNodeToRemove = headSingleHeadedNode.tail;
        headSingleHeadedNode.tail = singleHeadedNodeToRemove.tail;
        this.length--;
        return this;
    }

    public SingleHeadedNode<T> traverse(int index){
        int counter = 0;
        SingleHeadedNode<T> currentSingleHeadedNode = this.head;
        while (counter != index) {
            currentSingleHeadedNode = currentSingleHeadedNode.tail;
            counter++;
        }

        return currentSingleHeadedNode;
    }

    public void printList(SinglyLinkedList<T> singlyLinkedList){
        SingleHeadedNode<T> singleHeadedNode = singlyLinkedList.head;
        System.out.println("Linked List");
        while (singleHeadedNode != null){
            System.out.print(singleHeadedNode.value + " ");
            singleHeadedNode = singleHeadedNode.tail;
        }
        System.out.println("Length of Linked list is " + this.length);
    }

    public static void main(String[] args) {
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();
        singlyLinkedList.append(1);
        singlyLinkedList.append(2);
        singlyLinkedList.append(3);
        singlyLinkedList.append(4);
        singlyLinkedList.append(5);
        singlyLinkedList.printList(singlyLinkedList);
        singlyLinkedList.remove(3);
        singlyLinkedList.printList(singlyLinkedList);
    }
}
