/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

import ModelKhoa.Khoa;
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
public class DatabaseKhoa {

    private SQLServerDataSource ds;

    public DatabaseKhoa(ArrayList<Khoa> danhSachKhoa) throws SQLException {
        ds = new SQLServerDataSource();
        ds.setUser("sa");
        ds.setPassword("1");
        ds.setServerName("localhost");
        ds.setPortNumber(Integer.parseInt("1433"));
        ds.setDatabaseName("BAITAP2");
        try {
            Connection con = ds.getConnection();
            CallableStatement cstmt = con.prepareCall("select * from KHOA");
            ResultSet rs = cstmt.executeQuery();
            while (rs.next()) {
                danhSachKhoa.add(new Khoa(rs.getString("MAKHOA"), rs.getString("TENKHOA"), rs.getDate("NGTLAP"), rs.getInt("SOLUONGGIAOVIEN"), rs.getString("TRGKHOA")));
            }
        } catch (SQLServerException ex) {
            System.out.println("Loi dong 42 DatabaseLopHoc:" + ex);
        }
    }

    public ArrayList getMaGiaoVien() throws SQLException {
        ArrayList<String> danhSachMaGiaoVien = new ArrayList<>();
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
                danhSachMaGiaoVien.add(rs.getString("MAGV"));
            }
        } catch (SQLServerException ex) {
            System.out.println("Loi dong 60 DatabaseLopHoc:" + ex);
        }
        return danhSachMaGiaoVien;
    }

    public ArrayList getMaGiaoVienDangLaChuNhiemKhoa() throws SQLException {
        ArrayList<String> danhSachMaGiaoVien = new ArrayList<>();
        ds = new SQLServerDataSource();
        ds.setUser("sa");
        ds.setPassword("1");
        ds.setServerName("localhost");
        ds.setPortNumber(Integer.parseInt("1433"));
        ds.setDatabaseName("BAITAP2");
        try {
            Connection con = ds.getConnection();
            CallableStatement cstmt = con.prepareCall("select * from KHOA");
            ResultSet rs = cstmt.executeQuery();
            while (rs.next()) {
                danhSachMaGiaoVien.add(rs.getString("TRGKHOA"));
            }
        } catch (SQLServerException ex) {
            System.out.println("Loi dong 60 DatabaseLopHoc:" + ex);
        }
        return danhSachMaGiaoVien;
    }
}
