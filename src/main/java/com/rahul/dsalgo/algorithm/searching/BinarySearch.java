package com.rahul.dsalgo.algorithm.searching;

public class BinarySearch {
    int find(Integer arr[], int elem) {
        if (!isSorted(arr)) {
            return -1;
        }
        int low=0, high = arr.length-1, mid = (low+high) / 2;
        while (low < high) {
            if (arr[mid] == elem) {
                return mid;
            } else if (elem < arr[mid]) {
                high = mid-1;
                mid = (low + high) / 2;
            } else {
                low = mid + 1;
                mid = (low + high)/2;
            }
        }
        return -1;
    }
    boolean isSorted(Integer arr[]){
        int prev = arr[0];
        for (int i=1; i<arr.length; i++) {
            if (prev > arr[i]) {
                return false;
            }
        }
        return true;
    }
}
