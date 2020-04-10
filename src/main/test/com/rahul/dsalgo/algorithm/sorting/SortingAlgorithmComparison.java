package com.rahul.dsalgo.algorithm.sorting;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertTrue;

class SortingAlgorithmComparison {

    // Types of sort
    BubbleSort bubbleSort;
    SelectionSort selectionSort;
    InsertionSort insertionSort;
    BucketSort bucketSort;
    MergeSort mergeSort;

    // Sort Data
    Integer arrayBubble[];
    Integer arraySelection[];
    Integer arrayInsertion[];
    Integer arrayBucket[];
    Integer arrayMerge[];
    final int MAX_ELEMENTS = 100000;

    @BeforeEach
    void setUp() {
        bubbleSort = new BubbleSort();
        selectionSort = new SelectionSort();
        insertionSort = new InsertionSort();
        bucketSort = new BucketSort();
        mergeSort = new MergeSort();

        arrayBubble = new Integer[MAX_ELEMENTS];
        arraySelection = new Integer[MAX_ELEMENTS];
        arrayInsertion = new  Integer[MAX_ELEMENTS];
        arrayBucket = new Integer[MAX_ELEMENTS];
        arrayMerge = new Integer[MAX_ELEMENTS];

        int randomNumber;
        for(int i=0; i<MAX_ELEMENTS; i++) {
            randomNumber = Math.abs((int) (Math.random() * MAX_ELEMENTS));
            arrayBubble[i] = randomNumber ;
            arraySelection[i] = randomNumber;
            arrayInsertion[i] = randomNumber;
            arrayBucket[i] = randomNumber;
            arrayMerge[i] = randomNumber;
        }
    }

    private boolean assertSorted(Integer arr[]){
        int prev = arr[0];
        for (int i=1; i<MAX_ELEMENTS; i++){
            if (prev > arr[i]) {
                return false;
            }
        }
        return true;
    }

    @Test
    void sortTest() {
        long startTime, endTime;

        /**
         * Bubble Sort
         * */
        startTime = System.currentTimeMillis();
        bubbleSort.sort(arrayBubble);
        endTime = System.currentTimeMillis();
        System.out.println("Time it took to bubble sort " + MAX_ELEMENTS + " elements: "
                + (endTime - startTime)/1000.0 + " s");

        /**
         * Selection Sort
         * */
        startTime = System.currentTimeMillis();
        selectionSort.sort(arraySelection);
        endTime = System.currentTimeMillis();
        System.out.println("Time it took to selection sort " + MAX_ELEMENTS + " elements: "
                + (endTime - startTime)/1000.0 + " s");

        /**
         * Insertion sort
         * */
        startTime = System.currentTimeMillis();
        insertionSort.sort(arrayInsertion);
        endTime = System.currentTimeMillis();
        System.out.println("Time it took to insertion sort " + MAX_ELEMENTS + " elements: "
                + (endTime - startTime)/1000.0 + " s");

        /**
         * Bucket sort
         * */
        startTime = System.currentTimeMillis();
        bucketSort.sort(arrayBucket);
        endTime = System.currentTimeMillis();
        System.out.println("Time it took to bucket sort " + MAX_ELEMENTS + " elements: "
                + (endTime - startTime)/1000.0 + " s");

        /**
         * Merge Sort Recursive
         * */
        startTime = System.currentTimeMillis();
        mergeSort.mergeSort(arrayMerge);
        endTime = System.currentTimeMillis();
        System.out.println("Time it took to recursive merge sort " + MAX_ELEMENTS + " elements: "
                + (endTime - startTime)/1000.0 + " s");

        // Assert that array is sorted
        assertTrue(assertSorted(arrayBubble));
        assertTrue(assertSorted(arraySelection));
        assertTrue(assertSorted(arrayInsertion));
        assertTrue(assertSorted(arrayBucket));
    }

    //This is working but i dont want to run this or remove this for now
    //@Test
    void sortWithTempTest() {
        long startTime = System.currentTimeMillis();
        bubbleSort.sortWithoutTemp(arrayBubble);
        long endTime = System.currentTimeMillis();
        System.out.println("Time it took to bubble sort with temp " + MAX_ELEMENTS + " elements: "
                + (endTime - startTime)/1000.0 + " s");
        // Assert that array is sorted
        assertTrue(assertSorted(arrayBubble));
    }

    // this schedules the execution of method but is currently not producing output.
    //@Test
    void timeScheduledSort() {
        //TODO not working
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                bubbleSort.sort(arrayBubble);
            }
        }, 0);
        // Assert that array is sorted
        assertTrue(assertSorted(arrayBubble));
    }

    // this preemptive method of running the method works and produces correct output
    //@Test
    void timeBoundExecutorSort() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        try {
            Runnable r = new Runnable() {
                @Override
                public void run() {
                    bubbleSort.sort(arrayBubble);
                }
            };
            Future<?> f = executorService.submit(r);
            f.get(1000, TimeUnit.MILLISECONDS); // attempt the task for 1000 milliseconds
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Assert that array is sorted
        assertTrue(assertSorted(arrayBubble));
    }
}