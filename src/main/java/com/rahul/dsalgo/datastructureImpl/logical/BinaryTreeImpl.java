package com.rahul.dsalgo.datastructureImpl.logical;

import com.rahul.dsalgo.datastructure.logical.BinaryTree;
import com.rahul.dsalgo.datastructureImpl.logical.components.BTNode;

import java.util.*;

/**
 * This is un-ordered binary tree implementation that follows the principal of complete binary tree. All levels except
 * possibly the last level is completely filled and the elements in the last level are all to the left.
 *
 * Created by Rahul on 10/19/19
 */
public class BinaryTreeImpl implements BinaryTree {

    private BTNode root;
    private Stack<BTNode> stack;
    private int nodeCount;
    private int treeDepth;
    private int leafCount;
    private boolean leftInsert; // this is for random insertion algorithm

    public BTNode getRoot() {
        return this.root;
    }

    public BinaryTreeImpl() {
    }

    @Override
    public void create() {
        root = new BTNode();
        stack = new Stack<BTNode>();
        nodeCount = 0;
        treeDepth = 0;
        leafCount = 0;
        leftInsert = true;
    }

    /**
     * This method prints binary tree in pre-order fashion using iteration rather than recursion.
     * */
    public void preOrderTraversal(BTNode root) {
        System.out.println("Pre-Order traversal (Iterative)");
        Stack<BTNode> stack = new Stack<BTNode>();
        BTNode node = root;
        if (node == null) {
            return;
        } else {
            stack.push(node);
            while (!stack.isEmpty()) {
                node = stack.pop();
                System.out.print(node.value + " ");
                if (node.rightChild != null) {
                    stack.push(node.rightChild);
                }
                if (node.leftChild != null) {
                    stack.push(node.leftChild);
                }
            }
        }
    }

    /**
     * TODO check runtime
     * This method prints the binary tree in-order and uses iteration rather than recursion
     * @param
     * */
    public void inOrderTraversal(BTNode root) {
        System.out.println("In-order traversal (Iterative)");
        Stack<BTNode> stack = new Stack<BTNode>();
        BTNode node = null;
        if (root == null) {
            return;
        } else {
            stack.push(root);
            while (!stack.isEmpty()) {
                if (stack.peek().leftChild != null && node != stack.peek().leftChild) {
                    stack.push(stack.peek().leftChild);
                } else {
                    node = stack.pop();
                    System.out.print(node.value + " ");
                    if (node.rightChild != null) {
                        stack.push(node.rightChild);
                    } else {
                        if (!stack.isEmpty()) {
                            node = stack.peek().leftChild;
                        }
                    }
                }
            }
        }
    }

    void postOrderTraversal(BTNode root) {
        System.out.println("Post-order traversal (Iterative)");

    }

    @Override
    public void traverseDfsInOrder(BTNode node) {
        if (node == null) {
            return;
        } else {
            traverseDfsInOrder(node.leftChild);
            System.out.print(node.value + " ");
            traverseDfsInOrder(node.rightChild);
        }
    }

    @Override
    public void traverseDfsPreOrder(BTNode node) {
        if (node == null){
            return;
        } else {
            System.out.print(node.value + " ");
            traverseDfsPreOrder(node.leftChild);
            traverseDfsPreOrder(node.rightChild);
        }
    }

    @Override
    public void traverseDfsPostOrder(BTNode node){
        if (node == null) {
            return;
        } else {
            traverseDfsPostOrder(node.leftChild);
            traverseDfsPostOrder(node.rightChild);
            System.out.print(node.value + " ");
        }
    }

    @Override
    public void traverseBfsLvlOrder(BTNode node) {
        System.out.println("Level order traversal (Iterative)");
        if (node == null) {
            return;
        }
        List<BTNode> que = new ArrayList<BTNode>();
        que.add(node);
        while ( !que.isEmpty() ){
            node = que.remove(0);
            if (node.leftChild != null) {
                que.add(node.leftChild);
                if (node.rightChild != null) {
                    que.add(node.rightChild);
                }
            }
            System.out.print(node.value + " ");
        }
        System.out.println();
    }


    @Override
    public int insertNode(int value) {
        BTNode node = root;
        int retVal = Integer.MIN_VALUE;
        if ( node.value == Integer.MIN_VALUE) {
            // First insert. Initialize the root.
            node.value = value;
            treeDepth = 0;
            leafCount = 1; //each time depth is set or incremented, reset leafCount
            retVal = 0;
            nodeCount++;
        } else {
            if (leafCount == (int)Math.pow(2, treeDepth)) {
                // level is full, go to next level
                leafCount = 0;
                treeDepth++;
            }
           retVal = findLeafSpotAndIns(node, value);
        }
        stack.empty();
        return retVal;
    }

    private int findLeafSpotAndIns (BTNode node, int value) {
        int retVal = Integer.MIN_VALUE;
        while (true) {
            if (node.nodeDepth < treeDepth) {
                if (node.leftChild != null) {
                    if (node.rightChild != null) {
                        stack.push(node.rightChild);
                        node = node.leftChild;
                    } else {
                        retVal = addChild(node, value, false);
                        break;
                    }
                } else {
                    // checking here if the level is not full
                    if (leafCount < Math.pow(2, treeDepth)) {
                        retVal = addChild(node,value,true);
                        break;
                    }
                }
            } else {
                node = stack.pop();
            }
        }
        return retVal;
    }

    /**
     * Generic insert method to add child to a given parent
     * @param parent parent node reference
     * @param value value to insert as child
     * @param leftInsert is it a left child
     * */
    private int addChild(BTNode parent, int value, boolean leftInsert) {
        BTNode newNode = new BTNode();
        newNode.value = value;
        newNode.nodeDepth = treeDepth;
        if (leftInsert){
            parent.leftChild = newNode;
        } else {
            parent.rightChild = newNode;
        }
        leafCount++;
        nodeCount++;
        return parent.value;
    }

