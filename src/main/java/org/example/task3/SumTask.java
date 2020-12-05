package org.example.task3;

import java.util.concurrent.RecursiveTask;

public class SumTask extends RecursiveTask<Long> {


    private final int[] array;
    private final int start;
    private final int end;
    private final int threshold;

    public SumTask(int[] array, int start, int end, int threshold) {
        this.array = array;
        this.start = start;
        this.end = end;
        this.threshold = threshold;
    }

    @Override
    protected Long compute() {
        long sum = 0;
        if ((end - start) < threshold) {
            for (int i = start; i < end; i++) {
                sum += array[i];
            }
        } else {
            int middle = (start + end) / 2;
            SumTask subTask1 = new SumTask(array, start, middle, threshold);
            SumTask subTask2 = new SumTask(array, middle, end, threshold);

            subTask1.fork();
            subTask2.fork();

            sum = subTask1.join() + subTask2.join();
        }
        return sum;
    }
}
