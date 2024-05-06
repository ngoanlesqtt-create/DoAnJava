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
        System.out.println(" this.danhSachGiaoVien==null" + this.danhSachGiaoVien == null);
    }
    
    public ArrayList getDataGiaoVien() {
        return this.danhSachGiaoVien;
    }
    
    public ArrayList<GiaoVien> themGiaoVien(ArrayList<Object> thongTinInputGiaoVien) throws SQLException {
        this.danhSachGiaoVien = this.databaseGiaoVien.themGiaoVien(thongTinInputGiaoVien);
        return danhSachGiaoVien;
    }
    
    public ArrayList<GiaoVien> xoaGiaoVien(int[] cacChiSoBangGiaoVienDuocChon) throws SQLException {
        for (int i = cacChiSoBangGiaoVienDuocChon.length - 1; 0 <= i; i--) {
            this.danhSachGiaoVien = this.databaseGiaoVien.xoaGiaoVien(this.danhSachGiaoVien.get(cacChiSoBangGiaoVienDuocChon[i]));
        }
        return this.danhSachGiaoVien;
    }
}
