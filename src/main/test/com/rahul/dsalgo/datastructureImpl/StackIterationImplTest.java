package com.rahul.dsalgo.datastructureImpl;

import com.rahul.dsalgo.datastructureImpl.logical.StackIterationImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackIterationImplTest {

    private StackIterationImpl rStackIteration;

    @BeforeEach
    void setUp() {
        rStackIteration = new StackIterationImpl();
    }

    @AfterEach
    void tearDown() {
        rStackIteration = null;
    }

    @Test
    void push_twiceOverCapacity() {
        for ( int i=0; i<rStackIteration.capacity(); i++) {
            assertTrue(rStackIteration.push(i));
        }
        for ( int i=0; i<rStackIteration.capacity(); i++) {
            assertFalse(rStackIteration.push(i));
        }
    }
    @Test
    void push() {
        for ( int i=0; i<rStackIteration.capacity(); i++) {
            assertTrue(rStackIteration.push(i));
        }
        rStackIteration.printStack();
    }

    @Test
    void pop() {
        for (int i=0; i<rStackIteration.length();i++){
            System.out.println(rStackIteration.pop());
        }
        assertEquals(0,rStackIteration.length());
    }

    @Test
    void length() {
        assertNotEquals(-1, rStackIteration.length());
    }

    @Test
    void top() {
        int length = rStackIteration.length();
        assertNotNull(rStackIteration.top());
    }

    @Test
    void reverse() {
        rStackIteration.reverse();
        rStackIteration.printStack();
    }
}