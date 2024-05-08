/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModelGiaoVien;

import java.util.Date;

/**
 *
 * @author PC
 */
public class CuNhan extends GiaoVien {

    public CuNhan(String MaGV, String hoTen, String hocVi, String gioiTinh, Date ngaySinh, float heSo, float luongCB, float luong, String maKhoa) {
        super(MaGV, hoTen, hocVi, gioiTinh, ngaySinh, heSo, luongCB, luong, maKhoa);
    }

    @Override
    public float tinhLuong() {
        return this.luong = this.heSo * 50000 + this.luongCB;
    }

    

}
