package com.practice.data.structures.stack;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class StackUsingQueues {

    private Queue<Integer> primaryQueue;
    private Queue<Integer> secondaryQueue;

    private int size;

    public StackUsingQueues() {
        this.primaryQueue = new LinkedList<>();
        this.secondaryQueue = new LinkedList<>();
    }

    public void push(int x) {
        this.size++;
        this.secondaryQueue.add(x);

        while (!this.primaryQueue.isEmpty()){
            this.secondaryQueue.add(this.primaryQueue.peek());
            this.primaryQueue.remove();
        }

        Queue<Integer> tertiaryQueue = this.primaryQueue;
        this.primaryQueue = this.secondaryQueue;
        this.secondaryQueue = tertiaryQueue;
    }

    public int pop() {
        if(this.primaryQueue.isEmpty()){
            return 0;
        }
        int topElement = this.primaryQueue.peek();
        this.primaryQueue.remove();
        size--;
        return  topElement;
    }

    public int top() {
        if(this.primaryQueue.isEmpty()){
            return -1;
        }
        return this.primaryQueue.peek();
    }

    public boolean empty() {
        return this.primaryQueue.isEmpty();
    }

    public static void main(String[] args) {
        StackUsingQueues stackUsingQueues = new StackUsingQueues();
        stackUsingQueues.push(1);
        stackUsingQueues.push(2);
        System.out.println(stackUsingQueues.top());
        System.out.println(stackUsingQueues.pop());
        System.out.println(stackUsingQueues.empty());
        System.out.println(stackUsingQueues);
    }
}
