package org.ecos.logic.quicksort.benchmarking;

import org.ecos.logic.quicksort.QuickSortCollection;
import org.ecos.logic.quicksort.exceptions.BinaryCollectionNullPointerException;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class MyBenchmark {

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    @BenchmarkMode(Mode.AverageTime)
    public void quicksortBenchmarkQuarterMillion() throws BinaryCollectionNullPointerException {
        int length = 250000;
        Integer[] numbers = new Integer[length];
        Random rand = new Random();

        int min = 0;
        int max = 100;
        for(int i = 0; i < length; i++){
            numbers[i] = rand.nextInt(max-min) + min;
        }

        new QuickSortCollection<Integer>().addElements(numbers).sort();
    }
}
