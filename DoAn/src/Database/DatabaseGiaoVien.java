/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

import ModelGiaoVien.GiaoVien;
import ModelHocVien.HocVien;
import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class DatabaseGiaoVien {

    private SQLServerDataSource ds;

    public DatabaseGiaoVien(ArrayList<GiaoVien> danhSachGiaoVien) throws SQLException {
        ds = new SQLServerDataSource();
        ds.setUser("sa");
        ds.setPassword("1");
        ds.setServerName("localhost");
        ds.setPortNumber(Integer.parseInt("1433"));
        ds.setDatabaseName("BAITAP2");
        try {
            Connection con = ds.getConnection();
            CallableStatement cstmt = con.prepareCall("select * from GIAOVIEN");
            ResultSet rs = cstmt.executeQuery();
            while (rs.next()) {
                danhSachGiaoVien.add(new GiaoVien(
                        rs.getString("MAGV"),
                        rs.getString("HOTEN"),
                        rs.getString("HOCVI"),
                        rs.getString("GIOITINh"),
                        rs.getDate("NGSINH"),
                        rs.getFloat("LuongCB"),
                        rs.getFloat("HESO"),
                        rs.getFloat("MUCLUONG"),
                        rs.getString("MAKHOA")));
            }
        } catch (SQLServerException ex) {
            System.out.println("loi:" + ex);
        }
    }

    public ArrayList<GiaoVien> themGiaoVien(ArrayList<Object> thongTinInputGiaoVien) throws SQLException {
        ArrayList<GiaoVien> cacGiaoVienDuocThemVao = new ArrayList<>();
        ds = new SQLServerDataSource();
        ds.setUser("sa");
        ds.setPassword("1");
        ds.setServerName("localhost");
        ds.setPortNumber(Integer.parseInt("1433"));
        ds.setDatabaseName("BAITAP2");
        String ngayThangNamSinh = (String) thongTinInputGiaoVien.get(0) + "/"
                + (String) thongTinInputGiaoVien.get(0) + "/"
                + (String) thongTinInputGiaoVien.get(0);
        try {
            Connection con = ds.getConnection();
            CallableStatement cstmt = con.prepareCall("select * from GIAOVIEN");
            ResultSet rs = cstmt.executeQuery();
            while (rs.next()) {
                cacGiaoVienDuocThemVao.add(new GiaoVien(
                        rs.getString("MAGV"),
                        rs.getString("HOTEN"),
                        rs.getString("HOCVI"),
                        rs.getString("GIOITINh"),
                        rs.getDate("NGSINH"),
                        rs.getFloat("LuongCB"),
                        rs.getFloat("HESO"),
                        rs.getFloat("MUCLUONG"),
                        rs.getString("MAKHOA")));
            }
        } catch (SQLServerException ex) {
            System.out.println("loi:" + ex);
        }
        return cacGiaoVienDuocThemVao;
    }
}
