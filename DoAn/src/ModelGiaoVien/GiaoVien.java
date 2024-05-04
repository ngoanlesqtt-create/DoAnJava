/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModelGiaoVien;

import Interface.InterfaceGiaoVien;
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

}