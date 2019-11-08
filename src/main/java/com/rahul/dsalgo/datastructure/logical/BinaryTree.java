package com.rahul.dsalgo.datastructure.logical;

import com.rahul.dsalgo.datastructureImpl.logical.components.BTNode;

/**
 *
 * Created by Rahul on 10/19/19
 */
public interface BinaryTree {

    /**
     * Creates the root of the binary tree. This is completely unnecessary function but I did this because a video
     * I referred initially was using this.
     * */
    void create();

    /**
     * Prints the tree in Left-Root-Right order. Recursive solution
     * */
    void traverseDfsInOrder(BTNode root);

    /**
     * Prints the tree in Root-Left-Right order. Recursive solution.
     * */
    void traverseDfsPreOrder(BTNode root);

    /**
     * Prints the tree in Left-Right-Root order. Recursive solution.
     * */
    void traverseDfsPostOrder(BTNode root);

    /**
     * Prints the elements level wise. Iterative Solution.
     * */
    void traverseBfsLvlOrder(BTNode root);

    /**
     *
     * In case of an un-ordered binary tree:-
     * Builds a COMPLETE binary tree possibly with only last level not completely filled and elements to the left most.
     *
     * Insert follows pre-order principal to add new elements to the tree.
     *
     * For all types of trees:-
     * Returns the value of parent node. In case of
     * root node, returns value 0 since there is no parent of root.
     * */
    int insertNode(int value);

    /**
     * Returns true if the element in the parameter to the function exist in the binary tree.
     * */
    boolean lookUp (int value);

    /**
     * Calculates the max depth of the tree
     * */
    int maxDepth();

    /**
     * returns the max depth from a particular node
     * */
    int maxDepth(BTNode node);

    /**
     * calculates and returns the total count of nodes in the Binary tree
     * */
    int size();

    /**
     * returns the height of the tree
     * */
    int height();

    /**
     * returns height of a particular node in Binary tree
     * */
    int height(BTNode node);

    /**
     * Prints the tree in fancy visuals
     * */
    void printTree();

    /**
     * Returns true if there exist a path from root to a leaf node that sums up to the parameter variable sum
     * @param sum sum value to check against
     * */
    boolean hasPathSum(int sum);

    /**
     * Prints all paths from root to each leaf nodes
     * */
    void printPaths();

    /**
     * Creates a mirror binary tree of the original
     * */
    BTNode mirror();

    /**
     * Creates a copy of each element and adds it as a left child.
     * */
    void doubleTree();

    /**
     * Returns true if two binary trees are identical
     * */
    void sameTree(BTNode tree1, BTNode tree2);

    /**
     * This is not a binary tree programming problem in the ordinary sense -- it's more of a math/combinatorics
     * recursion problem that happens to use binary trees
     *
     * Returns the number of possible unique combinations of binary tree with given number of elements
     * Example: countTrees(4) should return 14, since there are 14  structurally unique binary search trees that store
     * 1, 2, 3, and 4 elements.
     * */
    void countTree(int elementCount);

    /**
     * Adds two binary trees to form third one. Addition happens at the node level and resultant tree contains number
     * of elements equal to max of both trees
     * */
    void addTrees(BTNode tree1, BTNode tree2);

    /**
     * Yet to finalize on the algorithm for delete
     * */
    void delete(int value);

    /**
     * This method re-balances the binary tree to make it a complete binary tree. This is needed after deletion of node
     * in a binary tree
     * */
    void reBalanceTree(BTNode node);

    /**
     * This method mirrors the original binary tree in place and do not create a new mirror
     * */
    void mirrorSelf();
}