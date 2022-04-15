package com.practice.data.structures.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class BinarySearchTree {

    private BinaryTreeNode root;
    private int height;

    private BinarySearchTree insert(int value){
        BinaryTreeNode treeNode = new BinaryTreeNode(value);
        if(this.root == null){
            this.root = treeNode;
        } else {
            BinaryTreeNode node = this.root;
            while (true){
                if (value < node.data){
                    if(node.leftChild == null){
                        node.leftChild = treeNode;
                        return this;
                    }
                    node = node.leftChild;
                } else {
                    if(node.rightChild == null){
                        node.rightChild = treeNode;
                        return this;
                    }
                    node = node.rightChild;
                }
            }
        }

        return this;
    }

    private boolean isElementPresentInTree(int value){
        if(this.root == null){
            return false;
        }

        BinaryTreeNode node = this.root;
        while(node != null){
            if(value == node.data){
                return true;
            } else if (value < node.data){
                node = node.leftChild;
            } else {
                node = node.rightChild;
            }
        }

        return false;
    }

    public BinarySearchTree removeNode(int value){
        if(this.root == null){
            return this;
        }

        BinaryTreeNode binaryTreeNode = this.root;
        BinaryTreeNode parentNode = null;
        while(binaryTreeNode != null){
            if(value < binaryTreeNode.data){
                parentNode = binaryTreeNode;
                binaryTreeNode = binaryTreeNode.leftChild;
            } else if (value > binaryTreeNode.data){
                parentNode = binaryTreeNode;
                binaryTreeNode = binaryTreeNode.rightChild;
            } else {
                if(binaryTreeNode.rightChild == null){
                    if(parentNode == null){
                        this.root = binaryTreeNode.leftChild;
                    } else {
                        if(binaryTreeNode.data < parentNode.data){
                            parentNode.leftChild = binaryTreeNode.leftChild;
                        } else {
                            parentNode.rightChild = binaryTreeNode.leftChild;
                        }
                    }
                } else if (binaryTreeNode.leftChild == null){
                    if(parentNode == null){
                        this.root = binaryTreeNode.rightChild;
                    } else {
                        if(binaryTreeNode.data < parentNode.data){
                            parentNode.leftChild = binaryTreeNode.rightChild;
                        } else {
                            parentNode.rightChild = binaryTreeNode.rightChild;
                        }
                    }
                } else {
                    BinaryTreeNode leftMost = binaryTreeNode.rightChild.leftChild;
                    BinaryTreeNode leftMostParent = binaryTreeNode.leftChild;

                    while (leftMost.leftChild != null){
                        leftMostParent = leftMost;
                        leftMost = leftMost.leftChild;
                    }

                    leftMostParent.leftChild = leftMost.rightChild;
                    leftMost.leftChild = binaryTreeNode.leftChild;
                    leftMost.rightChild = binaryTreeNode.rightChild;

                    if(parentNode == null) {
                        this.root = leftMost;
                    } else {
                        if(binaryTreeNode.data < parentNode.data){
                            parentNode.leftChild = leftMost;
                        } else if (binaryTreeNode.data > parentNode.data){
                            parentNode.rightChild = leftMost;
                        }
                    }
                }

            }
        }

        return this;
    }

    public ArrayList<Integer> breadthFirstSearch(){
        ArrayList<Integer> outputList = new ArrayList<>();
        Queue<BinaryTreeNode> queue = new PriorityQueue<>();
        BinaryTreeNode currentNode = this.root;
        queue.add(currentNode);
        while(queue.size() > 0){
            currentNode = queue.poll();
            outputList.add(currentNode.data);
            if(currentNode.leftChild != null){
                queue.add(currentNode.leftChild);
            }

            if(currentNode.rightChild != null) {
                queue.add(currentNode.rightChild);
            }
        }
        return outputList;
    }

    private ArrayList<Integer> depthFirstSearchInOrder(){
        return traverseInOrder(this.root,new ArrayList<>());
    }

    private ArrayList<Integer> depthFirstSearchPreOrder(){
        return traversePreOrder(this.root,new ArrayList<>());
    }

    private ArrayList<Integer> depthFirstSearchPostOrder(){
        return traversePostOrder(this.root,new ArrayList<>());
    }

    private ArrayList<Integer> traverseInOrder(BinaryTreeNode node,ArrayList<Integer> outputList){
        if(node.leftChild != null){
            traverseInOrder(node.leftChild,outputList);
        }

        outputList.add(node.data);

        if(node.rightChild != null){
            traverseInOrder(node.rightChild,outputList);
        }

        return outputList;
    }

    private ArrayList<Integer> traversePreOrder(BinaryTreeNode node,ArrayList<Integer> outputList){
        outputList.add(node.data);
        if(node.leftChild != null){
            traversePreOrder(node.leftChild,outputList);
        }

        if(node.rightChild != null){
            traversePreOrder(node.rightChild,outputList);
        }

        return outputList;
    }

    private ArrayList<Integer> traversePostOrder(BinaryTreeNode node, ArrayList<Integer> outputList){
        if(node.leftChild != null){
            traversePostOrder(node.leftChild,outputList);
        }

        if(node.rightChild != null){
            traversePostOrder(node.rightChild,outputList);
        }

        outputList.add(node.data);
        return outputList;
    }

    public boolean isValidBST(BinaryTreeNode root) {
        return false;
    }

    private boolean isValidBST(BinaryTreeNode binaryTreeNode,int minValue, int maxValue){
        if(binaryTreeNode == null){
            return true;
        }

        if(binaryTreeNode.data < minValue || binaryTreeNode.data > maxValue){
            return false;
        }

        boolean isLeftBinaryTree = isValidBST(binaryTreeNode.leftChild, minValue, binaryTreeNode.data - 1);
        boolean isRightBinaryTree = isValidBST(binaryTreeNode.rightChild, binaryTreeNode.data - 1, maxValue);
        return isLeftBinaryTree && isRightBinaryTree;
    }

    public static void main(String[] args) {
        Integer[] inputArray = {5,14,null,1};
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        for (Integer i : inputArray) {
            binarySearchTree.insert(i);
        }
        System.out.println(binarySearchTree.root);

        System.out.println(binarySearchTree.isElementPresentInTree(170));

        ArrayList<Integer> output = binarySearchTree.breadthFirstSearch();
        System.out.println("********************** Breadth First Search");
        for (int items : output) {
            System.out.println(items);
        }

        System.out.println("**********************  In Order Depth First Search");
        output = binarySearchTree.depthFirstSearchInOrder();
        for (int items : output) {
            System.out.println(items);
        }
        System.out.println("Is valid BST " + binarySearchTree.isValidBST(binarySearchTree.root));
        System.out.println("********************** Pre Order Depth First Search");
        output = binarySearchTree.depthFirstSearchPreOrder();
        for (int items : output) {
            System.out.println(items);
        }

        System.out.println("********************** Post Order Depth First Search");
        output = binarySearchTree.depthFirstSearchPostOrder();
        for (int items : output) {
            System.out.println(items);
        }

        Integer[] array = {3,9,20,null,null,15,7};
        binarySearchTree = new BinarySearchTree();
        for (int i : inputArray) {
            binarySearchTree.insert(i);
        }
        System.out.println(binarySearchTree.root);
        List<Integer> lst = binarySearchTree.depthFirstSearchInOrder();
        System.out.println(lst.size());
    }
}
