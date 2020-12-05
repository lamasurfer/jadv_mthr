package org.example.task3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayHelperTest {

    private final ArrayHelper arrayHelper = new ArrayHelper();


    @Test
    void getSumWithRecursiveTask() {
        int[] array = {1, 2, 3, 4, 5, 6};
        long expected = 21;

        assertEquals(expected, arrayHelper.getSumWithRecursiveTask(array, 3));
    }

    @Test
    void getArraysSumWithCycle() {
        int[] array = {1, 2, 3, 4, 5, 6};
        long expected = 21;

        assertEquals(expected, arrayHelper.getSumWithCycle(array));
    }
}