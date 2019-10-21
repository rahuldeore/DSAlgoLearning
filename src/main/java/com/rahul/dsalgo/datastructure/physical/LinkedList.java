package com.rahul.dsalgo.datastructure.physical;

/**
 * Created by Rahul on 10/17/19
 */
public interface LinkedList {

    /**
     * Inserts element at the tail of the linked list
     * */
    void insert(int element);

    /**
     * Inserts element at the specified position in the linked list
     * */
    void insert(int position, int element);

    /**
     * deletes element in the linked list
     * */
    int deleteLast();

    /**
     * deletes element at the specified position in linked list
     * */
    int delete(int position);

    /**
     * deletes first element in linked list
     * */
    int deleteFirst();

    /**
     * Returns the position of the element in the linked list
     * */
    int findPosition(int element);

    /**
     * Returns element at the specified position in the linked list
     * */
    int findElement(int position);

    /**
     * Returns the count of elements in the linked list
     * */
    int size();

    /**
     * Prints the list
     * */
    void print();
}
