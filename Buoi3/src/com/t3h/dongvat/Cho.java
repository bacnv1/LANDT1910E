package com.t3h.dongvat;

public class Cho extends DongVat {
    private boolean huyenDe;
    private boolean domLuoi;

    public Cho(String ten, int tuoi, boolean gioiTinh, String mauSac, String loai, boolean huyenDe, boolean domLuoi) {
        super(ten, tuoi, gioiTinh, mauSac, loai);
        this.huyenDe = huyenDe;
        this.domLuoi = domLuoi;
    }

    public void coiNha() {
        System.out.println("Coi nha");
    }

    public void boi() {
        System.out.println("Biet boi");
    }

    @Override
    public void inThongTin() {
        super.inThongTin();
        System.out.println("Huyen de: "
                + (huyenDe == true ? "Co" : "Khong"));
        System.out.println("Dom luoi: "
                + (domLuoi == true ? "Co" : "Khong"));
    }
}
