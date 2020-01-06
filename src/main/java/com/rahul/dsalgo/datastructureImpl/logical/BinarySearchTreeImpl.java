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
    public BTNode getRoot() {
        return root;
    }

    BTNode getSuperRoot() {
        return super.getRoot();
    }

    public BinarySearchTreeImpl() {
        this.create();
        super.setRoot(this.root);
    }

    @Override
    public void create() {
        root = new BTNode();
    }

    @Override
    public int insertNode(int value) {
        Stack<BTNode> nodes = new Stack<>();
        boolean heightRecalculation = false;
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        if (root.value == Integer.MIN_VALUE) {
            root.value = value;
            root.height = 0;
            return root.value;
        }
        BTNode node = root;

        while (true) {
            if (value <= node.value) {
                if (node.leftChild != null) {
                    nodes.push(node);
                    node = node.leftChild;
                } else {
                    BTNode newNode = new BTNode();
                    newNode.value = value;
                    node.leftChild = newNode;
                    nodes.push(node);
                    // Height recalculation is needed only when the new node is first child of a leaf node.
                    heightRecalculation = node.rightChild == null ? true :  false;
                    break;
                }
            } else {
                if (node.rightChild != null) {
                    nodes.push(node);
                    node = node.rightChild;
                } else {
                    BTNode newNode = new BTNode();
                    newNode.value = value;
                    node.rightChild = newNode;
                    nodes.push(node);
                    // Height recalculation is needed only the new node is first child of a leaf node.
                    heightRecalculation = node.leftChild==null ? true : false;
                    break;
                }
            }
        }
        if (heightRecalculation) {
            heightRecalculation(nodes);
        }
        return node.value;
    }

    /**
     * Uses stack from the insert method to recalculate the height of all the visited nodes during insert operation
     * */
    private void heightRecalculation(Stack<BTNode> nodes) {
        BTNode node;
        while (!nodes.isEmpty()) {
            node = nodes.pop();
            int leftHeight = node.leftChild != null ? node.leftChild.height : 0;
            int rightHeight = node.rightChild != null ? node.rightChild.height : 0;
            node.height = Integer.max(leftHeight, rightHeight) + 1;
        }
    }

    /**
     * TODO 11/03/19 Revisit this logic to find run time and make sure this takes no more than O(n).
     * i.e visit each node no more than once
     * */
    @Override
    public void treeList() {
        // Converts the ordered binary tree into circular ordered doubly linked list
        Stack<BTNode> stack = new Stack<>();
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
        System.out.println("Printing the Tree-List Result: ");
        // Print
        BTNode node = head;
        while (node !=null)
        {
            System.out.print(node.value + " ");
            node = node.rightChild;
        }
    }

    private void reversePrintTreeList(BTNode tail) {
        System.out.println("\nReverse Printing the Tree-List result: ");
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
                parent.height--;
                root = root.rightChild;
            }
            if (parent != null) { //TODO remove the parent null check. I think it is not needed.
                parent.rightChild = root.leftChild;
                // Left sub tree do not need height adjustment since it is height and not depth. Make sense ?
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
            newNode.height = node.height;
            node.leftChild = null;
            node.rightChild = null;
            root = newNode;
            return;
        }

        while (node != null) {
            if (value < node.value) {
                parent = node;
                parent.height--;
                node = node.leftChild;
            } else if (value > node.value){
                parent = node;
                parent.height--;
                node = node.rightChild;
            } else {
                break;
            }
        }
        evaluateAndDelete(node, parent, value);
    }

    /**
     * This method evaluates if the node to be deleted has two children or 1 child or no child. In case of two children,
     * it finds a new node to replace the deleted node. In all other cases it is trivial.
     * */
    private void evaluateAndDelete(BTNode node, BTNode parent, int value){
        if (node.leftChild != null && node.rightChild != null) {
            // For replacement, we can use the largest from left sub tree or smallest from right sub tree of the node
            // to be deleted.
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
            Queue<BTNode> que = new LinkedList<>();
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

    public void traverseBfsLvlOrderHeightPrint(BTNode node) {
        System.out.println("\nBinary Search Tree Level Order Height Print");
        if (node != null) {
            Queue<BTNode> que = new LinkedList<>();
            que.add(node);
            while (!que.isEmpty()) {
                node = que.remove();
                System.out.print(node.value + "|" + node.height + " ");
                if (node.leftChild != null) {
                    que.add(node.leftChild);
                }
                if (node.rightChild != null) {
                    que.add(node.rightChild);
                }
            }
        }
    }

    /**
     * This algorithm uses post order traversal and calculates the height of node
     * */
    @Override
    public int height(BTNode root) {
        return super.height(root);
        /*Stack<BTNode> stack = new Stack<>();
        if (this.root == null) {
            return -1; //tree does not exist
        }
        BTNode node = root, lastNode = null;

        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.leftChild;
            }
            node = stack.peek();
            if (node.rightChild != null && node.rightChild != lastNode) {
                node = node.rightChild;
            } else {
                lastNode = stack.pop();
                int leftHeight = node.leftChild != null ? node.leftChild.height : -1;
                int rightHeight = node.rightChild != null ? node.rightChild.height : -1;
                lastNode.height = Integer.max(leftHeight, rightHeight) + 1;
                node = null;
            }
        }
        return root.height;*/
    }

    @Override
    public BTNode getNode(int value) {
        super.setRoot(this.root); // this is done in create method but is not working for this method. Check why
        return super.getNode(value);
    }
}
