package com.rahul.dsalgo.algorithm.sorting;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class BubbleSortTest {

    BubbleSort bubbleSort;
    Integer arrayBubble[];
    final int MAX_ELEMENTS = 1000;

    @BeforeEach
    void setUp() {
        bubbleSort = new BubbleSort();

        arrayBubble = new Integer[MAX_ELEMENTS];

        int randomNumber;
        for(int i=0; i<MAX_ELEMENTS; i++) {
            randomNumber = ((int) (Math.random() * MAX_ELEMENTS));
            arrayBubble[i] = randomNumber ;
        }
    }

    @Test
    void sortTest() {
        long startTime = System.currentTimeMillis();
        bubbleSort.sort(arrayBubble);
        long endTime = System.currentTimeMillis();

        System.out.println("Time it took to Bubble sort " + MAX_ELEMENTS + " integers: " + (endTime-startTime)
                + " milliseconds");

        System.out.print(arrayBubble[0] + " ");
        for (int i=1; i<MAX_ELEMENTS; i++) {
            System.out.print(arrayBubble[i] + " ");
            if (arrayBubble[i-1] > arrayBubble[i]) {
                assertTrue(false);
                break;
            }
        }
    }
}