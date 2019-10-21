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

    @Override
    public void traverseBfsPreOrder() {
        BTNode rootNode = root;
        traverseBfsPreOrder_1(rootNode);
    }

    private void traverseBfsPreOrder_1(BTNode node) {
        if (node == null){
            return;
        } else {
            System.out.println(node.value);
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
            leafCount = 0; //each time depth is set or incremented, reset leafCount
            retVal = 0;
            nodeCount++;
        } else {
            if (leafCount == 2 * treeDepth) {
                // level is full, go to next level
                leafCount = 0;
                treeDepth++;
            }
            while (true) {
                if (node.nodeDepth < treeDepth) {
                    if (node.leftChild != null) {
                        if (node.rightChild != null) {
                            stack.push(node.rightChild);
                            node = node.leftChild;
                        } else {
                            BTNode newNode = new BTNode();
                            newNode.value = value;
                            newNode.nodeDepth = treeDepth;
                            node.rightChild = newNode;
                            leafCount++;
                            retVal = node.value;
                            break;
                        }
                    } else {
                        if (leafCount < 2 * treeDepth) {
                            BTNode newNode = new BTNode();
                            newNode.value = value;
                            newNode.nodeDepth = treeDepth;
                            node.leftChild = newNode;
                            leafCount++;
                            retVal = node.value;
                            break;
                        }
                    }
                } else {
                    node = stack.pop();
                }
            }
        }
        stack.empty();
        return retVal;
    }

    @Override
    public void traverseDfsLvlOrder() {

    }

    public int nodeCount(){
        return nodeCount;
    }
}
