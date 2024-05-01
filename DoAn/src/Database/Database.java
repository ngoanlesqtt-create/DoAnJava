/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

import Model.HocVien;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author PC
 */
public class Database {

    private SQLServerDataSource ds;

    public Database(ArrayList<HocVien> danhSachHocVien) throws SQLException {
        ds = new SQLServerDataSource();
        ds.setUser("sa");
        ds.setPassword("1");
        ds.setServerName("localhost");
        ds.setPortNumber(Integer.parseInt("1433"));
        ds.setDatabaseName("BAITAP2");

        try {
            Connection con = ds.getConnection();
            CallableStatement cstmt = con.prepareCall("	select * from hocvien");
            ResultSet rs = cstmt.executeQuery();

            while (rs.next()) {
                danhSachHocVien.add(new HocVien(rs.getString("MAHV"), rs.getString("HO"), rs.getString("TEN"), rs.getDate("NGSINH"), rs.getString("GIOITINH"), rs.getString("NOISINH"), rs.getString("MALOP")));
            }
        } catch (SQLServerException ex) {
        }
    }

    public ArrayList themHocVienVaoDanhSach(HocVien hocVienDuocThemVao) throws SQLException, ParseException {
        ArrayList<HocVien> danhSachHocVienDuocThemVao = new ArrayList<>();
        ds = new SQLServerDataSource();
        ds.setUser("sa");
        ds.setPassword("1");
        ds.setServerName("localhost");
        ds.setPortNumber(Integer.parseInt("1433"));
        ds.setDatabaseName("BAITAP2");
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");
            String ngaySinh = simpleDateFormat.format(hocVienDuocThemVao.getNgaySinh());
            Connection con = ds.getConnection();
            CallableStatement cstmt = con.prepareCall("INSERT INTO HOCVIEN VALUES('"
                    + hocVienDuocThemVao.getMaHocVien()
                    + "','"
                    + hocVienDuocThemVao.getHo()
                    + "','"
                    + hocVienDuocThemVao.getTen()
                    + "','"
                    + ngaySinh
                    + "','"
                    + hocVienDuocThemVao.getGioiTinh()
                    + "','"
                    + hocVienDuocThemVao.getNoiSinh()
                    + "','"
                    + hocVienDuocThemVao.getMaLop()
                    + "')"
                    + "select * from HOCVIEN "
            );
            ResultSet rs = cstmt.executeQuery();
            while (rs.next()) {
                danhSachHocVienDuocThemVao.add(new HocVien(rs.getString("MAHV"), rs.getString("HO"), rs.getString("TEN"), rs.getDate("NGSINH"), rs.getString("GIOITINH"), rs.getString("NOISINH"), rs.getString("MALOP")));
            }
        } catch (SQLServerException ex) {
            System.out.println("loi:" + ex);
            return null;
        }
        return danhSachHocVienDuocThemVao;
    }

}
