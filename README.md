# INFO6205_FinalProject

## Group Members:
## 1. Varun Venkatesh Gowda (002126161)
## 2. Namrata Ruchandani (002125637)
## 3. Venkteshprasad Maya Rao (001087357)

##
## The project structure is split up into main(Sources root), resources(Resources root) and test(Test root) with Driver.java as the main class.

### The "sorts" package consists of:
1) DualPivotQuickSort.java which uses pinyin4j for preprocessing and performs dual pivot quick sort on the chinese array.
2) MSDRadixSort.java which makes of pinyin4j library to convert chinese text to pinyin and then sorts the pinyin array whilst also sorting the original chinese text array
3) TimSort.java which sorts the chinese array post conversion to pinyin
4) LSRadixSort.java which sorts the pinyin array post conversion

### The "utils" package consists of:
1) Benchmark utilities (Benchmark, Benchmark_Timer, BenchmarkTarget, Timer) to be able to measure the running times of the sort algorithms (Credits: Info6205 assignments repo)
2) SortUtils.java that houses functions for compares, swapping, stubs for unit tests, file reader and Chinese to pinyin converter
3) Logger utils to log and format text displayed for benchmarks

### The "resources" directory consists of:
1) The chinese text files containing data sets for sort (Courtesy of Prof. Robin Hillyard) and reproduced for the benchmark sizes of 250k, 500k, 1M, 2M and 4M
2) log4j.properties file for the configuration of the logger
3) chineseExample.txt for unit tests
4) sortedArraySample.txt which consists of a part of shuffledChinese.txt (1500 words) in sorted order which has been sorted using our implementation of MSD Radix Sort

### The "test" directory consists of:
1) Tests for all the sort mechanisms (with the inclusion of partition test for DualPivotQuickSort)
2) Tests for the benchmark utility (Credits: info6205 assignments repo)

### Additional libraries used to complete the project:
1) pinyin4j
2) ini4j
3) log4j
4) junit

### Credits: In addition to links provided in each file
1) Prof. Robin Hillyard and contributors of the Info6205 assignments & huskysort repositories (https://github.com/rchillyard/INFO6205 ; https://github.com/rchillyard/The-repository-formerly-known-as)
2) pinyin4j (http://pinyin4j.sourceforge.net/)
3) log4j (https://logging.apache.org/log4j/2.x/)
4) ini4j (http://ini4j.sourceforge.net/)
5) stackoverflow and geeksforgeeks community
