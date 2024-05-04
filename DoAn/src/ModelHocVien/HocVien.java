/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModelHocVien;

import java.util.Date;

/**
 *
 * @author PC
 */
public class HocVien {

    private String maHV;
    private String ho;
    private String ten;
    private Date ngaySinh;
    private String gioiTinh;
    private String noiSinh;
    private String maLop;

    public HocVien(String maHV, String ho, String ten, Date ngaySinh, String gioiTinh, String noiSinh, String maLop) {
        this.maHV = maHV;
        this.ho = ho;
        this.ten = ten;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.noiSinh = noiSinh;
        this.maLop = maLop;
    }

    public void xuat() {
        System.out.println("Thong tin hoc vien:");
        System.out.println("\tMa hoc vien:" + this.maHV);
        System.out.println("\tTen:" + this.ten);
        System.out.println("\tNgay sinh:" + this.ngaySinh);
        System.out.println("\tGioi tinh:" + this.gioiTinh);
        System.out.println("\tNoi sinh:" + this.noiSinh);
        System.out.println("\tMa lop:" + this.maLop);
    }

    public Object[] getDataHocVien() {
        Object[] data = {this.maHV, this.ho, this.ten, this.ngaySinh, this.gioiTinh, this.noiSinh, this.maLop};
        return data;
    }

    public String getMaHocVien() {
        return this.maHV;
    }

    public String getHo() {
        return this.ho;
    }

    public String getTen() {
        return this.ten;
    }

    public Date getNgaySinh() {
        return this.ngaySinh;
    }

    public String getGioiTinh() {
        return this.gioiTinh;
    }

    public String getNoiSinh() {
        return this.noiSinh;
    }

    public String getMaLop() {
        return this.maLop;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public HocVien timHocVienTheoMa(String thongTin) {

        if (this.maHV.equalsIgnoreCase(thongTin)) {
            return this;
        }
        if ((this.ten + " " + this.maLop).equalsIgnoreCase(thongTin)) {
            return this;
        }
        String hoTen = this.ho + ' ' + this.ten + " " + this.maLop;
        if (hoTen.equalsIgnoreCase(thongTin)) {
            return this;
        }
        if ((this.ho + " " + this.ten).equalsIgnoreCase(thongTin)) {
            return this;
        }
        if (this.maLop.equalsIgnoreCase(thongTin)) {
            return this;
        }
        if (this.ten.equalsIgnoreCase(thongTin) || this.ho.contains(thongTin)) {
            return this;

        }
        if (!this.maHV.equalsIgnoreCase(thongTin)) {
            return null;
        }
        return null;
    }

    public void setNoiSinh(String noiSinh) {
        this.noiSinh = noiSinh;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public void setMaHocVien(String maHocVien) {
        this.maHV = maHocVien;
    }

    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

}
