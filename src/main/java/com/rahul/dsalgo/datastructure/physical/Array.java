package com.rahul.dsalgo.datastructure.physical;

/**
 * Created by Rahul on 2019-10-09
 */

/*
* This Array interface is implemented for primitive int datatype. Next version of this class should use Generics.
* */
public interface Array {
    /**
    * This function takes element as a parameter and inserts it into the next available position. If the array is
    * full, it returns -1 else returns the position of new element in the array
    * */
    int insert(int element);

    int insert(int position, int element);

    /**
     * This function takes element as parameter and deletes it in the array. It then returns the position back to caller
     * . If the element does not exist in the array, it returns -1;
     * */
    int deleteElement (int element);

    /**
    * This function takes position as parameter and deletes it in the array. It then returns the element back to caller.
    * If the position contains 0 (default element value), then it returns Integer.MIN_VALUE to imply element did not
    * exist.
    * */
    int deleteAtPosition (int position);

    /**
    * This function takes element as a parameter and returns the position in the array. If the element is not found, it
    * returns -1
    * */
    int findPosition(int element);

    /**
    * returns the element at given position. Integer.MIN_VALUE is returned for an empty position.
    * */
    int findElementAt(int position);

    /**
    * Prints the array in space separated format
    * */
    void printArray();

}
