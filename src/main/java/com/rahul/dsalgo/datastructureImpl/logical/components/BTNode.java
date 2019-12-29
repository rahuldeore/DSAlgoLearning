package com.rahul.dsalgo.datastructureImpl.logical.components;

/**
 * Created by Rahul on 10/19/19
 */
public class BTNode {
    public int value = Integer.MIN_VALUE;
    public BTNode leftChild = null;
    public BTNode rightChild = null;
    //Maybe i need just one of the below and not both
    public int depth;
    public int height=0; // a leaf node has height 0
}
