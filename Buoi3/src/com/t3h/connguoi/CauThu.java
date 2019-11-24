package com.t3h.connguoi;

import com.t3h.dongvat.Cho;

public class CauThu extends ConNguoi{
    private int soAo;
    private String cauLacBo;
    private int soBanThang;
    private Cho cho;

    public CauThu(String ten, int tuoi, boolean gioiTinh, String diaChi, String sdt, int soAo, String cauLacBo, int soBanThang, Cho cho) {
        super(ten, tuoi, gioiTinh, diaChi, sdt);
        this.soAo = soAo;
        this.cauLacBo = cauLacBo;
        this.soBanThang = soBanThang;
        this.cho = cho;
    }

    public void diDao() {
        System.out.println("Dat cho di dao");
    }

    @Override
    public void inThongTin() {
        super.inThongTin();
        System.out.println("Cau lac bo: " + cauLacBo);
        System.out.println("So ao: " + soAo);
        System.out.println("So ban thang: " + soBanThang);
        System.out.println("==Thong tin thu nuoi==");
        cho.inThongTin();
        cho.coiNha();
        cho.boi();
    }

    @Override
    public void an() {
        System.out.println("An che do suc khoe");
    }
}
