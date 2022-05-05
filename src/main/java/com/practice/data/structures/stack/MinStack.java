package com.practice.data.structures.stack;

import java.util.Stack;

public class MinStack {

    private Stack<Integer> stack;
    private int minElement;

    public MinStack() {
        stack = new Stack<>();
        minElement = 0;
    }

    public void push(int val) {
        if(this.stack.isEmpty()){
            stack.push(val);
            minElement = val;
        } else if(val > minElement){
            stack.push(val);
        } else {
            stack.push(2*val - minElement);
            minElement = val;
        }

        if(val < minElement){
            minElement = val;
        }

    }

    public void pop() {
        int topElement = top();
        if(topElement < minElement){
            minElement = 2*minElement - topElement;
        }

        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        if(stack.isEmpty()){
            return -1;
        }
        return this.minElement;
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }
}
