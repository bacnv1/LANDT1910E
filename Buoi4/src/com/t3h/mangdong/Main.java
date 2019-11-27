package com.t3h.mangdong;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(10);
        arr.add(5);
        arr.add(2, 6);

        ArrayList<Integer> arr1 = new ArrayList<>();
        arr1.add(1);
        arr1.add(3);
        arr.addAll(arr1);
        arr.addAll(1, arr1);

        arr.set(3, 100);
        arr.remove(2);
//        arr.clear();

        arr.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        int index = arr.lastIndexOf(1000);
        System.out.println(index);

        boolean contain = arr.contains(10);
        System.out.println(contain);

        boolean isEmpty = arr.isEmpty();
        System.out.println(isEmpty);

        Collections.reverse(arr);
        Collections.shuffle(arr);

        for (int i = 0; i < arr.size(); i++) {
            System.out.print(arr.get(i) +"\t");
        }
    }
}
