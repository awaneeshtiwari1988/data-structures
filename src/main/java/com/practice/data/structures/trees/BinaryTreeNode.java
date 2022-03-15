package com.practice.data.structures.trees;

public class BinaryTreeNode {

    int data;
    BinaryTreeNode leftChild;
    BinaryTreeNode rightChild;

    public BinaryTreeNode(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "BinaryTreeNode{" +
                "data=" + data +
                ", leftChild=" + leftChild +
                ", rightChild=" + rightChild +
                '}';
    }
}
