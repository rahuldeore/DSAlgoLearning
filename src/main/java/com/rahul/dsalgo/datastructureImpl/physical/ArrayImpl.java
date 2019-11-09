package com.rahul.dsalgo.datastructureImpl.physical;

import com.rahul.dsalgo.datastructure.physical.Array;

/**
 * Created by Rahul on 10/14/19
 */
public class ArrayImpl implements Array {
    private static int INIT_SIZE = 10;
    private int size;
    private int emptyIndex; // Value range from 0 to 9 for array of length 10
    private int[] array;

    public ArrayImpl() {
        size = INIT_SIZE;
        emptyIndex=0;
        array = new int[size];
        for (int i=0; i<size; i++){
            array[i]=Integer.MIN_VALUE;
        }
    }

    public ArrayImpl(int size) {
        this.size = size;
        emptyIndex=0;
        array = new int[this.size];
        for (int i=0; i<size; i++){
            array[i]=Integer.MIN_VALUE;
        }
    }

    @Override
    public int insert(int element) {
        if (emptyIndex<size){
            array[emptyIndex]=element;
            emptyIndex++;
            return emptyIndex;
        } else {
            return -1;
        }
    }

    // TODO This is not yet implemented. This operation will need array shifting.
    @Override
    public int insert(int position, int element) {
        return 0;
    }

    @Override
    public int deleteElement(int element) {
        int pos = findPosition(element);
        int index = pos-1;
        //if element exist
        if (index > -1) {
            shiftElementFrom(pos);
            return pos;
        }
        //if element does not exist
        else {
            return -1;
        }
    }

    public void shiftElementFrom(int pos){
        int index = pos-1;
        if (!(pos <= size)) {
            return;
        }
        if ((emptyIndex-index)>1) {
            for (int i=index; i<emptyIndex-1;i++){
                array[i]=array[i+1];
            }
            //emptyIndex--;
            if(emptyIndex == size){
                array[emptyIndex-1]=Integer.MIN_VALUE;
            }
        } else {
            array[index]=Integer.MIN_VALUE;
        }
    }

    @Override
    public int deleteAtPosition(int position) {
        int element=Integer.MIN_VALUE;
        int index = position - 1;
        if ( index < size){
            if (array[index] != 0) {
                element = array[index];
                shiftElementFrom(position);
            }
        }
        return element;
    }

    @Override
    public int findPosition(int element) {
        int position=-1;
        for (int i=0; i<emptyIndex;i++){
            if (element == array[i]){
                position=i+1;
                break;
            }
        }
        return position;
    }

    @Override
    public int findElementAt(int position) {
        if (position <= size){
            return array[position-1];
        }
        return Integer.MIN_VALUE;
    }

    @Override
    public void printArray() {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public boolean isFull (){
        return size==emptyIndex;
    }

}
