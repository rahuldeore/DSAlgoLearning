package com.rahul.dsalgo.datastructure.logical;

import com.rahul.dsalgo.datastructureImpl.logical.components.BTNode;

/**
 * Created by Rahul on 10/19/19
 */
public interface BinaryTree {

    /**
     * Creates the root of the binary tree.
     * */
    void create();

    /**
     * Prints the tree in Left-Root-Right order. Recursive solution
     * */
    void traverseDfsInOrder();

    /**
     * Prints the tree in Root-Left-Right order. Recursive solution.
     * @param */
    void traverseDfsPreOrder();

    /**
     * Prints the tree in Left-Right-Root order. Recursive solution.
     * */
    void traverseDfsPostOrder();

    /**
     * Builds a COMPLETE binary tree with only last level not completely filled and elements to the left most.
     *
     * Insert follows pre-order principal to add new elements to the tree. Returns the value of parent node. In case of
     * root node, returns value 0 since there is no parent of root.
     * */
    int insertNode(int value);

    /**
     * traverse level wise
     * */
    void traverseBfsLvlOrder();

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
     * Adds two binary trees to form third one.
     * */
    void addTrees(BTNode tree1, BTNode tree2);

}