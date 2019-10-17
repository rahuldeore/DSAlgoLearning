package com.rahul.dsalgo.datastructureImpl.physical;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ArrayImplTest {
    ArrayImpl array;
    int size;

    @BeforeEach
    void setUp() {
        size = 10;
        array = new ArrayImpl(size);
    }

    @AfterEach
    void tearDown() {
        array = null;
    }

    @Test
    void insertTest() {
            for(int i=0; i<size; i++){
                assertEquals(i+1,array.insert((i+1)*10));
            }
    }

    @Test
    void insertOverCapacityTest(){
        for(int i=0; i<size; i++){
            assertEquals(i+1, array.insert((i+1)*10));
        }
        assertEquals(-1, array.insert(110));
    }

    @Test
    void deleteElementExistTest() {
        setupData();
        assertEquals(5, array.deleteElement(50));
        assertEquals(9, array.deleteElement(100));
        assertEquals(6, array.deleteElement(70));
        assertEquals(-1, array.deleteElement(50));
    }

    @Test
    void deleteElementDoesNotExistTest(){
        setupData();
        assertEquals(-1,array.deleteElement(200));
    }

    @Test
    void shiftElementFrom() {
        setupData();
        // For a fully initialized array

        // Shift operation overwrites element at position and shifts rest of the array left.
        array.shiftElementFrom(1);
        array.shiftElementFrom(4);
        array.shiftElementFrom(10);
        array.shiftElementFrom(6);
    }

    @Test
    void deleteAtPositionWhenElemExist() {
        setupData();
        // For a fully initialized array

        // Deletes element at position 8, expectation is when 8 is deleted, rest of the elements are shifted left and
        // next open position is not at 8 but at 10 (index 9 for array of 10). The open position is filled with
        // Integer.MIN_VALUE
        assertEquals(80, array.deleteAtPosition(8));
        // Since position 10 (index 9) is next open position, a delete is useless at this position. Delete identifies
        // the element at this position is minValue and returns it.
        assertEquals(Integer.MIN_VALUE, array.deleteAtPosition(10));

        assertEquals(50, array.deleteAtPosition(5));
        assertEquals(10, array.deleteAtPosition(1));
        assertEquals(30, array.deleteAtPosition(2));
        assertEquals(Integer.MIN_VALUE, array.deleteAtPosition(8));
    }

    @Test
    void deleteAtPositionWhenElemDoesNotExist() {
        setupData();
        assertEquals(Integer.MIN_VALUE, array.deleteAtPosition(18));
        assertEquals(Integer.MIN_VALUE, array.deleteAtPosition(19));
        assertEquals(Integer.MIN_VALUE, array.deleteAtPosition(199));
    }

    @Test
    void findElementPositionWhenElemExist() {
        setupData();
        assertEquals(9, array.findPosition(90));
    }

    @Test
    void findElementPositionWhenElemDoesNotExist() {
        setupData();
        assertEquals(-1, array.findPosition(900));
    }

    void setupData(){
        for(int i=0; i<size; i++){
            array.insert((i+1)*10);
        }
    }
}