package com.rahul.dsalgo.algorithm.searching;

import com.rahul.dsalgo.algorithm.sorting.MergeSort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BinarySearchTest {

    Integer MAX_ELEMENTS = 1000000;
    MergeSort mergeSort = new MergeSort();
    BinarySearch binarySearch = new BinarySearch();
    Integer arr[];

    @BeforeEach
    void setUp() {
        arr = new Integer[MAX_ELEMENTS];
        for (int i=0; i<MAX_ELEMENTS; i++) {
            arr[i] = (int)(Math.random() * MAX_ELEMENTS);
        }
        arr = mergeSort.mergeSort(arr);
    }

    @Test
    void find() {
        System.out.println("1000: " + binarySearch.find(arr, 1000) );
        System.out.println("1: " + binarySearch.find(arr, 1));
        System.out.println("97013: " + binarySearch.find(arr, 97013));
    }
}