package com.t3h.main;

import com.t3h.sinhvien.NhanVien;
import com.t3h.sinhvien.SinhVien;
import com.t3h.sinhvien.VanDongVien;

public class Main {
    public static void main(String[] args) {
        SinhVien sv = new SinhVien(
                "Nguyen Van",
                12,
                true,
                8.5F,
                "CNTT"
                );
        sv.inThongTin();
        sv.hocBai();
        sv.thi();
        System.out.println("===================");
        NhanVien nv = new NhanVien(
                "Nguyen Thi B",
                32,
                false,
                "IT",
                "Tester"
        );
        nv.inThongTin();
        nv.lamViec();
        nv.baoCao();

        System.out.println("=================");
        VanDongVien.CauThu cauThu = new VanDongVien().new CauThu();
        cauThu.soSanhTuoi();
        System.out.println(VanDongVien.CAN_NANG);
    }
}
