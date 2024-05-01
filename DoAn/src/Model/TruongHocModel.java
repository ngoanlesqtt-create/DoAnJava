/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Database.Database;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class TruongHocModel {

    private ArrayList<HocVien> danhSachHocVien;
    private Database ds;

    public TruongHocModel() {
        danhSachHocVien = new ArrayList<>();
    }

    public void nhap() throws SQLException {
        ds = new Database(this.danhSachHocVien);
    }

    public void xuat() {
        for (HocVien hocVien : this.danhSachHocVien) {
            hocVien.xuat();
        }
    }

    public Object[][] getDataHocVien() throws SQLException {
        Object[][] data = new Object[this.danhSachHocVien.size()][7];
        for (int i = 0; i <= this.danhSachHocVien.size() - 1; i++) {
            for (int j = 0; j <= 6; j++) {
                data[i][j] = this.danhSachHocVien.get(i).getDataHocVien()[j];
            }

        }

        return data;
    }

    public Object[][] timHocVienTheoThongTin(String thongTin) {

        ArrayList<HocVien> cacHocVienDuocTimThay = new ArrayList<>();
        for (HocVien hocVien : this.danhSachHocVien) {
            if (hocVien.timHocVienTheoMa(thongTin) != null) {
                cacHocVienDuocTimThay.add(hocVien);
            }
        }
        if (cacHocVienDuocTimThay.size() >= 1) {
            Object[][] data = new Object[cacHocVienDuocTimThay.size()][7];
            for (int i = 0; i <= cacHocVienDuocTimThay.size() - 1; i++) {
                for (int j = 0; j <= 6; j++) {
                    data[i][j] = cacHocVienDuocTimThay.get(i).getDataHocVien()[j];
                }
            }
            return data;
        }
        return null;

    }

    public ArrayList getDanhSachHocVien() {
        return this.danhSachHocVien;
    }

    public Object[][] themHocVienVaoDanhSach(HocVien hocVienDuocThemVao) throws SQLException, ParseException {

        for (HocVien hocVien : this.danhSachHocVien) {
            if (hocVien.getMaHocVien().equalsIgnoreCase(hocVienDuocThemVao.getMaHocVien())) {
                return null;
            }
        }
        this.danhSachHocVien = this.ds.themHocVienVaoDanhSach(hocVienDuocThemVao);
        Object[][] data = new Object[this.danhSachHocVien.size()][7];
        for (int i = 0; i <= this.danhSachHocVien.size() - 1; i++) {
            for (int j = 0; j <= 6; j++) {
                data[i][j] = this.danhSachHocVien.get(i).getDataHocVien()[j];
            }
        }
        return data;
    }

}
