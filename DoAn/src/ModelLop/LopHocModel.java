/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModelLop;

import Database.DatabaseLopHoc;
import ModelGiaoVien.GiaoVien;
import ModelHocVien.HocVien;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class LopHocModel {

    private ArrayList<LopHoc> danhSachLop;
    private ArrayList<HocVien> danhSachHocVien;
    private ArrayList<GiaoVien> danhSachGiaoVien;
    private final DatabaseLopHoc databaseLopHoc;
    private final String[] column = {"Mã lớp", "Tên lớp", "Lớp trưởng", "Sĩ số", "Mã giáo viên chủ nhiệm"};

    public LopHocModel() throws SQLException {
        this.danhSachGiaoVien = new ArrayList<>();
        this.danhSachHocVien = new ArrayList<>();
        this.danhSachLop = new ArrayList<>();
        this.databaseLopHoc = new DatabaseLopHoc(this.danhSachLop);
    }

    public ArrayList getDanhSachGiaoVien() throws SQLException {
        return this.danhSachGiaoVien = this.databaseLopHoc.getDanhSachGiaoVien();
    }

    public ArrayList getDanhSachHocVien() throws SQLException {
        return this.danhSachHocVien = this.databaseLopHoc.getDanhSachHocVien();
    }

    public ArrayList getDanhSachLop() {
        return this.danhSachLop;
    }

    public String[] getColumnLopHoc() {
        return this.column;
    }

    public Object[][] loadDanhSachLopHoc() {
        Object[][] data = new Object[this.danhSachLop.size()][5];
        for (int i = 0; i <= this.danhSachLop.size() - 1; i++) {
            for (int j = 0; j <= 4; j++) {
                data[i][j] = this.danhSachLop.get(i).getDataLopHoc()[j];
            }
        }
        return data;
    }

    public boolean kiemTraTrungMaLopTruong(ArrayList<Object> inputLopHoc) {
        for (LopHoc lopHoc : this.danhSachLop) {
            if (inputLopHoc.get(2).equals(lopHoc.getTruongLop() + " ")) {
                return false;
            }
        }
        return true;
    }

    public boolean kiemTraTrungMaGiaoVienChuNhiem(ArrayList<Object> inputLopHoc) {
        for (LopHoc lopHoc : this.danhSachLop) {
            if (inputLopHoc.get(3).equals(lopHoc.getMaGiaoVienChuNhiem())) {
                return false;
            }
        }
        return true;
    }

    public boolean kiemTraTrungMaGiaoVienChuNhiem(String maGiaoVienChuNhiem, int row) {
        ArrayList<LopHoc> lopHocDuocThayDoi = this.danhSachLop;
        if (!this.danhSachLop.get(row).getMaGiaoVienChuNhiem().equalsIgnoreCase(maGiaoVienChuNhiem)) {
            lopHocDuocThayDoi.remove(this.danhSachLop.get(row));
            for (LopHoc lopHoc : this.danhSachLop) {
                if (lopHoc.getMaGiaoVienChuNhiem().equalsIgnoreCase(maGiaoVienChuNhiem)) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean kiemTraMaLopKhiThayDoi(String maLopHocCanSua, int row) {
        ArrayList<LopHoc> lopHocDuocThayDoi = this.danhSachLop;
        if (!this.danhSachLop.get(row).getMaLop().equalsIgnoreCase(maLopHocCanSua)) {
            lopHocDuocThayDoi.remove(this.danhSachLop.get(row));
            for (LopHoc lopHoc : this.danhSachLop) {
                if (lopHoc.getMaLop().equalsIgnoreCase(maLopHocCanSua)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean kiemTraMaLopTruongKhiThayDoi(String maLopTruongMuonThayDoi, int row) {
        if (!this.danhSachLop.get(row).getTruongLop().equalsIgnoreCase(maLopTruongMuonThayDoi)) {
            return this.kiemTraCapNhapLopTruong(row, maLopTruongMuonThayDoi);
        }
        return true;
    }

    public Object[][] themLopHoc(ArrayList<Object> inputLopHoc) throws SQLException {
        this.danhSachLop = this.databaseLopHoc.themLopHoc(inputLopHoc);
        Object[][] data = this.loadDanhSachLopHoc();
        return data;
    }

    public Object[][] capNhapLopTruong(int dongDuocChonTrenBangLopHoc, String maLopTruong) throws SQLException {
        this.danhSachLop = this.databaseLopHoc.capNhapMaLopTruong(this.danhSachLop.get(dongDuocChonTrenBangLopHoc).getMaLop(), maLopTruong);
        Object[][] data = this.loadDanhSachLopHoc();
        return data;
    }

    public boolean kiemTraCapNhapLopTruong(int dongDuocChonTrenBangLopHoc, String maSoLopTruong) {
        return maSoLopTruong.contains(this.danhSachLop.get(dongDuocChonTrenBangLopHoc).getMaLop());
    }

    public boolean kiemTraSiSoLop(int dongDuocChonTrenBangLopHoc) {
        for (HocVien hocVien : this.danhSachHocVien) {
            if (hocVien.getMaHocVien().contains(this.danhSachLop.get(dongDuocChonTrenBangLopHoc).getMaLop())) {
                return true;
            }
        }
        return false;

    }

    public Object[][] xoaLopHoc(int dongDuocChonTrenBangLopHoc) throws SQLException {
        this.danhSachLop = this.databaseLopHoc.xoaLopHoc(this.danhSachLop.get(dongDuocChonTrenBangLopHoc).getMaLop());
        Object[][] data = this.loadDanhSachLopHoc();
        return data;
    }

    public Object[][] capNhapLopSiSoLopHoc() throws SQLException {
        for (LopHoc lopHoc : this.danhSachLop) {
            int count = 0;
            for (HocVien hocVien : this.danhSachHocVien) {
                if (hocVien.getMaHocVien().contains(lopHoc.getMaLop())) {
                    count++;
                }
            }
            this.danhSachLop = this.databaseLopHoc.capNhapSiSoLop(lopHoc.getMaLop(), count);
        }
        Object[][] data = this.loadDanhSachLopHoc();
        return data;
    }

    public Object[][] suaThongTinLopHoc(ArrayList<Object> inputLopHoc, int row) throws SQLException {
        this.danhSachLop = this.databaseLopHoc.suaThongTinLopHoc(inputLopHoc, this.danhSachLop.get(row).getMaLop(), this.danhSachLop.get(row).getTruongLop());
        if (this.danhSachLop != null) {
            Object[][] data = this.loadDanhSachLopHoc();
            return data;
        }
        return null;
    }

    public String thayTheMaLopTruong(String maLopHocString, int row) {
        System.out.println("test dong 167 LopHocModel ,maLopHocString:" + maLopHocString);
        System.out.println("test dong 168 LopHocModel, row:" + row);
        String ketQua = this.danhSachLop.get(row).getTruongLop().replaceFirst(this.danhSachLop.get(row).getMaLop(), maLopHocString);
        return ketQua;
    }

    public void setMaLopTruong(String maLopTruongDuocThayThe, int row) {
        this.danhSachLop.get(row).setMaLopTruong(maLopTruongDuocThayThe);
    }

    public void setGiaTriDeCapNhapLaiBangHocVien(ArrayList<Object> inputLopHoc, int row, ArrayList<LopHoc> danhSachLopHoc) throws SQLException {
        this.databaseLopHoc.setGiaTriDeSuaChuabangHocVien((String) inputLopHoc.get(0), row, danhSachLopHoc.get(row).getMaLop());
    }

}
