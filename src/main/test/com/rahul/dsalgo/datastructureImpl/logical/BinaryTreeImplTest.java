package com.rahul.dsalgo.datastructureImpl.logical;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinaryTreeImplTest {

    private BinaryTreeImpl binaryTree;

    @BeforeEach
    void setUp() {
        binaryTree  = new BinaryTreeImpl();
    }

    @AfterEach
    void tearDown() {
    }

    //@Test
    void create() {
        binaryTree.create();
    }

    @Test
    void traverseBfsPreOrder() {
        binaryTree.create();
        binaryTree.insertNode(1);
        binaryTree.insertNode(2);
        binaryTree.insertNode(3);
        binaryTree.insertNode(4);
        binaryTree.insertNode(5);
        binaryTree.insertNode(6);
        binaryTree.insertNode(7);
        binaryTree.insertNode(8);
        binaryTree.insertNode(9);
        binaryTree.insertNode(10);
        binaryTree.insertNode(11);
        binaryTree.insertNode(12);
        binaryTree.insertNode(13);
        binaryTree.insertNode(14);
        binaryTree.insertNode(15);
        binaryTree.traverseBfsPreOrder();
    }

    @Test
    void insertNodeTest() {
        binaryTree.create();
        assertEquals(0,binaryTree.insertNode(1));
        assertEquals(1, binaryTree.insertNode(2));
        assertEquals(1, binaryTree.insertNode(3));
        assertEquals(2, binaryTree.insertNode(4));
        assertEquals(2, binaryTree.insertNode(5));
        assertEquals(3, binaryTree.insertNode(6));
        assertEquals(3, binaryTree.insertNode(7));
        assertEquals(4, binaryTree.insertNode(8));
        assertEquals(4, binaryTree.insertNode(9));
        assertEquals(5, binaryTree.insertNode(10));
        assertEquals(5, binaryTree.insertNode(11));
        assertEquals(6, binaryTree.insertNode(12));
        assertEquals(6, binaryTree.insertNode(13));
        assertEquals(7, binaryTree.insertNode(14));
        assertEquals(7, binaryTree.insertNode(15));
    }

    @Test
    void nodeCountTest() {
        binaryTree.create();
        binaryTree.insertNode(1);
        binaryTree.insertNode(2);
        binaryTree.insertNode(3);
        binaryTree.insertNode(4);
        binaryTree.insertNode(5);
        binaryTree.insertNode(6);
        binaryTree.insertNode(7);
        binaryTree.insertNode(8);
        binaryTree.insertNode(9);
        binaryTree.insertNode(10);
        binaryTree.insertNode(11);
        binaryTree.insertNode(12);
        binaryTree.insertNode(13);
        binaryTree.insertNode(14);
        binaryTree.insertNode(15);
        assertEquals(15, binaryTree.nodeCount());
    }

    @Test
    void lookUpTest() {
        binaryTree.create();
        binaryTree.insertNode(1);
        binaryTree.insertNode(2);
        binaryTree.insertNode(3);
        binaryTree.insertNode(4);
        binaryTree.insertNode(5);
        binaryTree.insertNode(6);
        binaryTree.insertNode(7);
        binaryTree.insertNode(8);
        binaryTree.insertNode(9);
        binaryTree.insertNode(10);
        binaryTree.insertNode(11);
        binaryTree.insertNode(12);
        binaryTree.insertNode(13);
        binaryTree.insertNode(14);
        binaryTree.insertNode(15);
        assertEquals(true, binaryTree.lookUp(1));
        assertEquals(true, binaryTree.lookUp(2));
        assertEquals(true, binaryTree.lookUp(3));
        assertEquals(true, binaryTree.lookUp(12));
        assertEquals(true, binaryTree.lookUp(15));
        assertEquals(false, binaryTree.lookUp(22));
    }
}