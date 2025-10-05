package com.akbota.algorithms;


import com.akbota.metrics.PerformanceTracker;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class MinHeapTest {
    @Test
    public void testEmptyHeap() {
        MinHeap h = new MinHeap();
        assertTrue(h.isEmpty());
        assertThrows(java.util.NoSuchElementException.class, h::peek);
        assertThrows(java.util.NoSuchElementException.class, h::extractMin);
    }


    @Test
    public void testSingleElement() {
        MinHeap h = new MinHeap();
        h.insert(5);
        assertEquals(1, h.size());
        assertEquals(5, h.peek());
        assertEquals(5, h.extractMin());
        assertTrue(h.isEmpty());
    }


    @Test
    public void testOrderedInsertExtract() {
        MinHeap h = new MinHeap();
        for (int i = 10; i >= 1; i--) h.insert(i);
        for (int i = 1; i <= 10; i++) assertEquals(i, h.extractMin());
    }
}