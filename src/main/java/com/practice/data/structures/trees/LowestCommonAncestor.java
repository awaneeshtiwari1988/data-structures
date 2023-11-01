package com.practice.data.structures.trees;

public class LowestCommonAncestor {

    public BinaryTreeNode lowestCommonAncestor(BinaryTreeNode root, BinaryTreeNode p, BinaryTreeNode q){
        if(root == null){
            return null;
        }

        if(root == p || root == q){
            return root;
        }

        BinaryTreeNode left = lowestCommonAncestor(root.left, p, q);
        BinaryTreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left != null && right != null){
            return root;
        }

        return left != null ? left : right;
    }
}
