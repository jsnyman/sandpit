package com.acmevending;

import org.junit.Test;
import static org.junit.Assert.*;

public class VendingMachineTest {

    private static final int[] US_DOLLAR = new int[]{1, 5, 10, 25};
    private static final int[] BRITISH_POUND = new int[]{1, 2, 5, 10, 20, 50};
    @Test
    public void testCalculateChange() throws Exception {
        float pa1 = 1.00f;
        float pa2 = 0.93f;

        float ta1 = 1.00f;
        float ta2 = 1.50f;
        float ta3 = 2.15f;
        float ta4 = 10.23f;

        VendingMachine machine = new VendingMachine(US_DOLLAR);
        int[] expected = new int[]{0, 0 ,0, 0};
        int[] actual = machine.calculateChange(pa1, ta1);
        assertArrayEquals(expected, actual);

        expected = new int[]{0, 0 ,0, 2};
        actual = machine.calculateChange(pa1, ta2);
        assertArrayEquals(expected, actual);

        expected = new int[]{0, 1, 1, 4};
        actual = machine.calculateChange(pa1, ta3);
        assertArrayEquals(expected, actual);

        expected = new int[]{3, 0, 2, 36};
        actual = machine.calculateChange(pa1, ta4);
        assertArrayEquals(expected, actual);

        expected = new int[]{2, 1 ,0, 0};
        assertArrayEquals(expected, actual);

        machine = new VendingMachine(BRITISH_POUND);

        expected = new int[]{0, 0, 0, 0, 0, 0};
        actual = machine.calculateChange(pa1, ta1);
        assertArrayEquals(expected, actual);

        expected = new int[]{0, 1, 1, 0, 0, 1};
        actual = machine.calculateChange(pa2, ta2);
        assertArrayEquals(expected, actual);

        expected = new int[]{0, 1, 0, 0, 1, 2};
        actual = machine.calculateChange(pa2, ta3);
        assertArrayEquals(expected, actual);

        expected = new int[]{0, 0, 0, 1, 1, 18};
        actual = machine.calculateChange(pa2, ta4);
        assertArrayEquals(expected, actual);
    }

    @Test(expected = Exception.class)
    public void testCalculateChangeException() throws Exception {
        VendingMachine machine = new VendingMachine(US_DOLLAR);
        float pa = 1.00f;
        float ta = 0.80f;
        int[] actual = machine.calculateChange(pa, ta);
    }
}
