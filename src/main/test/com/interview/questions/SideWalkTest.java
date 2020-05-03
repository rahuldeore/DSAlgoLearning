package com.interview.questions;

import com.interview.questions.amazon.SideWalk;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SideWalkTest {

    int size;
    SideWalk sideWalk;


    @BeforeEach
    void setUp() {
        size=10;
        sideWalk = new SideWalk(size);
    }

    @Test
    void newDroplet() throws Exception{
        assertEquals(false, sideWalk.newDroplet(1.0));
        assertEquals(false, sideWalk.newDroplet(2.0));
        assertEquals(false, sideWalk.newDroplet(3.0));
        assertEquals(false, sideWalk.newDroplet(4.0));
        assertEquals(false, sideWalk.newDroplet(5.0));
        assertEquals(false, sideWalk.newDroplet(6.0));
        assertEquals(false, sideWalk.newDroplet(7.0));
        //sideWalk.printWetSideWalk();
    }

    @Test
    void fullSideWalkTest() {
        for (Double d=0.0; d<9.7; d = d + 0.1d) {
            //System.out.print(d + " ");
            assertEquals(false,sideWalk.newDroplet(d));
        }

        //assertEquals(false,sideWalk.newDroplet(9.7));
        //sideWalk.printWetSideWalk();
        assertEquals(false, sideWalk.newDroplet(1.0));
        assertEquals(true, sideWalk.newDroplet(9.9));
        assertEquals(true, sideWalk.newDroplet(1.0));
        assertEquals(false, sideWalk.newDroplet(11.0));

    }

    @Test
    void longSideWalkTest() {
        sideWalk = new SideWalk(100);
        for (Double d=0.0; d<99.8; d = d + 0.1d) {
            //System.out.print(d + " ");
            assertEquals(false, sideWalk.newDroplet(d));
        }
        //sideWalk.printWetSideWalk();
    }
}