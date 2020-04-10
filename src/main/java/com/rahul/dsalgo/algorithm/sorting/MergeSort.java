package com.rahul.dsalgo.algorithm.sorting;

/**
 * Created by Rahul on 3/15/20
 */
public class MergeSort {

    /*
    * Basic recursive merge sort. This is also implemented in the collections api as legacyMergeSort. Its replacement
    * is iterative stable TimSort
    * */

    Integer[] mergeSort(Integer arr[]){
        int length = arr.length;
        if (length == 1) {
            return arr;
        } else {
            int low = 0, high = length-1, mid = low+high/2;
            Integer[] subArr1 = sliceArray(arr, low, mid);
            Integer[] subArr2 = sliceArray(arr, mid+1, high);

            subArr1 = mergeSort(subArr1);
            subArr2 = mergeSort(subArr2);

            return mergeArrays(subArr1, subArr2);
        }
    }
    /*
     returns the sub array consisting of elements from arr[startIndex] until arr[endIndex]. Make sure you provide indexes
     */
    Integer[] sliceArray(Integer[] arr, int startIndex, int endIndex) {
        int size = (endIndex-startIndex) + 1;
        Integer res[] = new Integer[size];

        for (int i=startIndex, j=0; i <= endIndex & j < size; i++, j++){
            res[j] = arr[i];
        }
        return res;
    }

    /*
    * Merges two sorted arrays and return sorted one array
    * */
    Integer[] mergeArrays(Integer[] array1, Integer[] array2) {
        int s1 = array1.length, s2 = array2.length;
        Integer[] res = new Integer[s1+s2];
        int i1=0, i2=0, ir=0;

        // traverse both arrays until we reach end of at least one. If one of then still have elements,
        // append all to result at the end.
        while (i1 < s1 && i2 < s2) {
            if (array1[i1] <= array2[i2]) {
                res[ir] = array1[i1];
                i1++;
            } else {
                res[ir] = array2[i2];
                i2++;
            }
            ir++;
        }

        // if i haven't crossed the last index position in array1
        if (i1 != s1) {
            while (i1 < s1) {
                res[ir] = array1[i1];
                i1++;
                ir++;
            }
        } else if (i2 != s2) {
            while (i2 < s2) {
                res[ir] = array2[i2];
                i2++;
                ir++;
            }
        }
        return res;
    }

    /**
     * Iterative version of merge sort
     * */
    Integer[] sort(Integer[] arr) {

        return null;
    }
}
