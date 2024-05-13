/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModelKetQuaThi;

import Database.DatabaseKetQuaThi;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author PC
 */
public class KetQuaThiModel extends AbstractTableModel {

    private ArrayList<KetQuaThi> danhSachKetQuaThi;
    private final DatabaseKetQuaThi databaseKetQuaThi;
    private final String[] column = {"Mã học viên", "Mã môn học", "Lần thi", "Ngày thi", "Điểm", "Kết quả"};

    public KetQuaThiModel() {
        this.danhSachKetQuaThi = new ArrayList<>();
        this.databaseKetQuaThi = new DatabaseKetQuaThi();
    }

    private Object[][] capNhapDataKetQuaThi() {
        Object[][] data = new Object[this.danhSachKetQuaThi.size()][6];
        for (int i = 0; i <= this.danhSachKetQuaThi.size() - 1; i++) {
            for (int j = 0; j <= 5; j++) {
                data[i][j] = this.danhSachKetQuaThi.get(i).getData()[j];
            }
        }

        return data;
    }

    private Object[][] capNhapDataKetQuaThi(ArrayList<KetQuaThi> ketQuaThiDuocTimThay) {
        Object[][] data = new Object[ketQuaThiDuocTimThay.size()][6];
        for (int i = 0; i <= ketQuaThiDuocTimThay.size() - 1; i++) {
            for (int j = 0; j <= 5; j++) {
                data[i][j] = ketQuaThiDuocTimThay.get(i).getData()[j];
            }
        }

        return data;
    }

    public Object[][] loadDataketQuaThi() throws SQLException {
        ArrayList<Object> cacGiaTriDeSuaMaHocVien = this.databaseKetQuaThi.getGiaTriDeSuaChuabangHocVien();
        this.danhSachKetQuaThi = this.databaseKetQuaThi.loadDataKetQuaThi();
        for (KetQuaThi ketQuaThi : this.danhSachKetQuaThi) {
            if (ketQuaThi.getMaHocVien().equalsIgnoreCase((String) cacGiaTriDeSuaMaHocVien.get(2))) {
                this.danhSachKetQuaThi = this.databaseKetQuaThi.suaMaHocVien((String) cacGiaTriDeSuaMaHocVien.get(1), (String) cacGiaTriDeSuaMaHocVien.get(2));
            }
        }
        Object[][] data = this.capNhapDataKetQuaThi();
        return data;
    }

    public Object[][] suaMaHocVienTheoBangKhoa() throws SQLException {
        String maHocVienSauKhiCapNhap = "";
        ArrayList<Object> cacGiaTriDeSuaMaHocVien = this.databaseKetQuaThi.getGiaTriDeSuaChuabangHocVien();
        this.danhSachKetQuaThi = this.databaseKetQuaThi.loadDataKetQuaThi();
        for (KetQuaThi ketQuaThi : danhSachKetQuaThi) {
            if (ketQuaThi.getMaHocVien().contains((String) cacGiaTriDeSuaMaHocVien.get(1))) {
                maHocVienSauKhiCapNhap = ketQuaThi.getMaHocVien().replaceFirst((String) cacGiaTriDeSuaMaHocVien.get(1), (String) cacGiaTriDeSuaMaHocVien.get(2));
                this.danhSachKetQuaThi = this.databaseKetQuaThi.suaMaHocVien(maHocVienSauKhiCapNhap, ketQuaThi.getMaHocVien());
            }
        }
        Object[][] data = this.capNhapDataKetQuaThi();
        return data;
    }

    public Object[][] ketQuaThiDuocTimKiem(ArrayList<Object> inputBangKetQuaThi) {
        ArrayList<KetQuaThi> ketQuaThiDuocTimThay = new ArrayList<>();
        for (KetQuaThi ketQuaThi : this.danhSachKetQuaThi) {
            if (ketQuaThi.getMaHocVien().equalsIgnoreCase((String) inputBangKetQuaThi.get(0)) && ketQuaThi.getMaMonHoc().contains((String) inputBangKetQuaThi.get(1))) {
                ketQuaThiDuocTimThay.add(ketQuaThi);
                Object[][] data = this.capNhapDataKetQuaThi(ketQuaThiDuocTimThay);
                return data;
            } else if (ketQuaThi.getMaHocVien().contains((String) inputBangKetQuaThi.get(0)) && !ketQuaThi.getMaMonHoc().contains((String) inputBangKetQuaThi.get(1))) {
                ketQuaThiDuocTimThay.add(ketQuaThi);
            }
        }
        if (ketQuaThiDuocTimThay.isEmpty()) {
            return null;
        }
        Object[][] data = this.capNhapDataKetQuaThi(ketQuaThiDuocTimThay);
        return data;
    }

    public ArrayList<KetQuaThi> getDanhSachKetQuaThi() {
        return danhSachKetQuaThi;
    }

    public ArrayList<String> getMaMonHoc() throws SQLException {
        ArrayList<String> danhSachMaMonHoc = this.databaseKetQuaThi.getMaMonHoc();
        return danhSachMaMonHoc;
    }

    public String[] getColumn() {
        return column;
    }

    @Override
    public int getRowCount() {
        return this.danhSachKetQuaThi.size();
    }

    @Override
    public int getColumnCount() {
        return this.column.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        KetQuaThi ketQuaThi = this.danhSachKetQuaThi.get(rowIndex);
        switch (columnIndex) {
            case 0 -> {
                return ketQuaThi.getMaHocVien();
            }
            case 1 -> {
                return ketQuaThi.getMaMonHoc();
            }
            case 2 -> {
                return ketQuaThi.getLanThi();
            }
            case 3 -> {
                return ketQuaThi.getNgayThi();
            }
            case 4 -> {
                return ketQuaThi.getDiem();
            }
            case 5 -> {
                return ketQuaThi.getKetQua();
            }
            default -> {
                return null;
            }
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        KetQuaThi ketQuaThi = this.danhSachKetQuaThi.get(rowIndex);
        switch (columnIndex) {
            case 0 -> {
                ketQuaThi.setMaHocVien((String) aValue);
            }
            case 1 -> {
                ketQuaThi.setMaMonHoc((String) aValue);
            }
            case 2 -> {
                ketQuaThi.setLanThi(Integer.parseInt((String) aValue));
            }
            case 3 -> {
                ketQuaThi.setNgayThi((Date) aValue);
            }
            case 4 -> {
                ketQuaThi.setDiem((float) aValue);
            }
            case 5 -> {
                ketQuaThi.setKetQua((String) aValue);
            }
        }
        try {
            this.danhSachKetQuaThi = this.databaseKetQuaThi.suaThongTinKetQuaThi(ketQuaThi, this.danhSachKetQuaThi.get(rowIndex).getMaHocVien(), this.danhSachKetQuaThi.get(rowIndex).getMaMonHoc());
        } catch (SQLException ex) {
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return !(columnIndex == 0 || columnIndex == 1);
    }

    @Override
    public String getColumnName(int column) {
        return this.column[column];
    }

}
