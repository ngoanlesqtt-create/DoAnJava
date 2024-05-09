/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

import ModelGiaoVien.CuNhan;
import ModelGiaoVien.GiaoVien;
import ModelGiaoVien.ThacSy;
import ModelGiaoVien.TienSy;
import ModelHocVien.HocVien;
import ModelLop.LopHoc;
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
public class DatabaseLopHoc {

    private SQLServerDataSource ds;

    public DatabaseLopHoc(ArrayList<LopHoc> danhSachLopHoc) throws SQLException {
        ds = new SQLServerDataSource();
        ds.setUser("sa");
        ds.setPassword("1");
        ds.setServerName("localhost");
        ds.setPortNumber(Integer.parseInt("1433"));
        ds.setDatabaseName("BAITAP2");

        try {
            Connection con = ds.getConnection();
            CallableStatement cstmt = con.prepareCall("select * from Lop");
            ResultSet rs = cstmt.executeQuery();

            while (rs.next()) {
                danhSachLopHoc.add(new LopHoc(rs.getString("MALOP"), rs.getString("TENLOP"), rs.getString("TRGLOP"), rs.getInt("SISO"), rs.getString("MAGVCN")));
            }
        } catch (SQLServerException ex) {
            System.out.println("Loi dong 42 DatabaseLopHoc:" + ex);
        }
    }

    public ArrayList getDanhSachHocVien() throws SQLException {
        ArrayList<HocVien> danhSachHocVien = new ArrayList<>();
        ds = new SQLServerDataSource();
        ds.setUser("sa");
        ds.setPassword("1");
        ds.setServerName("localhost");
        ds.setPortNumber(Integer.parseInt("1433"));
        ds.setDatabaseName("BAITAP2");

        try {
            Connection con = ds.getConnection();
            CallableStatement cstmt = con.prepareCall("select * from hocvien");
            ResultSet rs = cstmt.executeQuery();

            while (rs.next()) {
                danhSachHocVien.add(new HocVien(rs.getString("MAHV"), rs.getString("HO"), rs.getString("TEN"), rs.getDate("NGSINH"), rs.getString("GIOITINH"), rs.getString("NOISINH"), rs.getString("MALOP")));
            }
        } catch (SQLServerException ex) {
        }

        return danhSachHocVien;
    }

    public ArrayList getDanhSachGiaoVien() throws SQLException {
        ArrayList<GiaoVien> danhSachGiaoVien = new ArrayList<>();
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
                if (rs.getString("HOCVI").equalsIgnoreCase("CN")) {
                    danhSachGiaoVien.add(new CuNhan(
                            rs.getString("MAGV"),
                            rs.getString("HOTEN"),
                            rs.getString("HOCVI"),
                            rs.getString("GIOITINh"),
                            rs.getDate("NGSINH"),
                            rs.getFloat("HESO"),
                            rs.getFloat("LuongCB"),
                            rs.getFloat("MUCLUONG"),
                            rs.getString("MAKHOA")));
                } else if (rs.getString("HOCVI").equalsIgnoreCase("Ths")) {
                    danhSachGiaoVien.add(new ThacSy(
                            rs.getString("MAGV"),
                            rs.getString("HOTEN"),
                            rs.getString("HOCVI"),
                            rs.getString("GIOITINh"),
                            rs.getDate("NGSINH"),
                            rs.getFloat("HESO"),
                            rs.getFloat("LuongCB"),
                            rs.getFloat("MUCLUONG"),
                            rs.getString("MAKHOA")));
                } else if (rs.getString("HOCVI").equalsIgnoreCase("TS")) {
                    danhSachGiaoVien.add(new TienSy(
                            rs.getString("MAGV"),
                            rs.getString("HOTEN"),
                            rs.getString("HOCVI"),
                            rs.getString("GIOITINh"),
                            rs.getDate("NGSINH"),
                            rs.getFloat("HESO"),
                            rs.getFloat("LuongCB"),
                            rs.getFloat("MUCLUONG"),
                            rs.getString("MAKHOA")));
                }
            }
        } catch (SQLServerException ex) {
            System.out.println("Hello dong 48 DatabaseGiaoVien");
            System.out.println("loi:" + ex);
        }
        return danhSachGiaoVien;
    }

    public ArrayList themLopHoc(ArrayList<Object> inputLopHoc) throws SQLException {
        ArrayList<LopHoc> lopHocDuocThem = new ArrayList<>();
        ds = new SQLServerDataSource();
        ds.setUser("sa");
        ds.setPassword("1");
        ds.setServerName("localhost");
        ds.setPortNumber(Integer.parseInt("1433"));
        ds.setDatabaseName("BAITAP2");
        try {
            Connection con = ds.getConnection();
            CallableStatement cstmt = con.prepareCall("INSERT INTO LOP VALUES('"
                    + inputLopHoc.get(0) + "','"
                    + inputLopHoc.get(1) + "',"
                    + "'',"
                    + 0 + ",'"
                    + inputLopHoc.get(3) + "')"
                    + "select * from Lop");
            ResultSet rs = cstmt.executeQuery();

            while (rs.next()) {
                lopHocDuocThem.add(new LopHoc(rs.getString("MALOP"), rs.getString("TENLOP"), rs.getString("TRGLOP"), rs.getInt("SISO"), rs.getString("MAGVCN")));
            }
        } catch (SQLServerException ex) {
            System.out.println("Loi dong 145 DatabaseLopHoc:" + ex);
            return null;
        }
        return lopHocDuocThem;
    }
}
