/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import InputThongTin.InputThongTin;
import ModelHocVien.HocVien;
import ModelKhoa.KhoaModel;
import ModelLop.LopHocModel;
import View.TruongHoc2View;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author PC
 */
public class TruongHoc2Controller extends TruongHoc1Controller {

    private final LopHocModel modelLopHoc;
    private final TruongHoc2View view2;
    private ArrayList<Object> inputLopHoc;
    private KhoaModel modelKhoa;
    private ArrayList<String> maGiaoVienDangLaChuNhiemKhoa;

    public TruongHoc2Controller() throws SQLException {
        //Khoa
        this.modelKhoa = new KhoaModel();
        this.inputLopHoc = new ArrayList<>();
        this.modelLopHoc = new LopHocModel();
        this.maGiaoVienDangLaChuNhiemKhoa = this.modelKhoa.getMaGiaoVienDangLaChuNhiemKhoa();
        this.view2 = new TruongHoc2View(this.modelHocVien.getDanhSachHocVien(), this.dataGiaoVien.getDataGiaoVien(), this.modelKhoa.getMaGiaoVien(), maGiaoVienDangLaChuNhiemKhoa);
        this.dongDuocChonTrenBangLopHoc = -1;
        view2.setVisible(true);
        view.setVisible(false);
        view2.loadLopHoc(new LopHocDuocLoad());
        view2.themLopHoc(new LopHocDuocThem());
        view2.capNhapLopTruong(new LopHocCapCapNhapLopTruong());
        view2.layDongTrenBangLopHocDeXuLy(new DongTrenBangLopHoc());
        view2.xoaLopHoc(new LopHocDuocXoa());
        view2.capNhapSiSoLopHoc(new LopHocDuocCapNhapSiSo());
        view2.suaLopHoc(new LopHocDuocSuaThongTin());
        //Khoa
        view2.loadKhoa(new KhoaDuocLoad());
        view2.renderNamThanhLapKhoa(new ComboBoxNam());
    }

