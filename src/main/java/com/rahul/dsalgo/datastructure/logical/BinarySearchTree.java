package com.rahul.dsalgo.datastructure.logical;

/**
 * Created by Rahul on 11/6/19
 */
public interface BinarySearchTree extends BinaryTree{
    /**
     * This problem realizes the fact that binary tree is implemented using node structure exactly same as that of a
     * doubly linked list except the wording used for pointers.
     *
     * This function converts ordered binary tree (BST) into sorted circular doubly linked list with a head and tail.
     * The problem as describe is referred as "The Great Tree-List" problem at the staford cslibrary at:
     * http://cslibrary.stanford.edu/109/
     * */
    void treeList();

    void deleteNode(int value);

}
