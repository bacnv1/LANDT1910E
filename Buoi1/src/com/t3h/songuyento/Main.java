package com.t3h.songuyento;

public class Main {
    public static void main(String[] args) {
        SoNguyen sn = new SoNguyen();
        sn.nhap(11);
        sn.ketLuan();
        System.out.println("======================");
        LietKe lk = new LietKe();
        lk.nhap(100);
        lk.lietKe();
    }
}
