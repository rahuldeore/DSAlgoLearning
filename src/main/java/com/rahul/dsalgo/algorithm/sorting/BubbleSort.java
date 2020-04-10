package com.rahul.dsalgo.algorithm.sorting;

/**
 * Created by Rahul on 3/4/20
 * TODO Can i make it static ?
 * Works for integer array. Separate version available for time series.
 */
public class BubbleSort {

    void sortWithoutTemp(Integer arr[]){
        for (int i=0; i<arr.length; i++) {
            for (int j=1; j<arr.length-i; j++) {
                if (arr[j-1] > arr[j]) {
                    arr[j-1] = arr[j-1] + arr[j];
                    arr[j] = arr[j-1] - arr[j];
                    arr[j-1] = arr[j-1] - arr[j];
                }
            }
        }
    }

    void sort(Integer arr[]){
        for (int i=0; i<arr.length; i++) {
            for (int j=1; j<arr.length-i; j++) {
                if (arr[j-1] > arr[j]) {
                    // If exchange is done without using third variable "temp", the operation is expensive at
                    // compiler level
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }
        }
    }
}
