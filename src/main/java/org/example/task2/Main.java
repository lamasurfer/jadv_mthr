package org.example.task2;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) {

        int threadCount = 4;
        ExecutorService executor = Executors.newFixedThreadPool(threadCount);

        List<CallableTest> tasks = Arrays.asList(
                new CallableTest("1"),
                new CallableTest("2"),
                new CallableTest("3"),
                new CallableTest("4"));

        // 1
        try {
            List<Future<Integer>> futures = executor.invokeAll(tasks);

            int result = 0;
            for (Future<Integer> future : futures) {
                result += future.get();
            }
            System.out.println("Кол-во сообщений от 4-х задач: " + result);

        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        // 2
        try {

            Integer future = executor.invokeAny(tasks);
            System.out.println("Кол-во сообщений от одной задачи: " + future);
            executor.shutdown();

        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
