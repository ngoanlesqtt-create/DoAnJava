/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModelGiaoVien;

import Data.DataGiaoVien;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author PC
 */
public class GiaoVienModel extends AbstractTableModel {

    private ArrayList<GiaoVien> danhSachGiaoVien = new ArrayList<>();
    private final String[] columnNames = {"Mã giáo viên", "Họ tên", "Học vị", "Giới tính", "Ngày sinh", "Hệ số", "Lương cơ bản", "Lương", "Khoa"};
    private final DataGiaoVien dataGiaoVien;

    public GiaoVienModel(ArrayList<GiaoVien> danhSachGiaoVien) throws SQLException {
        this.dataGiaoVien = new DataGiaoVien();
        this.danhSachGiaoVien = danhSachGiaoVien;
    }

    public void setDanhSachGiaoVien(ArrayList<GiaoVien> giaoVien) {
        this.danhSachGiaoVien = giaoVien;
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
        return columnNames[column];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if (columnIndex == 0) {
            return false;
        }
        if (columnIndex == 4) {
            return false;
        }
        if (columnIndex == 7) {
            return false;
        }
        return columnIndex != 8;
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
                return giaoVien.getHeSo();
            }
            case 6 -> {
                return giaoVien.getLuongCoBan();
            }
            case 7 -> {
                return giaoVien.getLuong();
            }
            case 8 -> {
                return giaoVien.getMaKhoa();
            }
            default -> {
                return null;
            }
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        GiaoVien giaoVien = this.danhSachGiaoVien.get(rowIndex);
        switch (columnIndex) {
            case 1 -> {
                try {
                    giaoVien.setHoTen((String) aValue);
                    this.danhSachGiaoVien = this.dataGiaoVien.suaThongTinGiaoVienTrucTiepTrenBang(giaoVien, rowIndex);

                } catch (SQLException ex) {
                }
                break;
            }
            case 2 -> {
                try {
                    giaoVien.setHocVi((String) aValue);
                    this.danhSachGiaoVien = this.dataGiaoVien.suaThongTinGiaoVienTrucTiepTrenBang(giaoVien, rowIndex);
                } catch (SQLException ex) {
                }
                break;
            }
            case 3 -> {
                try {
                    giaoVien.setGioiTinh((String) aValue);
                    this.dataGiaoVien.suaThongTinGiaoVienTrucTiepTrenBang(giaoVien, rowIndex);
                } catch (SQLException ex) {
                }
                break;
            }

            case 5 -> {
                try {
                    giaoVien.setHeSo(Float.parseFloat((String) aValue));
                    System.out.println("Hello dong 131 GiaoVienModel,rowIndex: " + rowIndex);
                    this.dataGiaoVien.suaThongTinGiaoVienTrucTiepTrenBang(giaoVien, rowIndex);
                } catch (SQLException ex) {
                }
                break;
            }
            case 6 -> {
                try {
                    giaoVien.setLuongCoBan(Float.parseFloat((String) aValue));
                    this.dataGiaoVien.suaThongTinGiaoVienTrucTiepTrenBang(giaoVien, rowIndex);
                } catch (SQLException ex) {
                }

                break;
            }

        }
    }

}
