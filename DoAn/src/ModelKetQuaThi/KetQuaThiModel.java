/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModelKetQuaThi;

import Database.DatabaseKetQuaThi;
import ModelHocVien.HocVien;
import ModelHocVien.HocVienModel;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
    private final HocVienModel modelHocVien;

    public KetQuaThiModel() throws SQLException {
        this.danhSachKetQuaThi = new ArrayList<>();
        this.databaseKetQuaThi = new DatabaseKetQuaThi();
        this.modelHocVien = new HocVienModel();
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

    public Object[][] timKiemketQuaThi(ArrayList<Object> inputBangKetQuaThi, ArrayList<KetQuaThi> ketQuaThiDuocTimThay) {

        for (KetQuaThi ketQuaThi : this.danhSachKetQuaThi) {
            if (ketQuaThi.getMaHocVien().equalsIgnoreCase((String) inputBangKetQuaThi.get(0)) && ketQuaThi.getMaMonHoc().equalsIgnoreCase((String) inputBangKetQuaThi.get(1))) {
                ketQuaThiDuocTimThay.add(ketQuaThi);
                Object[][] data = this.capNhapDataKetQuaThi(ketQuaThiDuocTimThay);
                return data;
            }
        }
        for (KetQuaThi ketQuaThi : this.danhSachKetQuaThi) {
            if (ketQuaThi.getMaHocVien().equalsIgnoreCase((String) inputBangKetQuaThi.get(0))) {
                ketQuaThiDuocTimThay.add(ketQuaThi);
            }
        }
        if (ketQuaThiDuocTimThay.isEmpty()) {
            return null;
        }
        Object[][] data = this.capNhapDataKetQuaThi(ketQuaThiDuocTimThay);
        return data;
    }

    public ArrayList<KetQuaThi> timThayKetQuaThi(ArrayList<Object> inputBangKetQuaThi) {
        ArrayList<KetQuaThi> ketQuaThiDuocTimThay = new ArrayList<>();
        for (KetQuaThi ketQuaThi : this.danhSachKetQuaThi) {
            if (ketQuaThi.getMaHocVien().equalsIgnoreCase((String) inputBangKetQuaThi.get(0)) && ketQuaThi.getMaMonHoc().equalsIgnoreCase((String) inputBangKetQuaThi.get(1))) {
                ketQuaThiDuocTimThay.add(ketQuaThi);
                return ketQuaThiDuocTimThay;
            }
        }
        for (KetQuaThi ketQuaThi : this.danhSachKetQuaThi) {
            if (ketQuaThi.getMaHocVien().equalsIgnoreCase((String) inputBangKetQuaThi.get(0))) {
                ketQuaThiDuocTimThay.add(ketQuaThi);
            }
        }
        return ketQuaThiDuocTimThay;
    }

    public Object[][] themKetQuaThiKhiTimKiem(ArrayList<Object> inputBangKetQuaThi, ArrayList<Object> ketQuaInputDeThemKetQuaThi) throws SQLException, ParseException {
        ArrayList<KetQuaThi> ketQuaThiDuocTimThay = this.timThayKetQuaThi(inputBangKetQuaThi);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date date = simpleDateFormat.parse((String) ketQuaInputDeThemKetQuaThi.get(3));
        ketQuaThiDuocTimThay.add(new KetQuaThi((String) ketQuaInputDeThemKetQuaThi.get(0), (String) ketQuaInputDeThemKetQuaThi.get(1), Integer.parseInt((String) ketQuaInputDeThemKetQuaThi.get(2)), date, Float.parseFloat((String) ketQuaInputDeThemKetQuaThi.get(4)), " "));
        this.danhSachKetQuaThi = this.databaseKetQuaThi.themKetQuaThi(ketQuaInputDeThemKetQuaThi);
        Object[][] data = this.capNhapDataKetQuaThi(ketQuaThiDuocTimThay);
        return data;

    }

    public Object[][] xoaKetQuaThi(int[] rows) throws SQLException {
        for (int i = rows.length - 1; 0 <= i; i--) {
            this.danhSachKetQuaThi = this.databaseKetQuaThi.xoaKetQuaThi(this.danhSachKetQuaThi.get(rows[i]).getMaHocVien(), this.danhSachKetQuaThi.get(rows[i]).getMaMonHoc());
        }
        Object[][] data = this.capNhapDataKetQuaThi();
        return data;
    }

    public Object[][] xoaKetQuaThiDuocTimThay(ArrayList<Object> inputBangKetQuaThi, int[] rows) throws SQLException {
        ArrayList<KetQuaThi> ketQuaThiDuocTimThay = this.timThayKetQuaThi(inputBangKetQuaThi);
        for (int i = rows.length - 1; 0 <= i; i--) {
            for (KetQuaThi ketQuaThi : this.danhSachKetQuaThi) {
                if (ketQuaThiDuocTimThay.get(i).getMaHocVien().equalsIgnoreCase(ketQuaThi.getMaHocVien())
                        && ketQuaThiDuocTimThay.get(i).getMaMonHoc().equalsIgnoreCase(ketQuaThi.getMaMonHoc())) {
                    this.danhSachKetQuaThi = this.databaseKetQuaThi.xoaKetQuaThi(ketQuaThi.getMaHocVien(), ketQuaThi.getMaMonHoc());

                }

            }
            ketQuaThiDuocTimThay.remove(ketQuaThiDuocTimThay.get(i));
        }
        Object[][] data = this.capNhapDataKetQuaThi(ketQuaThiDuocTimThay);
        return data;
    }

    public Object[][] xoaHetKetQuaThi() throws SQLException {
        this.danhSachKetQuaThi = this.databaseKetQuaThi.xoaHetKetQuaThi();
        Object[][] data = this.capNhapDataKetQuaThi();
        return data;
    }

    public Object[][] xoaHetKetQuaThiDuocTimKiem(ArrayList<Object> inputBangKetQuaThi) throws SQLException {
        ArrayList<KetQuaThi> ketQuaThiDuocTimKiem = this.timThayKetQuaThi(inputBangKetQuaThi);
        for (int i = 0; i <= ketQuaThiDuocTimKiem.size() - 1; i++) {
            for (KetQuaThi ketQuaThi : this.danhSachKetQuaThi) {
                if (ketQuaThi.getMaHocVien().equalsIgnoreCase(ketQuaThiDuocTimKiem.get(i).getMaHocVien())
                        && ketQuaThi.getMaMonHoc().equalsIgnoreCase(ketQuaThiDuocTimKiem.get(i).getMaMonHoc())) {
                    this.danhSachKetQuaThi = this.databaseKetQuaThi.xoaKetQuaThi(ketQuaThi.getMaHocVien(), ketQuaThi.getMaMonHoc());
                }
            }
        }
        for (int i = ketQuaThiDuocTimKiem.size() - 1; 0 <= i; i--) {
            ketQuaThiDuocTimKiem.remove(i);
        }
        Object[][] data = this.capNhapDataKetQuaThi(ketQuaThiDuocTimKiem);
        return data;
    }

    public Object[][] capNhapKetQua() throws SQLException {
        for (KetQuaThi ketQuathi : this.danhSachKetQuaThi) {
            ketQuathi.capNhapKetQua();
            this.danhSachKetQuaThi = this.databaseKetQuaThi.capNhapKetQuaThi(ketQuathi.getMaHocVien(), ketQuathi.getMaMonHoc(), ketQuathi.getKetQua());
        }
        Object[][] data = this.capNhapDataKetQuaThi();
        return data;
    }

    public ArrayList<KetQuaThi> getDanhSachKetQuaThi() {
        return danhSachKetQuaThi;
    }

    public ArrayList<String> getMaMonHoc() throws SQLException {
        ArrayList<String> danhSachMaMonHoc = this.databaseKetQuaThi.getMaMonHoc();
        return danhSachMaMonHoc;
    }

    public Object[][] tinhDiemTrungbinh() throws SQLException {
        ArrayList<HocVien> danhSachHocVien = this.modelHocVien.getHocVien();
        ArrayList<ArrayList> ketQuaTongThe = new ArrayList<>();
        String ketQuaXepLoai = null;
        for (HocVien hocVien : danhSachHocVien) {
            ArrayList<Object> ketQuaTungHocVien = new ArrayList<>();
            int count = 0;
            float tong = 0;
            for (KetQuaThi ketQuaThi : this.danhSachKetQuaThi) {
                if (hocVien.getMaHocVien().equalsIgnoreCase(ketQuaThi.getMaHocVien())) {
                    count++;
                    tong += ketQuaThi.getDiem();
                }
            }
            if (count != 0) {
                float diemTrungBinh = tong / count;
                double scale = Math.pow(10, 1);
                double result = Math.ceil(diemTrungBinh * scale) / scale;
                if (diemTrungBinh >= 8) {
                    ketQuaXepLoai = "Gioi";
                } else if (diemTrungBinh >= 7.0) {
                    ketQuaXepLoai = "Kha";
                } else if (diemTrungBinh >= 5) {
                    ketQuaXepLoai = "Trung binh";
                } else if (diemTrungBinh >= 3.5) {
                    ketQuaXepLoai = "Duoi trung binh";
                } else {
                    ketQuaXepLoai = "Yeu";
                }
                ketQuaTungHocVien.add(hocVien.getMaHocVien());
                ketQuaTungHocVien.add(result);
                ketQuaTungHocVien.add(ketQuaXepLoai);
                ketQuaTongThe.add(ketQuaTungHocVien);
            }

        }
        Object[][] data = new Object[ketQuaTongThe.size()][3];
        for (int i = 0; i <= ketQuaTongThe.size() - 1; i++) {
            for (int j = 0; j <= 2; j++) {
                data[i][j] = ketQuaTongThe.get(i).get(j);
            }
        }
        return data;
    }

    public String[] getColumn() {
        return column;
    }

    public Object[][] themKetQuaThi(ArrayList<Object> ketQuaInputDeThemKetQuaThi) throws SQLException {
        this.danhSachKetQuaThi = this.databaseKetQuaThi.themKetQuaThi(ketQuaInputDeThemKetQuaThi);
        Object[][] data = this.capNhapDataKetQuaThi();
        return data;
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
