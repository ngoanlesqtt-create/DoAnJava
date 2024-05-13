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
import java.text.ParseException;
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

    public ArrayList<Khoa> getDanhSachKhoa() throws SQLException {
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
            System.out.println("Loi dong 64 DatabaseLopHoc:" + ex);
            return null;
        }
        return danhSachKhoa;
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

    public ArrayList<Khoa> themKhoa(ArrayList<Object> inputKhoa) throws SQLException, ParseException {
        ArrayList<Khoa> khoaDuocThemVao = new ArrayList<>();
        ds = new SQLServerDataSource();
        ds.setUser("sa");
        ds.setPassword("1");
        ds.setServerName("localhost");
        ds.setPortNumber(Integer.parseInt("1433"));
        ds.setDatabaseName("BAITAP2");
        try {
            String ngay = (String) inputKhoa.get(2);
            String thang = (String) inputKhoa.get(3);
            String nam = (String) inputKhoa.get(4);
            String ngayThangNam = ngay + '/' + thang + '/' + nam;
            Connection con = ds.getConnection();
            CallableStatement cstmt = con.prepareCall("INSERT INTO KHOA VALUES('" + inputKhoa.get(0) + "','" + inputKhoa.get(1) + "','" + ngayThangNam + "','" + "'," + 0 + ")" + "select * from KHOA");
            ResultSet rs = cstmt.executeQuery();
            while (rs.next()) {
                khoaDuocThemVao.add(new Khoa(rs.getString("MAKHOA"), rs.getString("TENKHOA"), rs.getDate("NGTLAP"), rs.getInt("SOLUONGGIAOVIEN"), rs.getString("TRGKHOA")));
            }
        } catch (SQLServerException ex) {
            System.out.println("Loi dong 60 DatabaseLopHoc:" + ex);
            return null;
        }
        return khoaDuocThemVao;
    }

    public ArrayList<Khoa> capNhapSiSoGiaoVienKhoa(String maKhoa, int count) throws SQLException {
        ArrayList<Khoa> danhSachKhoaDuocCapNhapSiSoGiaoVien = new ArrayList<>();
        ds = new SQLServerDataSource();
        ds.setUser("sa");
        ds.setPassword("1");
        ds.setServerName("localhost");
        ds.setPortNumber(Integer.parseInt("1433"));
        ds.setDatabaseName("BAITAP2");
        try {

            Connection con = ds.getConnection();
            CallableStatement cstmt = con.prepareCall("update KHOA set SOLUONGGIAOVIEN=" + count + " where MAKHOA='" + maKhoa + "'" + "select * from KHOA");
            ResultSet rs = cstmt.executeQuery();
            while (rs.next()) {
                danhSachKhoaDuocCapNhapSiSoGiaoVien.add(new Khoa(rs.getString("MAKHOA"), rs.getString("TENKHOA"), rs.getDate("NGTLAP"), rs.getInt("SOLUONGGIAOVIEN"), rs.getString("TRGKHOA")));
            }
        } catch (SQLServerException ex) {
            System.out.println("Loi dong 60 DatabaseLopHoc:" + ex);
            return null;
        }
        return danhSachKhoaDuocCapNhapSiSoGiaoVien;

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

    public ArrayList<Khoa> xoaKhoa(String maKhoa) throws SQLException {
        ArrayList<Khoa> khoaDuocXoa = new ArrayList<>();
        ds = new SQLServerDataSource();
        ds.setUser("sa");
        ds.setPassword("1");
        ds.setServerName("localhost");
        ds.setPortNumber(Integer.parseInt("1433"));
        ds.setDatabaseName("BAITAP2");
        try {

            Connection con = ds.getConnection();
            CallableStatement cstmt = con.prepareCall("delete from KHOA where MAKHOA='" + maKhoa + "'" + "select * from KHOA");
            ResultSet rs = cstmt.executeQuery();
            while (rs.next()) {
                khoaDuocXoa.add(new Khoa(rs.getString("MAKHOA"), rs.getString("TENKHOA"), rs.getDate("NGTLAP"), rs.getInt("SOLUONGGIAOVIEN"), rs.getString("TRGKHOA")));
            }
        } catch (SQLServerException ex) {
            System.out.println("Loi dong 60 DatabaseLopHoc:" + ex);
            return null;
        }

        return khoaDuocXoa;
    }

    public ArrayList<Khoa> suaThongTinKhoaTrucTiepTrenBang(Khoa khoa, String maKhoa) throws SQLException {
        ArrayList<Khoa> danhSachKhoaDuocSuaTrucTiepTrenBang = new ArrayList<>();
        ds = new SQLServerDataSource();
        ds.setUser("sa");
        ds.setPassword("1");
        ds.setServerName("localhost");
        ds.setPortNumber(Integer.parseInt("1433"));
        ds.setDatabaseName("BAITAP2");
        try {

            Connection con = ds.getConnection();
            CallableStatement cstmt = con.prepareCall("update KHOA set MAKHOA='" + khoa.getMaKhoa()
                    + "',TENKHOA='" + khoa.getTenKhoa()
                    + "',NGTLAP='" + khoa.getNgayThanhLap()
                    + "',TRGKHOA='" + khoa.getTruongKhoa()
                    + "',SOLUONGGIAOVIEN='" + khoa.getSoLuongGiangVien() + "'"
                    + " where MAKHOA='" + maKhoa + "'"
                    + "select * from KHOA");
            ResultSet rs = cstmt.executeQuery();
            while (rs.next()) {
                danhSachKhoaDuocSuaTrucTiepTrenBang.add(new Khoa(rs.getString("MAKHOA"), rs.getString("TENKHOA"), rs.getDate("NGTLAP"), rs.getInt("SOLUONGGIAOVIEN"), rs.getString("TRGKHOA")));
            }
        } catch (SQLServerException ex) {
            System.out.println("Loi dong 60 DatabaseLopHoc:" + ex);
            return null;
        }
        return danhSachKhoaDuocSuaTrucTiepTrenBang;
    }

    public ArrayList setGiaTriDeSuaChuaBangHocVien(String maKhoaCanSua, int row, String maKhoaBanDau) throws SQLException {
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
            CallableStatement cstmt = con.prepareCall("update CacGiaTriDeCapNhapBangHocVien set " + "dong=" + row
                    + "," + "maLopHocDeSua='"
                    + maKhoaCanSua + "', maLopHocBanDau='" + maKhoaBanDau + "'"
                    + "select * from CacGiaTriDeCapNhapBangHocVien"
            );

            ResultSet rs = cstmt.executeQuery();

            while (rs.next()) {
                data.add(rs.getInt("dong"));
                data.add(rs.getString("maLopHocDeSua"));
            }
        } catch (SQLServerException ex) {
            System.out.println("Loi dong 282 DatabaseLopHoc:" + ex);
            return null;
        }
        return data;
    }
}
