package com.akbota.cli;


import com.akbota.algorithms.MinHeap;
import com.akbota.metrics.PerformanceTracker;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;


public class BenchmarkRunner {
    public static void main(String[] args) throws IOException {
        int[] ns = {100, 1000, 10000, 100000};
        File dir = new File("performance-data");
        if (!dir.exists()) dir.mkdirs();
        String outCsv = "performance-data/minheap_bench.csv";
        try (FileWriter writer = new FileWriter(outCsv)) {
            writer.write("n,time_ms,comparisons,swaps,array_accesses,allocations ");
            for (int n : ns) {
                PerformanceTracker tracker = new PerformanceTracker();
                MinHeap heap = new MinHeap(n, tracker);
                Random rnd = new Random(42);
                int[] data = new int[n];
                for (int i = 0; i < n; i++) data[i] = rnd.nextInt();


                long t0 = System.nanoTime();
                for (int v : data) heap.insert(v);
                while (!heap.isEmpty()) heap.extractMin();
                long t1 = System.nanoTime();


                long timeMs = (t1 - t0) / 1_000_000;
                writer.write(String.format("%d,%d,%d,%d,%d,%d ", n, timeMs,
                        tracker.getComparisons(), tracker.getSwaps(), tracker.getArrayAccesses(), tracker.getAllocations()));
                System.out.println("Done n=" + n + " time_ms=" + timeMs);
            }
        }
    }
}