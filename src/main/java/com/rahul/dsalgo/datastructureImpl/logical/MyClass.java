package com.rahul.dsalgo.datastructureImpl.logical;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Rahul on 12/29/19
 */
public class MyClass {
    private  Map<String, Integer> map;

    public MyClass() {
        map = new HashMap<>();
        map.put("foo", 1);
        map.put("bar", 3);
    }

    public int getValue(String input, int numRetries) throws Exception {
        try {
            return map.get(input);
        } catch (Exception e) {
            if (numRetries > 3) {
                throw e;
            }
            return getValue(input, numRetries + 1);
        }
    }

    public static void main(String args[]) throws Exception {
        MyClass a = new MyClass();
        System.out.println(a.getValue("foo",0));
        System.out.println(a.getValue("bar",2));
        System.out.println(a.getValue("baz",0));
        System.out.println(a.getValue("fubar",1));
    }
}
// Question:How many times will'getValue(…)'execute with the following inputs,and what will be the result?(1)getValue("foo",0);(2)getValue("bar",2);(3)getValue("baz",0);(4)getValue("fubar",1);*

