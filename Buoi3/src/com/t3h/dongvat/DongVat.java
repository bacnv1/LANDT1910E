package com.t3h.dongvat;

public class DongVat {
    protected String ten;
    protected int tuoi;
    protected boolean gioiTinh;
    protected String mauSac;
    protected String loai;


    public DongVat(String ten, int tuoi, boolean gioiTinh,
                   String mauSac, String loai) {
        this.ten = ten;
        this.tuoi = tuoi;
        this.gioiTinh = gioiTinh;
        this.mauSac = mauSac;
        this.loai = loai;
    }

    public void inThongTin() {
        System.out.println("Ten: " + ten);
        System.out.println("Tuoi: " + tuoi);
        System.out.println("Gioi tinh: "
                + (gioiTinh == true ? "Duc" : "Cai"));
        System.out.println("Mau sac: " + mauSac);
        System.out.println("Loai: " + loai);
    }

}
