/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModelKetQuaThi;

import java.util.Date;

/**
 *
 * @author PC
 */
public class KetQuaThi {

    private String maHocVien;
    private String maMonHoc;
    private int lanThi;
    private Date ngayThi;
    private float diem;
    private String ketQua;

    public KetQuaThi(String maHocVien, String maMonHoc, int lanThi, Date ngayThi, float diem, String ketQua) {
        this.maHocVien = maHocVien;
        this.maMonHoc = maMonHoc;
        this.lanThi = lanThi;
        this.ngayThi = ngayThi;
        this.diem = diem;
        this.ketQua = ketQua;
    }

    public void setMaHocVien(String maHocVien) {
        this.maHocVien = maHocVien;
    }

    public void setMaMonHoc(String maMonHoc) {
        this.maMonHoc = maMonHoc;
    }

    public void setLanThi(int lanThi) {
        this.lanThi = lanThi;
    }

    public void setNgayThi(Date ngayThi) {
        this.ngayThi = ngayThi;
    }

    public void setDiem(float diem) {
        this.diem = diem;
    }

    public void setKetQua(String ketQua) {
        this.ketQua = ketQua;
    }

    public String getMaHocVien() {
        return maHocVien;
    }

    public String getMaMonHoc() {
        return maMonHoc;
    }

    public int getLanThi() {
        return lanThi;
    }

    public Date getNgayThi() {
        return ngayThi;
    }

    public float getDiem() {
        return diem;
    }

    public String getKetQua() {
        return ketQua;
    }

    public Object[] getData() {
        Object[] data = {this.maHocVien, this.maMonHoc, this.lanThi, this.ngayThi, this.diem, this.ketQua};
        return data;
    }

}
