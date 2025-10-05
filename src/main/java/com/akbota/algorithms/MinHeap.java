package com.akbota.algorithms;

import com.akbota.metrics.PerformanceTracker;
import java.util.NoSuchElementException;

public class MinHeap {
    private int[] heap;
    private int size;
    private PerformanceTracker tracker;

    public MinHeap() {
        this(10, new PerformanceTracker());
    }

    public MinHeap(int capacity, PerformanceTracker tracker) {
        this.heap = new int[Math.max(2, capacity)];
        this.size = 0;
        this.tracker = tracker == null ? new PerformanceTracker() : tracker;
    }

    public void insert(int value) {
        if (size == heap.length) resize();
        heap[size] = value;
        tracker.recordArrayAccess();
        siftUp(size++);
    }

    public int extractMin() {
        if (isEmpty()) throw new NoSuchElementException("Heap is empty");
        int min = heap[0];
        tracker.recordArrayAccess();
        heap[0] = heap[--size];
        tracker.recordArrayAccess();
        siftDown(0);
        return min;
    }

    public int peek() {
        if (isEmpty()) throw new NoSuchElementException("Heap is empty");
        tracker.recordArrayAccess();
        return heap[0];
    }

    public void decreaseKey(int index, int newValue) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        tracker.recordArrayAccess();
        if (newValue > heap[index]) throw new IllegalArgumentException("new key is greater than current key");
        heap[index] = newValue;
        tracker.recordArrayAccess();
        siftUp(index);
    }

    public void merge(MinHeap other) {
        if (other == null) return;
        for (int i = 0; i < other.size(); i++) {
            tracker.recordArrayAccess();
            insert(other.heap[i]);
        }
    }

    private void siftUp(int idx) {
        while (idx > 0) {
            int parent = (idx - 1) / 2;
            tracker.countComparison();
            if (heap[idx] >= heap[parent]) break;
            swap(idx, parent);
            idx = parent;
        }
    }

    private void siftDown(int idx) {
        while (true) {
            int left = 2 * idx + 1;
            int right = left + 1;
            int smallest = idx;

            if (left < size) {
                tracker.countComparison();
                if (heap[left] < heap[smallest]) smallest = left;
            }
            if (right < size) {
                tracker.countComparison();
                if (heap[right] < heap[smallest]) smallest = right;
            }
            if (smallest == idx) break;
            swap(idx, smallest);
            idx = smallest;
        }
    }

    private void swap(int i, int j) {
        tracker.countSwap();
        tracker.recordArrayAccess();
        int tmp = heap[i];
        heap[i] = heap[j];
        heap[j] = tmp;
        tracker.recordArrayAccess();
    }

    private void resize() {
        int[] newHeap = new int[heap.length * 2];
        System.arraycopy(heap, 0, newHeap, 0, heap.length);
        heap = newHeap;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
}
