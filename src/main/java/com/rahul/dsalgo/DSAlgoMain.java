package com.rahul.dsalgo;

import com.rahul.dsalgo.algorithm.Factorial;
import com.rahul.dsalgo.algorithm.Fibonacci;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Rahul
 * */
public class DSAlgoMain {

    private static final int FACTORIAL_NUM=8;
    private static final int FIBONACCI_NUM=8;

    public static void main(String[] args) {

        Factorial factorial = new Factorial();
        System.out.println(factorial.factorial(FACTORIAL_NUM));
        System.out.println(factorial.factorialIterative(FACTORIAL_NUM));

        Fibonacci fibonacci = new Fibonacci();
        System.out.println(fibonacci.recursiveFindFiboNumAt(FIBONACCI_NUM));
        System.out.println(fibonacci.iterativeFindFiboNumAt(FIBONACCI_NUM));
        fibonacci.printFiboSequence(FIBONACCI_NUM);


        List<Integer> list = new LinkedList<Integer>();
    }
}
