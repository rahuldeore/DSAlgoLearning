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
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void traverseDfsPreOrderTest() {
        System.out.println("DFS Pre-Order traversal (Recursive)");
        binaryTree.traverseDfsPreOrder(binaryTree.getRoot());
    }

    @Test
    void traverseDfsPostOrderTest() {
        System.out.println("DFS Post_Order traversal (Recursive)");
        binaryTree.traverseDfsPostOrder(binaryTree.getRoot());
    }

    @Test
    void traverseDfsInOrderTest() {
        System.out.println("DFS In-Order traversal (Recursive)");
        binaryTree.traverseDfsInOrder(binaryTree.getRoot());
    }

    @Test
    void traverseBfsLvlOrderTest (){
        binaryTree.traverseBfsLvlOrder(binaryTree.getRoot());
    }

    @Test
    void insertNodeTest() {
        assertEquals(8,binaryTree.insertNode(16));
    }

    @Test
    void nodeCountTest() {
        assertEquals(15, binaryTree.nodeCount());
    }

    @Test
    void lookUpTest() {
        assertEquals(true, binaryTree.lookUp(1));
        assertEquals(true, binaryTree.lookUp(2));
        assertEquals(true, binaryTree.lookUp(3));
        assertEquals(true, binaryTree.lookUp(12));
        assertEquals(true, binaryTree.lookUp(15));
        assertEquals(false, binaryTree.lookUp(22));
    }

    @Test
    void printTreeTest(){
        binaryTree.printTree();
    }

    @Test
    void printPathsTest() {
        binaryTree.printPaths();
    }

    @Test
    void hasPathSumTest() {
        assertEquals(true,binaryTree.hasPathSum(15));
        assertEquals(true,binaryTree.hasPathSum(16));
        assertEquals(false,binaryTree.hasPathSum(17));
        assertEquals(true,binaryTree.hasPathSum(18));
    }

    @Test
    void mirrorTreeTest() {
        BTNode mirrorTree = binaryTree.mirror();
        binaryTree.traverseBfsLvlOrder(binaryTree.getRoot());
        System.out.print("\nReverse Tree ");
        binaryTree.traverseBfsLvlOrder(mirrorTree);
    }

    @Test
    void preOrderTraversalTest() {
        // iterative function test
        binaryTree.preOrderTraversal(binaryTree.getRoot());
    }

    @Test
    void inOrderTraversalTest() {
        // iterative function test
        binaryTree.insertNode(16);
        binaryTree.insertNode(17);
        binaryTree.insertNode(18);
        binaryTree.insertNode(19);
        binaryTree.insertNode(20);
        binaryTree.insertNode(21);
        binaryTree.insertNode(22);
        binaryTree.inOrderTraversal(binaryTree.getRoot());
    }

    @Test
    void otherMethodsTest() {
        // This test all other methods
        System.out.println("Node Count: " + binaryTree.nodeCount());
        System.out.println("MaxDepth of Tree: " + binaryTree.maxDepth());
        System.out.println("MaxDepth from RootNode: " + binaryTree.maxDepth(binaryTree.getRoot()));
        System.out.println("Binary Tree Size: " + binaryTree.size());
        System.out.println("Height of Binary Tree: " + binaryTree.height());
        System.out.println("Height from Root Node: " + binaryTree.height(binaryTree.getRoot()));
    }
}