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

    public AVLTreeImpl() {
        create();
        root = new BTNode();
    }

    //@Override
    private void leftRotate(BTNode root, BTNode parentOfRoot) {
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
        reCalculateHeight(newRoot.leftChild);
        reCalculateHeight(newRoot.rightChild);
        reCalculateHeight(newRoot);
    }

    //@Override
    private void rightRotate(BTNode root, BTNode parentOfRoot) {
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
        reCalculateHeight(newRoot.leftChild);
        reCalculateHeight(newRoot.rightChild);
        reCalculateHeight(newRoot);
    }

    private void reCalculateHeight(BTNode node) {
        if (node == null) {
            return;
        }
        int leftHeight = node.leftChild != null ? node.leftChild.height : -1;
        int rightHeight = node.rightChild != null ? node.rightChild.height : -1;
        node.height = Integer.max(leftHeight, rightHeight) + 1;
    }
    /*
    * Code is not in use as of now but will be used soon in place of interface implementation.
    * */
    private BTNode rightRotate(BTNode root) {
        BTNode newRoot =  root.leftChild;
        root.leftChild = newRoot.rightChild;
        newRoot.rightChild = root;
        return newRoot;
    }

    /*
     * Code is not in use as of now but will be used soon in place of interface implementation.
     * */
    private BTNode leftRotate(BTNode root) {
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

    @Override
    public void delete(int value) {
        if (root == null) {
            return;
        }
        if (value == root.value) {
            evaluateAndDelete(null);
        }
        BTNode node = root;
        Stack<BTNode> stack = new Stack<>();

        while (node != null) {
            stack.push(node);
            if (value == node.value) {
                evaluateAndDelete(stack);
                break;
            } else {
                node = value < node.value ? node.leftChild : node.rightChild;
            }

        }
    }

    /**
    * This function evaluates the candidate for delete for one of the tree conditions and also evaluates if
    * height recalculation and rotations is required for the tree path of that node.
    *
    * @param stack of the node path
    * */
    private void evaluateAndDelete(Stack<BTNode> stack) {
        if (stack == null) {
            // TODO implement root node condition
            BTNode newRoot = getSmallestFromRightSubTree(root);
            newRoot.leftChild = root.leftChild;
            newRoot.rightChild = root.rightChild;
            root = newRoot;
            return;
        }
        BTNode node = stack.pop();
        BTNode parentNode = stack.peek();
        boolean heightRecalculation = false;
        if (node.leftChild == null && node.rightChild == null) {
            // Leaf node condition
            if (parentNode.leftChild == node) {
                parentNode.leftChild = null;
            } else {
                parentNode.rightChild = null;
            }
        } else if (node.leftChild == null) {
            // right child condition
            if (parentNode.leftChild == node) {
                parentNode.leftChild = node.rightChild;
            } else {
                parentNode.rightChild = node.rightChild;
            }
            heightRecalculation = true;
        } else if (node.rightChild == null) {
            // left child condition
            if (parentNode.leftChild == node) {
                parentNode.leftChild = node.leftChild;
            } else {
                parentNode.rightChild = node.leftChild;
            }
            heightRecalculation = true;
        } else {
            //both child condition. Get the smallest from right sub tree or largest from left sub tree
            BTNode newSubRoot = getSmallestFromRightSubTree(node);
            //BTNode newSubRoot = getLargestFromLeftSubTree(node); TODO implement this

            newSubRoot.leftChild = node.leftChild;
            node.leftChild = null;
            newSubRoot.rightChild = node.rightChild;
            node.rightChild = null;
            if (parentNode.leftChild == node) {
                parentNode.leftChild = newSubRoot;
            } else {
                parentNode.rightChild = newSubRoot;
            }

            heightRecalculation = true;
        }
        if (heightRecalculation == true) {
            heightRecalculationAndRotation(stack);
        }
    }
    /*
    * Returns the smallest from right sub tree of node and unlinks the smallest node
    * */
    private BTNode getSmallestFromRightSubTree (BTNode node) {
        BTNode parent = node;
        node = node.rightChild;
        while (node.leftChild != null) {
            parent = node;
            node = node.leftChild;
        }
        if (node.rightChild != null) {
            if (parent.rightChild == node){
                parent.rightChild = node.rightChild;
            } else {
                parent.leftChild = node.rightChild;
            }
        } else {
            if (parent.rightChild == node){
                parent.rightChild = null;
            } else {
                parent.leftChild = null;
            }
        }
        return node;
    }
}
