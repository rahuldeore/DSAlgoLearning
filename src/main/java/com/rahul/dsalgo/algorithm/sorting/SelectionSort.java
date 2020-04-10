package com.rahul.dsalgo.algorithm.sorting;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Rahul on 3/5/20
 */
public class SelectionSort {

    /**
     * This is optimized selection sort where only one swap is performed per iteration. The complexity is O(n*n) but
     * time required is at least a third of bubble sort.
     * */
    void sort(Integer array[]) {
        int size = array.length, min, minIndex, temp;
        for (int i=0; i<size; i++) {
            min = array[i];
            minIndex = i;
            for (int j=i+1; j<size; j++) { // this loop just find the min value in unsorted list
                if (min > array[j]) {
                    min = array[j];
                    minIndex = j;
                }
            }
            // swap the min value from sublist with the min position
            array[minIndex] = array[i];
            array[i] = min;
        }
    }

    // List as input
    void sort(List<Integer> list) {
        Integer[] array = new Integer[list.size()];
        int i=0;

        Iterator<Integer> iterator = list.iterator();

        while (iterator.hasNext()) {
            array[i] = iterator.next();
            i++;
        }
        sort(array);

        for (int j=0; j<list.size(); j++){
            list.removeAll(list);
        }

        for (int j=0; j<array.length; j++){
            list.add(array[j]);
        }
    }
}
