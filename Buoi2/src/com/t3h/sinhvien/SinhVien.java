package com.t3h.sinhvien;

public class SinhVien {
    private String ten;
    private int tuoi;
    private boolean gioiTinh;
    private float diem;
    private String nghanhHoc;

    public SinhVien(String ten, int tuoi, boolean gioiTinh, float diem, String nghanhHoc) {
        this.ten = ten;
        this.tuoi = tuoi;
        this.gioiTinh = gioiTinh;
        this.diem = diem;
        this.nghanhHoc = nghanhHoc;
    }

    public void hocBai() {
        System.out.println("Sinh vien hoc bai");
    }

    public void thi() {
        System.out.println("Sinh vien thi cuoi ki");
    }

    public void inThongTin(){
        System.out.println("Ho ten: " + ten);
        System.out.println("Tuoi: " + tuoi);
        if (gioiTinh == true) {
            System.out.println("Gioi tinh: Nam");
        }else {
            System.out.println("Gioi tinh: Nu");
        }
        System.out.println("Diem: " + diem);
        System.out.println("Nganh hoc: " + nghanhHoc);
    }
}
