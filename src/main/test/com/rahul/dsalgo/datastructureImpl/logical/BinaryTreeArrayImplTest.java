package com.rahul.dsalgo.datastructureImpl.logical;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BinaryTreeArrayImplTest {

    BinaryTreeArrayImpl binaryTreeArray;

    @BeforeEach
    void setUp() {
        binaryTreeArray = new BinaryTreeArrayImpl(20);
        binaryTreeArray.insert(1);
        binaryTreeArray.insert(2);
        binaryTreeArray.insert(3);
        binaryTreeArray.insert(4);
        binaryTreeArray.insert(5);
        binaryTreeArray.insert(6);
        binaryTreeArray.insert(7);
        binaryTreeArray.insert(8);
        binaryTreeArray.insert(9);
        binaryTreeArray.insert(10);
        binaryTreeArray.insert(11);
        binaryTreeArray.insert(12);
        binaryTreeArray.insert(13);
        binaryTreeArray.insert(14);
        binaryTreeArray.insert(15);
    }

    @Test
    void insert() {
        binaryTreeArray.insert(21);
    }

    @Test
    void traversePreOrderTest() {
        System.out.println("Binary Tree Array Impl DFS Pre-Order traversal");
        binaryTreeArray.traversePreOrder(0);
    }

    @Test
    void traverseInOrderTest() {
        System.out.println("Binary Tree Array Impl DFS In-Order traversal");
        binaryTreeArray.traverseInOrder(0);
    }

    @Test
    void traversePostOrderTest() {
        System.out.println("Binary Tree Array Impl DFS Post-Order Traversal");
        binaryTreeArray.traversePostOrder(0);
    }

    @Test
    void traverseLevelOrderTest() {
        System.out.println("Binary Tree Array Impl BFS Level-Order Traversal");
        binaryTreeArray.traverseLevelOrder();
    }

    @Test
    void preOrderTraversalTest() {
        binaryTreeArray.preOrderTraversal();
    }
}