package com.rahul.dsalgo.datastructureImpl.logical;

import com.rahul.dsalgo.datastructure.logical.BinarySearchTree;
import com.rahul.dsalgo.datastructureImpl.logical.components.BTNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by Rahul on 10/28/19
 */
public class BinarySearchTreeImpl extends BinaryTreeImpl implements BinarySearchTree {
    public BTNode root;

    @Override
    public void create() {
        root = new BTNode();
    }

    @Override
    public int insertNode(int value) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        if (root.value == Integer.MIN_VALUE) {
            root.value = value;
            return 0;
        }
        BTNode node = root;

        while (true) {
            if (value <= node.value) {
                if (node.leftChild != null) {
                    node = node.leftChild;
                } else {
                    BTNode newNode = new BTNode();
                    newNode.value = value;
                    node.leftChild = newNode;
                    break;
                }
            } else {
                if (node.rightChild != null) {
                    node = node.rightChild;
                } else {
                    BTNode newNode = new BTNode();
                    newNode.value = value;
                    node.rightChild = newNode;
                    break;
                }
            }
        }
        return node.value;
    }

    /**
     * TODO 11/03/19 Revisit this logic to find run time and make sure this takes no more than O(n).
     * i.e visit each node no more than once
     * */
    @Override
    public void treeList() {
        // Converts the ordered binary tree into circular ordered doubly linked list
        Stack<BTNode> stack = new Stack<BTNode>();
        BTNode node = null;
        BTNode head, tail = null;
        if (root == null){
            return;
        }
        stack.push(root);
        head = root;
        // Runtime O(log(n))
        while ( head.leftChild != null ) {
            head = head.leftChild;
            stack.push(head);
        }

        // Runtime O(n)
        while (!stack.isEmpty()){
            if (stack.peek().leftChild != null && node != stack.peek().leftChild) {
                stack.push(stack.peek().leftChild);
            } else {
                node = stack.pop();
                if (node.rightChild != null) {
                    stack.push(node.rightChild);
                    node.rightChild.leftChild = node;
                } else {
                    if (!stack.isEmpty()) {
                        node.rightChild = stack.peek();
                        stack.peek().leftChild = node;
                        node = stack.peek().leftChild;
                    }
                }
            }
        }
        tail = node;
        printTreeList(head);
        reversePrintTreeList(tail);
    }

    private void printTreeList(BTNode head) {
        System.out.println("Printing the Tree-Node Result: ");
        // Print
        BTNode node = head;
        while (node !=null)
        {
            System.out.print(node.value + " ");
            node = node.rightChild;
        }
    }

    private void reversePrintTreeList(BTNode tail) {
        System.out.println("Reverse Printing the Tree-Node result: ");
        // Print reverse
        BTNode node = tail;
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.leftChild;
        }
    }

    /**
     * Takes a binary search tree (sub-tree) root as a parameter and returns reference to the parent of largest node. Largest
     * will always be the right child of the parent.
     * @param root root of a binary search tree
     * @return reference of the parent to the largest node. In case tree has only root, returns root reference.
     * */
    private BTNode findParentOfLargest(BTNode root) {
        if (root != null) {
            while (root.rightChild != null && root.rightChild.rightChild != null) {
                root = root.rightChild;
            }
        }
        return root; // parent of the largest node
    }

    /**
     * Takes a binary search tree (sub-tree)) root as a parameter and returns reference to the parent of smallest node. Smallest
     * will always be the left child of the parent
     * @param root root of a binary search tree
     * @return reference of the parent to the smallest node. In case tree has only root, returns root reference.
     * */
    private BTNode findParentOfSmallest(BTNode root) {
        if (root != null) {
            while (root.leftChild != null && root.leftChild.leftChild != null){
                root = root.leftChild;
            }
        }
        return root;
    }

    /**
     * Takes a binary search tree (sub-tree) root as a parameter and returns largest node. The largest node is also
     * unlinked from the parent
     * @param root root of a binary search tree
     * @return reference largest node. In case tree has only root, returns root reference.
     * */
    public BTNode findAndUnlinkLargest(BTNode root) {
        BTNode parent = null;
        if (root != null) {
            while (root.rightChild != null) {
                parent = root;
                root = root.rightChild;
            }
            if (parent != null) {
                parent.rightChild = root.leftChild;
            }
        }
        return root;
    }

    /**
     * Takes a binary search tree (sub-tree) root as a parameter and returns smallest node. The smallest node is also
     * unlinked from the parent.
     * @param root root of a binary search tree
     * @return reference smallest node. In case tree has only root, returns root reference.
     * */
    public BTNode findAndUnlinkSmallest(BTNode root) {
        BTNode parent = null;
        if (root != null) {
            while (root.leftChild != null) {
                parent = root;
                root = root.leftChild;
            }
            if (parent != null) {
                parent.leftChild = root.rightChild;
            }
        }
        return root;
    }

    @Override
    public void deleteNode(int value) {
        BTNode node = root;
        BTNode parent = null;
        if (root != null && root.value == value) {
            BTNode newNode = findAndUnlinkLargest(node.leftChild);
            newNode.leftChild = node.leftChild;
            newNode.rightChild = node.rightChild;
            node.leftChild = null;
            node.rightChild = null;
            root = newNode;
            return;
        }

        while (node != null) {
            if (value < node.value) {
                parent = node;
                node = node.leftChild;
            } else if (value > node.value){
                parent = node;
                node = node.rightChild;
            } else {
                break;
            }
        }
        evaluateAndDelete(node, parent, value);
    }
    void evaluateAndDelete(BTNode node, BTNode parent, int value){
        if (node.leftChild != null && node.rightChild != null) {
            BTNode newNode = findAndUnlinkLargest(node);
            newNode.leftChild = node.leftChild;
            newNode.rightChild = node.rightChild;
            if (parent.leftChild == node) {
                parent.leftChild = newNode;
            } else {
                parent.rightChild = newNode;
            }
        } else if (node.leftChild != null) {
            if (parent.leftChild == node) {
                parent.leftChild = node.leftChild;
            } else {
                parent.rightChild = node.leftChild;
            }
        } else if (node.rightChild != null) {
            if (parent.leftChild == node) {
                parent.leftChild = node.rightChild;
            } else {
                parent.rightChild = node.rightChild;
            }
        } else {
            if (parent.leftChild == node) {
                parent.leftChild = null;
            } else {
                parent.rightChild = null;
            }
        }
    }

    @Override
    public void traverseBfsLvlOrder(BTNode node) {
        System.out.println("\nBinary Search Tree Level Order Traversal");
        if (node != null) {
            Queue<BTNode> que = new LinkedList<BTNode>();
            que.add(node);
            while (!que.isEmpty()) {
                node = que.remove();
                System.out.print(node.value + " ");
                if (node.leftChild != null) {
                    que.add(node.leftChild);
                }
                if (node.rightChild != null) {
                    que.add(node.rightChild);
                }
            }
        }
    }
}
