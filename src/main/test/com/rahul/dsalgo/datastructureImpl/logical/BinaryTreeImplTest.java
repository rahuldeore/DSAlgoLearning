package com.rahul.dsalgo.datastructureImpl.logical;

import com.rahul.dsalgo.datastructureImpl.logical.components.BTNode;
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
    void traverseDfsPreOrderTest() {
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
        binaryTree.traverseDfsPreOrder();
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
    void traverseDfsPostOrderTest() {
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
        binaryTree.traverseDfsPostOrder();
    }

    @Test
    void traverseDfsInOrderTest() {
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
        binaryTree.traverseDfsInOrder();
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

    @Test
    void printTreeTest(){
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
        binaryTree.printTree();
    }

    @Test
    void traverseBfsLvlOrderTest (){
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
        binaryTree.traverseBfsLvlOrder();
    }

    @Test
    void printPathsTest() {
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
        binaryTree.printPaths();
    }

    @Test
    void hasPathSumTest() {
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
        assertEquals(true,binaryTree.hasPathSum(15));
        assertEquals(true,binaryTree.hasPathSum(16));
        assertEquals(false,binaryTree.hasPathSum(17));
        assertEquals(true,binaryTree.hasPathSum(18));
    }

    @Test
    void mirrorTreeTest() {
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
        BTNode mirrorTree = binaryTree.mirror();
        binaryTree.traverseBfsLvlOrder();
        binaryTree.traverseBfsLvlOrder_2(mirrorTree);
        binaryTree.traverseBfsLvlOrder();
    }

    @Test
    void preOrderTraversalTest() {
        // iterative function test
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
        binaryTree.preOrderTraversal(binaryTree.getRoot());
    }

    @Test
    void inOrderTraversalTest() {
        // iterative function test
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
        binaryTree.insertNode(16);
        binaryTree.insertNode(17);
        binaryTree.insertNode(18);
        binaryTree.insertNode(19);
        binaryTree.insertNode(20);
        binaryTree.insertNode(21);
        binaryTree.insertNode(22);

        binaryTree.inOrderTraversal(binaryTree.getRoot());
    }
}