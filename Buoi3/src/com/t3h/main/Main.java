package com.t3h.main;

import com.t3h.connguoi.CauThu;
import com.t3h.connguoi.ConNguoi;
import com.t3h.connguoi.NguoiMau;
import com.t3h.dongvat.Cho;
import com.t3h.dongvat.DongVat;
import com.t3h.dongvat.Meo;

public class Main {
    public static void main(String[] args) {
        Meo meo = new Meo(
                "Mimi",
                2,
                true,
                "Vang",
                "Meo mun",
                true
        );
        Cho cho = new Cho(
                "Kiki",
                3,
                false,
                "Do",
                "Tay tang",
                true,
                false
        );
        NguoiMau nm = new NguoiMau(
                "Natasa",
                20,
                false,
                "Ha noi",
                "0124567990",
                "90-60-90",
                "ABC",
                meo
        );
        CauThu ct = new CauThu(
                "David",
                25,
                true,
                "Ha Noi",
                "0994812231",
                7,
                "Ha Noi - FC",
                1000,
                cho
        );

        nm.inThongTin();
        nm.bieuDien();
        nm.diShopping(true);
        System.out.println("===================");
        ct.inThongTin();
        ct.diDao();


        updateInfo(ct, "Jone");
        updateInfo(nm, "Nisa");
        System.out.println("===Update=========");
        ct.inThongTin();
        ct.an();
        System.out.println("========");
        nm.inThongTin();
        nm.an();
    }

    public static void updateInfo(ConNguoi cn, String name) {
        cn.setTen(name);
    }
}