    public int nodeCount(){
        return nodeCount;
    }

    @Override
    public boolean lookUp(int value) {
        BTNode node = root;
        Stack<BTNode> lookupStack = new Stack<BTNode>();
        while (true){
            if (node.value == value){
                return true;
            } else if (node.leftChild != null) {
                if (node.rightChild != null){
                    lookupStack.push(node.rightChild);
                    node = node.leftChild;
                } else {
                    node = lookupStack.pop();
                }
            } else {
                if (! lookupStack.isEmpty()){
                    node = lookupStack.pop();
                } else {
                    return false;
                }
            }
        }
    }

    @Override
    public int maxDepth() {
        return treeDepth;
    }

    @Override
    public int maxDepth(BTNode node) {
        return node.nodeDepth;
    }

    @Override
    public int size() {
        return nodeCount;
    }

    @Override
    public int height() {
        return treeDepth;
    }

    @Override
    public int height(BTNode node) {
        return treeDepth-node.nodeDepth;
    }

    /**
     * Prints the tree in this fashion
     *
     *                                      1
     * 								2		3
     * 						4		5		6		7
     * 				8		9		10		11		12		13		14		15
     *
     * */
    @Override
    public void printTree() {
        int level = treeDepth + 1;

        BTNode node = root;
        Queue<BTNode> que = new LinkedList<BTNode>();
        que.add(node);
        int currentDepth = -1;
        int spaces=level; // to keep track of spaces for each level
        while ( !que.isEmpty() ) {
            spaces=level-currentDepth;
            node = que.remove();
            if (node.leftChild != null) {
                que.add(node.leftChild);
                if (node.rightChild != null){
                    que.add(node.rightChild);
                }
            }
            if (node.nodeDepth == currentDepth) {
                System.out.print(node.value + "\t\t");
            }else {
                currentDepth++;
                System.out.println();
                for (int i=0; i<spaces; i++){
                    System.out.print("\t\t");
                }
                System.out.print(node.value + "\t\t");
            }
        }
    }

    @Override
    public boolean hasPathSum(int sum) {
        BTNode node = root;

        Stack<BTNode> stack = new Stack<BTNode>();
        List<BTNode> que = new LinkedList<BTNode>();

        stack.push(node);

        while (!stack.isEmpty()){
            node = stack.pop();
            que.add(node);
            if (node != null){
                if (node.leftChild != null) {
                    if (node.rightChild != null) {
                        stack.push(node.rightChild);
                    }
                    stack.push(node.leftChild);
                } else {
                    int pathSum = 0;
                    for (BTNode pathNode : que) {
                        pathSum += pathNode.value;
                    }
                    if (pathSum == sum) {
                        return true;
                    }
                    while (!stack.isEmpty() && que.get(que.size()-1).nodeDepth >= stack.peek().nodeDepth) {
                        que.remove(que.size()-1);
                    }
                }
            }
        }
        return false;
    }

    @Override
    public void printPaths() {
        BTNode node = root;
        Stack<BTNode> stack = new Stack<BTNode>();
        List<BTNode> que = new LinkedList<BTNode>();
        stack.push(node);

        while (!stack.isEmpty()) {
            if (stack.peek() != null) {
                node = stack.pop();
                que.add(node);
                if (node.leftChild != null) {
                    if (node.rightChild != null) {
                        stack.push(node.rightChild);
                    }
                    stack.push(node.leftChild);
                } else {
                    String path = "";
                    for (BTNode pathNode : que) {
                        path = path + " " + pathNode.value;
                    }
                    System.out.println("Path: " + path);
                    while (!stack.isEmpty() && stack.peek().nodeDepth <= que.get(que.size()-1).nodeDepth) {
                        que.remove(que.size()-1);
                    }
                }
            }
        }
    }

    @Override
    public BTNode mirror() {
        BTNode mirrorRoot = new BTNode();
        BTNode mirrorNode = mirrorRoot;

        BTNode node = root;

        Stack<BTNode> stack = new Stack<BTNode>();
        Stack<BTNode> rStack = new Stack<BTNode>();

        stack.push(node);
        rStack.push(mirrorNode);
        while (!stack.isEmpty()) {
            node = stack.pop();
            mirrorNode = rStack.pop();
            mirrorNode.value=node.value;
            if (node.leftChild != null) {

                if (node.rightChild != null) {
                    mirrorNode.leftChild = new BTNode();
                    stack.push(node.rightChild);
                    rStack.push(mirrorNode.leftChild);
                }
                mirrorNode.rightChild = new BTNode();
                stack.push(node.leftChild);
                rStack.push(mirrorNode.rightChild);
            }
        }

        return mirrorRoot;
    }

    @Override
    public void doubleTree() {
        // TODO implementation remaining
    }

    @Override
    public void sameTree(BTNode tree1, BTNode tree2) {
        // TODO implementation remaining
    }

    @Override
    public void countTree(int elementCount) {
        // TODO implementation remaining
    }

    @Override
    public void addTrees(BTNode tree1, BTNode tree2) {
        // TODO implementation remaining
    }

    @Override
    public void delete(int value) {
        // TODO Need to decide on the delete algorithm. Which child node becomes the parent when non leaf node is
        //  deleted
    }

    @Override
    public void reBalanceTree(BTNode node) {
        // TODO Need to understand this properly
    }

    @Override
    public void mirrorSelf() {
        // TODO Implementation remaining
    }
}
