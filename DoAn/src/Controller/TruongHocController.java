/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Data.DataGiaoVien;
import InputThongTin.InputThongTin;
import ModelGiaoVien.GiaoVien;
import ModelGiaoVien.GiaoVienModel;
import ModelHocVien.HocVien;
import ModelHocVien.HocVienModel;
import View.TruongHocView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
public class TruongHocController {

    private final HocVienModel modelHocVien;
    private final TruongHocView view;
    private final String[] columnHocVien = {"Mã học viên", "Họ", "Tên", "Ngày sinh", "Giới tính", "Nơi sinh", "Mã lớp"};
    private int[] nhieuChiSoTable;
    private boolean state;
    private boolean stateSuaThongtin;
    private GiaoVienModel modelGiaoVien;
    private DataGiaoVien dataGiaoVien;
    private int[] cacChiSoBangGiaoVienDuocChon;

    public TruongHocController() throws SQLException {
        this.view = new TruongHocView();
        this.state = false;
        this.stateSuaThongtin = false;
        //them giao vien
        this.dataGiaoVien = new DataGiaoVien();
        this.modelGiaoVien = new GiaoVienModel(this.dataGiaoVien.getDataGiaoVien());
        view.loadGiaoVienBangClickButton(new DataGiaoVienDuocLoad());
        view.themGiaoVien(new GiaoVienDuocThem());
        view.xoaGiaoVien(new CacGiaoVienDuocXoa());
        view.nhanNutXoaGiaoVien(new CacGiaoVienDuocNhanNutXoa());
        //Thêm học viên
        modelHocVien = new HocVienModel();
        modelHocVien.nhap();
        view.loadHocVien(new LoadedHocVien());//load học viên bằng bấm nút load
        view.loadHocVienBangEnter(new LoadedHocVienBangEnter());
        view.timHocVien(new HocVienDuocTimThay());
        view.tatPopUpThongBaoTimKiemHocVien(new CachTatThongBaoTimKiemHocVien());
        view.tatPopUpThongBaoChuaNhapThongTinSinhVien(new CachTatThongBaoChuaNhapThongTinSinhVien());
        view.themHocVien(new HocVienDuocThem());
        view.xoaHocVien(new HocVienBiXoa());
        view.layDuLieuBang(new DuLieuDuocLayTuBang());
        view.xoaHetDuLieuBang(new DuLieuBangBiXoaHet());
        view.suaThongTinHocVien(new ThongTinHocVienDuocSua());//Sửa thông tin học viên
        view.capNhapDuLieuTungO(new DuLieuDuocThayDoi());//bat su kien khi bam nut enter
        view.setVisible(true);
    }

    private class DataGiaoVienDuocLoad implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            view.loadGiaoVien(modelGiaoVien);
        }
    }

    private class GiaoVienDuocThem implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            ArrayList<Object> thongTinInputGiaoVien = view.getThongTinInputGiaoVien();
            if (!InputThongTin.kiemTraInputRong(thongTinInputGiaoVien)) {
                view.hienThiThongBaoChuaNhapThongTinHocVien("Ban chua nhap thong tin cua giao vien");
            } else {
                if (!InputThongTin.kiemTraToanBoThongTinInput(thongTinInputGiaoVien)) {//xac thuc cac input cua giao vien
                    view.hienThiThongBaoChuaNhapThongTinHocVien("Ban nhap sai thong tin");
                } else {
                    try {
                        ArrayList<GiaoVien> giaoVienDuocThemVao = dataGiaoVien.themGiaoVien(thongTinInputGiaoVien);
                        if (giaoVienDuocThemVao == null) {
                            view.hienThiThongBaoChuaNhapThongTinHocVien("Ban nhap trung ma giao vien");
                        } else {
                            modelGiaoVien.setDanhSachGiaoVien(giaoVienDuocThemVao);
                            view.loadGiaoVien(modelGiaoVien);
                        }

                    } catch (SQLException ex) {
                    }
                }
            }
        }

    }

    private class CacGiaoVienDuocXoa implements ListSelectionListener {

        @Override
        public void valueChanged(ListSelectionEvent e) {
            if (e.getValueIsAdjusting()) {
                return;
            }
            cacChiSoBangGiaoVienDuocChon = view.getRowsGiaoVien();
        }

    }

    private class CacGiaoVienDuocNhanNutXoa implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (cacChiSoBangGiaoVienDuocChon == null) {
                view.hienThiThongBaoChuaNhapThongTinHocVien("Bạn chưa chọn giáo viên để xóa");
            } else {
                try {
                    ArrayList<GiaoVien> cacGiaoVienDuocXoa = dataGiaoVien.xoaGiaoVien(cacChiSoBangGiaoVienDuocChon);
                    modelGiaoVien.setDanhSachGiaoVien(cacGiaoVienDuocXoa);
                    view.loadGiaoVien(modelGiaoVien);
                } catch (SQLException ex) {
                }

            }

        }

    }
