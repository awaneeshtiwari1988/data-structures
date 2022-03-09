package com.practice.data.structures.linkedlist;

public class SingleHeadedNode<T> {
    T value;
    SingleHeadedNode<T> tail;

    public SingleHeadedNode(T value){
        this.value = value;
    }
}
