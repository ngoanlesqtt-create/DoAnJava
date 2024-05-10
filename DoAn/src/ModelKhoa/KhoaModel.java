/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModelKhoa;

import Database.DatabaseKhoa;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author PC
 */
public class KhoaModel extends AbstractTableModel {

    private ArrayList<Khoa> danhSachKhoa;
    private DatabaseKhoa databaseKhoa;
    private String[] column = {"Mã khoa", "Tên khoa", "Ngày thành lập", "Số lượng giáo viên", "Trưởng khoa"};

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

    public String[] getColumn() {
        return this.column;
    }

    public ArrayList getMaGiaoVien() throws SQLException {
        ArrayList<String> danhSachMaGiaoVien = this.databaseKhoa.getMaGiaoVien();
        return danhSachMaGiaoVien;
    }

    public ArrayList getMaGiaoVienDangLaChuNhiemKhoa() throws SQLException {
        ArrayList<String> danhSachMaGiaoVienDangLaChuNhiemKhoa = this.databaseKhoa.getMaGiaoVienDangLaChuNhiemKhoa();
        return danhSachMaGiaoVienDangLaChuNhiemKhoa;
    }

    @Override
    public int getRowCount() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int getColumnCount() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
