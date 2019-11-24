package com.t3h.connguoi;

import com.t3h.dongvat.Meo;

public class NguoiMau extends ConNguoi{
    private String soDo3Vong;
    private String ctyDaiDien;
    private Meo meo;

    public NguoiMau(String ten, int tuoi, boolean gioiTinh, String diaChi, String sdt, String soDo3Vong, String ctyDaiDien, Meo meo) {
        super(ten, tuoi, gioiTinh, diaChi, sdt);
        this.soDo3Vong = soDo3Vong;
        this.ctyDaiDien = ctyDaiDien;
        this.meo = meo;
    }

    public void bieuDien() {
        System.out.println("Bieu dien thoi trang");
    }

    /**
     * Shopping when free with here cat
     * @param isFree: if true is available
     * */
    public void diShopping(boolean isFree) {
        if (isFree) {
            System.out.println("Dat meo di shopping");
        } else {
            System.out.println("O nha lam viec");
        }
    }

    @Override
    public void inThongTin() {
        super.inThongTin();
        System.out.println("So do 3 vong: " + soDo3Vong);
        System.out.println("Cong ty dai dien: " + ctyDaiDien);
        System.out.println("==Thong tin thu nuoi==");
        meo.inThongTin();
        meo.batChuoi();
    }

    @Override
    public void an() {
        System.out.println("An kieng");
    }
}
