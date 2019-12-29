package com.rahul.dsalgo.datastructureImpl.logical;

import com.rahul.dsalgo.datastructure.logical.AVLTree;
import com.rahul.dsalgo.datastructureImpl.logical.components.BTNode;
import org.jetbrains.annotations.NotNull;

import java.util.Stack;

/**
 * Created by Rahul on 12/5/19
 */
public class AVLTreeImpl extends BinarySearchTreeImpl implements AVLTree {

    private BTNode root;

    @Override
    public BTNode getRoot() {
        return root;
    }

    @Override
    public void setRoot(BTNode root) {
        this.root = root;
    }

    void setSuperRoot(BTNode root) {
        super.setRoot(this.root);
    }

    BTNode getSuperRoot() {
        return super.getRoot();
    }

    public AVLTreeImpl() {
        create();
        //setSuperRoot(this.root);
        //super.setSuperRoot(this.root); // set root of this class to the root of super class' super class
        //super.setRoot(this.root); // set root of this class to the root of super class
        root = new BTNode();
    }

    @Override
    public void leftRotate(BTNode root, BTNode parentOfRoot) {
        BTNode newRoot = root.rightChild;
        root.rightChild = newRoot.leftChild;
        newRoot.leftChild = root;
        if (parentOfRoot != null) {
            if (parentOfRoot.leftChild == root) {
                parentOfRoot.leftChild = newRoot;
            } else {
                parentOfRoot.rightChild = newRoot;
            }
        } else {
            this.root = newRoot;
        }
        //height(this.root);
    }

    @Override
    public void rightRotate(BTNode root, BTNode parentOfRoot) {
        BTNode newRoot = root.leftChild;
        root.leftChild = newRoot.rightChild;
        newRoot.rightChild = root;
        if (parentOfRoot != null) {
            if (parentOfRoot.leftChild == root) {
                parentOfRoot.leftChild = newRoot;
            } else {
                parentOfRoot.rightChild = newRoot;
            }
        } else {
            this.root = newRoot;
        }
        //height(this.root);
    }

    /*
    * Code is not in use as of now but will be used soon in place of interface implementation.
    * */
    public BTNode rightRotate(BTNode root) {
        BTNode newRoot =  root.leftChild;
        root.leftChild = newRoot.rightChild;
        newRoot.rightChild = root;
        return newRoot;
    }

    /*
     * Code is not in use as of now but will be used soon in place of interface implementation.
     * */
    public BTNode leftRotate(BTNode root) {
        BTNode newRoot = root.rightChild;
        root.rightChild = newRoot.leftChild;
        newRoot.leftChild = root;
        return newRoot;
    }

    @Override
    public int insertNode(int value) {
        BTNode node = root;
        Stack<BTNode> stack = new Stack<>();
        boolean heightRecalculation = false;
        if (node == null) {
            return Integer.MIN_VALUE;
        } else if (node.value == Integer.MIN_VALUE) {
            node.value = value;
            return node.value;
        }

        while (true) {
            if (node != null) {
                stack.push(node);
                node = value < node.value ? node.leftChild : node.rightChild;
            } else {
                node = new BTNode();
                node.value = value;
                if (value < stack.peek().value) {
                    stack.peek().leftChild = node;
                } else {
                    stack.peek().rightChild = node;
                }
                heightRecalculation = stack.peek().leftChild == null || stack.peek().rightChild == null ? true : false;
                break;
            }
        }
        if (heightRecalculation) {
            heightRecalculationAndRotation(stack);
        }
        return node == root ? 0 : node.value;
    }

    // TODO Simplify this logic
    private void heightRecalculationAndRotation(@NotNull Stack<BTNode> stack) {
        BTNode node;
        while (!stack.isEmpty()) {
            node = stack.pop();
            int leftHeight = node.leftChild != null ? node.leftChild.height : -1;
            int rightHeight = node.rightChild != null ? node.rightChild.height : -1;
            // Update node height
            node.height = Math.max(leftHeight, rightHeight) + 1;
            // Rotation logic
            if (leftHeight - rightHeight > 1) {
                // Tree is left heavy
                BTNode leftNode = node.leftChild;
                int leftSubTreeHeight = leftNode.leftChild != null ? leftNode.leftChild.height : -1;
                int rightSubTreeHeight = leftNode.rightChild != null ? leftNode.rightChild.height : -1;
                if (leftSubTreeHeight > rightSubTreeHeight) {
                    // Single right rotate condition
                    rightRotate(node, stack.isEmpty() != true ? stack.peek() : null);
                } else {
                    // Left rotate on left node, right rotate on node
                    leftRotate(leftNode, node);
                    rightRotate(node, stack.isEmpty() != true ? stack.peek() : null);
                }
            } else if (leftHeight - rightHeight < -1) {
                // Tree is right heavy
                BTNode rightNode = node.rightChild;
                int leftSubTreeHeight = rightNode.leftChild != null ? rightNode.leftChild.height : -1;
                int rightSubTreeHeight = rightNode.rightChild != null ? rightNode.rightChild.height : -1;
                if (leftSubTreeHeight > rightSubTreeHeight) {
                    // Right rotate on right sub tree then left rotate on node.
                    rightRotate(rightNode, node);
                    leftRotate(node, stack.isEmpty() != true ? stack.peek() : null);
                } else {
                    leftRotate(node, stack.isEmpty() != true ? stack.peek() : null);
                }
            }
        }
    }
}
