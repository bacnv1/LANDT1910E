package com.t3h.songuyento;

public class SoNguyen {
    int x;

    void nhap(int giaTriX) {
        x = giaTriX;
    }

    boolean kiemTra() {
        for (int i = 2; i <= Math.sqrt(x); i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }

    void ketLuan() {
        boolean check = kiemTra();
        if (check == true) {
            System.out.println(x + " la so nguyen to");
        }else {
            System.out.println(x + " khong la so nguyen to");
        }
    }

}
