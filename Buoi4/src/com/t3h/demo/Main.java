package com.t3h.demo;

public class Main {

    public static void main(String[] args) {
        int a = 3;
        int[] arr = { 1 };
        changeA(a);
        changeArr(arr);
        System.out.println(a);
        System.out.println(arr[0]);

        int b = a;
        int[] arr1 = arr;
        b = 5;
        arr1[0] = 3;
        System.out.println(a);
        System.out.println(arr[0]);
    }
    private static void changeA(int a) {
        a = 4;
    }
    private static void changeArr(int[] arr){
        arr[0] = 2;
    }


}
