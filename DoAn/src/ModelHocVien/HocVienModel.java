/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModelHocVien;

import Database.DatabaseHocVien;
import ModelLop.LopHoc;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class HocVienModel {

    private ArrayList<HocVien> danhSachHocVien;
    private ArrayList<LopHoc> danhSachLopHoc;
    private DatabaseHocVien ds;

    public HocVienModel() throws SQLException {
        this.danhSachHocVien = new ArrayList<>();
        this.danhSachLopHoc = new ArrayList<>();
        ds = new DatabaseHocVien(this.danhSachHocVien);
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

    public Object[][] xoaHocVien(int[] nhieuChiSoTable) throws SQLException {
        for (int i = nhieuChiSoTable.length - 1; 0 <= i; i--) {
            this.danhSachHocVien = this.ds.xoaHocVien(this.danhSachHocVien.get(nhieuChiSoTable[i]).getMaHocVien());
        }
        Object[][] data = new Object[this.danhSachHocVien.size()][7];
        capNhatData(data);
        return data;

    }

    public Object[][] xoaCacHocVienDuocTimThay(int[] nhieuChiSoTable, String thongTin) throws SQLException {
        ArrayList<HocVien> cacHocVienDuocTimThay = new ArrayList<>();
        capNhapCacHocVienDuocTimThay(cacHocVienDuocTimThay, thongTin);
        if (cacHocVienDuocTimThay.size() >= 1) {
            for (HocVien hocVien : this.danhSachHocVien) {
                for (int i = 0; i <= nhieuChiSoTable.length - 1; i++) {
                    if (cacHocVienDuocTimThay.get(nhieuChiSoTable[i]).getMaHocVien().equals(hocVien.getMaHocVien())) {
                        this.danhSachHocVien = this.ds.xoaHocVien(hocVien.getMaHocVien());
                    }
                }
            }
            for (int i = nhieuChiSoTable.length - 1; 0 <= i; i--) {
                cacHocVienDuocTimThay.remove(nhieuChiSoTable[i]);
            }
            Object[][] data = new Object[cacHocVienDuocTimThay.size()][7];
            capNhatData(data, cacHocVienDuocTimThay);
            return data;
        }
        return null;
    }

    public Object[][] suaThongTinHocVien(HocVien hocVienDuocSua, int chiSoBang) throws SQLException, ParseException {
        if (!hocVienDuocSua.getMaHocVien().contains(hocVienDuocSua.getMaLop())) {
            return null;
        }
        if (!this.kiemTraMaLopKhiThemHocVien(hocVienDuocSua)) {
            return null;
        }
        this.danhSachHocVien = this.ds.suaThongTinHocVien(hocVienDuocSua, this.danhSachHocVien.get(chiSoBang).getMaHocVien());
        if (this.danhSachHocVien != null) {
            Object[][] data = new Object[this.danhSachHocVien.size()][7];
            capNhatData(data, this.danhSachHocVien);
            return data;
        } else {
        }
        return null;
    }

    public Object[][] suaThongTinHocVienKhiDuocTimKiem(int nhieuChiSoTable, String thongTin, HocVien hocVienDuocSua) throws SQLException, ParseException {
        ArrayList<HocVien> cacHocVienDuocTimThay = new ArrayList<>();
        capNhapCacHocVienDuocTimThay(cacHocVienDuocTimThay, thongTin);
        for (HocVien hocVien : this.danhSachHocVien) {
            if (cacHocVienDuocTimThay.get(nhieuChiSoTable).getMaHocVien().equalsIgnoreCase(hocVien.getMaHocVien())) {
                this.danhSachHocVien = this.ds.suaThongTinHocVien(hocVienDuocSua, hocVien.getMaHocVien());
            }
        }
        ArrayList<HocVien> cacHocVienDuocSuaThongTinKhiTimThay = new ArrayList<>();//load lai danh sach cac sinh vien da duoc sua
        capNhapCacHocVienDuocTimThay(cacHocVienDuocSuaThongTinKhiTimThay, thongTin);

        Object[][] data = new Object[cacHocVienDuocSuaThongTinKhiTimThay.size()][7];
        capNhatData(data, cacHocVienDuocSuaThongTinKhiTimThay);
        return data;
    }

    public boolean kiemTraMaLopKhiThemHocVien(HocVien hocVienDuocThemVao) throws SQLException {
        this.danhSachLopHoc = this.ds.loadLopHoc();
        for (LopHoc lopHoc : this.danhSachLopHoc) {
            if (hocVienDuocThemVao.getMaLop().equalsIgnoreCase(lopHoc.getMaLop())) {
                return true;
            }
        }
        return false;
    }

    public boolean kiemTraMaLopKhiThemHocVien1(String noiDungThayDoi) throws SQLException {
        this.danhSachLopHoc = this.ds.loadLopHoc();
        for (LopHoc lopHoc : this.danhSachLopHoc) {
            if (noiDungThayDoi.contains(lopHoc.getMaLop())) {
                return true;
            }
        }
        return false;
    }

    public boolean kiemTraMaLopKhiThemHocVien2(String noiDungThayDoi) throws SQLException {
        this.danhSachLopHoc = this.ds.loadLopHoc();
        for (LopHoc lopHoc : this.danhSachLopHoc) {
            if (noiDungThayDoi.contains(lopHoc.getMaLop())) {
                return true;
            }
        }
        return false;
    }

    public Object[][] setMaLopCuaHocVien(String maLopBanDau, String maLopDeSua) throws SQLException {
        this.danhSachLopHoc = this.ds.loadLopHoc();
        String maHocVienSauKhiCapNhap = "";
        for (HocVien hocVien : this.danhSachHocVien) {
            if (hocVien.getMaLop().equalsIgnoreCase(maLopBanDau)) {
                maHocVienSauKhiCapNhap = hocVien.getMaHocVien().replaceFirst(maLopBanDau, maLopDeSua);
                this.danhSachLopHoc = this.ds.suaMaHocVienKhiThayDoiLopHoc(maHocVienSauKhiCapNhap, hocVien.getMaHocVien());
            }
        }

        this.danhSachHocVien = this.ds.capNhapThongTinHocVienKhiSuaLopHoc(maLopDeSua, maLopBanDau);
        Object[][] data = new Object[this.danhSachHocVien.size()][7];
        this.capNhatData(data);
        return data;
    }

    public ArrayList setMaLopCuaHocVien(String maLopBanDau, String maLopDeSua, int row) throws SQLException {
        this.danhSachLopHoc = this.ds.loadLopHoc();
        String maHocVienSauKhiCapNhap = "";
        for (HocVien hocVien : this.danhSachHocVien) {
            if (hocVien.getMaLop().equalsIgnoreCase(maLopBanDau)) {
                maHocVienSauKhiCapNhap = hocVien.getMaHocVien().replaceFirst(maLopBanDau, maLopDeSua);
                this.danhSachLopHoc = this.ds.suaMaHocVienKhiThayDoiLopHoc(maHocVienSauKhiCapNhap, hocVien.getMaHocVien());
            }
        }

        return this.danhSachHocVien = this.ds.capNhapThongTinHocVienKhiSuaLopHoc(maLopDeSua, maLopBanDau);

    }

    public ArrayList layCacGiaTriCanSuaTuLopHoc() throws SQLException {
        ArrayList<Object> data = this.ds.setGiaTriDeSuaChuabangHocVien();
        return data;
    }
}
