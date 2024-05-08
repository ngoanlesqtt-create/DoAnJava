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
import View.TruongHoc1View;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author PC
 */
public class TruongHoc1Controller {

    private final HocVienModel modelHocVien;
    private final TruongHoc1View view;
    private final String[] columnHocVien = {"Mã học viên", "Họ", "Tên", "Ngày sinh", "Giới tính", "Nơi sinh", "Mã lớp"};
    private final String[] columnGiaoVien = {"Mã giáo viên", "Họ tên", "Học vị", "Giới tính", "Ngày sinh", "Hệ số", "Lương cơ bản", "Lương", "Khoa"};
    private int[] nhieuChiSoTable;
    private boolean state;
    private boolean stateSuaThongtin;
    private final GiaoVienModel modelGiaoVien;
    private final DataGiaoVien dataGiaoVien;
    private int[] cacChiSoBangGiaoVienDuocChon;
    private ArrayList<GiaoVien> giaoVienDuocTimThay;

    public TruongHoc1Controller() throws SQLException {
        this.view = new TruongHoc1View();
        this.state = false;
        this.stateSuaThongtin = false;
        //them giao vien
        this.dataGiaoVien = new DataGiaoVien();
        this.modelGiaoVien = new GiaoVienModel(this.dataGiaoVien.getDataGiaoVien());
        view.loadGiaoVienBangClickButton(new DataGiaoVienDuocLoad());
        view.themGiaoVien(new GiaoVienDuocThem());
        view.xoaGiaoVien(new CacGiaoVienDuocXoa());
        view.nhanNutXoaGiaoVien(new CacGiaoVienDuocNhanNutXoa());
        view.xoaHetGiaoVien(new GiaoVienDuocXoaHet());
        view.suaThongTinGiaoVien(new CacGiaoVienDuocSuaThongTin());
        view.xuLySuKienEnterChoTableGiaoVien(new CacThongTinGiaoVienDuocSuaKhinhanEnter());
        view.timKiemGiaoVien(new GiaoVienDuocTimKiem());
        this.giaoVienDuocTimThay = new ArrayList<>();
        view.tinhLuongGiaoVien(new GiaoVienDuocTinhLuong());
        view.dieuHuong(new TrangDieuHuong());
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
            Object[][] data = dataGiaoVien.capNhapDanhSachGiaoVien();
            view.hienThiTableGiaoVien(data, columnGiaoVien);
            modelGiaoVien.setDanhSachGiaoVien(dataGiaoVien.getDataGiaoVien());
            view.loadGiaoVien(modelGiaoVien);
            state = false;
            view.xoaInputTableGiaoVien();

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
                        System.out.println("test dong 102 TruongHocController");
                        if (giaoVienDuocThemVao == null) {
                            view.hienThiThongBaoChuaNhapThongTinHocVien("Ban nhap trung ma giao vien");
                        } else {
                            modelGiaoVien.setDanhSachGiaoVien(giaoVienDuocThemVao);
                            Object[][] data = dataGiaoVien.capNhapDanhSachGiaoVien();
                            view.hienThiTableGiaoVien(data, columnGiaoVien);
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
            view.setLaiGiaTriInputGiaoVien();
        }
    }

