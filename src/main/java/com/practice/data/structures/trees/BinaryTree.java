package com.practice.data.structures.trees;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTree {
    private BinaryTreeNode root;

    public BinaryTree() {
        this.root = null;
    }

    public BinaryTree(int data) {
        this.root = new BinaryTreeNode(data);
    }

    public BinaryTree(List<Integer> lst){
        this.root = null;
        for(Integer num : lst){
            insert(num);
        }
    }

    public void insert(int data){
        BinaryTreeNode newNode = new BinaryTreeNode(data);
        if(this.root == null){
            this.root = newNode;
        } else {
            BinaryTreeNode parent = null;
            BinaryTreeNode temp = this.root;
            while(temp != null){
                parent = temp;
                if(data <= temp.data){
                    temp = temp.left;
                } else {
                    temp = temp.right;
                }
            }

            if(data <= parent.data){
                parent.left = newNode;
            } else {
                parent.right = newNode;
            }
        }
    }

    public void insertBinaryTreeByLevel(int data){
        Queue<BinaryTreeNode> tempQueue = new LinkedList<>();
        BinaryTreeNode temp = new BinaryTreeNode(data);
        tempQueue.add(temp);

        while(!tempQueue.isEmpty()){
            temp = tempQueue.peek();
            tempQueue.remove();

            if(temp.left == null){
                temp.left = new BinaryTreeNode(data);
                break;
            } else {
                tempQueue.add(temp.left);
            }

            if(temp.right == null){
                temp.right = new BinaryTreeNode(data);
                break;
            } else {
                tempQueue.add(temp.right);
            }
        }
    }

    public BinaryTreeNode findInBinarySearchTree(BinaryTreeNode node, int nodeData){
        if(node == null){
            return null;
        }

        if(node.data == nodeData){
            return node;
        } else if(node.data > nodeData){
            return findInBinarySearchTree(node.left,nodeData);
        } else {
            return findInBinarySearchTree(node.right,nodeData);
        }
    }

    public BinaryTreeNode findInBinarySearchTree(int data){
        return findInBinarySearchTree(this.root,data);
    }
}
