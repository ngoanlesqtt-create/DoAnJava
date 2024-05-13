/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModelKetQuaThi;

import Database.DatabaseKetQuaThi;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author PC
 */
public class SubKetQuaThiModel extends AbstractTableModel {

    private ArrayList<KetQuaThi> danhSachKetQuaThi;
    private final String[] column = {"Mã học viên", "Mã môn học", "Lần thi", "Ngày thi", "Điểm", "Kết quả"};
    private DatabaseKetQuaThi databaseKetQuaThi;

    public SubKetQuaThiModel() {
        this.danhSachKetQuaThi = new ArrayList<>();
    }

    public void setDanhSachKetQuaThi(ArrayList<KetQuaThi> danhSachKetQuaThi) {
        this.danhSachKetQuaThi = danhSachKetQuaThi;
        this.databaseKetQuaThi = new DatabaseKetQuaThi();
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
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return !(columnIndex == 0 || columnIndex == 1);
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
                try {
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd-yyyy");
                    Date date = simpleDateFormat.parse((String) aValue);
                    ketQuaThi.setNgayThi(date);
                } catch (ParseException ex) {
                }
            }
            case 4 -> {
                ketQuaThi.setDiem(Float.parseFloat((String) aValue));
            }
            case 5 -> {
                ketQuaThi.setKetQua((String) aValue);
            }
        }
        try {
            ArrayList<KetQuaThi> danhSachKQT = this.databaseKetQuaThi.loadDataKetQuaThi();
            for (KetQuaThi ketQuaThiVongLap : danhSachKQT) {
                if (ketQuaThiVongLap.getMaHocVien().equalsIgnoreCase(ketQuaThi.getMaHocVien()) && ketQuaThiVongLap.getMaMonHoc().equalsIgnoreCase(ketQuaThi.getMaMonHoc())) {
                    this.databaseKetQuaThi.suaThongTinKetQuaThi(ketQuaThi, ketQuaThiVongLap.getMaHocVien(), ketQuaThiVongLap.getMaMonHoc());
                }
            }

        } catch (SQLException ex) {
        }
    }

    @Override
    public String getColumnName(int column) {
        return this.column[column];
    }

}
