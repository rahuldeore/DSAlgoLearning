package com.rahul.dsalgo.algorithm.sorting;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class SelectionSortTest {

    SelectionSort selectionSort;
    Integer arraySelection[];
    final int MAX_ELEMENTS = 1000;

    @BeforeEach
    void setUp() {
        selectionSort = new SelectionSort();

        arraySelection = new Integer[MAX_ELEMENTS];

        int randomNumber;
        for(int i=0; i<MAX_ELEMENTS; i++) {
            randomNumber = ((int) (Math.random() * MAX_ELEMENTS));
            arraySelection[i] = randomNumber ;
        }
    }

    @Test
    void sortTest() {
        long startTime = System.currentTimeMillis();
        selectionSort.sort(arraySelection);
        long endTime = System.currentTimeMillis();

        System.out.println("Time it took to Selection sort " + MAX_ELEMENTS + " integers: " + (endTime-startTime)
                + " milliseconds");

        System.out.print(arraySelection[0] + " ");
        for (int i=1; i<MAX_ELEMENTS; i++) {
            System.out.print(arraySelection[i] + " ");
            if (arraySelection[i-1] > arraySelection[i]) {
                assertTrue(false);
                break;
            }
        }
    }
}