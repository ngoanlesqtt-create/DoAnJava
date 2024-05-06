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

    public ArrayList getDataGiaoVien() {
        return this.danhSachGiaoVien;
    }

    public ArrayList<GiaoVien> themGiaoVien(ArrayList<Object> thongTinInputGiaoVien) throws SQLException {
        this.danhSachGiaoVien = this.databaseGiaoVien.themGiaoVien(thongTinInputGiaoVien);
        return danhSachGiaoVien;
    }
}
