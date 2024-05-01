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
                view.hienThiThongBaoChuaNhapThongTinHocVien();
            }

        }

    }

    private class HocVienDuocThem implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            HocVien hocVienDuocThemVao;
            try {
                hocVienDuocThemVao = view.getHocVien();
                Object[][] data = model.themHocVienVaoDanhSach(hocVienDuocThemVao);
                System.out.println("Hello");
                if (data != null) {
                    view.hienThiTrenTable(data, columnHocVien);
                }

            } catch (ParseException | SQLException ex) {
            }

        }

    }
}
