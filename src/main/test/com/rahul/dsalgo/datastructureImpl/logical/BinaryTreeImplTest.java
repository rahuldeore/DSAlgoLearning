package com.rahul.dsalgo.datastructureImpl.logical;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinaryTreeImplTest {

    private BinaryTreeImpl binaryTree = new BinaryTreeImpl();

    @BeforeEach
    void setUp() {
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
    }

    @Test
    void insertNode() {
        binaryTree.create();
        assertEquals(0,binaryTree.insertNode(1));
        assertEquals(1, binaryTree.insertNode(2));
        assertEquals(1, binaryTree.insertNode(3));
        assertEquals(2, binaryTree.insertNode(4));
        assertEquals(2, binaryTree.insertNode(5));
        assertEquals(3, binaryTree.insertNode(6));
        assertEquals(3, binaryTree.insertNode(7));
    }

    @Test
    void nodeCount() {
    }
}