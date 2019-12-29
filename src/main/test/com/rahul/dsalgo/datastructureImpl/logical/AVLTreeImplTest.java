package com.rahul.dsalgo.datastructureImpl.logical;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AVLTreeImplTest {

    AVLTreeImpl avlTree;

    @BeforeEach
    void setUp() {
        avlTree = new AVLTreeImpl();
    }

    @Test
    void insertNode() {
        avlTree.insertNode(50);
        avlTree.traverseBfsLvlOrder(avlTree.getRoot());
        avlTree.insertNode(40);
        avlTree.traverseBfsLvlOrder(avlTree.getRoot());
        avlTree.insertNode(30);
        avlTree.traverseBfsLvlOrder(avlTree.getRoot());
        avlTree.insertNode(10);
        avlTree.traverseBfsLvlOrder(avlTree.getRoot());
        avlTree.insertNode(90);
        avlTree.traverseBfsLvlOrder(avlTree.getRoot());
        avlTree.insertNode(80);
        avlTree.traverseBfsLvlOrder(avlTree.getRoot());
        avlTree.insertNode(100);
        avlTree.traverseBfsLvlOrder(avlTree.getRoot());
        avlTree.inOrderTraversal(avlTree.getRoot());
    }
}