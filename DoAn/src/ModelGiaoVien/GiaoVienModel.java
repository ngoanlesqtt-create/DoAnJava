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
    private final String[] column = {"Mã giáo viên", "Họ tên", "Học vị", "Giới tính", "Ngày sinh", "Lương cơ bản", "Mức lương", "Khoa"};

    public GiaoVienModel(ArrayList<GiaoVien> danhSachGiaoVien) {
        this.danhSachGiaoVien = danhSachGiaoVien;
    }

    @Override
    public int getRowCount() {
        return this.danhSachGiaoVien.size();
    }

    @Override
    public int getColumnCount() {
        return column.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
