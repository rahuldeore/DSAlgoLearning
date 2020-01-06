package com.rahul.dsalgo.datastructureImpl.logical;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AVLTreeImplTest {

    AVLTreeImpl avlTree;

    @BeforeEach
    void setUp() {
        avlTree = new AVLTreeImpl();
        avlTree.insertNode(50);
        avlTree.insertNode(40);
        avlTree.insertNode(30);
        avlTree.insertNode(10);
        avlTree.insertNode(90);
        avlTree.insertNode(80);
        avlTree.insertNode(100);
        avlTree.insertNode(5);
        avlTree.insertNode(105);
        avlTree.insertNode(22);
        avlTree.insertNode(200);
    }

    @Test
    void insertNode() {
        // Insert statements moved to setUp() method
        avlTree.inOrderTraversal(avlTree.getRoot());
        avlTree.traverseBfsLvlOrder(avlTree.getRoot());
    }

    @Test
    void deleteNodeTest() {
        avlTree.inOrderTraversal(avlTree.getRoot());
        System.out.println("\nDeleting 50 from tree");
        avlTree.delete(50);
        avlTree.inOrderTraversal(avlTree.getRoot());
        System.out.println("\nDeleting 32 from tree");
        avlTree.delete(32);
        avlTree.inOrderTraversal(avlTree.getRoot());
        System.out.println("\nDeleting 100 from tree");
        avlTree.delete(100);
        avlTree.inOrderTraversal(avlTree.getRoot());
        System.out.println("\nDeleting 40 from tree");
        avlTree.delete(40);
        avlTree.inOrderTraversal(avlTree.getRoot());
        avlTree.traverseBfsLvlOrder(avlTree.getRoot());
    }
}