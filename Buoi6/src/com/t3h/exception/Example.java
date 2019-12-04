package com.t3h.exception;

import java.util.Random;

public class Example {
    private int[] arr = new int[10];
    private Random rd = new Random();

    public Example() {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rd.nextInt(100);
        }
    }

    public void print() {
        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.println(arr[i]);
        }
    }
}
