package com.t3h.sinhvien;

public class VanDongVien {
    public static final int CAN_NANG = 60;

    private int tuoi = 32;

    public class CauThu {
        private int tuoi = 21;

        public void soSanhTuoi() {
            if (VanDongVien.this.tuoi > tuoi) {
                System.out.println("Van dong vien lon hon");
            }else if (VanDongVien.this.tuoi < tuoi) {
                System.out.println("Van dong vien nho hon");
            }else {
                System.out.println("Bang nhau");
            }
        }
    }
}
