/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModelKhoa;

import java.util.Date;

/**
 *
 * @author PC
 */
public class Khoa {

    private String maKhoa;
    private String tenKhoa;
    private Date ngayThanhLap;
    private String truongKhoa;
    private int soLuongGiangVien;

    public Khoa(String maKhoa, String tenKhoa, Date ngayThanhLap, int soLuongGiangVien, String truongKhoa) {
        this.maKhoa = maKhoa;
        this.tenKhoa = tenKhoa;
        this.ngayThanhLap = ngayThanhLap;
        this.truongKhoa = truongKhoa;
        this.soLuongGiangVien = 0;
    }

    public String getMaKhoa() {
        return maKhoa;
    }

    public String getTenKhoa() {
        return tenKhoa;
    }

    public Date getNgayThanhLap() {
        return ngayThanhLap;
    }

    public String getTruongKhoa() {
        return truongKhoa;
    }

    public int getSoLuongGiangVien() {
        return soLuongGiangVien;
    }

    public void setMaKhoa(String maKhoa) {
        this.maKhoa = maKhoa;
    }

    public void setTenKhoa(String tenKhoa) {
        this.tenKhoa = tenKhoa;
    }

    public void setNgayThanhLap(Date ngayThanhLap) {
        this.ngayThanhLap = ngayThanhLap;
    }

    public void setTruongKhoa(String truongKhoa) {
        this.truongKhoa = truongKhoa;
    }

    public void setSoLuongGiangVien(int soLuongGiangVien) {
        this.soLuongGiangVien = soLuongGiangVien;
    }

    public Object[] getDataLop() {
        Object[] data = {this.maKhoa, this.tenKhoa, this.ngayThanhLap, this.soLuongGiangVien, this.truongKhoa};
        return data;
    }

}
