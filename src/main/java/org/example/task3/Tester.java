package org.example.task3;

public class Tester {

    private static final String HEADER = "№    " +
            "size            " +
            "threshold       " +
            "cycle        " +
            "fork/join    " +
            "is better?  " +
            "%";

    private static final String RESULT_TEMPLATE = "%-4s %,-15d %,-15d %-12.7f %-12.7f %-11s %4.1f %%";

    private static int counter = 1;

    private final ArrayHelper arrayHelper;

    public Tester(ArrayHelper arrayHelper) {
        this.arrayHelper = arrayHelper;
    }

    public void test(int arraySize, int threshold) {
        System.out.println();
        int[] array = arrayHelper.randomArray(arraySize);

        if (counter == 1) {
            System.out.println(HEADER);
        }

        long cycleStartTime = System.nanoTime();
        long cycleResult = arrayHelper.getSumWithCycle(array);
        double cycleTotalTime = (System.nanoTime() - cycleStartTime) / 1_000_000_000.0;


        long forkStartTime = System.nanoTime();
        long forkResult = arrayHelper.getSumWithRecursiveTask(array, threshold);
        double forkTotalTime = (System.nanoTime() - forkStartTime) / 1_000_000_000.0;

        double percentage = (forkTotalTime - cycleTotalTime) / cycleTotalTime * 100;
        boolean forkIsBetter = forkTotalTime < cycleTotalTime;

        System.out.printf(
                RESULT_TEMPLATE,
                counter++, arraySize, threshold, cycleTotalTime, forkTotalTime, forkIsBetter, percentage);
    }

    public static void main(String[] args) {

        ArrayHelper arrayHelper = new ArrayHelper();
        Tester tester = new Tester(arrayHelper);

        final int[] ARRAY_SIZES = {
                10, 25, 50, 75,
                100, 250, 500, 750,
                1_000, 2_500, 5_000, 7_500,
                10_000, 25_000, 50_000, 75_000,
                100_000, 250_000, 500_000, 750_000,
                1_000_000, 2_500_000, 5_000_000, 7_500_000,
                10_000_000, 25_000_000, 50_000_000, 75_000_000,
                100_000_000, 250_000_000, 500_000_000, 750_000_000,
                1_000_000_000
        };

        for (int arraySize : ARRAY_SIZES) {
            for (int threshold : ARRAY_SIZES) {
                if (threshold < arraySize) {
                    tester.test(arraySize, threshold);
                }
            }
        }
    }
}
