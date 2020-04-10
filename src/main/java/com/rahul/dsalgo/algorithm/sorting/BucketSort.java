package com.rahul.dsalgo.algorithm.sorting;

import java.util.ArrayList;

/**
 * Created by Rahul on 3/10/20
 */
public class BucketSort {

    void sort(Integer array[]) {
        int size = array.length, numBuckets = (int) Math.ceil(Math.sqrt(size)), bucketNumber=0;
        SelectionSort selectionSort= new SelectionSort();

        //System.out.println(numBuckets + " buckets");
        int max = 0;
        // get the max element in array
        for (int a : array) {
            if(a > max) {
                max = a;
            }
        }

        //System.out.println("Maximum number in array is: " +max);

        ArrayList<Integer>[] buckets = new ArrayList[numBuckets];

        // initialize buckets
        for (int i=0; i<numBuckets; i++) {
            buckets[i] = new ArrayList<Integer>();
            //System.out.println("Bucket " + i + " initialized.");
        }


        // fill buckets
        for (int val : array) {
            bucketNumber = (int) Math.ceil((val * numBuckets-1) / max);
            //System.out.println("Number " + val + " goes to bucket " + bucketNumber);
            buckets[bucketNumber].add(val);
        }



        for (int i=0; i<numBuckets; i++) {
            selectionSort.sort(buckets[i]);
        }


        int j=0;
        for (int i=0; i<numBuckets; i++) {
            for (Integer e : buckets[i]) {
                array[j] = e;
                j++;
            }
        }
    }
}
