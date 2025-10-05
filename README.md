# Min-Heap Implementation (Assignment 2 - Algorithmic Analysis and Peer Code Review)

## Author
**Aitmukasheva Akbota**, Group SE-2425

## Project Overview
This project implements a **Min-Heap data structure** with advanced functionality including:
- `insert(int value)`
- `extractMin()`
- `decreaseKey(int index, int newValue)`
- `merge(MinHeap other)`

All operations are tracked for **comparisons**, **swaps**, and **array accesses** using the `PerformanceTracker` utility.

## Goals
This work fulfills the requirements for *Assignment 2: Algorithmic Analysis and Peer Code Review* in the Design and Analysis of Algorithms (DAA) course.

### Learning Outcomes
- Implement efficient algorithms with correct asymptotic analysis.
- Perform peer code review with optimization suggestions.
- Validate theoretical complexity through empirical benchmarks.

---

## 📊 Algorithm Complexity
| Operation | Best | Average | Worst | Space |
|------------|------|----------|--------|--------|
| Insert | O(1) | O(log n) | O(log n) | O(1) |
| Extract Min | O(log n) | O(log n) | O(log n) | O(1) |
| Decrease Key | O(log n) | O(log n) | O(log n) | O(1) |
| Merge | O(n) | O(n) | O(n) | O(n) |

---

## ⚙️ How to Run
1. **Compile the project**
   ```bash
   mvn compile
Run tests


   ```bash 
   mvn test
   ```
Run performance benchmark

```bash
mvn exec:java -Dexec.mainClass="com.akbota.cli.BenchmarkRunner"
```
Benchmark output will appear in the console and can be saved into:

```bash
/docs/performance-plots/
```
### 📊 Performance Results

Benchmark results are located in:
```bash
docs/performance-plots/benchmarkresults.csv
```
## 📂 Repository Structure

src/main/java/com/akbota/algorithms/MinHeap.java
src/main/java/com/akbota/metrics/PerformanceTracker.java
src/main/java/com/akbota/cli/BenchmarkRunner.java
src/test/java/com/akbota/algorithms/MinHeapTest.java
docs/performance-plots/ 

README.md

pom.xml


### Author’s Notes

#### This implementation emphasizes:

- Code clarity

- Memory efficiency

- Algorithmic correctness

#### Further optimization and performance comparison with Max-Heap (partner’s task) will be presented in the final report.