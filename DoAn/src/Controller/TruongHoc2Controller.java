/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import InputThongTin.InputThongTin;
import ModelGiaoVien.GiaoVien;
import ModelHocVien.HocVien;
import ModelKetQuaThi.KetQuaThiModel;
import ModelKhoa.Khoa;
import ModelKhoa.KhoaModel;
import ModelLop.LopHocModel;
import View.TruongHoc2View;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.text.ParseException;
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
    private final KhoaModel modelKhoa;
    private final KetQuaThiModel modelKetQuaThi;
    private final TruongHoc2View view2;
    private ArrayList<Object> inputLopHoc;
    private ArrayList<String> maGiaoVienDangLaChuNhiemKhoa;
    private ArrayList<Object> inputKhoa;
    private int rowTableKhoa;

    public TruongHoc2Controller() throws SQLException {
        this.modelKetQuaThi = new KetQuaThiModel();
        this.modelKhoa = new KhoaModel();
        this.inputLopHoc = new ArrayList<>();
        this.modelLopHoc = new LopHocModel();
        this.maGiaoVienDangLaChuNhiemKhoa = this.modelKhoa.getMaGiaoVienDangLaChuNhiemKhoa();
        this.view2 = new TruongHoc2View(this.modelHocVien.getDanhSachHocVien(), this.dataGiaoVien.getDataGiaoVien(),
                this.modelKhoa.getMaGiaoVien(), maGiaoVienDangLaChuNhiemKhoa, this.modelKetQuaThi.getMaMonHoc());
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
        view2.batSuKienChoJpanel(new JpanelKhoa());
        view2.batSuKienNgayThangNam(new NgayThangNam());
        view2.themKhoa(new KhoaDuocThem());
        view2.capNhapGiaoVienTrenBangKhoa(new KhoaDuocCapNhapSiSoGiaoVien());
        view2.xoaKhoa(new KhoaDuocXoa());
        view2.xuLiSuKienTungDongTrenBangKhoa(new DongTrenBangKhoa());
        view2.batSuKienEnterTrenBangKhoa(new KhoaDuocBatSuKienEnter());
        this.rowTableKhoa = -1;
        //KetQuaThi
        view2.loadKetQuaThi(new KetQuaThiDuocLoad());
        view2.capNhapMaHocVienTheoKhoa(new KetQuaThiCapNhapMaHocVienTheoKhoa());
        view2.timKetQuaThi(new KetQuaThiDuocTim());
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
            try {
                Object[][] data = modelLopHoc.capNhapLopSiSoLopHoc();
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
    private void capNhapComboBoxKhoa() throws SQLException {
        maGiaoVienDangLaChuNhiemKhoa = modelKhoa.getMaGiaoVienDangLaChuNhiemKhoa();
        ArrayList<String> danhSachMaGiaoVien = modelKhoa.getMaGiaoVien();
        view2.setComboBoxChoBangKhoa(danhSachMaGiaoVien, maGiaoVienDangLaChuNhiemKhoa);
        view2.resetComboBoxNamThanhLapKhoa();

    }

    private class KhoaDuocLoad implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                Object[][] data = modelKhoa.loadData();
                view2.hienThiTrenTableKhoa(data, modelKhoa.getColumn());
                view2.hienThiBangKhoaBangAbstractTableModel(modelKhoa);
                capNhapComboBoxKhoa();
            } catch (SQLException ex) {
            }

        }

    }

    private class ComboBoxNam extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                view2.tangThemNamThanhLapKhoa();
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                view2.tangThemNamThanhLapKhoa();
            }
        }

    }

    private class JpanelKhoa extends MouseAdapter {

        @Override
        public void mouseReleased(MouseEvent e) {
            view2.resetComboBoxNamThanhLapKhoa();
        }

    }

    private class NgayThangNam implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent e) {
            if (e.getSource() == view2.getJcombobox()) {
                view2.xacThucNgayThangNam();
            }

        }
    }

    private class KhoaDuocThem implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            inputKhoa = view2.getInputKhoa();
            if (!InputThongTin.kiemTraInputRong(inputKhoa)) {
                view.hienThiThongBaoChuaNhapThongTinHocVien("Bạn đã nhập thiếu thông tin");
            } else {
                try {
                    Object[][] data = modelKhoa.themKhoa(inputKhoa);
                    if (data != null) {
                        view2.hienThiTrenTableKhoa(data, modelKhoa.getColumn());
                        capNhapComboBoxKhoa();
                    } else {
                        view.hienThiThongBaoChuaNhapThongTinHocVien("Bạn đã nhập sai thông tin");
                    }
                } catch (SQLException | ParseException ex) {
                }

            }
        }

    }

    private class KhoaDuocCapNhapSiSoGiaoVien implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                Object[][] data = modelKhoa.capNhapSiSoGiaoVienKhoa();
                view2.hienThiTrenTableKhoa(data, modelKhoa.getColumn());
                capNhapComboBoxKhoa();
            } catch (SQLException ex) {
            }
        }
    }

    private class DongTrenBangKhoa implements ListSelectionListener {

        @Override
        public void valueChanged(ListSelectionEvent e) {
            if (e.getValueIsAdjusting()) {
                return;
            }
            try {
                rowTableKhoa = view2.getRowTableKhoa();
                if (rowTableKhoa != -1) {
                    ArrayList<Khoa> danhSachKhoa = modelKhoa.getDanhSachKhoa();
                    ArrayList<GiaoVien> danhSachGiaoVien = modelKhoa.getDanhSachGiaoVien();
                    view2.locMaGiaoVienDeLamTruongKhoa(danhSachKhoa, danhSachGiaoVien, rowTableKhoa);
                    view2.showThongTinKhoaTrenInput(rowTableKhoa);
                }
            } catch (SQLException ex) {
            }

        }

    }

    private class KhoaDuocXoa implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (rowTableKhoa == -1) {
                view.hienThiThongBaoChuaNhapThongTinHocVien("Bạn chưa chọn khoa nào để xóa");
            } else {
                try {
                    Object[][] data = modelKhoa.xoaKhoa(rowTableKhoa);
                    if (data != null) {
                        view2.hienThiTrenTableKhoa(data, modelKhoa.getColumn());
                    } else {
                        view.hienThiThongBaoChuaNhapThongTinHocVien("Vẫn còn giáo viên nên bạn không thể xóa được");
                    }
                    rowTableKhoa = -1;
                } catch (SQLException ex) {
                }
            }
        }

    }

    private class KhoaDuocBatSuKienEnter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
            try {
                ArrayList<Khoa> danhSachKhoa = modelKhoa.getDanhSachKhoa();
                if (danhSachKhoa.get(rowTableKhoa).getTruongKhoa() == null) {
                    view.hienThiThongBaoChuaNhapThongTinHocVien("Bạn đã chọn sai mã trưởng khoa");
                } else {
                    capNhapComboBoxKhoa();
                }
            } catch (SQLException ex) {
            }

        }

    }

    //KetQuaThi
    private class KetQuaThiDuocLoad implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                state = false;
                Object[][] data = modelKetQuaThi.loadDataketQuaThi();
                view2.hienThiBangKetQuaThi(data, modelKetQuaThi.getColumn());
                view2.hienThiBangKetQuaThiBangAbstractModel(modelKetQuaThi);
                view2.showComboBoxMaHocVienTrenBangKetQuaThi(modelHocVien.getHocVien());
            } catch (SQLException ex) {
            }
        }

    }

    private class KetQuaThiCapNhapMaHocVienTheoKhoa implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Object[][] data;
            try {
                data = modelKetQuaThi.suaMaHocVienTheoBangKhoa();
                view2.hienThiBangKetQuaThi(data, modelKetQuaThi.getColumn());
                view2.showComboBoxMaHocVienTrenBangKetQuaThi(modelHocVien.getHocVien());
                view2.hienThiBangKetQuaThiBangAbstractModel(modelKetQuaThi);
            } catch (SQLException ex) {
            }

        }

    }

    private class KetQuaThiDuocTim implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            ArrayList<Object> inputBangKetQuaThi = view2.getInputBangKetQuaThi();
            Object[][] data = modelKetQuaThi.ketQuaThiDuocTimKiem(inputBangKetQuaThi);
            if (data == null) {
                view.hienThiThongBaoChuaNhapThongTinHocVien("Không tìm thấy học viên");
            } else {
                view2.hienThiBangKetQuaThi(data, modelKetQuaThi.getColumn());
                state = true;
            }

        }

    }
}
