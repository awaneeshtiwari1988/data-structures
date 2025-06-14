package com.practice.data.structures.linkedlist;

public class LinkedList {

    int[] num;

    class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node head;
    private Node tail;
    private int length;
    public LinkedList(int value) {
        Node node = new Node(value);
        this.head = node;
        this.tail = node;
        this.length = 1;
    }

    public void printList(){
        Node temp = head;
        while(temp != null){
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void append(int value){
        Node node = new Node(value);
        if (this.length == 0){
            this.head = node;
        } else {
            this.tail.next = node;
        }
        this.tail = node;
        length++;
    }

    public Node removeLast(){
        if(this.length == 0){
            return null;
        }

        Node previous = this.head;
        Node temp = this.head;
        while (temp.next != null){
            previous = temp;
            temp = temp.next;
        }

        this.tail = previous;
        this.tail.next = null;
        length--;
        if(this.length == 0){
            this.head = null;
            this.tail = null;
        }
        return temp;
    }

    public void prepend(int value){
        Node node = new Node(value);
        if(this.length == 0){
            this.head = node;
            this.tail = node;
        } else {
            node.next = this.head;
            this.head = node;
        }
        this.length++;
    }

    public Node removeFirst(){
        if(this.length == 0){
            return null;
        }

        Node temp = this.head;
        this.head = temp.next;
        temp.next = null;
        this.length--;
        if(this.length == 0){
            this.tail = null;
        }

        return temp;
    }

    public Node get(int index){
        if(index < 0 || index >= this.length){
            return null;
        }

        Node temp = this.head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }

        return temp;
    }

    public boolean set(int index, int value){
        Node temp = get(index);
        if(temp != null){
            temp.value = value;
            return true;
        }

        return false;
    }

    public boolean insert(int index, int value){
        if (index < 0 || index > length){
            return false;
        }

        if(index == 0){
            prepend(value);
            return true;
        }

        if(index == this.length){
            append(value);
            return true;
        }

        Node node = new Node(value);
        Node temp = get(index - 1);
        node.next = temp.next;
        temp.next = node;
        this.length++;
        return true;
    }

    public Node remove(int index){
        if(index < 0 || index > length){
            return null;
        }

        if(index == 0){
            return removeFirst();
        }

        if(index == this.length){
            return removeLast();
        }

        Node previous = get(index - 1);
        Node temp = previous.next;
        previous.next = temp.next;
        temp.next = null;
        this.length--;
        return temp;
    }

    public void reverse(){
        Node temp = this.head;
        this.head = this.tail;
        this.tail = temp;

        Node after = null;
        Node before = null;
        for (int i = 0; i < this.length; i++) {
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }

    }
}
