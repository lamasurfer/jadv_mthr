package org.example.task1;

public class ThreadTest extends Thread {

    public ThreadTest(ThreadGroup group, String name) {
        super(group, name);
    }

    @Override
    public void run() {
        try {
            while(!isInterrupted()) {
                Thread.sleep(2500);
                System.out.printf("Я поток %s. Всем привет!\n", getName());
            }
        } catch (InterruptedException ignored) {

        } finally{
            System.out.printf("%s завершен\n", getName());
        }
    }
}



