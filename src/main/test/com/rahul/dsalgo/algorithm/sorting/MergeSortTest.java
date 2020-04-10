package com.rahul.dsalgo.algorithm.sorting;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class MergeSortTest {

    static final int SIZE = 10000000;
    Integer arr[];
    //Integer arr[] = {5, 10, 70, 3, 1, 22, 67, 30, 11};
    //Integer arr[] = {5,3};

    Integer[] leftHalf, rightHalf;

    MergeSort mergeSort;

    @BeforeEach
    void setUp() {
        arr = new Integer[SIZE];
        for (int i=0; i<SIZE; i++) {
            arr[i] = (int)(Math.random() * SIZE);
        }
        mergeSort = new MergeSort();
    }

    boolean assertSorted(Integer arr[]) {
        int prev = arr[0];
        for (int elem : arr) {
            if (elem >= prev) {
                prev = elem;
            } else {
                return false;
            }
        }
        return true;
    }

    @Test
    void mergeSort() {
        Integer res[] = mergeSort.mergeSort(arr);
        /*
        for (int i : res) {
            System.out.print(i + " ");
        }
        */
        assertTrue(assertSorted(res));
    }

    //@Test
    void sliceArray() {
        int low = 0, high = arr.length-1, mid = low + high / 2;
        System.out.println("low: " +low+ " mid: " +mid+ " high: "+ high);
        leftHalf = mergeSort.sliceArray(arr, low, mid);
        for (int i: leftHalf){
            System.out.print(i + " ");
        }
        System.out.println("\n--");
        rightHalf = mergeSort.sliceArray(arr, mid+1, high);
        for (int i: rightHalf){
            System.out.print(i + " ");
        }
    }

    //@Test
    void mergeArrays() {
        int low = 0, high = arr.length-1, mid = (low + high) / 2;
        System.out.println("low: " +low+ " mid: " +mid+ " high: "+ high);
        leftHalf = mergeSort.sliceArray(arr, low, mid);
        for (int i: leftHalf){
            System.out.print(i + " ");
        }
        System.out.println("\n--");
        rightHalf = mergeSort.sliceArray(arr, mid+1, high);
        for (int i: rightHalf){
            System.out.print(i + " ");
        }

        Integer res[] = mergeSort.mergeArrays(leftHalf, rightHalf);

        System.out.println();

        for (int i : res) {
            System.out.print(i + " ");
        }

    }
}