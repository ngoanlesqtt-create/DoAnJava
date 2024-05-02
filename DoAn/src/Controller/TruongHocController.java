/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.HocVien;
import Model.TruongHocModel;
import View.TruongHocView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author PC
 */
public class TruongHocController {

    private TruongHocModel model;
    private TruongHocView view;
    private String[] columnHocVien = {"Mã học viên", "Họ", "Tên", "Ngày sinh", "Giới tính", "Nơi sinh", "Mã lớp"};
    private int chiSoTable;
    private boolean state;

    public TruongHocController() throws SQLException {
        this.chiSoTable = -1;
        this.state = false;
        model = new TruongHocModel();
        model.nhap();
        view = new TruongHocView();
        view.setVisible(true);
        view.loadHocVien(new LoadedHocVien());
        view.timHocVien(new HocVienDuocTimThay());
        view.tatPopUpThongBaoTimKiemHocVien(new CachTatThongBaoTimKiemHocVien());
        view.tatPopUpThongBaoChuaNhapThongTinSinhVien(new CachTatThongBaoChuaNhapThongTinSinhVien());
        view.themHocVien(new HocVienDuocThem());
        view.xoaHocVien(new HocVienBiXoa());
        view.layDuLieuBang(new DuLieuDuocLayTuBang());
    }

    private class LoadedHocVien implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                state = false;
                Object[][] data = model.getDataHocVien();
                view.hienThiTrenTable(data, columnHocVien);
            } catch (SQLException ex) {
            }

        }

    }

    private class CachTatThongBaoTimKiemHocVien implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            view.tatHienThiPopUpThongBaoTimKiemHocVien();
        }

    }

    private class CachTatThongBaoChuaNhapThongTinSinhVien implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            view.tatHienThiPopUpThongBaoChuaNhapThongTinHocVien();
        }

    }

    private class HocVienDuocTimThay implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            state = true;
            if (view.getThongTinVienMuonTim() != null) {//Nếu đã nhập các thông tin tìm kiếm học viên
                Object[][] data = model.timHocVienTheoThongTin(view.getThongTinVienMuonTim());
                if (data != null) {//nếu tìm thấy học viên theo thông tin đã nhập
                    view.hienThiTrenTable(data, columnHocVien);
                } else {//Không tim thấy sinh viên theo thông tin đã nhập
                    view.hienThiPopUpThongBaoTimKiemHocVien();
                }
            } else {//Chưa nhập thông tin tìm kiếm học viên
                view.hienThiThongBaoChuaNhapThongTinHocVien("Ban chua nhap thong tin can tim");
            }

        }

    }

    private class HocVienDuocThem implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            HocVien hocVienDuocThemVao;
            try {
                hocVienDuocThemVao = view.getHocVien();

                if (hocVienDuocThemVao == null) {
                    view.hienThiThongBaoChuaNhapThongTinHocVien("Ban chua nhap thong tin");
                    return;
                }
                if (!hocVienDuocThemVao.getMaLop().equalsIgnoreCase("K11") && !hocVienDuocThemVao.getMaLop().equalsIgnoreCase("K12") && !hocVienDuocThemVao.getMaLop().equalsIgnoreCase("K13")) {
                    view.hienThiThongBaoChuaNhapThongTinHocVien("Ban da nhap sai lop");
                    return;
                }
                if (!hocVienDuocThemVao.getMaHocVien().contains(hocVienDuocThemVao.getMaLop())) {
                    view.hienThiThongBaoChuaNhapThongTinHocVien("Ban da nhap sai ma hoc vien, ma hoc vien phai bat dau bang ma lop");
                    return;
                }
                Object[][] data = model.themHocVienVaoDanhSach(hocVienDuocThemVao);
                if (data != null) {
                    view.hienThiTrenTable(data, columnHocVien);
                } else {
                    view.hienThiThongBaoChuaNhapThongTinHocVien("Ma hoc vien bi trung");
                }
            } catch (ParseException | SQLException ex) {
            }

        }

    }

    private class DuLieuDuocLayTuBang implements ListSelectionListener {

        @Override
        public void valueChanged(ListSelectionEvent e) {
            //khi click vào 1 row thì sẽ có 2 sự kiện đó là MousePressed và MouseRealesed 
            if (e.getValueIsAdjusting()) {
                return;
            }
            chiSoTable = view.layChiSoMang();
        }
    }

    private class HocVienBiXoa implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                if (view.getThongTinVienMuonTim() != null && state) {
                    Object[][] cacHocVienDuocTimThay = model.timHocVienTheoThongTin(view.getThongTinVienMuonTim());
                    if (cacHocVienDuocTimThay != null) {
                        Object[][] cacHocVienDuocXoaKhiTimThay = model.xoaCacHocVienDuocTimThay(chiSoTable, view.getThongTinVienMuonTim());
                        view.hienThiTrenTable(cacHocVienDuocXoaKhiTimThay, columnHocVien);
                    } else {
                        view.hienThiThongBaoChuaNhapThongTinHocVien("Đã hết học viên để xóa");
                    }
                }
                if (!state) {
                    if (model.getDataHocVien().length != 0) {
                        if (chiSoTable != -1) {
                            Object[][] data = model.xoaHocVien(chiSoTable);
                            view.hienThiTrenTable(data, columnHocVien);
                        } else {
                            view.hienThiThongBaoChuaNhapThongTinHocVien("Ban chua chon hoc vien can xoa");
                        }
                    } else {
                        view.hienThiThongBaoChuaNhapThongTinHocVien("Đã hết học viên để xóa");
                    }
                }
            } catch (SQLException ex) {
            }
        }

    }
}
