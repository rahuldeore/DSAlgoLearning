package com.rahul.dsalgo.datastructureImpl.logical;

import com.rahul.dsalgo.datastructure.logical.BinaryTree;
import com.rahul.dsalgo.datastructureImpl.logical.components.BTNode;

import java.util.*;

/**
 * This is un-ordered binary tree implementation that follows the principal of complete binary tree. All levels except
 * possibly the last level is completely filled and the elements in the last level are all to the left.a
 *
 * Some operations of this class do not work for child implementations like BST or AVL.
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

    public void setRoot(BTNode root) {
        this.root = root;
    }

    public BinaryTreeImpl() {
    }

    @Override
    public void create() {
        root = new BTNode();
        stack = new Stack<>();
        nodeCount = 0;
        treeDepth = 0;
        leafCount = 0;
        leftInsert = true;
    }

    /**
     * @TODO Just revising the preorder traversal
     * */
    void preOrderTraversal_revision(BTNode root){
        BTNode node = root;
        Stack<BTNode> stack = new Stack<>();
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

    /**
     * This method prints binary tree in pre-order fashion using iteration rather than recursion.
     * */
    public void preOrderTraversal(BTNode root) {
        System.out.println("Pre-Order traversal (Iterative)");
        Stack<BTNode> stack = new Stack<>();
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
     * Simpler algorithm to do pre-order traversal. Code is also simplified
     * */
    public List<BTNode> preOrderTraversal_V2(BTNode root) {
        Stack<BTNode> stack = new Stack<>();
        List<BTNode> preOrder = new ArrayList<>();
        BTNode currNode = root;
        stack.push(currNode);
        while (!stack.isEmpty()) {
            currNode = stack.pop();
            if (currNode != null) {
                preOrder.add(currNode);
                stack.push(currNode.rightChild);
                stack.push(currNode.leftChild);
            }
        }
        return preOrder;
    }

    /**
     * @TODO revising in-order traversal
     *
     * */
    void inOrderTraversal_revision(BTNode root){
        BTNode node = root;
        Stack<BTNode> stack = new Stack<>();

        if (node == null){
            return;
        } else {
            stack.push(node);
            while (!stack.isEmpty()){
                //node = stack.peek();
                if (stack.peek().leftChild != null && node != stack.peek().leftChild) {
                    stack.push(stack.peek().leftChild);
                } else {
                    node = stack.pop();
                    System.out.println(node + " ");
                    if (node.rightChild != null) {
                        stack.push(node.rightChild);
                    }
                    if (!stack.isEmpty()) {
                        node = stack.peek().leftChild;
                    }
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
        Stack<BTNode> stack = new Stack<>();
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

    /**
     * Simpler version of in-order traversal. Code is also simplified and algorithm is different.
     * */
    public List<BTNode> inOrderTraversal_V2(BTNode root) {
        Stack<BTNode> stack = new Stack<>();
        List<BTNode> inOrder = new ArrayList<>();
        BTNode currNode = root;

        while (currNode != null || !stack.isEmpty()) {
            while (currNode != null) {
                stack.push(currNode);
                currNode = currNode.leftChild;
            }
            currNode = stack.pop();
            inOrder.add(currNode);
            currNode = currNode.rightChild;
        }
        return inOrder;
    }
    /*
    * Works only for complete binary tree. Not generic.
    * */
    public void postOrderTraversal(BTNode root) {
        System.out.println("Post-order traversal (Iterative)");
        Stack<BTNode> stack = new Stack<>();
        BTNode node = null;
        if (root == null) {
            return;
        }
        stack.push(root);
        while (!stack.isEmpty()){
            BTNode tempNode = stack.peek();
            if (tempNode.rightChild != null && node != tempNode.rightChild) {
                stack.push(tempNode.rightChild);
            }
            if (tempNode.leftChild != null && node != tempNode.rightChild) {
                stack.push(tempNode.leftChild);
            } else {
                node = stack.pop();
                System.out.print(node.value + " ");
            }
        }
    }

    public LinkedList<BTNode> postOrderTraversalCorrected(BTNode root) {
        Stack<BTNode> stack = new Stack<>();
        LinkedList<BTNode> res = new LinkedList<>();
        BTNode lastVisited = null,  currNode = root, peekNode = null ;
        while (currNode != null || !stack.isEmpty()) {
            if (currNode != null) {
                stack.push(currNode);
                currNode = currNode.leftChild;
            } else {
                peekNode = stack.peek();
                if (peekNode.rightChild != null && lastVisited != peekNode.rightChild) {
                    currNode = peekNode.rightChild;
                } else {
                    lastVisited = stack.pop();
                    res.add(lastVisited);
                }
            }
        }
        return res;
    }

    public List<BTNode> postOrderTraversal_V2(BTNode root) {
        Stack<BTNode> stack = new Stack<>();
        List<BTNode> postOrder = new ArrayList<>();
        BTNode currNode ;
        stack.push(root);
        while (!stack.isEmpty()) {
            currNode = stack.pop();
            postOrder.add(0, currNode);
            if (currNode.leftChild != null) {
                stack.push(currNode.leftChild);
            }
            if (currNode.rightChild != null) {
                stack.push(currNode.rightChild);
            }
        }
        return postOrder;
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
        List<BTNode> que = new ArrayList<>();
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

    /*
    * This function uses level order algorithm to insert in next free spot
    * */
    public void insert(int value){
        Queue<BTNode> queue = new LinkedList<>();
        BTNode node = null;
        if (root == null || root.value == Integer.MIN_VALUE) {
            root.value = value;
            return;
        }
        queue.add(root);
        while (!queue.isEmpty()){
            node = queue.remove();
            if (node.leftChild != null) {
                queue.add(node.leftChild);
            } else {
                node.leftChild = new BTNode();
                node.leftChild.value = value;
                return;
            }
            if (node.rightChild != null) {
                queue.add(node.rightChild);
            } else {
                node.rightChild = new BTNode();
                node.rightChild.value = value;
                return;
            }
        }

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
            if (node.depth < treeDepth) {
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
        newNode.depth = treeDepth;
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
        Stack<BTNode> lookupStack = new Stack<>();
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
        // TODO Implementation remaining
        return treeDepth;
    }

    @Override
    public int maxDepth(BTNode node) {
        // TODO Implementation remaining
        return node.depth;
    }

    @Override
    public int size() {
        // TODO Implementation remaining
        return nodeCount;
    }

    @Override
    public int height() {
        return height(root);
    }

    @Override
    public int height(BTNode root) {
        Stack<BTNode> stack = new Stack<>();
        BTNode node = root, lastNode = null;
        while ( node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.leftChild;
            }
            node = stack.peek();
            if (node.rightChild != null && lastNode != node.rightChild) {
                node = node.rightChild;
            } else {
                lastNode = stack.pop();
                // calculate height
                int leftHeight = node.leftChild != null ? node.leftChild.height : -1;
                int rightHeight = node.rightChild != null ? node.rightChild.height : -1;
                node.height = Integer.max(leftHeight, rightHeight) + 1;
                node = null;
            }
        }
        return root.height;
    }

    /**
     * Prints the tree in this fashion
     *
     *                                      1
     * 								2		3
     * 						4		5		6		7
     * 				8		9		10		11		12		13		14		15
     *
     *
     * @param root*/
    @Override
    public void printTree(BTNode root) {
        int level = treeDepth + 1;
        BTNode node = root;
        Queue<BTNode> que = new LinkedList<>();
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
            if (node.depth == currentDepth) {
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

        Stack<BTNode> stack = new Stack<>();
        List<BTNode> que = new LinkedList<>();

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
                    while (!stack.isEmpty() && que.get(que.size()-1).depth >= stack.peek().depth) {
                        que.remove(que.size()-1);
                    }
                }
            }
        }
        return false;
    }

    /**
     * Complex algorithm and dependent on node depth variable
     * */
    // TODO Re-write this without using nodeDepth variable of node structure. Also write the recursive version.
    @Override
    public void printPaths() {
        BTNode node = root;
        Stack<BTNode> stack = new Stack<>();
        List<BTNode> que = new LinkedList<>();
        stack.push(node);

        while (!stack.isEmpty()) {
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
                // Remove nodes from queue that are at level equal or greater than the one on top of the stack. This
                // means, stack has either elements that are right child of the ones in queue or siblings. This is
                // valid only in case of complete binary tree.
                while (!stack.isEmpty() && stack.peek().depth <= que.get(que.size()-1).depth) {
                    que.remove(que.size()-1);
                }
            }
        }
    }

    /**
     * This is recursive print path algorithm that does not use height variable of {@Link(BTNode)}
     *
     * */
    void printPathsRecursively() {
        if (root == null) {
            return;
        }
        printPath(null, root);
    }

    private void printPath (List<BTNode> path, BTNode node) {
        if (path == null) {
            path = new LinkedList<>();
        }
        path.add(node);
        if (node.leftChild != null) {
            printPath(new LinkedList<>(path), node.leftChild);
        }
        if (node.rightChild != null) {
            printPath(new LinkedList<>(path), node.rightChild);
        }
        if (node.leftChild == null && node.rightChild == null) {
            path.forEach(btNode -> System.out.print(btNode.value + " "));
            System.out.println();
        }
    }
    /**
     * This is very brute force implementation. TODO Research a better/simpler algorithm
     *
     * Prints all paths from tree root to each leaf node iteratively.
     * */
    void printPathIterative() {
        BTNode node = root;
        Stack<BTNode> stack = new Stack<>();
        List<BTNode> list = new LinkedList<>();

        if (node == null) {
            return;
        }

        while (!stack.isEmpty() || node != null) {
            while (node != null){ // log n
                stack.push(node);
                list.add(node);
                node = node.leftChild;
            }
            node = stack.pop();
            if (node.rightChild != null) {
                // first, delete the left subtree elements from the list
                while (list.size()>0 && nodeExist(node.leftChild, list.get(list.size()-1))) { // (long n)/2
                    list.remove(list.size() - 1);
                }
                node = node.rightChild;
            } else {
                if (node.leftChild == null && node.rightChild == null) {
                    // print list only if it is a leaf node having no children
                    list.forEach(btNode -> System.out.print(btNode.value + " ")); // log n
                    System.out.println();
                }
                node=null;
            }
        }

    }

    // returns true if listNode is in the tree with given root element
    private boolean nodeExist(BTNode root, BTNode listNode) {
        Stack<BTNode> stack = new Stack<>();
        BTNode node = root;

        while( !stack.isEmpty() || node != null) {
            while (node != null) {
                if (node == listNode) {
                    return true;
                }
                stack.push(node);
                node = node.leftChild;
            }
            node = stack.pop();
            node = node.rightChild;
        }
        return false;
    }

    @Override
    public BTNode mirror() {
        BTNode mirrorRoot = new BTNode();
        BTNode mirrorNode = mirrorRoot;

        BTNode node = root;

        Stack<BTNode> stack = new Stack<>();
        Stack<BTNode> rStack = new Stack<>();

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
        Stack<BTNode> stack = new Stack<>();
        BTNode node = new BTNode();
        BTNode dupeNode = new BTNode();
        if (root == null) {
            return;
        }
        stack.push(root);
        while (!stack.isEmpty()) {
            node = stack.pop();
            dupeNode = copyNode(node);
            if (dupeNode.leftChild != null) {
                if (node.rightChild != null) {
                    stack.push(node.rightChild);
                }
                stack.push(dupeNode.leftChild);
            }
        }
        traverseBfsLvlOrder(root);
        inOrderTraversal(root);
    }

    private BTNode copyNode(BTNode node) {
        BTNode temp = new BTNode();
        temp.value = node.value;
        temp.leftChild = node.leftChild;
        node.leftChild = temp;
        return temp;
    }

    /**
     * This is a recursive solution. Find iterative and better solution
     * */
    @Override
    public boolean sameTree(BTNode node1, BTNode node2) {
        if (node1 != null && node2 != null) {
            if (node1.value == node2.value) {
                return sameTree(node1.leftChild, node2.leftChild) && sameTree(node1.rightChild, node2.rightChild);
            } else {
                return false;
            }
        } else if (node1 == null && node2 == null){
            return true;
        } else {
            return false;
        }
    }

    /**
     * This is iterative solution to sameTree problem.
     * */
    @Override
    public boolean sameTreeIterative(BTNode tree1, BTNode tree2) {
        Stack<BTNode> stack = new Stack<>();
        BTNode node1, node2;
        stack.push(tree1);
        stack.push(tree2);
        while (!stack.isEmpty()) {
            node2 = stack.pop();
            node1 = stack.pop();
            if (node1.value == node2.value) {
                if (node1.rightChild != null && node2.rightChild != null) {
                    stack.push(node1.rightChild);
                    stack.push(node2.rightChild);
                } else if (node1.rightChild == null && node2.rightChild == null) {
                    continue;
                } else {
                    return false;
                }

                if (node1.leftChild != null && node2.leftChild != null) {
                    stack.push(node1.leftChild);
                    stack.push(node2.leftChild);
                } else if (node1.leftChild == null && node2.leftChild == null) {
                    continue;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }

    @Override
    public void countTree(int elementCount) {
        // TODO implementation remaining
    }

    /**
     *    Sum the nodes of left tree with right.
     *    Follows the pre-order algorithm on right tree and if right tree is larger/different size than left tree,
     *    new node is added to the left tree.
     *
     *    Case1: If left tree node exist and right tree node exist, add.
     *    Case2: If left tree node does not exist but right tree node exist (also possible in case right tree is larger),
     *        create new node for left tree and copy right tree node value.
     *    Case3: If left tree node exist but right tree node does not, skip any more traversal on that path of right tree.
     * */
    @Override
    public boolean addTrees(BTNode leftTreeNode, BTNode rightTreeNode) {

        Stack<BTNode> rightStack = new Stack<>();
        Stack<BTNode> leftStack = new Stack<>();
        if (leftTreeNode == null || rightTreeNode== null) {
            return false;
        } else {
            rightStack.push(rightTreeNode);
            leftStack.push(leftTreeNode);
            while (!rightStack.isEmpty()) {
                leftTreeNode = leftStack.pop();
                rightTreeNode = rightStack.pop();
                leftTreeNode.value += rightTreeNode.value;

                if (rightTreeNode.rightChild != null) {
                    rightStack.push(rightTreeNode.rightChild);
                    if (leftTreeNode.rightChild != null) {
                        leftStack.push(leftTreeNode.rightChild);
                    } else {
                        leftTreeNode.rightChild = new BTNode();
                        leftTreeNode.rightChild.value = 0; // set to zero instead of minvalue
                    }
                }

                if (rightTreeNode.leftChild != null) {
                    rightStack.push(rightTreeNode.leftChild);
                    if (leftTreeNode.leftChild != null) {
                        leftStack.push(leftTreeNode.leftChild);
                    } else {
                        leftTreeNode.leftChild = new BTNode();
                        leftTreeNode.leftChild.value = 0;
                    }
                }
            }
        }
        return true;
    }

    /**
     * Deletes first occurrence of the node with given value. For deleting all occurrences, remove the return statement.
     * */
    @Override
    public void delete(int value) {
        Queue<BTNode> que = new LinkedList<>();
        BTNode node = new BTNode();
        node = root;
        if (node == null) {
            return;
        }
        if (root.value == value){
            BTNode newNode = evaluateAndMove(root, root, que);
            if (newNode != null) {
                newNode.leftChild = root.leftChild;
                newNode.rightChild = root.rightChild;
                root.leftChild = null;
                root.rightChild = null;
                root = newNode;
                return;
            }
        }
        que.add(node);
        while (!que.isEmpty()) {
            node = que.remove();
            if (node.leftChild != null) {
                que.add(node.leftChild);
                if (node.leftChild.value == value) {
                    BTNode newNode = evaluateAndMove(node, node.leftChild, que);
                    if (newNode != null) {
                        newNode.leftChild = node.leftChild.leftChild;
                        newNode.rightChild = node.leftChild.rightChild;
                        node.leftChild = newNode;
                        return;
                    }
                }
            }
            if (node.rightChild != null) {
                que.add(node.rightChild);
                if (node.rightChild.value == value) {
                    BTNode newNode = evaluateAndMove(node, node.rightChild, que);
                    if (newNode != null) {
                        newNode.leftChild = node.rightChild.leftChild;
                        newNode.rightChild = node.rightChild.rightChild;
                        node.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }

    /**
     * Evaluates the case of node for deletion and returns node in third case from below
     * 1. node has no children
     * 2. node has 1 child only
     * 3. node has two children
     * @return Reference to the leaf node for insertion at the place of deleted node
     * @param node parent of the node to be deleted
     * @param que queue reference from previous function to avoid unnecessary traversal
     * @param nodeToDelete reference to the node for deletion
     * */
    private BTNode evaluateAndMove(BTNode node, BTNode nodeToDelete, Queue<BTNode> que) {
        if (nodeToDelete.leftChild != null && nodeToDelete.rightChild != null){
            // This will have reference to parent of right most leaf node
            BTNode newNode = findNewNode(node, que);
            BTNode tempNode;
            if (newNode.rightChild != null) {
                tempNode = newNode.rightChild;
                newNode.rightChild = null;
                return tempNode;
            } else {
                tempNode = newNode.leftChild;
                newNode.leftChild = null;
                return tempNode;
            }
        } else if (nodeToDelete.leftChild != null) {
            // Since we build a complete binary tree, if first condition fails to satisfy, its either missing right
            // child or both children
            if (node.leftChild == nodeToDelete) {
                node.leftChild = nodeToDelete.leftChild;
            } else {
                node.rightChild = nodeToDelete.leftChild;
            }
            return null;
        } else  {
            // No need of any move, just delete the node
            // TODO implement the case when delete node is not the rightmost leaf. Do I create a re-balance method ?
            if (node.leftChild == nodeToDelete) {
                node.leftChild = node.rightChild;
                node.rightChild = null;
            } else {
                node.rightChild = null;
            }
            return null;
        }
    }

    /**
     * Traverses the tree level order wise and finds the rightmost leaf node to become the next parent in place of
     * deleted node
     * @param node reference to a node to level order traverse from
     * @param queue reference the queue used for level order traversal
     * @return reference to the rightmost leaf node
     * */
    private BTNode findNewNode(BTNode node, Queue<BTNode> queue) {
        // This is the parent of rightmost leaf. We need parent node reference to unlink rightmost leaf.
        BTNode parentOfLeaf = node;
        /*
        The if ensures that we have added both children of the node we are currently working on. If right is missing,
        left must be already added to the queue since its a complete binary tree implementation
        * */
        if (queue.peek() != node.rightChild) {
            queue.add(node.rightChild);
        }
        while (!queue.isEmpty()){
            node = queue.remove();
            if (node.leftChild != null) {
                queue.add(node.leftChild);
                parentOfLeaf = node;
            } else {
                break;
            }
            if(node.rightChild != null) {
                queue.add(node.rightChild);
                parentOfLeaf = node;
            } else {
                parentOfLeaf = node;
                break;
            }
        }
        return parentOfLeaf;
    }

    @Override
    public void reBalanceTree(BTNode node) {
        // TODO Need to understand this properly
    }

    /**
     * Mirrors the tree in-place
     * */
    @Override
    public void mirrorSelf() {
        // TODO Implementation remaining
    }

    /*
    * This method can use preorder or level order traversal for finding the value in the tree.
    * */
    @Override
    public BTNode getNode(int value) {
        if (root == null) {
            return null;
        }
        Stack<BTNode> stack = new Stack<>();
        BTNode node = root;
        stack.push(node);
        while (!stack.isEmpty()) {
            node = stack.pop();
            if (node != null) {
                if (node.value == value) {
                    return node;
                } else {
                    stack.push(node.rightChild);
                    stack.push(node.leftChild);
                }
            }
        }
        return null;
    }
}
