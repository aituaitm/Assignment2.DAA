package com.akbota.metrics;


public class PerformanceTracker {
    private long comparisons = 0;
    private long swaps = 0;
    private long arrayAccesses = 0;
    private long allocations = 0;


    public void countComparison() { comparisons++; }
    public void countSwap() { swaps++; }
    public void recordArrayAccess() { arrayAccesses++; }
    public void recordAllocation(long bytes) { allocations += bytes; }


    public long getComparisons() { return comparisons; }
    public long getSwaps() { return swaps; }
    public long getArrayAccesses() { return arrayAccesses; }
    public long getAllocations() { return allocations; }


    public void reset() { comparisons = swaps = arrayAccesses = allocations = 0; }
}