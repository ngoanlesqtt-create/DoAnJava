/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import InputThongTin.InputThongTin;
import ModelHocVien.HocVien;
import ModelLop.LopHocModel;
import View.TruongHoc1View;
import View.TruongHoc2View;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class TruongHoc2Controller extends TruongHoc1Controller {

    private final LopHocModel modelLopHoc;
    private final TruongHoc2View viewLopHoc;

    public TruongHoc2Controller() throws SQLException {
        this.modelLopHoc = new LopHocModel();
        this.viewLopHoc = new TruongHoc2View(this.modelHocVien.getDanhSachHocVien(), this.dataGiaoVien.getDataGiaoVien());
        viewLopHoc.setVisible(true);
        viewLopHoc.loadLopHoc(new LopHocDuocLoad());
        viewLopHoc.themLopHoc(new LopHocDuocThem());
        view.setVisible(false);

    }

    private class LopHocDuocLoad implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            viewLopHoc.hienThiLopHocTrenTable(modelLopHoc.loadDanhSachLopHoc(), modelLopHoc.getColumnLopHoc());
            try {
                viewLopHoc.xoaCombobox(modelHocVien.getDanhSachHocVien());
                viewLopHoc.showMaLopTruong(modelLopHoc.getDanhSachHocVien());
                viewLopHoc.showMaGiaoVienChuNhiem(modelLopHoc.getDanhSachGiaoVien());
            } catch (SQLException ex) {
            }
        }

    }

    private class LopHocDuocThem implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            ArrayList<Object> inputLopHoc = viewLopHoc.getInputLopHoc();
            if (!InputThongTin.kiemTraInputRong(inputLopHoc)) {
                view.hienThiThongBaoChuaNhapThongTinHocVien("Bạn chưa nhập thông tin tìm kiếm");
            } else {
                if (!modelLopHoc.kiemTraTrungMaLopTruong(inputLopHoc)) {
                    view.hienThiThongBaoChuaNhapThongTinHocVien("Bạn đã nhập trùng mã lớp trưởng");
                } else if (!modelLopHoc.kiemTraTrungMaGiaoVienChuNhiem(inputLopHoc)) {
                    view.hienThiThongBaoChuaNhapThongTinHocVien("Bạn đã nhập trùng mã giáo viên chủ nhiệm");
                } else {
                    Object[][] data;
                    try {
                        data = modelLopHoc.themLopHoc(inputLopHoc);
                        viewLopHoc.hienThiLopHocTrenTable(data, modelLopHoc.getColumnLopHoc());
                    } catch (SQLException ex) {
                    }
                }
            }
        }

    }

}
