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
    private final String[] column = {"Mã lớp", "Tên lớp", "Lớp trưởng", "Sỹ số", "Mã giáo viên chủ nhiệm"};

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

    public Object[][] themLopHoc(ArrayList<Object> inputLopHoc) throws SQLException {
        this.danhSachLop = this.databaseLopHoc.themLopHoc(inputLopHoc);
        Object[][] data = this.loadDanhSachLopHoc();
        return data;
    }
}
