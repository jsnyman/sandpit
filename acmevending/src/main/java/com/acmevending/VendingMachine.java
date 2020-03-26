package com.acmevending;

import java.util.Arrays;

public class VendingMachine {

    private final int[] coinDenomination;

    public VendingMachine(int[] coinDenomination) {
        Arrays.sort(coinDenomination);
        this.coinDenomination = coinDenomination;
    }

    public int[] calculateChange(float purchaseAmount, float tenderedAmount) throws Exception {
        if (tenderedAmount < purchaseAmount) {
            throw new Exception("Tendered Amount cannot be less than the purchase amount");
        }

        int[] changeArr = new int[coinDenomination.length];
        int changeInt = Math.round((tenderedAmount - purchaseAmount) * 100);

        for (int i = coinDenomination.length-1; i >= 0; i--) {
            if (changeInt == 0) {
                break;
            }

            int num = changeInt / coinDenomination[i];
            changeInt = changeInt % coinDenomination[i];

            changeArr[i] = num;
        }

        return changeArr;

    }
}
