/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;

import Database.DatabaseGiaoVien;
import ModelGiaoVien.GiaoVien;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class DataGiaoVien {

    private final DatabaseGiaoVien databaseGiaoVien;
    private ArrayList<GiaoVien> danhSachGiaoVien;

    public DataGiaoVien() throws SQLException {
        this.danhSachGiaoVien = new ArrayList<>();
        this.databaseGiaoVien = new DatabaseGiaoVien(this.danhSachGiaoVien);
    }

    public void setDataGiaoVien(ArrayList<GiaoVien> danhSachGiaoVien) {
        this.danhSachGiaoVien = danhSachGiaoVien;
    }

    public ArrayList getDataGiaoVien() {
        return this.danhSachGiaoVien;
    }

    public ArrayList<GiaoVien> themGiaoVien(ArrayList<Object> thongTinInputGiaoVien) throws SQLException {
        this.danhSachGiaoVien = this.databaseGiaoVien.themGiaoVien(thongTinInputGiaoVien);
        return this.danhSachGiaoVien;
    }

    public Object[][] capNhapDanhSachGiaoVien() {
        Object[][] data = new Object[this.danhSachGiaoVien.size()][9];
        for (int i = 0; i <= this.danhSachGiaoVien.size() - 1; i++) {
            for (int j = 0; j <= 8; j++) {
                data[i][j] = this.danhSachGiaoVien.get(i).getData()[j];
            }
        }

        return data;
    }

    public Object[][] capNhapDanhSachGiaoVien(ArrayList<GiaoVien> giaoVienDuocTimThay) {
        Object[][] data = new Object[giaoVienDuocTimThay.size()][9];
        for (int i = 0; i <= giaoVienDuocTimThay.size() - 1; i++) {
            for (int j = 0; j <= 8; j++) {
                data[i][j] = giaoVienDuocTimThay.get(i).getData()[j];
            }
        }

        return data;
    }

    public ArrayList<GiaoVien> xoaGiaoVien(int[] cacChiSoBangGiaoVienDuocChon) throws SQLException {
        for (int i = cacChiSoBangGiaoVienDuocChon.length - 1; 0 <= i; i--) {
            this.danhSachGiaoVien = this.databaseGiaoVien.xoaGiaoVien(this.danhSachGiaoVien.get(cacChiSoBangGiaoVienDuocChon[i]));
        }
        return this.danhSachGiaoVien;
    }

    public ArrayList<GiaoVien> suaThongTinGiaoVien(ArrayList<Object> thongTinInputGiaoVien, int i) throws SQLException {
        this.danhSachGiaoVien = this.databaseGiaoVien.suaThongTinGiaoVien(thongTinInputGiaoVien, this.danhSachGiaoVien.get(i).getMaGv());
        return this.danhSachGiaoVien;
    }

    public ArrayList<GiaoVien> suaThongTinGiaoVienTrucTiepTrenBang(GiaoVien giaoVienDuocTimThay, int rowIndex) throws SQLException {
        System.out.println("test dong 74 dataGiaoVien, ma giao vien duoc tim thay:" + giaoVienDuocTimThay.getMaGiaoVien());
        System.out.println("this.danhSachGiaoVien.get(rowIndex).getMaGv():" + this.danhSachGiaoVien.get(rowIndex).getMaGv());
        for (GiaoVien giaoVien : this.danhSachGiaoVien) {
            if (giaoVien.getMaGiaoVien().equalsIgnoreCase(giaoVienDuocTimThay.getMaGiaoVien())) {
                System.out.println("test dong 74 dataGiaoVien, ma giao vien duoc tim thay:" + giaoVienDuocTimThay.getMaGiaoVien());
                System.out.println("this.danhSachGiaoVien.get(rowIndex).getMaGv():" + giaoVien.getMaGv());
                this.danhSachGiaoVien = this.databaseGiaoVien.suaThongTinGiaoVienTrucTiepTrenBang(giaoVienDuocTimThay, giaoVien.getMaGv());
            }

        }
        return this.danhSachGiaoVien;
    }

    public ArrayList<GiaoVien> suaThongTinGiaoVienKhiTimKiemBangInput(ArrayList<Object> thongTinInputGiaoVien, String maGiaoVien) throws SQLException {
        ArrayList<GiaoVien> danhSachGiaoVienDuocSua = new ArrayList<>();
        this.danhSachGiaoVien = this.databaseGiaoVien.suaThongTinGiaoVienDuocTimKiemBangInput(thongTinInputGiaoVien, maGiaoVien);
        System.out.println("Thong tin ma giao vien khi duoc sua:" + (String) thongTinInputGiaoVien.get(0));
        System.out.println("Thong tin ma giao vien khi chua duoc sua:" + maGiaoVien);
        for (GiaoVien giaoVien : this.danhSachGiaoVien) {
            if (giaoVien.getMaGiaoVien().equalsIgnoreCase((String) thongTinInputGiaoVien.get(0))) {
                danhSachGiaoVienDuocSua.add(giaoVien);
            }
        }
        return danhSachGiaoVienDuocSua;
    }

    public ArrayList timGiaoVienTheoMa(String maGiaoVienDuocTim) throws SQLException {
        ArrayList<GiaoVien> giaoVienDuocTimThayTheoMa = this.databaseGiaoVien.timGiaoVienTheoMa(maGiaoVienDuocTim);
        return giaoVienDuocTimThayTheoMa;
    }

    public ArrayList suaThongTinGiaoVienTrucTiepTrenBang(GiaoVien giaoVienDuocTimThay) throws SQLException {
        ArrayList<GiaoVien> danhSachGiaoVienDuocSua = new ArrayList<>();
  
        for (GiaoVien giaoVien : this.danhSachGiaoVien) {
            System.out.println("test dong 102 DataGiaoVien");
            if ((giaoVien.getMaGiaoVien()).equalsIgnoreCase(giaoVienDuocTimThay.getMaGiaoVien())) {
                danhSachGiaoVienDuocSua = this.databaseGiaoVien.suaThongTinGiaoVienTrucTiepTrenBang(giaoVienDuocTimThay, giaoVien.getMaGiaoVien());
            }
        }

        return danhSachGiaoVienDuocSua;
    }

    public ArrayList<GiaoVien> xoaGiaoVienDuocTimKiem(String maHocVienCanXoa) throws SQLException {
        ArrayList<GiaoVien> giaoVienDuocXoa = new ArrayList<>();
        this.danhSachGiaoVien = this.databaseGiaoVien.xoaGiaoVienDuocTimKiem(maHocVienCanXoa);
        return giaoVienDuocXoa;
    }

    public Object[][] tinhLuongGiaoVien() throws SQLException {
        for (GiaoVien giaoVien : this.danhSachGiaoVien) {
            giaoVien.tinhLuong();
        }
        ArrayList<GiaoVien> cacGiaoVienDuocTinhLuong = new ArrayList<>();
        for (GiaoVien giaoVien : this.danhSachGiaoVien) {
            cacGiaoVienDuocTinhLuong.add(this.databaseGiaoVien.capNhapLuongGiaoVien(giaoVien.getMaGv(), giaoVien.getLuong()));
        }
        System.out.println("Luong cua giao vien dau tien:" + cacGiaoVienDuocTinhLuong.get(0).getLuong());
        this.danhSachGiaoVien = cacGiaoVienDuocTinhLuong;
        Object[][] data = this.capNhapDanhSachGiaoVien();
        return data;
    }

}
