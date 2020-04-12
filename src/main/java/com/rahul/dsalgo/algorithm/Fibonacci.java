package com.rahul.dsalgo.algorithm;

/**
 * Created by Rahul on 2019-10-06
 */
public class Fibonacci {

    public int recursiveFindFiboNumAt(int index){
        if (index == 0){
            return 0;
        } else if (index == 1) {
            return 1;
        } else {
            return recursiveFindFiboNumAt(index-1) + recursiveFindFiboNumAt(index-2);
        }
    }

    public int iterativeFindFiboNumAt(int index){
        int fiboNum = 0;
        if (index == 0 || index == 1){
            return 1;
        } else {
            int prev1=0, prev2=1;
            for (int i=0; i<index-1; i++) {
                fiboNum = prev1 + prev2 ;
                prev1=prev2;
                prev2=fiboNum;
            }
        }
        return fiboNum;
    }

    // term is the terminating number upto which this function prints the numbers.
    public void printFiboSequence(int term) {
        int fiboNum=0;
        if ( term == 0){
            System.out.print(0);
        } else if (term == 1) {
            System.out.print(1);
        } else {
            int prev1=0, prev2=1;
            System.out.print(prev1 + " " + prev2 + " ");
            for (int i=0; i<term-1; i++) {
                fiboNum = prev1 + prev2 ;
                prev1=prev2;
                prev2=fiboNum;
                System.out.print(fiboNum + " ");
            }
        }
    }
}
