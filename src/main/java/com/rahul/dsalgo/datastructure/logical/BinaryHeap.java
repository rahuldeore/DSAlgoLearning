package com.rahul.dsalgo.datastructure.logical;

import com.rahul.dsalgo.datastructureImpl.logical.components.BTNode;

/**
 * Created by Rahul on 1/5/20
 */
public interface BinaryHeap {

    void insert(int value);

    BTNode peek();

    void delete(int value);

    void find(int value);
}
