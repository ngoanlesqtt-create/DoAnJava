/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

import ModelGiaoVien.CuNhan;
import ModelGiaoVien.GiaoVien;
import ModelGiaoVien.ThacSy;
import ModelGiaoVien.TienSy;
import ModelKhoa.Khoa;
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
    }

    public ArrayList getDatabaseGiaoVien() throws SQLException {
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

    public ArrayList<GiaoVien> themGiaoVien(ArrayList<Object> thongTinInputGiaoVien) throws SQLException {
        ArrayList<GiaoVien> cacGiaoVienDuocThemVao = new ArrayList<>();
        ds = new SQLServerDataSource();
        ds.setUser("sa");
        ds.setPassword("1");
        ds.setServerName("localhost");
        ds.setPortNumber(Integer.parseInt("1433"));
        ds.setDatabaseName("BAITAP2");
        for (Object object : thongTinInputGiaoVien) {
            System.out.println("Object:" + object);
        }
        try {
            Connection con = ds.getConnection();
            CallableStatement cstmt = con.prepareCall("INSERT INTO GIAOVIEN VALUES('"
                    + thongTinInputGiaoVien.get(0) + "','"
                    + thongTinInputGiaoVien.get(1) + "','"
                    + thongTinInputGiaoVien.get(2) + "','"
                    + thongTinInputGiaoVien.get(3) + "','"
                    + thongTinInputGiaoVien.get(5) + "/"
                    + thongTinInputGiaoVien.get(4) + "/"
                    + thongTinInputGiaoVien.get(6) + "','"
                    + thongTinInputGiaoVien.get(7) + "','"
                    + thongTinInputGiaoVien.get(8) + "',"
                    + 0 + ",'"
                    + thongTinInputGiaoVien.get(9) + "')"
                    + "select * from GIAOVIEN"
            );
            System.out.println("test dong 164 DataGiaoVien");
            ResultSet rs = cstmt.executeQuery();
            while (rs.next()) {
                if (rs.getString("HOCVI").equalsIgnoreCase("CN")) {
                    cacGiaoVienDuocThemVao.add(new CuNhan(
                            rs.getString("MAGV"),
                            rs.getString("HOTEN"),
                            rs.getString("HOCVI"),
                            rs.getString("GIOITINH"),
                            rs.getDate("NGSINH"),
                            rs.getFloat("HESO"),
                            rs.getFloat("LuongCB"),
                            rs.getFloat("MUCLUONG"),
                            rs.getString("MAKHOA")));
                } else if (rs.getString("HOCVI").equalsIgnoreCase("Ths")) {
                    cacGiaoVienDuocThemVao.add(new ThacSy(
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
                    cacGiaoVienDuocThemVao.add(new TienSy(
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
            System.out.println("loi:" + ex);
            System.out.println("Hello dong 192 DatabaseGiaoVien");
            return null;
        }
        return cacGiaoVienDuocThemVao;
    }

    public ArrayList<GiaoVien> xoaGiaoVien(GiaoVien giaoVien) throws SQLException {
        ArrayList<GiaoVien> cacGiaoVienDuocXoa = new ArrayList<>();
        ds = new SQLServerDataSource();
        ds.setUser("sa");
        ds.setPassword("1");
        ds.setServerName("localhost");
        ds.setPortNumber(Integer.parseInt("1433"));
        ds.setDatabaseName("BAITAP2");
        try {
            Connection con = ds.getConnection();
            CallableStatement cstmt = con.prepareCall("delete from GIAOVIEN where MAGV='" + giaoVien.getMaGiaoVien() + "'"
                    + "select * from GIAOVIEN");
            ResultSet rs = cstmt.executeQuery();
            while (rs.next()) {
                if (rs.getString("HOCVI").equalsIgnoreCase("CN")) {
                    cacGiaoVienDuocXoa.add(new CuNhan(
                            rs.getString("MAGV"),
                            rs.getString("HOTEN"),
                            rs.getString("HOCVI"),
                            rs.getString("GIOITINH"),
                            rs.getDate("NGSINH"),
                            rs.getFloat("HESO"),
                            rs.getFloat("LuongCB"),
                            rs.getFloat("MUCLUONG"),
                            rs.getString("MAKHOA")));
                } else if (rs.getString("HOCVI").equalsIgnoreCase("Ths")) {
                    cacGiaoVienDuocXoa.add(new ThacSy(
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
                    cacGiaoVienDuocXoa.add(new TienSy(
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
            System.out.println("loi:" + ex);
            System.out.println("Hello dong 124 DatabaseGiaoVien");
            return null;
        }
        return cacGiaoVienDuocXoa;

    }

    public ArrayList<GiaoVien> suaThongTinGiaoVien(ArrayList<Object> thongTinInputGiaoVien, String maGiaoVien) throws SQLException {
        ArrayList<GiaoVien> giaoVienDuocSua = new ArrayList<>();
        ds = new SQLServerDataSource();
        ds.setUser("sa");
        ds.setPassword("1");
        ds.setServerName("localhost");
        ds.setPortNumber(Integer.parseInt("1433"));
        ds.setDatabaseName("BAITAP2");

        try {
            Connection con = ds.getConnection();
            CallableStatement cstmt;
            cstmt = con.prepareCall("update GIAOVIEN set MAGV='"
                    + thongTinInputGiaoVien.get(0) + "', HOTEN='"
                    + thongTinInputGiaoVien.get(1) + "', HOCVI='"
                    + thongTinInputGiaoVien.get(2) + "', GIOITINH='"
                    + thongTinInputGiaoVien.get(3) + "', NGSINH='"
                    + thongTinInputGiaoVien.get(5) + "/" + thongTinInputGiaoVien.get(4) + "/" + thongTinInputGiaoVien.get(6) + "', LuongCB='"
                    + thongTinInputGiaoVien.get(7) + "', HESO='"
                    + thongTinInputGiaoVien.get(8) + "', MAKHOA='"
                    + thongTinInputGiaoVien.get(9) + "'"
                    + "where MAGV='" + maGiaoVien + "'"
                    + "select * from GIAOVIEN"
            );
            ResultSet rs = cstmt.executeQuery();
            while (rs.next()) {
                if (rs.getString("HOCVI").equalsIgnoreCase("CN")) {
                    giaoVienDuocSua.add(new CuNhan(
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
                    giaoVienDuocSua.add(new ThacSy(
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
                    giaoVienDuocSua.add(new TienSy(
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
            System.out.println("loi:" + ex);
            System.out.println("Hello dong 170 DatabaseGiaoVien");
            return null;
        }
        return giaoVienDuocSua;
    }

    public ArrayList<GiaoVien> suaThongTinGiaoVienTrucTiepTrenBang(GiaoVien giaoVien, String maGiaoVien) throws SQLException {
        ArrayList<GiaoVien> giaoVienDuocSua = new ArrayList<>();
        ds = new SQLServerDataSource();
        ds.setUser("sa");
        ds.setPassword("1");
        ds.setServerName("localhost");
        ds.setPortNumber(Integer.parseInt("1433"));
        ds.setDatabaseName("BAITAP2");
        try {
            Connection con = ds.getConnection();
            CallableStatement cstmt;
            cstmt = con.prepareCall("update GIAOVIEN set MAGV='"
                    + giaoVien.getMaGv() + "', HOTEN='"
                    + giaoVien.getHoTen() + "', HOCVI='"
                    + giaoVien.getHocVi() + "', GIOITINH='"
                    + giaoVien.getGioiTinh() + "', LuongCB='"
                    + giaoVien.getLuongCoBan() + "', HESO='"
                    + giaoVien.getHeSo() + "'"
                    + "where MAGV='" + maGiaoVien + "'"
                    + "select * from GIAOVIEN "
            );
            ResultSet rs = cstmt.executeQuery();
            while (rs.next()) {
                if (rs.getString("HOCVI").equalsIgnoreCase("CN")) {
                    giaoVienDuocSua.add(new CuNhan(
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
                    giaoVienDuocSua.add(new TienSy(
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
                    giaoVienDuocSua.add(new ThacSy(
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
            System.out.println("loi:" + ex);
            System.out.println("Hello dong 210 DatabaseGiaoVien");
            return null;
        }
        return giaoVienDuocSua;
    }

    public ArrayList<GiaoVien> timGiaoVienTheoMa(String maGiaoVienDuocTim) throws SQLException {
        ArrayList<GiaoVien> giaoVienDuocTimThayTheoMa = new ArrayList<>();
        ds = new SQLServerDataSource();
        ds.setUser("sa");
        ds.setPassword("1");
        ds.setServerName("localhost");
        ds.setPortNumber(Integer.parseInt("1433"));
        ds.setDatabaseName("BAITAP2");
        try {
            Connection con = ds.getConnection();
            CallableStatement cstmt = con.prepareCall("select * from GIAOVIEN where MAGV='" + maGiaoVienDuocTim + "'");
            ResultSet rs = cstmt.executeQuery();
            while (rs.next()) {
                if (rs.getString("HOCVI").equalsIgnoreCase("CN")) {
                    giaoVienDuocTimThayTheoMa.add(new CuNhan(
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
                    giaoVienDuocTimThayTheoMa.add(new ThacSy(
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
                    giaoVienDuocTimThayTheoMa.add(new TienSy(
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
            System.out.println("loi:" + ex);
            System.out.println("Hello dong 242 DatabaseGiaoVien");
            return null;
        }

        return giaoVienDuocTimThayTheoMa;
    }

    public ArrayList<GiaoVien> suaThongTinGiaoVienDuocTimKiemBangInput(ArrayList<Object> thongTinInputGiaoVien, String maGiaoVien) throws SQLException {
        ArrayList<GiaoVien> giaoVienDuocSua = new ArrayList<>();
        ds = new SQLServerDataSource();
        ds.setUser("sa");
        ds.setPassword("1");
        ds.setServerName("localhost");
        ds.setPortNumber(Integer.parseInt("1433"));
        ds.setDatabaseName("BAITAP2");
        try {
            Connection con = ds.getConnection();
            CallableStatement cstmt;
            cstmt = con.prepareCall("update GIAOVIEN set MAGV='"
                    + thongTinInputGiaoVien.get(0) + "', HOTEN='"
                    + thongTinInputGiaoVien.get(1) + "', HOCVI='"
                    + thongTinInputGiaoVien.get(2) + "', GIOITINH='"
                    + thongTinInputGiaoVien.get(3) + "', NGSINH='"
                    + thongTinInputGiaoVien.get(5) + "/" + thongTinInputGiaoVien.get(4) + "/" + thongTinInputGiaoVien.get(6) + "', LuongCB='"
                    + thongTinInputGiaoVien.get(7) + "', HESO='"
                    + thongTinInputGiaoVien.get(8) + "', MAKHOA='"
                    + thongTinInputGiaoVien.get(9) + "'"
                    + "where MAGV='" + maGiaoVien + "'"
                    + "select * from GIAOVIEN"
            );
            ResultSet rs = cstmt.executeQuery();
            while (rs.next()) {
                if (rs.getString("HOCVI").equalsIgnoreCase("CN")) {
                    giaoVienDuocSua.add(new CuNhan(
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
                    giaoVienDuocSua.add(new TienSy(
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
                    giaoVienDuocSua.add(new ThacSy(
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
            System.out.println("loi:" + ex);
            return null;
        }
        return giaoVienDuocSua;
    }

    public ArrayList<GiaoVien> xoaGiaoVienDuocTimKiem(String maHocVienCanXoa) throws SQLException {
        ArrayList<GiaoVien> giaoVienDuocXoa = new ArrayList<>();
        ds = new SQLServerDataSource();
        ds.setUser("sa");
        ds.setPassword("1");
        ds.setServerName("localhost");
        ds.setPortNumber(Integer.parseInt("1433"));
        ds.setDatabaseName("BAITAP2");
        try {
            Connection con = ds.getConnection();
            CallableStatement cstmt = con.prepareCall("delete from GIAOVIEN where MAGV='" + maHocVienCanXoa + "'"
                    + "select * from GIAOVIEN"
            );
            ResultSet rs = cstmt.executeQuery();
            while (rs.next()) {
                if (rs.getString("HOCVI").equalsIgnoreCase("CN")) {
                    giaoVienDuocXoa.add(new CuNhan(
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
                    giaoVienDuocXoa.add(new TienSy(
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
                    giaoVienDuocXoa.add(new ThacSy(
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
            System.out.println("loi:" + ex);
            System.out.println("Hello dong 307 DatabaseGiaoVien");
            return null;
        }

        return giaoVienDuocXoa;
    }

    public GiaoVien capNhapLuongGiaoVien(String maGV, float luong) throws SQLException {
        ds = new SQLServerDataSource();
        ds.setUser("sa");
        ds.setPassword("1");
        ds.setServerName("localhost");
        ds.setPortNumber(Integer.parseInt("1433"));
        ds.setDatabaseName("BAITAP2");
        try {
            Connection con = ds.getConnection();
            CallableStatement cstmt;
            cstmt = con.prepareCall(
                    "update GIAOVIEN set MUCLUONG='" + luong + "'" + "where MAGV='" + maGV + "'"
                    + "select * from GIAOVIEN where magv='" + maGV + "'"
            );
            ResultSet rs = cstmt.executeQuery();
            while (rs.next()) {
                if (rs.getString("HOCVI").equalsIgnoreCase("CN")) {
                    return new CuNhan(
                            rs.getString("MAGV"),
                            rs.getString("HOTEN"),
                            rs.getString("HOCVI"),
                            rs.getString("GIOITINh"),
                            rs.getDate("NGSINH"),
                            rs.getFloat("HESO"),
                            rs.getFloat("LuongCB"),
                            rs.getFloat("MUCLUONG"),
                            rs.getString("MAKHOA"));

                } else if (rs.getString("HOCVI").equalsIgnoreCase("Ths")) {
                    return new ThacSy(
                            rs.getString("MAGV"),
                            rs.getString("HOTEN"),
                            rs.getString("HOCVI"),
                            rs.getString("GIOITINh"),
                            rs.getDate("NGSINH"),
                            rs.getFloat("HESO"),
                            rs.getFloat("LuongCB"),
                            rs.getFloat("MUCLUONG"),
                            rs.getString("MAKHOA"));

                } else if (rs.getString("HOCVI").equalsIgnoreCase("TS")) {
                    return new TienSy(
                            rs.getString("MAGV"),
                            rs.getString("HOTEN"),
                            rs.getString("HOCVI"),
                            rs.getString("GIOITINh"),
                            rs.getDate("NGSINH"),
                            rs.getFloat("HESO"),
                            rs.getFloat("LuongCB"),
                            rs.getFloat("MUCLUONG"),
                            rs.getString("MAKHOA"));

                }
            }
        } catch (SQLServerException ex) {
            System.out.println("Loi:" + ex);
        }
        return null;
    }

    public ArrayList getDanhSachKhoa() throws SQLException {
        ArrayList<Khoa> danhSachKhoa = new ArrayList<>();
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
        return danhSachKhoa;
    }

    public ArrayList getGiaTriDeSuaChuaBangGiaoVien() throws SQLException {
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

    public ArrayList<GiaoVien> suaMaKhoaCuaGiaoVienKhiThayDoiKhoa(String maKhoaCanSua, String maKhoaBanDau) throws SQLException {
        ArrayList<GiaoVien> giaoVienDuocCapNhapMaKhoa = new ArrayList<>();
        ds = new SQLServerDataSource();
        ds.setUser("sa");
        ds.setPassword("1");
        ds.setServerName("localhost");
        ds.setPortNumber(Integer.parseInt("1433"));
        ds.setDatabaseName("BAITAP2");
        try {
            Connection con = ds.getConnection();
            CallableStatement cstmt = con.prepareCall("update GIAOVIEN  set MAKHOA='" + maKhoaCanSua + "'" + " where MAKHOA='" + maKhoaBanDau + "'" + "select * from GIAOVIEN");
            ResultSet rs = cstmt.executeQuery();
            while (rs.next()) {
                if (rs.getString("HOCVI").equalsIgnoreCase("CN")) {
                    giaoVienDuocCapNhapMaKhoa.add(new CuNhan(
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
                    giaoVienDuocCapNhapMaKhoa.add(new ThacSy(
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
                    giaoVienDuocCapNhapMaKhoa.add(new TienSy(
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
            System.out.println("Loi dong 42 DatabaseLopHoc:" + ex);
        }
        return giaoVienDuocCapNhapMaKhoa;
    }
}
