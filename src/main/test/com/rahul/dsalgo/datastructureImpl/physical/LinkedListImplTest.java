package com.rahul.dsalgo.datastructureImpl.physical;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LinkedListImplTest {

    LinkedListImpl list;
    private static final int LIST_TENTATIVE_LENGTH=10;

    @BeforeEach
    void setUp() {
        list = new LinkedListImpl();
        for (int i=0; i<LIST_TENTATIVE_LENGTH; i++){
            list.insert(i+1);
        }
        System.out.println("Initial list");
        list.print();
    }

    @AfterEach
    void tearDown() {
        System.out.println("Final List");
        list.print();
        //list.printReverse();
    }

    @Test
    void insertTest() {
        for(int i=1; i<=LIST_TENTATIVE_LENGTH/5; i++){
            list.insert(i*10);
        }
    }

    @Test
    void insertAtPositionTest() {
        list.insert(2,99);
        list.insert(4,99);
        list.insert(2,199);
        list.insert(50,1);
    }

    @Test
    void findElementTest() {
        assertEquals(3,list.findElement(3));
        assertEquals(Integer.MIN_VALUE,list.findElement(100));
        assertEquals(Integer.MIN_VALUE,list.findElement(-1));
    }

    @Test
    void findPositionTest() {
        assertEquals(1,list.findPosition(1));
        assertEquals(Integer.MIN_VALUE,list.findPosition(50));
        assertEquals(Integer.MIN_VALUE,list.findPosition(-10));
    }

    @Test
    void deleteFirstTest(){
        assertEquals(1,list.deleteFirst());
        assertEquals(2,list.deleteFirst());
    }

    @Test
    void deleteLastTest() {
        assertEquals(10,list.deleteLast());
        assertEquals(9,list.deleteLast());
    }

    @Test
    void deleteAtTest() {
        assertEquals(Integer.MIN_VALUE, list.delete(100));
        assertEquals(1,list.delete(1));
        assertEquals(5,list.delete(4));
        assertEquals(Integer.MIN_VALUE, list.delete(-1));
    }
}