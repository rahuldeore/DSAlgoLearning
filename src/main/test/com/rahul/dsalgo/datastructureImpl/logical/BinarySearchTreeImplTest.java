package com.rahul.dsalgo.datastructureImpl.logical;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BinarySearchTreeImplTest {

    BinarySearchTreeImpl binarySearchTree;

    @BeforeEach
    void setUp() {
        binarySearchTree = new BinarySearchTreeImpl();
        binarySearchTree.create();
        binarySearchTree.insertNode(4);
        binarySearchTree.insertNode(2);
        binarySearchTree.insertNode(5);
        binarySearchTree.insertNode(1);
        binarySearchTree.insertNode(3);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void traverseBfsLvlOrder_2Test() {
        binarySearchTree.traverseBfsLvlOrder_2(binarySearchTree.root);
    }

    @Test
    void preOrderTraversalTest() {
        binarySearchTree.preOrderTraversal(binarySearchTree.getRoot());
    }

    @Test
    void inOrderTraversalTest() {
        binarySearchTree.inOrderTraversal(binarySearchTree.getRoot());
    }

    @Test
    void treeListTest(){
        //binarySearchTree.treeList();
    }
}