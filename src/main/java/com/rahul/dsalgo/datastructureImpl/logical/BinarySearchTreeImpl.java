package com.rahul.dsalgo.datastructureImpl.logical;

import com.rahul.dsalgo.datastructure.logical.BinaryTree;
import com.rahul.dsalgo.datastructureImpl.logical.components.BTNode;

import java.util.Stack;

/**
 * Created by Rahul on 10/28/19
 */
public class BinarySearchTreeImpl extends BinaryTreeImpl implements BinaryTree {
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
     * TODO 11/03/19 NOT WORKING. GETTING INTO INFINITE LOOP
     * */

    @Override
    public void treeList() {
        // Converts the ordered binary tree into circular ordered doubly linked list
        Stack<BTNode> stack = new Stack<BTNode>();
        BTNode node = root;
        BTNode head = null;
        stack.push(node);

        while ( !stack.isEmpty() ) {
            node = stack.pop();
            if (node.rightChild != null) {
                stack.push(node.rightChild);
            } else {
                stack.push(node);
            }
            node = node.leftChild;
        }

        head.leftChild = node;
        node.rightChild = head;

        // Print
        node = head;
        while (node.rightChild != head) {
            System.out.print(node.value + " ");
            node = node.rightChild;
        }
        System.out.print(node.value + " ");
    }
}
