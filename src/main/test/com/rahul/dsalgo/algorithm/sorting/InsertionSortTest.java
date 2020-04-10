package com.rahul.dsalgo.algorithm.sorting;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class InsertionSortTest {

    InsertionSort insertionSort;
    Integer arrayInsertion[];
    final int MAX_ELEMENTS = 1000;

    @BeforeEach
    void setUp() {
        insertionSort = new InsertionSort();

        arrayInsertion = new Integer[MAX_ELEMENTS];

        int randomNumber;
        for(int i=0; i<MAX_ELEMENTS; i++) {
            randomNumber = ((int) (Math.random() * MAX_ELEMENTS));
            arrayInsertion[i] = randomNumber ;
        }
    }

    @Test
    void sortTest() {
        long startTime = System.currentTimeMillis();
        insertionSort.sort(arrayInsertion);
        long endTime = System.currentTimeMillis();

        System.out.println("Time it took to Insertion sort " + MAX_ELEMENTS + " integers: " + (endTime-startTime)
                + " milliseconds");

        System.out.print(arrayInsertion[0] + " ");
        for (int i=1; i<MAX_ELEMENTS; i++) {
            System.out.print(arrayInsertion[i] + " ");
            if (arrayInsertion[i-1] > arrayInsertion[i]) {
                assertTrue(false);
                break;
            }
        }
    }

    //@Test
    void sortEfficientlyTest() {
        long startTime = System.currentTimeMillis();
        insertionSort.sortEfficiently(arrayInsertion);
        long endTime = System.currentTimeMillis();

        System.out.println("Time it took to Insertion sort efficiently " + MAX_ELEMENTS + " integers: " + (endTime-startTime)
                + " milliseconds");

        System.out.print(arrayInsertion[0] + " ");
        for (int i=1; i<MAX_ELEMENTS; i++) {
            System.out.print(arrayInsertion[i] + " ");
            if (arrayInsertion[i-1] > arrayInsertion[i]) {
                assertTrue(false);
                break;
            }
        }
    }
}