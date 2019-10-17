package com.rahul.dsalgo.datastructureImpl;

import com.rahul.dsalgo.datastructure.Stack;

/**
 * Created by Rahul on 2019-10-06
 */
public class StackIterationImpl implements Stack {

    private static final int CAPACITY=10;
    private int[] stack;
    private boolean full;
    private int numElements;

    public StackIterationImpl() {
        stack = new int[CAPACITY];
        full = false;
        numElements = 0;
    }

    private void shiftElementsRight() {

        if (numElements==0){
            numElements++;
            return;
        }
        if (numElements < stack.length) {
            for(int i=numElements-1; i>=0; i--) {
                stack[i+1]=stack[i];
            }
            numElements++;
        }
        if (numElements == stack.length) {
            full=true;
        }
    }

    private void shiftElementsLeft() {

        if (numElements==0){
            return;
        }
        if (numElements < stack.length) {
            for(int i=1; i<numElements; i++) {
                stack[i]=stack[i-1];
            }
            numElements--;
        }
        if (numElements == 0 || numElements < stack.length) {
            full=false;
        }
    }

    @Override
    public boolean push(int num) {
        if (!full){
                shiftElementsRight();
                stack[0]=num;
                return true;
            }
        else {
            return false;
        }
    }

    @Override
    public int pop() {
        int item = stack[0];
        shiftElementsLeft();
        return item;
    }

    @Override
    public int length() {
        return numElements;
    }

    @Override
    public int top() {
        if (numElements != 0){
            return stack[0];
        }
        else {
            return -999999999;
        }
    }

    @Override
    public int[] reverse() {
        int[] reverseStack = new int[numElements];
        for (int i=0; i<numElements; i++) {
            reverseStack[i]=stack[numElements-i];
        }
        return reverseStack;
    }

    @Override
    public void printStack() {
        if (numElements>0) {
            for (int item : stack) {
                System.out.print(item);
            }
        }
    }

    @Override
    public int capacity() {
        return CAPACITY;
    }
}
