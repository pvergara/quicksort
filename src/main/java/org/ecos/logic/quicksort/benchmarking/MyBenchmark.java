package org.ecos.logic.quicksort.benchmarking;

import org.ecos.logic.quicksort.QuickSortCollection;
import org.ecos.logic.quicksort.exceptions.BinaryCollectionNullPointerException;
import org.openjdk.jmh.annotations.*;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@State(Scope.Benchmark)
public class MyBenchmark {

    private final QuickSortCollection<Integer> collection;

    public MyBenchmark(){
        try {
            collection = new QuickSortCollection<Integer>().addElements((new Random().ints(250000, -100, 100))
                    .boxed()
                    .toArray(Integer[]::new));
        } catch (BinaryCollectionNullPointerException e) {
            throw new RuntimeException(e);
        }
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    @BenchmarkMode(Mode.AverageTime)
    public void quicksortBenchmarkQuarterMillion() {
        this.collection.sort();
    }
}
