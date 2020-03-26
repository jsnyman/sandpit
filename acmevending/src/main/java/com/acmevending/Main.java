package com.acmevending;

public class Main {

    public static void main(String[] args) {
	    System.out.println("Hello World");
        VendingMachine machine = new VendingMachine(new int[]{1,5,10,25});
        float purchaseAmount = 0.93f;
        float tenderedAmount = 1.00f;

//        try {
//            float result = machine.calculateChange(purchaseAmount, tenderedAmount);
//            System.out.println(result);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}
