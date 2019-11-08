package com.rahul.dsalgo.datastructureImpl.logical;

import com.rahul.dsalgo.datastructure.logical.BinarySearchTree;
import com.rahul.dsalgo.datastructureImpl.logical.components.BTNode;

import java.util.Stack;

/**
 * Created by Rahul on 10/28/19
 */
public class BinarySearchTreeImpl extends BinaryTreeImpl implements BinarySearchTree {
    public BTNode root;

    @Override
    public void create() {
        root = new BTNode();
    }

    @Override
    public int insertNode(int value) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        if (root.value == Integer.MIN_VALUE) {
            root.value = value;
            return 0;
        }
        BTNode node = root;

        while (true) {
            if (value <= node.value) {
                if (node.leftChild != null) {
                    node = node.leftChild;
                } else {
                    BTNode newNode = new BTNode();
                    newNode.value = value;
                    node.leftChild = newNode;
                    break;
                }
            } else {
                if (node.rightChild != null) {
                    node = node.rightChild;
                } else {
                    BTNode newNode = new BTNode();
                    newNode.value = value;
                    node.rightChild = newNode;
                    break;
                }
            }
        }
        return node.value;
    }

    /**
     * TODO 11/03/19 Revisit this logic to find run time and make sure this takes no more than O(n).
     * i.e visit each node no more than once
     * */
    @Override
    public void treeList() {
        // Converts the ordered binary tree into circular ordered doubly linked list
        Stack<BTNode> stack = new Stack<BTNode>();
        BTNode node = null;
        BTNode head, tail = null;
        if (root == null){
            return;
        }
        stack.push(root);
        head = root;
        // Runtime O(log(n))
        while ( head.leftChild != null ) {
            head = head.leftChild;
            stack.push(head);
        }

        // Runtime O(n)
        while (!stack.isEmpty()){
            if (stack.peek().leftChild != null && node != stack.peek().leftChild) {
                stack.push(stack.peek().leftChild);
            } else {
                node = stack.pop();
                if (node.rightChild != null) {
                    stack.push(node.rightChild);
                    node.rightChild.leftChild = node;
                } else {
                    if (!stack.isEmpty()) {
                        node.rightChild = stack.peek();
                        stack.peek().leftChild = node;
                        node = stack.peek().leftChild;
                    }
                }
            }
        }
        tail = node;
        printTreeList(head);
        reversePrintTreeList(tail);
    }

    private void printTreeList(BTNode head) {
        System.out.println("Printing the Tree-Node Result: ");
        // Print
        BTNode node = head;
        while (node !=null)
        {
            System.out.print(node.value + " ");
            node = node.rightChild;
        }
    }

    private void reversePrintTreeList(BTNode tail) {
        System.out.println("Reverse Printing the Tree-Node result: ");
        // Print reverse
        BTNode node = tail;
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.leftChild;
        }
    }
}