    private class LopHocDuocLoad implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            view2.hienThiLopHocTrenTable(modelLopHoc.loadDanhSachLopHoc(), modelLopHoc.getColumnLopHoc());
            try {
                view2.xoaCombobox();
                view2.showMaLopTruong(modelLopHoc.getDanhSachHocVien());
                view2.showMaGiaoVienChuNhiem(modelLopHoc.getDanhSachGiaoVien());
            } catch (SQLException ex) {
            }
        }

    }

    private class LopHocDuocThem implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            inputLopHoc = view2.getInputLopHoc();
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
                        view2.hienThiLopHocTrenTable(data, modelLopHoc.getColumnLopHoc());
                    } catch (SQLException ex) {
                    }
                }
            }
        }

    }

    private class DongTrenBangLopHoc implements ListSelectionListener {

        @Override
        public void valueChanged(ListSelectionEvent e) {
            if (e.getValueIsAdjusting()) {
                return;
            }
            dongDuocChonTrenBangLopHoc = view2.getRowLopHoc();
            view2.setInputKhiDuocChonVaoTrenBangLopHoc(dongDuocChonTrenBangLopHoc);
        }

    }

    private class LopHocCapCapNhapLopTruong implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            try {

                if (dongDuocChonTrenBangLopHoc != -1) {
                    if (!modelLopHoc.kiemTraCapNhapLopTruong(dongDuocChonTrenBangLopHoc, view2.getMaSoLopTruong())) {
                        view.hienThiThongBaoChuaNhapThongTinHocVien("Bạn đã chọn sai mã số lớp trưởng");
                    } else {
                        Object[][] data = modelLopHoc.capNhapLopTruong(dongDuocChonTrenBangLopHoc, view2.getMaSoLopTruong());
                        view2.hienThiLopHocTrenTable(data, modelLopHoc.getColumnLopHoc());
                    }
                } else {
                    view.hienThiThongBaoChuaNhapThongTinHocVien("Bạn chưa chọn lớp để cập nhập lớp trưởng");
                }

            } catch (SQLException ex) {
                Logger.getLogger(TruongHoc2Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    private class LopHocDuocXoa implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("dongDuocChonTrenBangLopHoc:" + dongDuocChonTrenBangLopHoc);
            if (dongDuocChonTrenBangLopHoc == -1) {
                view.hienThiThongBaoChuaNhapThongTinHocVien("Bạn chưa chọn lớp để xóa");
            } else {
                if (modelLopHoc.kiemTraSiSoLop(dongDuocChonTrenBangLopHoc)) {
                    view.hienThiThongBaoChuaNhapThongTinHocVien("Lớp học vẫn còn học viên nên bạn không thể xóa được");
                } else {
                    try {
                        Object[][] data = modelLopHoc.xoaLopHoc(dongDuocChonTrenBangLopHoc);
                        view2.hienThiLopHocTrenTable(data, modelLopHoc.getColumnLopHoc());

                    } catch (SQLException ex) {
                        Logger.getLogger(TruongHoc2Controller.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }

    }

    private class LopHocDuocCapNhapSiSo implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Object[][] data;
            try {
                data = modelLopHoc.capNhapLopSiSoLopHoc();
                view2.hienThiLopHocTrenTable(data, modelLopHoc.getColumnLopHoc());
            } catch (SQLException ex) {
            }
        }
    }

    private class LopHocDuocSuaThongTin implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (dongDuocChonTrenBangLopHoc == -1) {
                view.hienThiThongBaoChuaNhapThongTinHocVien("Bạn chưa chọn lớp để sửa");
            } else {
                inputLopHoc = view2.getInputLopHoc();
                try {
                    String maLopHocString = (String) inputLopHoc.get(0);
                    String maLopTruongDuocThayThe = modelLopHoc.thayTheMaLopTruong(maLopHocString, dongDuocChonTrenBangLopHoc);
                    modelLopHoc.setGiaTriDeCapNhapLaiBangHocVien(inputLopHoc, dongDuocChonTrenBangLopHoc, modelLopHoc.getDanhSachLop());
                    modelLopHoc.setMaLopTruong(maLopTruongDuocThayThe, dongDuocChonTrenBangLopHoc);
                    ArrayList<Object> cacGiaTriCanThayDoi = modelHocVien.layCacGiaTriCanSuaTuLopHoc();
                    ArrayList<HocVien> hocVienDuocCapNhapGiaTriTheoLop = modelHocVien.setMaLopCuaHocVien((String) cacGiaTriCanThayDoi.get(1), (String) cacGiaTriCanThayDoi.get(2), dongDuocChonTrenBangLopHoc);
                    Object[][] data = modelLopHoc.suaThongTinLopHoc(inputLopHoc, dongDuocChonTrenBangLopHoc);
                    if (data != null) {
                        view2.xoaCombobox();
                        view2.showMaLopTruong(hocVienDuocCapNhapGiaTriTheoLop);
                        view2.showMaGiaoVienChuNhiem(modelLopHoc.getDanhSachGiaoVien());
                        view2.hienThiLopHocTrenTable(data, modelLopHoc.getColumnLopHoc());
                    } else {
                        view.hienThiThongBaoChuaNhapThongTinHocVien("Bạn đã nhập trùng thông tin");
                    }

                } catch (SQLException ex) {
                }
                view2.setInputKhiDuocChonVaoTrenBangLopHoc(dongDuocChonTrenBangLopHoc);
            }
        }
    }

    //Khoa 
    private class KhoaDuocLoad implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Object[][] data = modelKhoa.loadData();
            try {
                ArrayList<String> danhSachMaGiaoVien = modelKhoa.getMaGiaoVien();
                view2.hienThiTrenTableKhoa(data, modelKhoa.getColumn());
                view2.setComboBoxChoBangKhoa(danhSachMaGiaoVien, maGiaoVienDangLaChuNhiemKhoa);
            } catch (SQLException ex) {
            }

        }

    }

    private class ComboBoxNam extends MouseAdapter {

 
        @Override
        public void mouseReleased(MouseEvent e) {
            System.out.println("Hello");
        }

    }
}
