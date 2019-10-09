package com.rahul.dsalgo.algorithm;

/**
 * Created by Rahul on 2019-10-06
 */
public class Factorial {

    public long factorial(int num){
        if (num == 0 || num == 1){
            return 1;
        }
        else{
            return num * factorial(num-1);
        }
    }

    public long factorialIterative (int num) {
        long factorial = 1;
        if (num == 0 || num == 1){
            return 1;
        }
        else {
            for (int i=num; i>0; i--) {
                factorial *= i;
            }
        }
        return factorial;
    }
}
