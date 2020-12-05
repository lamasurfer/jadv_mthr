package org.example.task1;

public class Main {
    public static void main(String[] args) {


        ThreadGroup threadGroup = new ThreadGroup("Task1");

        int threadCount = 4;
        System.out.println("Создаю потоки...");
        for (int i = 0; i < threadCount; i++) {
            new ThreadTest(threadGroup, i + 1 + "").start();
        }

        try {
            Thread.sleep(15000);
        } catch (InterruptedException ignored) {

        } finally {
            System.out.println("Завершаю все потоки...");
            threadGroup.interrupt();
        }

    }
}
