package com.practice.data.structures.linkedlist;

public class AddTwoNumbers {

    public SingleHeadedNode<Integer> addTwoNumbers(SingleHeadedNode<Integer> l1, SingleHeadedNode<Integer> l2) {
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        // Generate two integers from the linked list representation
        StringBuilder sb = new StringBuilder();
        SingleHeadedNode<Integer> temp = l1;
        while (temp != null) {
            sb.append(temp.value);
            temp = temp.tail;
        }

        int number1 = Integer.parseInt(sb.reverse().toString());
        sb = new StringBuilder();
        SingleHeadedNode<Integer> temp1 = l2;
        while (temp1 != null) {
            sb.append(temp1.value);
            temp1 = temp1.tail;
        }

        int number2 = Integer.parseInt(sb.reverse().toString());
        int outputNumber = number1 + number2;

        sb = new StringBuilder(String.valueOf(outputNumber));
        String output = sb.reverse().toString();
        SingleHeadedNode<Integer> outputNode = new SingleHeadedNode(Integer.valueOf(String.valueOf(output.charAt(0))));
        SingleHeadedNode<Integer> nextNode = outputNode;
        for(int i = 1; i < output.length(); i++){
            nextNode.tail = new SingleHeadedNode(Integer.valueOf(String.valueOf(output.charAt(i))));
            nextNode = nextNode.tail;
        }

        return outputNode;
    }

    public static void main(String[] args) {
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();
        singlyLinkedList.append(2);
        singlyLinkedList.append(4);
        singlyLinkedList.append(3);

        SinglyLinkedList<Integer> singlyLinkedList1 = new SinglyLinkedList<>();
        singlyLinkedList1.append(5);
        singlyLinkedList1.append(6);
        singlyLinkedList1.append(4);

        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        SingleHeadedNode<Integer> output = addTwoNumbers.addTwoNumbers(singlyLinkedList.getHead(),
                    singlyLinkedList1.getHead());
    }
}
