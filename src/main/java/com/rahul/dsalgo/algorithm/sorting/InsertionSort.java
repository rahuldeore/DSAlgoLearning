package com.rahul.dsalgo.algorithm.sorting;

import java.util.List;

/**
 * Created by Rahul on 3/7/20
 */
public class InsertionSort {

    void sort(Integer array[]) {
        int size = array.length, temp;
        for (int i=1; i<size; i++) { // The i here keeps track of the index that splits two sublist
            for (int j=i; j>0; j--) {
                if (array[j-1] > array[j]) {
                    temp = array[j-1];
                    array[j-1] = array[j];
                    array[j] = temp;
                } else {
                    break;
                }
            }
        }
    }

    // design this code in such a way that the unsorted element is inserted directly to its place without bulky swaps
    void sortEfficiently(Integer array[]) {
        int size = array.length, temp, j;
        for (int i=1; i<size; i++) { // The i here keeps track of start index of unsorted sublist
            j = i-1;
        }
    }

    // TODO Implement the algorithm using linked list
    void sort(List<Integer> list) {

    }
}
