package org.example.task2;

import java.util.concurrent.Callable;

public class CallableTest implements Callable<Integer> {

    private final String threadName;

    public CallableTest(String threadName) {
        this.threadName = threadName;
    }

    @Override
    public Integer call() {
        int counter = 0;
        Thread.currentThread().setName(threadName);
        try {
            while(counter < 5) {
                Thread.sleep(2500);
                System.out.printf("Я поток %s. Всем привет!\n", Thread.currentThread().getName());
                counter++;
            }
        } catch (InterruptedException ignored) {

        }
        return counter;
    }
}



