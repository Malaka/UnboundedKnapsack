package com.au.anz.algo.test.unboundedKnapsack;

import org.junit.Test;

import java.util.stream.Stream;

import static org.junit.Assert.*;

public class DynamicProgrammingTest {

    @Test
    public void testWithData() {
        Algo recursive = new DynamicProgramming();
        assertEquals("base case", 0, (int) recursive.knapsackValue(Stream.of(2).toArray(Integer[]::new), 0));
        assertEquals(4, (int) recursive.knapsackValue(Stream.of(2).toArray(Integer[]::new), 4));
        assertEquals(21, (int) recursive.knapsackValue(Stream.of(3, 6, 7).toArray(Integer[]::new), 21));
    }
}