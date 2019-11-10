package com.t3h.songuyento;

public class LietKe {
    int n;
    SoNguyen sn;

    void nhap(int giaTriN) {
        n = giaTriN;
        sn = new SoNguyen();
    }

    void lietKe() {
        for (int i = 2; i <= n; i++) {
            sn.nhap(i);
            boolean check = sn.kiemTra();
            if (check == true) {
                System.out.print(i + "\t");
            }
        }
    }
}
