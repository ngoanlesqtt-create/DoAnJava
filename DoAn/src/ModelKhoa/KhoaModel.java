/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModelKhoa;

import Database.DatabaseKhoa;
import ModelGiaoVien.GiaoVien;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author PC
 */
public class KhoaModel extends AbstractTableModel {

    private ArrayList<Khoa> danhSachKhoa;
    private final DatabaseKhoa databaseKhoa;
    private final String[] columns = {"Mã khoa", "Tên khoa", "Ngày thành lập", "Số lượng giáo viên", "Trưởng khoa"};

    public KhoaModel() throws SQLException {
        this.danhSachKhoa = new ArrayList<>();
        this.databaseKhoa = new DatabaseKhoa(this.danhSachKhoa);

    }

    public Object[][] loadData() {
        Object[][] data = new Object[this.danhSachKhoa.size()][5];
        for (int i = 0; i <= this.danhSachKhoa.size() - 1; i++) {
            for (int j = 0; j <= 4; j++) {
                data[i][j] = this.danhSachKhoa.get(i).getDataLop()[j];
            }
        }
        return data;
    }

    public ArrayList<Khoa> getDanhSachKhoa() {
        return danhSachKhoa;
    }

    public ArrayList<GiaoVien> getDanhSachGiaoVien() throws SQLException {
        ArrayList<GiaoVien> danhSachGiaoVien = this.databaseKhoa.getDanhSachGiaoVien();
        return danhSachGiaoVien;
    }

    public String[] getColumn() {
        return this.columns;
    }

    public ArrayList getMaGiaoVien() throws SQLException {
        ArrayList<String> danhSachMaGiaoVien = this.databaseKhoa.getMaGiaoVien();
        return danhSachMaGiaoVien;
    }

    public ArrayList getMaGiaoVienDangLaChuNhiemKhoa() throws SQLException {
        ArrayList<String> danhSachMaGiaoVienDangLaChuNhiemKhoa = this.databaseKhoa.getMaGiaoVienDangLaChuNhiemKhoa();
        return danhSachMaGiaoVienDangLaChuNhiemKhoa;
    }

    public Object[][] themKhoa(ArrayList<Object> inputKhoa) throws SQLException, ParseException {
        this.danhSachKhoa = this.databaseKhoa.themKhoa(inputKhoa);
        if (danhSachKhoa == null) {
            return null;
        }
        Object[][] data = this.loadData();
        return data;
    }

    public Object[][] capNhapSiSoGiaoVienKhoa() throws SQLException {
        ArrayList<GiaoVien> danhSachMaGiaoVien = this.databaseKhoa.getDanhSachGiaoVien();
        for (Khoa khoa : this.danhSachKhoa) {
            int count = 0;
            for (GiaoVien giaoVien : danhSachMaGiaoVien) {
                if (khoa.getMaKhoa().contains(giaoVien.getMaKhoa())) {
                    count++;
                }
            }
            this.danhSachKhoa = this.databaseKhoa.capNhapSiSoGiaoVienKhoa(khoa.getMaKhoa(), count);
        }
        Object[][] data = this.loadData();
        return data;
    }

    public Object[][] xoaKhoa(int row) throws SQLException {
        if (this.danhSachKhoa == null) {
            this.danhSachKhoa = this.databaseKhoa.getDanhSachKhoa();
        }
        if (this.danhSachKhoa.get(row).getSoLuongGiangVien() != 0) {
            return null;
        }

        this.danhSachKhoa = this.databaseKhoa.xoaKhoa(this.danhSachKhoa.get(row).getMaKhoa());
        Object[][] data = this.loadData();
        return data;
    }

    @Override
    public int getRowCount() {
        return this.danhSachKhoa.size();
    }

    @Override
    public int getColumnCount() {
        return this.columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Khoa khoa = this.danhSachKhoa.get(rowIndex);
        switch (columnIndex) {
            case 0 -> {
                return khoa.getMaKhoa();
            }
            case 1 -> {
                return khoa.getTenKhoa();
            }
            case 2 -> {
                return khoa.getNgayThanhLap();
            }
            case 3 -> {
                return khoa.getSoLuongGiangVien();
            }
            case 4 -> {
                return khoa.getTruongKhoa();
            }
            default -> {
                return null;
            }
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Khoa khoa = this.danhSachKhoa.get(rowIndex);
        switch (columnIndex) {
            case 0 -> {
                khoa.setMaKhoa((String) aValue);
                break;
            }
            case 1 -> {
                khoa.setTenKhoa((String) aValue);
                break;
            }
            case 2 -> {
                khoa.setNgayThanhLap((Date) aValue);
                break;
            }
            case 3 -> {
                khoa.setSoLuongGiangVien((int) aValue);
                break;
            }
            case 4 -> {
                khoa.setTruongKhoa((String) aValue);
            }
        }
        try {
            Khoa khoaDuocLayTuDatabase = this.databaseKhoa.getDanhSachKhoa().get(rowIndex);
            this.danhSachKhoa = this.databaseKhoa.suaThongTinKhoaTrucTiepTrenBang(khoa, khoaDuocLayTuDatabase.getMaKhoa());
            this.databaseKhoa.setGiaTriDeSuaChuaBangHocVien(khoa.getMaKhoa(), rowIndex, khoaDuocLayTuDatabase.getMaKhoa());

        } catch (SQLException ex) {
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex != 3;
    }

    @Override
    public String getColumnName(int column) {
        return this.columns[column];
    }

}
