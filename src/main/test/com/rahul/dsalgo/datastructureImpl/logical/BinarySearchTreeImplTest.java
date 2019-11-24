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
        System.out.println("Level Order Traversal (Iterative)");
        binarySearchTree.traverseBfsLvlOrder(binarySearchTree.root);
    }

    @Test
    void preOrderTraversalTest() {
        // TODO: 11/3/19 Why below statement returns a null root ??? Maybe something to do with the inheritance ???
        //         binarySearchTree.preOrderTraversal(binarySearchTree.getRoot());
        System.out.println("Pre-Order Traversal (Iterative)");
        binarySearchTree.preOrderTraversal(binarySearchTree.root);
    }

    @Test
    void inOrderTraversalTest() {
        System.out.println("In-Order Traversal (Iterative)");
        binarySearchTree.inOrderTraversal(binarySearchTree.root);

    }

    @Test
    void treeListTest(){
        binarySearchTree.treeList();
    }

    @Test
    void deleteTest(){
        BinarySearchTreeImpl binarySearchTree2 = new BinarySearchTreeImpl();
        binarySearchTree2.create();
        binarySearchTree2.insertNode(100);
        binarySearchTree2.insertNode(50);
        binarySearchTree2.insertNode(150);
        binarySearchTree2.insertNode(25);
        binarySearchTree2.insertNode(75);
        binarySearchTree2.insertNode(125);
        binarySearchTree2.insertNode(175);
        binarySearchTree2.insertNode(12);
        binarySearchTree2.insertNode(37);
        binarySearchTree2.insertNode(62);
        binarySearchTree2.insertNode(87);
        binarySearchTree2.insertNode(112);
        binarySearchTree2.insertNode(137);
        binarySearchTree2.insertNode(162);
        binarySearchTree2.insertNode(187);


        binarySearchTree2.traverseBfsLvlOrder(binarySearchTree2.root);
        binarySearchTree2.deleteNode(112);
        binarySearchTree2.traverseBfsLvlOrder(binarySearchTree2.root);
        binarySearchTree2.deleteNode(75);
        binarySearchTree2.traverseBfsLvlOrder(binarySearchTree2.root);
        binarySearchTree2.deleteNode(150);
        binarySearchTree2.traverseBfsLvlOrder(binarySearchTree2.root);
        binarySearchTree2.deleteNode(100);
        binarySearchTree2.traverseBfsLvlOrder(binarySearchTree2.root);
    }
}