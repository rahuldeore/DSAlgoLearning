package com.rahul.dsalgo.datastructureImpl.logical;

import com.rahul.dsalgo.datastructure.logical.BinaryTree;
import com.rahul.dsalgo.datastructureImpl.logical.components.BTNode;

import java.util.Stack;

/**
 * Created by Rahul on 10/19/19
 */
public class BinaryTreeImpl implements BinaryTree {

    private BTNode root;
    private Stack<BTNode> stack;
    private int nodeCount;
    private int treeDepth;
    private int leafCount;
    private boolean leftInsert; // this is for random insertion algorithm

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

    @Override
    public void traverseBfsInOrder() {

    }

    private void traverseBfsInOrder_1(BTNode node) {
        if (node == null) {
            return;
        } else {

        }
    }

    @Override
    public void traverseBfsPreOrder() {
        BTNode rootNode = root;
        traverseBfsPreOrder_1(rootNode);
    }

    private void traverseBfsPreOrder_1(BTNode node) {
        if (node == null){
            return;
        } else {
            System.out.print(node.value + " ");
            traverseBfsPreOrder_1(node.leftChild);
            traverseBfsPreOrder_1(node.rightChild);
        }
    }

    @Override
    public void traverseBfsPostOrder() {

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

    @Override
    public void traverseDfsLvlOrder() {

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
}
