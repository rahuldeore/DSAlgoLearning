package com.rahul.dsalgo.datastructureImpl.logical;

import com.rahul.dsalgo.datastructure.logical.BinaryTree;

import java.util.Stack;

/**
 *
 * This class implements Binary Tree using Arrays
 *
 * Created by Rahul on 11/11/19
 */
public class BinaryTreeArrayImpl extends BinaryTreeImpl implements BinaryTree {
    int tree[];
    int size;
    int insertIndex;
    static final int DEFAULT_SIZE = 20;

    public BinaryTreeArrayImpl(int size) {
        if (size == 0) {
            tree = new int[DEFAULT_SIZE];
            this.size = DEFAULT_SIZE;
        } else {
            tree = new int[size];
            this.size = size;
        }
        insertIndex = 0;
    }

    @Override
    public void insert(int value) {
        if (insertIndex < size) {
            tree[insertIndex] = value;
            insertIndex++;
        } else {
            // TODO array should grow to hold more elements
            System.out.println("Tree is full, cannot insert " + value);
        }
    }

    /**
     * recursive implementation of pre-order traversal in array based binary tree
     * */
    public void traversePreOrder(int index) {
        if (index < 0 || index >= insertIndex) {
            return;
        } else {
            System.out.print(tree[index] + " ");
            traversePreOrder(2*index + 1);
            traversePreOrder(2*index + 2);
        }
    }

    /**
     * Recursive implementation of in-order traversal in array based binary tree
     * */
    public void traverseInOrder(int index) {
        if (index < 0 || index >= insertIndex) {
            return;
        } else {
            traverseInOrder(2*index + 1);
            System.out.print(tree[index] + " ");
            traverseInOrder(2*index + 2);
        }
    }

    /**
     * Recursive implementation of post-order traversal in array based binary tree
     * */
    public void traversePostOrder(int index) {
        if (index < 0 || index >= insertIndex) {
            return;
        } else {
            traversePostOrder(2 * index + 1);
            traversePostOrder(2 * index + 2);
            System.out.print(tree[index] + " ");
        }
    }

    /**
     * Level order or BFS traversal in array based binary tree is printing the contents of array index-wise
     * */
    public void traverseLevelOrder() {
        for (int i=0; i<insertIndex; i++) {
            System.out.print(tree[i] + " ");
        }
    }

    /**
     * Iterative pre-order traversal of binary tree array
     * */
    public void preOrderTraversal() {
        System.out.println("Iterative pre-order traversal of Binary tree array impl");
        Stack<Integer> stack = new Stack<Integer>();
        if (insertIndex != 0) { // if array is not empty
            int traverseIndex = 0;
            stack.push(traverseIndex);
            while (!stack.isEmpty()) {
                traverseIndex = stack.pop();
                System.out.print(tree[traverseIndex] + " ");
                if (rightGuardCondition(traverseIndex) &&
                        (tree[(traverseIndex * 2) + 2] != 0 || tree[(traverseIndex * 2) + 2] != Integer.MIN_VALUE)) {
                    stack.push(traverseIndex * 2 + 2); // push right child index
                }
                if (leftGuardCondition(traverseIndex)  &&
                        (tree[(traverseIndex * 2) + 1] != 0 || tree[(traverseIndex * 2) + 1] != Integer.MIN_VALUE)) {
                    stack.push(traverseIndex * 2 + 1); // push left child index
                }
            }
        }
    }

    private boolean leftGuardCondition(int traverseIndex) {
        return (traverseIndex * 2 + 1) < insertIndex;
    }

    private boolean rightGuardCondition(int traverseIndex) {
        return (traverseIndex * 2 + 2) < insertIndex;
    }

    /**
     * Iterative in-order traversal of binary tree array implementation
     * */
    public void inOrderTraversal() {
        Stack<Integer> stack = new Stack<Integer>();
        if (insertIndex != 0) { // Tree is not empty
            int traverseIndex = 0;
            stack.push(traverseIndex); // start traversal from 0th index
            while (!stack.isEmpty()) {
                traverseIndex = stack.peek();
                if (leftGuardCondition(traverseIndex) &&
                        tree[traverseIndex * 2 + 1] != Integer.MIN_VALUE || tree[traverseIndex * 2 + 1] != 0 ) {
                    stack.push(traverseIndex * 2 + 1);
                } else {

                }

            }
        }
    }

    /**
     * Iterative post-order traversal of binary tree array implementation
     * */
    public void postOrderTraversal() {

    }
}
