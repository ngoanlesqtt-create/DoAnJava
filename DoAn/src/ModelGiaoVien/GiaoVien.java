/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModelGiaoVien;

import Interface.InterfaceGiaoVien;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author PC
 */
public class GiaoVien implements InterfaceGiaoVien {

    protected String MaGV;
    protected String hoTen;
    protected String hocVi;
    protected String gioiTinh;
    protected float heSo;
    protected float luongCB;
    protected float luong;
    protected String maKhoa;
    protected Date ngaySinh;

    public GiaoVien(String MaGV, String hoTen, String hocVi, String gioiTinh, Date ngaySinh, float heSo, float luongCB, float luong, String maKhoa) {
        this.MaGV = MaGV;
        this.hoTen = hoTen;
        this.hocVi = hocVi;
        this.gioiTinh = gioiTinh;
        this.heSo = heSo;
        this.luongCB = luongCB;
        this.luong = luong;
        this.maKhoa = maKhoa;
        this.ngaySinh = ngaySinh;
    }

    @Override
    public float tinhLuong() {
        return 0;
    }

    public String getMaGv() {
        return this.MaGV;
    }

    public Object getHoTen() {
        return this.hoTen;
    }

    public Object getHocVi() {
        return this.hocVi;
    }

    public String getGioiTinh() {
        return this.gioiTinh;
    }

    public Object getNgaySinh() {
        return this.ngaySinh;
    }

    public float getLuongCoBan() {
        return this.luongCB;
    }

    public float getHeSo() {
        return this.heSo;
    }

    public float getLuong() {
        return this.luong;
    }

    public String getMaKhoa() {
        return this.maKhoa;
    }

    public String getMaGiaoVien() {
        return this.MaGV;
    }

    public Object[] getData() {
        Object data[] = {this.MaGV, this.hoTen, this.hocVi, this.gioiTinh, this.ngaySinh, this.heSo, this.luongCB, this.luong, this.maKhoa};
        return data;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public void setHocVi(String hocVi) {
        this.hocVi = hocVi;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public void setLuongCoBan(float luongCoBan) {
        this.luongCB = luongCoBan;
    }

    public void setHeSo(float heSo) {
        this.heSo = heSo;
    }

    public void setMaKhoa(String maKhoa) {
        this.maKhoa = maKhoa;
    }

}
