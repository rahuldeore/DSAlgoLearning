package com.rahul.dsalgo.datastructureImpl.logical;

import com.rahul.dsalgo.datastructureImpl.logical.components.BTNode;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
    void insertTest() {
        BinaryTreeImpl binaryTree1 = new BinaryTreeImpl();
        binaryTree1.create();
        for (int i=1; i<10; i++) {
            binaryTree1.insert(i);
        }
        binaryTree1.traverseBfsLvlOrder(binaryTree1.getRoot());
        binaryTree1.traverseDfsInOrder(binaryTree1.getRoot());
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
        /*
        * V2
        * */
        System.out.println("\nPre-Order traversal V2 (Iterative)");
        List<BTNode> list= binaryTree.preOrderTraversal_V2(binaryTree.getRoot());
        for (BTNode node : list) {
            System.out.print(node.value + " ");
        }

        System.out.println("\nPre-Order traversal Corrected (Iterative)");
        LinkedList<BTNode> list2= binaryTree.postOrderTraversalCorrected(binaryTree.getRoot());
        for (BTNode node : list2) {
            System.out.print(node.value + " ");
        }

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
        /*
        * V2
        * */
        System.out.println("\nIn-Order traversal V2 (Iterative)");
        List<BTNode> list = binaryTree.inOrderTraversal_V2(binaryTree.getRoot());
        for (BTNode node : list) {
            System.out.print(node.value + " ");
        }
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
        System.out.println("Height of leaf node 15: " + binaryTree.height(binaryTree.getNode(15)));
        System.out.println("Height of leaf node 8: " + binaryTree.height(binaryTree.getNode(8)));
        System.out.println("Height of non-leaf node 3: " + binaryTree.height(binaryTree.getNode(3)));
    }

    @Test
    void doubleTreeTest() {
        binaryTree.doubleTree();
    }

    @Test
    void sameTreeTest() {
        BinaryTreeImpl binaryTree1 = new BinaryTreeImpl();
        binaryTree1.create();
        for (int i=1; i<16; i++){
            binaryTree1.insertNode(i);
        }

        BinaryTreeImpl binaryTree2 = new BinaryTreeImpl();
        binaryTree2.create();
        for (int i=1; i<9; i++){
            binaryTree2.insertNode(i);
        }
        assertFalse(binaryTree.sameTree(binaryTree.getRoot(), binaryTree2.getRoot()));
        assertTrue(binaryTree.sameTree(binaryTree.getRoot(), binaryTree1.getRoot()));
        assertFalse(binaryTree.sameTree(binaryTree1.getRoot(), binaryTree2.getRoot()));
    }

    @Test
    void sameTreeIterativeTest() {
        BinaryTreeImpl binaryTree1 = new BinaryTreeImpl();
        binaryTree1.create();
        for (int i=1; i<16; i++) {
            binaryTree1.insertNode(i);
        }

        BinaryTreeImpl binaryTree2 = new BinaryTreeImpl();
        binaryTree2.create();
        for (int i=1; i<18; i++) {
            binaryTree2.insertNode(i);
        }

        assertTrue(binaryTree.sameTreeIterative(binaryTree.getRoot(), binaryTree1.getRoot()));
        assertFalse(binaryTree.sameTreeIterative(binaryTree.getRoot(), binaryTree2.getRoot()));
        assertFalse(binaryTree.sameTreeIterative(binaryTree1.getRoot(), binaryTree2.getRoot()));
    }

    @Test
    void addTreesTest() {
        BinaryTreeImpl binaryTree1 = new BinaryTreeImpl();
        binaryTree1.create();
        for (int i=1; i<16; i++) {
            binaryTree1.insertNode(i);
        }

        assertTrue(binaryTree.addTrees(binaryTree.getRoot(), binaryTree1.getRoot()));
        binaryTree.traverseBfsLvlOrder(binaryTree.getRoot());

        BinaryTreeImpl binaryTree2 = new BinaryTreeImpl();
        binaryTree2.create();
        for (int i=1; i<4; i++) {
            binaryTree2.insertNode(i);
        }

        assertTrue(binaryTree.addTrees(binaryTree.getRoot(), binaryTree2.getRoot()));
        binaryTree.traverseBfsLvlOrder(binaryTree.getRoot());
    }

    @Test
    void postOrderTraversalTest() {
        binaryTree.postOrderTraversal(binaryTree.getRoot());

        /*
        * V2
        * */
        List<BTNode> list = binaryTree.postOrderTraversal_V2(binaryTree.getRoot());
        System.out.println("\nPost order traversal V2 (iterative)");
        for (BTNode node : list) {
            System.out.print(node.value + " ");
        }

        /*
        * Correct algorithm to work on all types of binary trees
        * */
        LinkedList<BTNode> list2 = binaryTree.postOrderTraversalCorrected(binaryTree.getRoot());
        System.out.println("\nPost order traversal corrected for non-complete binary tree (iterative)");
        for (BTNode node : list2) {
            System.out.print(node.value + " ");
        }
    }

    @Test
    void deleteTest() {
        binaryTree.delete(15);
        binaryTree.traverseBfsLvlOrder(binaryTree.getRoot());
        binaryTree.delete(7);
        binaryTree.traverseBfsLvlOrder(binaryTree.getRoot());
        binaryTree.delete(7);
        binaryTree.traverseBfsLvlOrder(binaryTree.getRoot());
        binaryTree.delete(2);
        binaryTree.traverseBfsLvlOrder(binaryTree.getRoot());
        binaryTree.delete(9);
        binaryTree.traverseBfsLvlOrder(binaryTree.getRoot());
        binaryTree.delete(1);
        binaryTree.traverseBfsLvlOrder(binaryTree.getRoot());
    }
}