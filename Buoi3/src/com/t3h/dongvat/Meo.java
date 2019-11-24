package com.t3h.dongvat;

public class Meo extends DongVat{
    private boolean luoiNham;

    public Meo(String ten, int tuoi, boolean gioiTinh, String mauSac, String loai, boolean luoiNham) {
        super(ten, tuoi, gioiTinh, mauSac, loai);
        this.luoiNham = luoiNham;
    }

    public void batChuoi() {
        System.out.println("Bat chuot gioi");
    }

    @Override
    public void inThongTin() {
        super.inThongTin();
        System.out.println("Luoi nham: "
                + (luoiNham == true ? "Co" : "Khong"));
    }
}