//Học viên

    private class LoadedHocVienBangEnter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                try {
                    state = false;
                    stateSuaThongtin = false;
                    Object[][] data = modelHocVien.getDataHocVien();
                    view.xoaInputHocVien();
                    view.hienThiTrenTable(data, columnHocVien);
                } catch (SQLException ex) {
                }
            }
        }
    }

    private class LoadedHocVien implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                state = false;
                stateSuaThongtin = false;
                Object[][] data = modelHocVien.getDataHocVien();
                view.xoaInputHocVien();
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
            stateSuaThongtin = true;
            if (view.getThongTinVienMuonTim() != null) {//Nếu đã nhập các thông tin tìm kiếm học viên
                Object[][] data = modelHocVien.timHocVienTheoThongTin(view.getThongTinVienMuonTim());
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
                Object[][] data = modelHocVien.themHocVienVaoDanhSach(hocVienDuocThemVao);
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
            nhieuChiSoTable = view.layNhieuChiSoMang();

        }
    }

    private class HocVienBiXoa implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                if (view.getThongTinVienMuonTim() != null && state) {
                    Object[][] cacHocVienDuocTimThay = modelHocVien.timHocVienTheoThongTin(view.getThongTinVienMuonTim());
                    if (cacHocVienDuocTimThay != null) {
                        Object[][] cacHocVienDuocXoaKhiTimThay = modelHocVien.xoaCacHocVienDuocTimThay(nhieuChiSoTable, view.getThongTinVienMuonTim());
                        view.hienThiTrenTable(cacHocVienDuocXoaKhiTimThay, columnHocVien);
                    } else {
                        view.hienThiThongBaoChuaNhapThongTinHocVien("Đã hết học viên để xóa");
                    }
                }
                if (!state) {//Nếu đang ở vị trí bảng chính
                    if (modelHocVien.getDataHocVien().length != 0) {
                        if (nhieuChiSoTable != null) {
                            Object[][] data = modelHocVien.xoaHocVien(nhieuChiSoTable);
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

    private class DuLieuBangBiXoaHet implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            int doDaiBang = view.getDoDaiBang();
            if (doDaiBang >= 1) {
                //khởi tạo giá trị cho mảng nhieuChiSoTable
                nhieuChiSoTable = new int[doDaiBang];
                for (int i = 0; i <= doDaiBang - 1; i++) {
                    nhieuChiSoTable[i] = i;
                }
                try {
                    Object[][] data = modelHocVien.xoaHocVien(nhieuChiSoTable);
                    view.hienThiTrenTable(data, columnHocVien);
                } catch (SQLException ex) {
                }
            } else {
                view.hienThiThongBaoChuaNhapThongTinHocVien("Đã hết học viên để xóa");
            }
        }
    }

    private class ThongTinHocVienDuocSua implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                HocVien hocVienDuocSua = view.getHocVien();
                if (nhieuChiSoTable.length == 1) {
                    if (!stateSuaThongtin) {
                        Object[][] data = modelHocVien.suaThongTinHocVien(hocVienDuocSua, nhieuChiSoTable[0]);
                        if (data != null) {
                            view.hienThiTrenTable(data, columnHocVien);
                        } else {
                            view.hienThiThongBaoChuaNhapThongTinHocVien("Bạn đã nhập sai thông tin cần sửa");
                        }
                    } else {
                        Object[][] hocVienDuocSuaThongTinKhiTimThay = modelHocVien.suaThongTinHocVienKhiDuocTimKiem(nhieuChiSoTable[0], view.getThongTinVienMuonTim(), hocVienDuocSua);
                        view.hienThiTrenTable(hocVienDuocSuaThongTinKhiTimThay, columnHocVien);
                    }
                } else if (nhieuChiSoTable.length > 1) {
                    view.hienThiThongBaoChuaNhapThongTinHocVien("Bạn chỉ có thể chọn 1 học viên để sửa");
                } else if (nhieuChiSoTable.length == 0) {
                    view.hienThiThongBaoChuaNhapThongTinHocVien("Bạn chưa chọn sinh viên nào để sửa");
                }
            } catch (ParseException | SQLException ex) {
            }

        }
    }

    private class DuLieuDuocThayDoi extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                try {
                    int hang = view.getRow();
                    int cot = view.getColumn();
                    HocVien hocVienDuocChon = view.getHocVien();
                    if (view.getThongTinVienMuonTim() == null) {
                        switch (cot) {
                            case 0 -> {
                                if (!((String) view.getGiaTriTungO(hang, 0)).contains("K11") && !((String) view.getGiaTriTungO(hang, 0)).contains("K12") && !((String) view.getGiaTriTungO(hang, 0)).contains("K13")) {
                                    view.hienThiThongBaoChuaNhapThongTinHocVien("Bạn đã nhập sai mã lớp");
                                    view.setGiaTriTungO(hocVienDuocChon.getMaHocVien(), hang, 0);
                                } else if (!((String) view.getGiaTriTungO(hang, 0)).contains((String) (view.getGiaTriTungO(hang, 6)))) {
                                    view.setGiaTriTungO(hocVienDuocChon.getMaHocVien(), hang, 0);
                                    view.hienThiThongBaoChuaNhapThongTinHocVien("Bạn phải sửa mã lớp trước");
                                } else {
                                    hocVienDuocChon.setMaHocVien((String) view.getGiaTriTungO(hang, 0));
                                    hocVienDuocChon.setMaLop((String) view.getGiaTriTungO(hang, 6));
                                    Object[][] hocVienSauKhiDuocSuaBangEnter = modelHocVien.suaThongTinHocVien(hocVienDuocChon, nhieuChiSoTable[0]);
                                    if (hocVienSauKhiDuocSuaBangEnter != null) {
                                        view.hienThiTrenTable(hocVienSauKhiDuocSuaBangEnter, columnHocVien);
                                    } else {
                                        view.hienThiThongBaoChuaNhapThongTinHocVien("Bạn đã nhập trùng mã số sinh viên");
                                        view.setGiaTriTungO(hocVienDuocChon.getMaHocVien(), hang, 0);
                                    }
                                }
                                view.setLaiGiaTriInput();

                                break;
                            }
                            case 1 -> {
                                hocVienDuocChon.setHo((String) view.getGiaTriTungO(hang, 1));
                                modelHocVien.suaThongTinHocVien(hocVienDuocChon, nhieuChiSoTable[0]);
                                view.setLaiGiaTriInput();
                                break;
                            }
                            case 2 -> {
                                hocVienDuocChon.setTen((String) view.getGiaTriTungO(hang, 2));
                                modelHocVien.suaThongTinHocVien(hocVienDuocChon, nhieuChiSoTable[0]);
                                view.setLaiGiaTriInput();
                                break;
                            }

                            case 4 -> {

                                hocVienDuocChon.setGioiTinh((String) view.getGiaTriTungO(hang, 4));
                                modelHocVien.suaThongTinHocVien(hocVienDuocChon, nhieuChiSoTable[0]);
                                view.setLaiGiaTriInput();
                            }
                            case 5 -> {
                                hocVienDuocChon.setNoiSinh((String) view.getGiaTriTungO(hang, 5));
                                modelHocVien.suaThongTinHocVien(hocVienDuocChon, nhieuChiSoTable[0]);
                                view.setLaiGiaTriInput();
                                break;
                            }
                            case 6 -> {
                                if (!((String) view.getGiaTriTungO(hang, 6)).equalsIgnoreCase("K11") && !((String) view.getGiaTriTungO(hang, 6)).equalsIgnoreCase("K12") && !((String) view.getGiaTriTungO(hang, 6)).equalsIgnoreCase("K13")) {
                                    view.setGiaTriTungO(hocVienDuocChon.getMaLop(), hang, 6);
                                    view.hienThiThongBaoChuaNhapThongTinHocVien("Mã lớp bạn nhập không tồn tại");
                                    break;
                                }
                                view.hienThiThongBaoChuaNhapThongTinHocVien("Bạn nhớ sửa mã học viên nhé");
                                view.setLaiGiaTriInput();
                                break;
                            }
                        }
                    } else {
                        System.out.println("Hello dong 125 controller");
                        switch (cot) {

                            case 0 -> {
                                if (!((String) view.getGiaTriTungO(hang, 0)).contains("K11") && !((String) view.getGiaTriTungO(hang, 0)).contains("K12") && !((String) view.getGiaTriTungO(hang, 0)).contains("K13")) {
                                    view.hienThiThongBaoChuaNhapThongTinHocVien("Bạn đã nhập sai mã lớp");
                                    view.setGiaTriTungO(hocVienDuocChon.getMaHocVien(), hang, 0);
                                } else if (!((String) view.getGiaTriTungO(hang, 0)).contains((String) (view.getGiaTriTungO(hang, 6)))) {
                                    view.setGiaTriTungO(hocVienDuocChon.getMaHocVien(), hang, 0);
                                    view.hienThiThongBaoChuaNhapThongTinHocVien("Bạn phải sửa mã lớp trước");
                                } else {
                                    hocVienDuocChon.setMaHocVien((String) view.getGiaTriTungO(hang, 0));
                                    hocVienDuocChon.setMaLop((String) view.getGiaTriTungO(hang, 6));
                                    view.setLaiGiaTriInput();
                                    Object[][] hocVienDuocSuaThongTinKhiTimThay = modelHocVien.suaThongTinHocVienKhiDuocTimKiem(nhieuChiSoTable[0], view.getThongTinVienMuonTim(), hocVienDuocChon);
                                    if (hocVienDuocSuaThongTinKhiTimThay == null) {
                                        view.hienThiThongBaoChuaNhapThongTinHocVien("Bạn đã nhập trùng mã số sinh viên");
                                        view.setGiaTriTungO(hocVienDuocChon.getMaHocVien(), hang, 0);
                                    } else {
                                        view.hienThiTrenTable(hocVienDuocSuaThongTinKhiTimThay, columnHocVien);
                                    }
                                    break;
                                }
                            }

                            case 1 -> {
                                hocVienDuocChon.setHo((String) view.getGiaTriTungO(hang, 1));
                                modelHocVien.suaThongTinHocVienKhiDuocTimKiem(nhieuChiSoTable[0], view.getThongTinVienMuonTim(), hocVienDuocChon);
                                view.setLaiGiaTriInput();
                                break;
                            }
                            case 2 -> {
                                hocVienDuocChon.setTen((String) view.getGiaTriTungO(hang, 2));
                                modelHocVien.suaThongTinHocVienKhiDuocTimKiem(nhieuChiSoTable[0], view.getThongTinVienMuonTim(), hocVienDuocChon);
                                view.setLaiGiaTriInput();
                                break;
                            }
                            case 4 -> {
                                hocVienDuocChon.setTen((String) view.getGiaTriTungO(hang, 4));
                                modelHocVien.suaThongTinHocVienKhiDuocTimKiem(nhieuChiSoTable[0], view.getThongTinVienMuonTim(), hocVienDuocChon);
                                view.setLaiGiaTriInput();
                                break;
                            }
                            case 5 -> {
                                hocVienDuocChon.setNoiSinh((String) view.getGiaTriTungO(hang, 5));
                                modelHocVien.suaThongTinHocVienKhiDuocTimKiem(nhieuChiSoTable[0], view.getThongTinVienMuonTim(), hocVienDuocChon);
                                view.setLaiGiaTriInput();
                                break;
                            }
                            case 6 -> {
                                if (!((String) view.getGiaTriTungO(hang, 6)).equalsIgnoreCase("K11") && !((String) view.getGiaTriTungO(hang, 6)).equalsIgnoreCase("K12") && !((String) view.getGiaTriTungO(hang, 6)).equalsIgnoreCase("k13")) {
                                    view.hienThiThongBaoChuaNhapThongTinHocVien("Lớp học bạn sửa không tồn tại");
                                    break;
                                } else {
                                    hocVienDuocChon.setMaLop((String) view.getGiaTriTungO(hang, 6));
                                    modelHocVien.suaThongTinHocVienKhiDuocTimKiem(nhieuChiSoTable[0], view.getThongTinVienMuonTim(), hocVienDuocChon);
                                    view.setLaiGiaTriInput();
                                    view.hienThiThongBaoChuaNhapThongTinHocVien("Bạn nhớ sửa mã lớp nhé");
                                    break;
                                }
                            }

                        }
                    }
                } catch (ParseException | SQLException ex) {
                }

            }
        }

    }
}
