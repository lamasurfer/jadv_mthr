package org.example.task3;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;

public class ArrayHelper {

    public long getSumWithRecursiveTask(int[] array, int threshold) {
        ForkJoinPool commonPool = ForkJoinPool.commonPool();
        SumTask sumTask = new SumTask(array, 0, array.length, threshold);
        return commonPool.invoke(sumTask);
    }

    public long getSumWithCycle(int[] array) {
        long result = 0;
        for (int i = 0; i < array.length; i++) {
            result += array[i];
        }
        return result;
    }

    public double getArrayAverage(long sum, int size) {
        return (double) sum / size;
    }

    public int[] randomArray(int size) {
        Random random = new Random();
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = random.nextInt();
        }
        return result;
    }

    public int[] randomArray(int size, int seed) {
        Random random = new Random(seed);
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = random.nextInt();
        }
        return result;
    }
}