    private class CacGiaoVienDuocNhanNutXoa implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (!dataGiaoVien.getDataGiaoVien().isEmpty()) {
                if (cacChiSoBangGiaoVienDuocChon == null) {
                    view.hienThiThongBaoChuaNhapThongTinHocVien("Bạn chưa chọn giáo viên để xóa");
                } else {
                    try {
                        if (!state) {
                            ArrayList<GiaoVien> cacGiaoVienDuocXoa = dataGiaoVien.xoaGiaoVien(cacChiSoBangGiaoVienDuocChon);
                            modelGiaoVien.setDanhSachGiaoVien(cacGiaoVienDuocXoa);
                            Object[][] data = dataGiaoVien.capNhapDanhSachGiaoVien();
                            view.hienThiTableGiaoVien(data, columnGiaoVien);
                        } else {
                            String maHocVienCanXoa = view.getMaGiaoVien();
                            ArrayList<GiaoVien> giaoVienDuocXoa = dataGiaoVien.xoaGiaoVienDuocTimKiem(maHocVienCanXoa);
                            Object[][] data = dataGiaoVien.capNhapDanhSachGiaoVien(giaoVienDuocXoa);
                            view.hienThiTableGiaoVien(data, columnHocVien);
                        }

                    } catch (SQLException ex) {
                    }

                }
            } else {
                view.hienThiThongBaoChuaNhapThongTinHocVien("Đã hết giáo viên để xóa");
            }

        }

    }

    private class GiaoVienDuocXoaHet implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            int soLuongGiaoVienTrongbang = view.getColumnCountGiaoVien();
            if (soLuongGiaoVienTrongbang >= 1) {
                cacChiSoBangGiaoVienDuocChon = new int[soLuongGiaoVienTrongbang];
                for (int i = 0; i <= soLuongGiaoVienTrongbang - 1; i++) {
                    cacChiSoBangGiaoVienDuocChon[i] = i;
                }
                ArrayList<GiaoVien> cacGiaoVienDuocXoa;
                try {
                    cacGiaoVienDuocXoa = dataGiaoVien.xoaGiaoVien(cacChiSoBangGiaoVienDuocChon);
                    modelGiaoVien.setDanhSachGiaoVien(cacGiaoVienDuocXoa);
                    Object[][] data = dataGiaoVien.capNhapDanhSachGiaoVien();
                    view.hienThiTableGiaoVien(data, columnGiaoVien);
                } catch (SQLException ex) {
                }
            } else {
                view.hienThiThongBaoChuaNhapThongTinHocVien("Đã hết giáo viên để xóa");
            }

        }

    }

    private class CacGiaoVienDuocSuaThongTin implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (cacChiSoBangGiaoVienDuocChon != null) {
                if (cacChiSoBangGiaoVienDuocChon.length == 0) {
                    view.hienThiThongBaoChuaNhapThongTinHocVien("Bạn chưa chọn giáo viên để sửa");
                } else if (cacChiSoBangGiaoVienDuocChon.length > 1) {
                    view.hienThiThongBaoChuaNhapThongTinHocVien("Bạn chỉ được chọn một giáo viên để sửa");
                } else {
                    ArrayList<Object> thongTinInputGiaoVien = view.getThongTinInputGiaoVien();
                    if (!InputThongTin.kiemTraInputRong(thongTinInputGiaoVien)) {
                        view.hienThiThongBaoChuaNhapThongTinHocVien("Ban chua nhap thong tin cua giao vien");
                    } else {
                        if (!InputThongTin.kiemTraToanBoThongTinInput(thongTinInputGiaoVien)) {//xac thuc cac input cua giao vien
                            view.hienThiThongBaoChuaNhapThongTinHocVien("Ban nhap sai thong tin");
                        } else {
                            try {

                                if (!state) {
                                    ArrayList<GiaoVien> cacGiaoVienDuocSuaThongTin = dataGiaoVien.suaThongTinGiaoVien(thongTinInputGiaoVien, cacChiSoBangGiaoVienDuocChon[0]);
                                    if (cacGiaoVienDuocSuaThongTin != null) {
                                        Object[][] data = dataGiaoVien.capNhapDanhSachGiaoVien();
                                        view.hienThiTableGiaoVien(data, columnGiaoVien);
                                    } else {
                                        view.hienThiThongBaoChuaNhapThongTinHocVien("Bạn đã nhập trùng mã giáo viên");
                                    }
                                } else {
                                    ArrayList<GiaoVien> giaoVienDuocThayDoiThongTin = dataGiaoVien.suaThongTinGiaoVienKhiTimKiemBangInput(thongTinInputGiaoVien, giaoVienDuocTimThay.get(0).getMaGiaoVien());
                                    Object[][] data = dataGiaoVien.capNhapDanhSachGiaoVien(giaoVienDuocThayDoiThongTin);
                                    view.hienThiTableGiaoVien(data, columnGiaoVien);
                                }
                                view.setLaiGiaTriInputGiaoVien();
                            } catch (SQLException ex) {
                            }

                        }
                    }
                }
            } else {
                view.hienThiThongBaoChuaNhapThongTinHocVien("Bạn chưa chọn giáo viên để sửa");
            }

        }

    }

    private class CacThongTinGiaoVienDuocSuaKhinhanEnter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                try {
                    if (state) {
                        String maGiaoVienDuocTim = view.getMaGiaoVien();
                        giaoVienDuocTimThay = dataGiaoVien.timGiaoVienTheoMa(maGiaoVienDuocTim);
                        int coulmnTableGiaoVien = view.getColumGiaoVien();
                        switch (coulmnTableGiaoVien) {
                            case 1 -> {
                                dataGiaoVien.setDataGiaoVien(dataGiaoVien.suaThongTinGiaoVienTrucTiepTrenBang(giaoVienDuocTimThay.get(0)));
                                break;
                            }
                            case 2 -> {
                                dataGiaoVien.setDataGiaoVien(dataGiaoVien.suaThongTinGiaoVienTrucTiepTrenBang(giaoVienDuocTimThay.get(0)));
                                break;
                            }
                            case 3 -> {
                                dataGiaoVien.setDataGiaoVien(dataGiaoVien.suaThongTinGiaoVienTrucTiepTrenBang(giaoVienDuocTimThay.get(0)));
                                break;
                            }
                            case 5 -> {

                                dataGiaoVien.setDataGiaoVien(dataGiaoVien.suaThongTinGiaoVienTrucTiepTrenBang(giaoVienDuocTimThay.get(0)));
                                break;
                            }
                            case 6 -> {
                                dataGiaoVien.setDataGiaoVien(dataGiaoVien.suaThongTinGiaoVienTrucTiepTrenBang(giaoVienDuocTimThay.get(0)));
                                break;
                            }
                        }
                    }
                    view.setLaiGiaTriInputGiaoVien();
                } catch (SQLException ex) {
                }

            }
        }

    }

    private class GiaoVienDuocTimKiem implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            state = true;
            String maGiaoVienDuocTim = view.getMaGiaoVien();
            if (maGiaoVienDuocTim == null || maGiaoVienDuocTim.length() == 0) {
                view.hienThiThongBaoChuaNhapThongTinHocVien("Bạn chưa nhập thông tin giáo viên muốn tìm");
            } else {
                try {
                    giaoVienDuocTimThay = dataGiaoVien.timGiaoVienTheoMa(maGiaoVienDuocTim);
                    if (giaoVienDuocTimThay.isEmpty()) {
                        view.hienThiThongBaoChuaNhapThongTinHocVien("Không tìm thấy giáo viên bạn muốn tìm");
                    } else {
                        Object[][] data = dataGiaoVien.capNhapDanhSachGiaoVien(giaoVienDuocTimThay);
                        view.hienThiTableGiaoVien(data, columnGiaoVien);
                        view.setLaiGiaTriInputGiaoVien();
                        modelGiaoVien.setDanhSachGiaoVien(giaoVienDuocTimThay);
                        view.loadGiaoVien(modelGiaoVien);
                    }

                } catch (SQLException ex) {
                }

            }
        }

    }

    private class GiaoVienDuocTinhLuong implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                Object[][] data = dataGiaoVien.tinhLuongGiaoVien();
                view.hienThiTrenTable(data, columnGiaoVien);
            } catch (SQLException ex) {
            }
        }

    }

    private class TrangDieuHuong implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            view.hienThiTruongHoc2View();
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
