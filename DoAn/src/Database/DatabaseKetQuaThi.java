/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

import ModelKetQuaThi.KetQuaThi;
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
public class DatabaseKetQuaThi {

    private SQLServerDataSource ds;

    public ArrayList<KetQuaThi> loadDataKetQuaThi() throws SQLException {
        ArrayList<KetQuaThi> danhSachKetQuaThi = new ArrayList<>();
        ds = new SQLServerDataSource();
        ds.setUser("sa");
        ds.setPassword("1");
        ds.setServerName("localhost");
        ds.setPortNumber(Integer.parseInt("1433"));
        ds.setDatabaseName("BAITAP2");
        try {
            Connection con = ds.getConnection();
            CallableStatement cstmt = con.prepareCall("select * from KETQUATHI");
            ResultSet rs = cstmt.executeQuery();
            while (rs.next()) {
                danhSachKetQuaThi.add(new KetQuaThi(rs.getString("MAHV"), rs.getString("MAMH"), rs.getInt("LANTHI"), rs.getDate("NGTHI"), rs.getFloat("DIEM"), rs.getString("KQUA")));
            }
        } catch (SQLServerException ex) {
            System.out.println("Loi dong 64 DatabaseLopHoc:" + ex);
            return null;
        }
        return danhSachKetQuaThi;

    }

    public ArrayList<String> getMaMonHoc() throws SQLException {
        ArrayList<String> danhSachMaMonHoc = new ArrayList<>();
        ds = new SQLServerDataSource();
        ds.setUser("sa");
        ds.setPassword("1");
        ds.setServerName("localhost");
        ds.setPortNumber(Integer.parseInt("1433"));
        ds.setDatabaseName("BAITAP2");
        try {
            Connection con = ds.getConnection();
            CallableStatement cstmt = con.prepareCall("select * from MONHOC");
            ResultSet rs = cstmt.executeQuery();
            while (rs.next()) {
                danhSachMaMonHoc.add((rs.getString("MAMH")));
            }
        } catch (SQLServerException ex) {
            System.out.println("Loi dong 64 DatabaseLopHoc:" + ex);
            return null;
        }
        return danhSachMaMonHoc;
    }

    public ArrayList<KetQuaThi> suaThongTinKetQuaThi(KetQuaThi ketQuaThi, String maHocVien, String maMonHoc) throws SQLException {
        ArrayList<KetQuaThi> danhSachKetQuaThiDuocSua = new ArrayList<>();
        ds = new SQLServerDataSource();
        ds.setUser("sa");
        ds.setPassword("1");
        ds.setServerName("localhost");
        ds.setPortNumber(Integer.parseInt("1433"));
        ds.setDatabaseName("BAITAP2");
        try {
            Connection con = ds.getConnection();
            CallableStatement cstmt = con.prepareCall("update KETQUATHI set LANTHI=" + ketQuaThi.getLanThi()
                    + ",NGTHI='" + ketQuaThi.getNgayThi()
                    + "',DIEM=" + ketQuaThi.getDiem()
                    + " where MAHV='" + ketQuaThi.getMaHocVien() + "'"
                    + " and MAMH='" + ketQuaThi.getMaMonHoc() + "'"
                    + "select * from KETQUATHI");
            ResultSet rs = cstmt.executeQuery();
            while (rs.next()) {
                danhSachKetQuaThiDuocSua.add(new KetQuaThi(rs.getString("MAHV"), rs.getString("MAMH"), rs.getInt("LANTHI"), rs.getDate("NGTHI"), rs.getFloat("DIEM"), rs.getString("KQUA")));
            }
        } catch (SQLServerException ex) {
            System.out.println("Loi dong 64 DatabaseLopHoc:" + ex);
            return null;
        }
        return danhSachKetQuaThiDuocSua;
    }

    public ArrayList getGiaTriDeSuaChuabangHocVien() throws SQLException {
        ArrayList<Object> data = new ArrayList<>();
        ds = new SQLServerDataSource();
        ds.setUser("sa");
        ds.setPassword("1");
        ds.setServerName("localhost");
        ds.setPortNumber(Integer.parseInt("1433"));
        ds.setDatabaseName("BAITAP2");
        try {
            System.out.println("test dong 241 DatabaseLopHoc:");
            Connection con = ds.getConnection();
            CallableStatement cstmt = con.prepareCall("select * from CacGiaTriDeCapNhapBangHocVien");

            ResultSet rs = cstmt.executeQuery();

            while (rs.next()) {
                data.add(rs.getInt("dong"));
                data.add(rs.getString("maLopHocBanDau"));
                data.add(rs.getString("maLopHocDeSua"));
            }
        } catch (SQLServerException ex) {
            System.out.println("Loi dong 282 DatabaseLopHoc:" + ex);
            return null;
        }
        return data;
    }

//    public ArrayList<KetQuaThi> suaThongTinKetQuaThi() throws SQLException {
//        ArrayList<KetQuaThi> danhSachKetQuaThiDuocSua = new ArrayList<>();
//        ds = new SQLServerDataSource();
//        ds.setUser("sa");
//        ds.setPassword("1");
//        ds.setServerName("localhost");
//        ds.setPortNumber(Integer.parseInt("1433"));
//        ds.setDatabaseName("BAITAP2");
//        try {
//            Connection con = ds.getConnection();
//            CallableStatement cstmt = con.prepareCall("update KETQUATHI set LANTHI=" + ketQuaThi.getLanThi()
//                    + ",NGTHI='" + ketQuaThi.getNgayThi()
//                    + "',DIEM=" + ketQuaThi.getDiem()
//                    + " where MAHV='" + ketQuaThi.getMaHocVien() + "'"
//                    + " and MAMH='" + ketQuaThi.getMaMonHoc() + "'"
//                    + "select * from KETQUATHI");
//            ResultSet rs = cstmt.executeQuery();
//            while (rs.next()) {
//                danhSachKetQuaThiDuocSua.add(new KetQuaThi(rs.getString("MAHV"), rs.getString("MAMH"), rs.getInt("LANTHI"), rs.getDate("NGTHI"), rs.getFloat("DIEM"), rs.getString("KQUA")));
//            }
//        } catch (SQLServerException ex) {
//            System.out.println("Loi dong 64 DatabaseLopHoc:" + ex);
//            return null;
//        }
//        return danhSachKetQuaThiDuocSua;
//    }
    public ArrayList<KetQuaThi> suaMaHocVien(String maHocVienCanSua, String maHocVienBanDau) throws SQLException {
        ArrayList<KetQuaThi> danhSachKetQuaThi = new ArrayList<>();
        ds = new SQLServerDataSource();
        ds.setUser("sa");
        ds.setPassword("1");
        ds.setServerName("localhost");
        ds.setPortNumber(Integer.parseInt("1433"));
        ds.setDatabaseName("BAITAP2");
        try {
            Connection con = ds.getConnection();
            CallableStatement cstmt = con.prepareCall("update KETQUATHI set MAHV='" + maHocVienCanSua + "'"
                    + " where MAHV='" + maHocVienBanDau + "'"
                    + "select * from KETQUATHI");
            ResultSet rs = cstmt.executeQuery();
            while (rs.next()) {
                danhSachKetQuaThi.add(new KetQuaThi(rs.getString("MAHV"), rs.getString("MAMH"), rs.getInt("LANTHI"), rs.getDate("NGTHI"), rs.getFloat("DIEM"), rs.getString("KQUA")));
            }
        } catch (SQLServerException ex) {
            System.out.println("Loi dong 64 DatabaseLopHoc:" + ex);
            return null;
        }
        return danhSachKetQuaThi;
    }
}
