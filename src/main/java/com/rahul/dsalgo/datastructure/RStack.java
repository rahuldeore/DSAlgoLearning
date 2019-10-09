package com.rahul.dsalgo.datastructure;

/**
 * Created by Rahul on 2019-10-06
 */

/*
* This implementation of stack works on primitive int array. In the next version, use java generics to generalize it to
* any type. 10/06/2019
*
* There is a separate linked list implementation of stack
* */
public interface RStack {
    boolean push(int num);
    int pop();
    int length();
    int top();
    int[] reverse(int[] stack);
    void printStack();
    int capacity();
}
