package com.practice.data.structures.linkedlist;

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

    public SinglyLinkedList<T> reverse(){
        if(this.head.tail == null){
            return this;
        }

        var firstSingleHeadedNode = this.head;
        var secondSingleHeadedNode = firstSingleHeadedNode.tail;

        return this;
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
        singlyLinkedList.append(10);
        singlyLinkedList.append(5);
        singlyLinkedList.append(16);
        singlyLinkedList.prepend(1);
        singlyLinkedList.insert(2,99);
        singlyLinkedList.insert(20,88);
        singlyLinkedList.remove(2);
        singlyLinkedList.printList(singlyLinkedList);

    }
}
