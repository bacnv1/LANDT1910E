package com.t3h.connguoi;

public abstract class ConNguoi {
    protected String ten;
    protected int tuoi;
    protected boolean gioiTinh;
    protected String diaChi;
    protected String sdt;

    public ConNguoi(String ten, int tuoi, boolean gioiTinh, String diaChi, String sdt) {
        this.ten = ten;
        this.tuoi = tuoi;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.sdt = sdt;
    }

    public void inThongTin() {
        System.out.println("Ten: "+ ten);
        System.out.println("Tuoi: " + tuoi);
        System.out.println("Gioi Tinh: "
                +(gioiTinh == true ? "Nam" : "Nu"));
        System.out.println("SDT: " + sdt);
        System.out.println("Dia chi: " + diaChi);
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public abstract void an();
}
