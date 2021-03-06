package com.rahul.dsalgo.datastructure.logical;

/**
 * Created by Rahul on 2019-10-06
 */

/*
* This implementation of stack works on primitive int array. In the next version, use java generics to generalize it to
* any type. 10/06/2019
*
* There is a separate linked list implementation of stack
* */
public interface Stack {
    boolean push(int num);
    int pop();
    int length();
    int top();
    int[] reverse();
    void printStack();
    int capacity();
}
