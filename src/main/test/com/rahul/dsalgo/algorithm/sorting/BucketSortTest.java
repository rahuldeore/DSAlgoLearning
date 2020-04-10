package com.rahul.dsalgo.algorithm.sorting;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class BucketSortTest {

    BucketSort bucketSort;
    Integer arrayBucket[];
    final int MAX_ELEMENTS = 1000000;
    @BeforeEach
    void setUp() {
        bucketSort = new BucketSort();
        arrayBucket = new Integer[MAX_ELEMENTS];

        int randomNumber;
        for(int i=0; i<MAX_ELEMENTS; i++) {
            randomNumber = ((int) (Math.random() * MAX_ELEMENTS));
            arrayBucket[i] = randomNumber ;
        }
    }

    @Test
    void sortTest() {
        long startTime = System.currentTimeMillis();
        bucketSort.sort(arrayBucket);
        long endTime = System.currentTimeMillis();

        System.out.println("Time it took to Bucket sort " + MAX_ELEMENTS + " integers: " + (endTime-startTime)
                + " milliseconds");

        //System.out.print(arrayBucket[0] + " ");
        for (int i=1; i<MAX_ELEMENTS; i++) {
            //System.out.print(arrayBucket[i] + " ");
            if (arrayBucket[i-1] > arrayBucket[i]) {
                assertTrue(false);
                break;
            }
        }
    }
}