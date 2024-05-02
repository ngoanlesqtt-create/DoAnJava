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

    private void capNhatData(Object[][] data) {
        for (int i = 0; i <= this.danhSachHocVien.size() - 1; i++) {
            for (int j = 0; j <= 6; j++) {
                data[i][j] = this.danhSachHocVien.get(i).getDataHocVien()[j];
            }

        }
    }

    private void capNhatData(Object[][] data, ArrayList<HocVien> danhSachHocVien) {
        for (int i = 0; i <= danhSachHocVien.size() - 1; i++) {
            for (int j = 0; j <= 6; j++) {
                data[i][j] = danhSachHocVien.get(i).getDataHocVien()[j];
            }
        }
    }

    private void capNhapCacHocVienDuocTimThay(ArrayList<HocVien> cacHocVienDuocTimThay, String thongTin) {
        for (HocVien hocVien : this.danhSachHocVien) {
            if (hocVien.timHocVienTheoMa(thongTin) != null) {
                cacHocVienDuocTimThay.add(hocVien);
            }
        }
    }

    public Object[][] getDataHocVien() throws SQLException {
        Object[][] data = new Object[this.danhSachHocVien.size()][7];
        capNhatData(data);
        return data;
    }

    public Object[][] timHocVienTheoThongTin(String thongTin) {
        ArrayList<HocVien> cacHocVienDuocTimThay = new ArrayList<>();
        capNhapCacHocVienDuocTimThay(cacHocVienDuocTimThay, thongTin);
        if (cacHocVienDuocTimThay.size() >= 1) {
            Object[][] data = new Object[cacHocVienDuocTimThay.size()][7];
            capNhatData(data, cacHocVienDuocTimThay);
            return data;
        }
        return null;
    }

    public ArrayList getDanhSachHocVien() {
        return this.danhSachHocVien;
    }

    private void vietHoaHoHocVien(HocVien hocVienDuocThemVao) {
        char chuCaiDau = Character.toUpperCase(hocVienDuocThemVao.getHo().charAt(0));
        String replace = hocVienDuocThemVao.getHo().replace(hocVienDuocThemVao.getHo().charAt(0), chuCaiDau);
        hocVienDuocThemVao.setHo(replace);
        for (int i = 0; i <= hocVienDuocThemVao.getHo().length() - 2; i++) {
            if (hocVienDuocThemVao.getHo().charAt(i) == ' ') {
                chuCaiDau = Character.toUpperCase(hocVienDuocThemVao.getHo().charAt(i + 1));
                replace = hocVienDuocThemVao.getHo().replace(hocVienDuocThemVao.getHo().charAt(i + 1), chuCaiDau);
                hocVienDuocThemVao.setHo(replace);
            }
        }
    }

    private void vietHoaNoiSinhHocVien(HocVien hocVienDuocThemVao) {
        char chuCaiDau = Character.toUpperCase(hocVienDuocThemVao.getNoiSinh().charAt(0));
        String replace = hocVienDuocThemVao.getNoiSinh().replace(hocVienDuocThemVao.getNoiSinh().charAt(0), chuCaiDau);
        hocVienDuocThemVao.setNoiSinh(replace);
        for (int i = 0; i <= hocVienDuocThemVao.getNoiSinh().length() - 2; i++) {
            if (hocVienDuocThemVao.getNoiSinh().charAt(i) == ' ') {
                chuCaiDau = Character.toUpperCase(hocVienDuocThemVao.getNoiSinh().charAt(i + 1));
                replace = hocVienDuocThemVao.getNoiSinh().replace(hocVienDuocThemVao.getNoiSinh().charAt(i + 1), chuCaiDau);
                hocVienDuocThemVao.setNoiSinh(replace);
            }
        }
    }

    private void vietHoaTenHocVien(HocVien hocVienDuocThemVao) {
        char chuCaiDau = Character.toUpperCase(hocVienDuocThemVao.getTen().charAt(0));
        String replace = hocVienDuocThemVao.getTen().replace(hocVienDuocThemVao.getTen().charAt(0), chuCaiDau);
        hocVienDuocThemVao.setTen(replace);

    }

    private void vietMaHocVien(HocVien hocVienDuocThemVao) {
        char chuCaiDau = Character.toUpperCase(hocVienDuocThemVao.getMaHocVien().charAt(0));
        String replace = hocVienDuocThemVao.getMaHocVien().replace(hocVienDuocThemVao.getMaHocVien().charAt(0), chuCaiDau);
        hocVienDuocThemVao.setMaHocVien(replace);

    }

    private void vietMaLop(HocVien hocVienDuocThemVao) {
        char chuCaiDau = Character.toUpperCase(hocVienDuocThemVao.getMaLop().charAt(0));
        String replace = hocVienDuocThemVao.getMaLop().replace(hocVienDuocThemVao.getMaLop().charAt(0), chuCaiDau);
        hocVienDuocThemVao.setMaLop(replace);

    }

    public Object[][] themHocVienVaoDanhSach(HocVien hocVienDuocThemVao) throws SQLException, ParseException {

        if (!(hocVienDuocThemVao.getHo().charAt(0) >= 'Z' && hocVienDuocThemVao.getHo().charAt(0) <= 'A')) {
            vietHoaHoHocVien(hocVienDuocThemVao);
        }
        if (!(hocVienDuocThemVao.getMaLop().charAt(0) >= 'Z' && hocVienDuocThemVao.getMaLop().charAt(0) <= 'A')) {
            vietHoaNoiSinhHocVien(hocVienDuocThemVao);
        }
        if (!(hocVienDuocThemVao.getTen().charAt(0) >= 'Z' && hocVienDuocThemVao.getTen().charAt(0) <= 'A')) {
            vietHoaTenHocVien(hocVienDuocThemVao);
        }
        if (!(hocVienDuocThemVao.getMaHocVien().charAt(0) >= 'Z' && hocVienDuocThemVao.getMaHocVien().charAt(0) <= 'A')) {
            vietMaHocVien(hocVienDuocThemVao);
        }
        if (!(hocVienDuocThemVao.getMaLop().charAt(0) >= 'Z' && hocVienDuocThemVao.getMaLop().charAt(0) <= 'A')) {
            vietMaLop(hocVienDuocThemVao);
        }
        this.danhSachHocVien = this.ds.themHocVienVaoDanhSach(hocVienDuocThemVao);
        if (this.danhSachHocVien != null) {
            Object[][] data = new Object[this.danhSachHocVien.size()][7];
            capNhatData(data);
            return data;
        }
        return null;
    }

    public Object[][] xoaHocVien(int chiSoTable) throws SQLException {
        this.danhSachHocVien = this.ds.xoaHocVien(this.danhSachHocVien.get(chiSoTable).getMaHocVien());
        Object[][] data = new Object[this.danhSachHocVien.size()][7];
        capNhatData(data);
        return data;

    }

    public Object[][] xoaCacHocVienDuocTimThay(int chiSoTable, String thongTin) throws SQLException {
        ArrayList<HocVien> cacHocVienDuocTimThay = new ArrayList<>();
        capNhapCacHocVienDuocTimThay(cacHocVienDuocTimThay, thongTin);
        if (cacHocVienDuocTimThay.size() >= 1) {
            for (HocVien hocVien : this.danhSachHocVien) {
                if (cacHocVienDuocTimThay.get(chiSoTable).getMaHocVien().equals(hocVien.getMaHocVien())) {
                    this.danhSachHocVien = this.ds.xoaHocVien(hocVien.getMaHocVien());
                }
            }
            cacHocVienDuocTimThay.remove(chiSoTable);
            Object[][] data = new Object[cacHocVienDuocTimThay.size()][7];
            capNhatData(data, cacHocVienDuocTimThay);
            return data;
        }
        return null;
    }

}
