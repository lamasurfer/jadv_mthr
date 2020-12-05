package org.example.task3;

public class Main {
    public static void main(String[] args) {

        ArrayHelper arrayHelper = new ArrayHelper();

        final int ARRAY_SIZE = 1_000_000;
        int[] array = arrayHelper.randomArray(ARRAY_SIZE, Integer.MAX_VALUE);

        long resultSingle = arrayHelper.getSumWithCycle(array);
        System.out.println("Однопоточный подсчет суммы элементов массива " + resultSingle);
        long resultMulti = arrayHelper.getSumWithRecursiveTask(array, 1000);
        System.out.println("Многопоточный подсчет суммы элементов массива " + resultMulti);

        double average = arrayHelper.getArrayAverage(resultMulti, ARRAY_SIZE);
        System.out.println("Среднее арифметическое элементов массива " + average);

        // fork/join
        // попробовал все сочетания прогнать
        // до миллиона стабильно проигрывает обычному циклу, есть редкие исключения, но если прогнать такой
        // исключительный случай сто раз, то максимум 2-3 раза выигрыш встретится, т.е. можно пренебречь;

        // 1 млн элементов - есть прирост при определенных значениях порога, но совсем незначительный
        // 2,5 млн - прирост уже более явный, но значения разнятся

        // от 5 млн при значении порога от 1000 однозначно быстрее fork/join
        // в общем, отличная штука, важно тщательно подбирать пороговое значение
        // подробности в файлах results.txt в корне, тестировал в main класса Tester

    }
}
