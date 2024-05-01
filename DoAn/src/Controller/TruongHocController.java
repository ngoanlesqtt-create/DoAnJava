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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class TruongHocController {

    private TruongHocModel model;
    private TruongHocView view;
    private String[] columnHocVien = {"Mã học viên", "Họ", "Tên", "Ngày sinh", "Giới tính", "Nơi sinh", "Mã lớp"};

    public TruongHocController() throws SQLException {
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
    }

    private class LoadedHocVien implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
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
            String ketQua = view.getThongTinVienMuonTim();
            System.out.println(("ket qua:" + ketQua));
            if (view.getThongTinVienMuonTim() != null) {
                Object[][] data = model.timHocVienTheoThongTin(view.getThongTinVienMuonTim());

                if (data != null) {
                    view.hienThiTrenTable(data, columnHocVien);
                } else {
                    view.hienThiPopUpThongBaoTimKiemHocVien();

                }
            } else {
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

    private class HocVienBiXoa implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("hello");
        }

    }
}
