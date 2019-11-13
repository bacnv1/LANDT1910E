package com.t3h.sinhvien;

public class NhanVien {
    private String ten;
    private int tuoi;
    private boolean gioiTinh;
    private String ngheNghiep;
    private String chucVu;

    public NhanVien(String ten, int tuoi, boolean gioiTinh,
                    String ngheNghiep, String chucVu) {
        this.ten = ten;
        this.tuoi = tuoi;
        this.gioiTinh = gioiTinh;
        this.ngheNghiep = ngheNghiep;
        this.chucVu = chucVu;
    }

    public void lamViec() {
        System.out.println("Nhan vien lam viec");
    }

    public void baoCao() {
        System.out.println("Nhan vien bao cao");
    }

    public void inThongTin() {
        System.out.println("Ho ten: " + ten);
        System.out.println("Tuoi: " + tuoi);
        System.out.println("Gioi tinh: " +
                (gioiTinh == true ? "Nam" : "Nu"));
        System.out.println("Nghe nghiep: " + ngheNghiep);
        System.out.println("Chuc vu: " + chucVu);
    }
}
