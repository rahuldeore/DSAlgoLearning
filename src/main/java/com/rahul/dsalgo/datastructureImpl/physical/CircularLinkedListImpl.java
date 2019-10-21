package com.rahul.dsalgo.datastructureImpl.physical;

import com.rahul.dsalgo.datastructure.physical.CircularLinkedList;
import com.rahul.dsalgo.datastructureImpl.physical.components.Node;

/**
 * Created by Rahul on 10/18/19
 */
public class CircularLinkedListImpl extends LinkedListImpl implements CircularLinkedList {

    public CircularLinkedListImpl() {
    }

    @Override
    public void printReverse() {
        Node tNode = getTail();

        while (tNode.previous != null) {
            System.out.print(tNode.element + " ");
            tNode = tNode.previous;
        }
        System.out.println(tNode.element);
    }
}
