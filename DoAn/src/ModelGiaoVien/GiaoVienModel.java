/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModelGiaoVien;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author PC
 */
public class GiaoVienModel extends AbstractTableModel {

    private final ArrayList<GiaoVien> danhSachGiaoVien;
    private final String[] columnNames = {"Mã giáo viên", "Họ tên", "Học vị", "Giới tính", "Ngày sinh", "Hệ số", "Lương cơ bản", "Lương", "Khoa"};

    public GiaoVienModel(ArrayList<GiaoVien> danhSachGiaoVien) {
        this.danhSachGiaoVien = danhSachGiaoVien;
    }

    @Override
    public int getRowCount() {
        return this.danhSachGiaoVien.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column]; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex != 0;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        GiaoVien giaoVien = this.danhSachGiaoVien.get(rowIndex);
        switch (columnIndex) {
            case 0 -> {
                return giaoVien.getMaGv();
            }
            case 1 -> {
                return giaoVien.getHoTen();
            }
            case 2 -> {
                return giaoVien.getHocVi();
            }
            case 3 -> {
                return giaoVien.getGioiTinh();
            }
            case 4 -> {
                return giaoVien.getNgaySinh();
            }
            case 5 -> {
                return giaoVien.getLuongCoBan();
            }
            case 6 -> {
                return giaoVien.getHeSo();
            }
            case 7 -> {
                return giaoVien.getMucLuong();
            }
            case 8 -> {
                return giaoVien.getMaKhoa();
            }
            default -> {
                return null;
            }
        }
    }

}
