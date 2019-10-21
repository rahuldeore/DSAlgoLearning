package com.rahul.dsalgo.datastructure.logical;

/**
 * Created by Rahul on 10/19/19
 */
public interface BinaryTree {

    /**
     *
     * */
    void create();

    /**
     *
     * */
    void traverseBfsInOrder();

    /**
     *
     *
     * @param */
    void traverseBfsPreOrder();

    /**
     *
     * */
    void traverseBfsPostOrder();

    /**
     * Builds a complete binary tree with only last level not completely filled and elements to the left most.
     *
     * Insert follows pre-order principal to add new elements to the tree. Returns the value of parent node. In case of
     * root node, returns value 0 since there is no parent of root.
     * */
    int insertNode(int value);

    /**
     * traverse level wise
     * */
    void traverseDfsLvlOrder();
}