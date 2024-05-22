/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import ModelGiaoVien.GiaoVienModel;
import ModelHocVien.HocVien;
import ModelKhoa.Khoa;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PC
 */
public final class TruongHoc1View extends javax.swing.JFrame {

    private int hangNgang;
    private ArrayList<String> gioiTinh;
    private ArrayList<Number> ngaySinh;
    private ArrayList<String> maKhoa;

    /**
     * Creates new form QLGVView
     *
     * @param danhSachKhoa
     */
    public TruongHoc1View(ArrayList<Khoa> danhSachKhoa) {
        initComponents();
        showGioiTinhGiaoVien();
        showNgaySinhGiaoVien();
        showNamSinhGiaoVien();
        showMaKhoaGiaoVien(danhSachKhoa);
        showHocViGiaoVien();
        buttonGroupGioiTinh.add(radioButtonNu);
        buttonGroupGioiTinh.add(radioButtonNam);
        dialogThongBaoChuaNhapThongTinHocVien.setLocationRelativeTo(null);
    }

    public int xacNhanXoaHocVien() {
        int x = JOptionPane.showConfirmDialog(this, "Bạn đã chắc chắn muốn xóa?", "Xác nhận", JOptionPane.DEFAULT_OPTION);
        if (x == JOptionPane.YES_OPTION) {
            return 0;
        }
 
        return 1;
    }

    public void loadHocVien(ActionListener listen) {
        btnNhapHocVien.addActionListener(listen);
    }

    public void loadHocVienBangEnter(KeyAdapter listener) {
        jTabbedPanelHocVien.addKeyListener(listener);
    }

    public void timHocVien(ActionListener listen) {
        btnTimHocVien.addActionListener(listen);
    }

    public String getThongTinVienMuonTim() {
        if (textMaHocVienMuonTim.getText().length() != 0 && textMaHocVienMuonTim.getText() != null) {
            return textMaHocVienMuonTim.getText();
        }
        if (textHoTenMuonTim.getText().length() != 0 && textHoTenMuonTim.getText() != null && textMaLop.getText().length() != 0 && textMaLop.getText() != null) {
            return textHoTenMuonTim.getText() + " " + textMaLop.getText();
        }
        if (textHoTenMuonTim.getText().length() != 0) {
            if (textHoTenMuonTim.getText() != null) {
                return textHoTenMuonTim.getText();
            }
        }
        if (textMaLop.getText().length() != 0 && textMaLop.getText() != null) {
            return textMaLop.getText();
        }

        return null;
    }

    public void hienThiTrenTable(Object[][] data, String[] column) {
        DefaultTableModel table = new DefaultTableModel(data, column);
        tableHocVien.setModel(table);

    }

    public void hienThiPopUpThongBaoTimKiemHocVien() {
        dialogThongBaoTimKiemHocVien.setVisible(true);
    }

    public void tatPopUpThongBaoTimKiemHocVien(ActionListener listener) {
        btnThoatDialog.addActionListener(listener);
    }

    public void tatHienThiPopUpThongBaoTimKiemHocVien() {
        dialogThongBaoTimKiemHocVien.setVisible(false);
    }

    public void hienThiThongBaoChuaNhapThongTinHocVien(String thongBao) {
        labelThongBaoNhapKhongThanhCong.setText(thongBao);
        dialogThongBaoChuaNhapThongTinHocVien.setVisible(true);
    }

    public void tatPopUpThongBaoChuaNhapThongTinSinhVien(ActionListener listener) {
        btnThoatDialogChuaNhapThongTinSinhVien.addActionListener(listener);
    }

    public void tatHienThiPopUpThongBaoChuaNhapThongTinHocVien() {
        dialogThongBaoChuaNhapThongTinHocVien.setVisible(false);
    }

    public void themHocVien(ActionListener listener) {
        btnThemHocVien.addActionListener(listener);
    }

    public HocVien getHocVien() throws ParseException {
        String gioiTinh = "";
        if (radioButtonNam.isSelected()) {
            gioiTinh = "Nam";
        } else if (radioButtonNu.isSelected()) {
            gioiTinh = "Nu";
        }
        if (textMaHocVien.getText().length() == 0 || textHo.getText().length() == 0 || textTen.getText().length() == 0 || gioiTinh.length() == 0 || textNgaySinh.getText().length() == 0 || textNoiSinh.getText().length() == 0 || textMaLopDeChinhSuaThongTin.getText().length() == 0) {
            return null;
        }
        String sDate = textNgaySinh.getText();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date date = formatter.parse(sDate);
        return new HocVien(textMaHocVien.getText(), textHo.getText(), textTen.getText(), date, gioiTinh, textNoiSinh.getText(), textMaLopDeChinhSuaThongTin.getText());
    }

    public void xoaHocVien(ActionListener listener) {
        btnXoaHocVien.addActionListener(listener);
    }

    /**
     *
     * @param listSelectionListener
     */
    public void layDuLieuBang(ListSelectionListener listSelectionListener) {
        tableHocVien.getSelectionModel().addListSelectionListener(listSelectionListener);
    }

    public void capNhapDuLieuTungO(KeyAdapter listener) {
        tableHocVien.addKeyListener(listener);
    }

    public int[] layNhieuChiSoMang() {

        int row = tableHocVien.getSelectedRow();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");//Tạo một đối tượng có giá trị khởi tạo là ngày-tháng-năm
        if (row != -1) {
            textMaHocVien.setText((String) tableHocVien.getValueAt(row, 0));
            textHo.setText((String) tableHocVien.getValueAt(row, 1));
            textTen.setText((String) tableHocVien.getValueAt(row, 2));
            textNgaySinh.setText(formatter.format(tableHocVien.getValueAt(row, 3)));//Vì là kiểu ngày nên phải dùng hàm format để set lại định dạng của date
            textNoiSinh.setText((String) tableHocVien.getValueAt(row, 5));
            textMaLopDeChinhSuaThongTin.setText((String) tableHocVien.getValueAt(row, 6));
            if (((String) tableHocVien.getValueAt(row, 4)).equals("Nam")) {
                radioButtonNam.setSelected(true);//cho radiobutton được click
            } else {
                radioButtonNu.setSelected(true);//cho radiobutton được click bằng cách dùng hàm setSelected(true)
            }
        } else {//khi không bấm vào dòng nào thì các input quay về rỗng
            textMaHocVien.setText("");
            textHo.setText("");
            textTen.setText("");
            textNgaySinh.setText("");
            textNoiSinh.setText("");
            textMaLopDeChinhSuaThongTin.setText("");
            radioButtonNam.setSelected(false);
            radioButtonNu.setSelected(false);
        }
        return tableHocVien.getSelectedRows();
    }

    public void xoaHetDuLieuBang(ActionListener listener) {
        btnXoaHetDuLieuBang.addActionListener(listener);
    }

    public int getRowHocVien() {
        return tableHocVien.getRowCount();
    }

    public void suaThongTinHocVien(ActionListener listener) {
        btnSuaThongTinHocVien.addActionListener(listener);
    }

    public int getRow() {

        return tableHocVien.getSelectedRow();
    }

    public int getColumn() {
        return tableHocVien.getSelectedColumn();
    }

    public Object getGiaTriTungO(int row, int column) {

        return tableHocVien.getValueAt(row, column);
    }

    public void setGiaTriTungO(Object value, int row, int column) {
        tableHocVien.setValueAt(value, row, column);

    }

    public void xoaInputHocVien() {
        textMaHocVien.requestFocus();
        textMaHocVienMuonTim.setText(null);
        textHoTenMuonTim.setText(null);
        textMaLop.setText(null);
        textMaHocVien.setText("");
        textHo.setText("");
        textTen.setText("");
        textNgaySinh.setText("");
        textNoiSinh.setText("");
        textMaLopDeChinhSuaThongTin.setText("");
        radioButtonNam.setSelected(false);
        radioButtonNu.setSelected(false);
    }

    public void setLaiGiaTriInput() {
        int row = tableHocVien.getSelectedRow();
        if (row != -1) {
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");//Tạo một đối tượng có giá trị khởi tạo là ngày-tháng-năm
            textMaHocVien.setText((String) tableHocVien.getValueAt(row, 0));
            textHo.setText((String) tableHocVien.getValueAt(row, 1));
            textTen.setText((String) tableHocVien.getValueAt(row, 2));
            textNgaySinh.setText(formatter.format(tableHocVien.getValueAt(row, 3)));//Vì là kiểu ngày nên phải dùng hàm format để set lại định dạng của date
            textNoiSinh.setText((String) tableHocVien.getValueAt(row, 5));
            textMaLopDeChinhSuaThongTin.setText((String) tableHocVien.getValueAt(row, 6));
            if (((String) tableHocVien.getValueAt(row, 4)).equals("Nam")) {
                radioButtonNam.setSelected(true);//cho radiobutton được click
            } else {
                radioButtonNu.setSelected(true);//cho radiobutton được click bằng cách dùng hàm setSelected(true)
            }
        }

    }

    public void capNhapHocVienKhiSuaTrenLopHoc(ActionListener listener) {
        btnCapNhapLop.addActionListener(listener);
    }

    //Giáo viên
    public void loadGiaoVienBangClickButton(ActionListener listener) {
        btnLoadGiaoVien.addActionListener(listener);
    }

    public void loadGiaoVien(GiaoVienModel modelGiaoVien) {
        tableGiaoVien.setModel(modelGiaoVien);
    }

    public void hienThiTableGiaoVien(Object[][] data, String[] column) {
        DefaultTableModel defaultTableModel = new DefaultTableModel(data, column);
        tableGiaoVien.setModel(defaultTableModel);
    }

    public void themGiaoVien(ActionListener listener) {
        btnThemGiaoVien.addActionListener(listener);
    }

    public ArrayList getThongTinInputGiaoVien() {
        ArrayList<Object> thongTinInputGiaovien = new ArrayList<>();
        thongTinInputGiaovien.add(textMaGiaovien.getText());
        thongTinInputGiaovien.add(textHoTenGiaoVien.getText());
        thongTinInputGiaovien.add(comboboxHocViGiaoVien.getSelectedItem());
        thongTinInputGiaovien.add(comboboxGioiTinhGiaoVien.getSelectedItem());
        thongTinInputGiaovien.add(comboboxNgaySinhGiaoVien.getSelectedItem());
        thongTinInputGiaovien.add(comboboxThangSinhGiaoVien.getSelectedItem());
        thongTinInputGiaovien.add(textNamSinhGiaoVien.getText());
        thongTinInputGiaovien.add(textLuongCoBanGiaoVien.getText());
        thongTinInputGiaovien.add(textHeSoLuongGiaoVien.getText());
        thongTinInputGiaovien.add(comboboxMaKhoaGiaoVien.getSelectedItem());
        return thongTinInputGiaovien;
    }

    public final void showGioiTinhGiaoVien() {
        this.gioiTinh = new ArrayList<>();
        this.gioiTinh.add("Nam");
        this.gioiTinh.add("Nu");
        for (String gioiTinhGiaoVien : this.gioiTinh) {
            comboboxGioiTinhGiaoVien.addItem(gioiTinhGiaoVien);
        }
    }

    public final void showNgaySinhGiaoVien() {
        for (int i = 1; i <= 31; i++) {
            comboboxNgaySinhGiaoVien.addItem(String.valueOf(i));
        }
    }

    public final void showNamSinhGiaoVien() {
        for (int i = 1; i <= 12; i++) {
            comboboxThangSinhGiaoVien.addItem(String.valueOf(i));
        }
    }

    public void showMaKhoaGiaoVien(ArrayList<Khoa> danhSachKhoa) {
        comboboxMaKhoaGiaoVien.removeAllItems();
        for (int i = 0; i <= danhSachKhoa.size() - 1; i++) {
            comboboxMaKhoaGiaoVien.addItem(danhSachKhoa.get(i).getMaKhoa());
        }

    }

    public final void showHocViGiaoVien() {
        comboboxHocViGiaoVien.addItem("Ths");
        comboboxHocViGiaoVien.addItem("TS");
        comboboxHocViGiaoVien.addItem("CN");
    }

    public void xoaGiaoVien(ListSelectionListener listener) {
        ListSelectionModel listSelectionModel = tableGiaoVien.getSelectionModel();
        listSelectionModel.addListSelectionListener(listener);
    }

    public int[] getRowsGiaoVien() {
        return tableGiaoVien.getSelectedRows();
    }

    public void nhanNutXoaGiaoVien(ActionListener listener) {
        btnXoaGiaoVien.addActionListener(listener);
    }

    public void xoaHetGiaoVien(ActionListener listener) {
        btnXoaHetGiaoVien.addActionListener(listener);
    }

    public int getColumnCountGiaoVien() {
        return tableGiaoVien.getRowCount();
    }

    public void setLaiGiaTriInputGiaoVien() {
        int row = tableGiaoVien.getSelectedRow();
        if (row != -1) {
            String heSoString = String.valueOf(tableGiaoVien.getValueAt(row, 5));
            String luongCoBanString = String.valueOf(tableGiaoVien.getValueAt(row, 6));
            textMaGiaovien.setText((String) tableGiaoVien.getValueAt(row, 0));
            textHoTenGiaoVien.setText((String) tableGiaoVien.getValueAt(row, 1));
            comboboxHocViGiaoVien.setSelectedItem((String) tableGiaoVien.getValueAt(row, 2));
            comboboxGioiTinhGiaoVien.setSelectedItem((String) tableGiaoVien.getValueAt(row, 3));
            textHeSoLuongGiaoVien.setText(heSoString);
            textLuongCoBanGiaoVien.setText(luongCoBanString);
            comboboxMaKhoaGiaoVien.setSelectedItem((String) tableGiaoVien.getValueAt(row, 8));
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
            String ngayThangNam = simpleDateFormat.format(tableGiaoVien.getValueAt(row, 4));
            String[] ngayThangNamDuoctach = ngayThangNam.split("-");
            String ngay = ngayThangNamDuoctach[0];
            String ngayString = String.valueOf(ngay.charAt(1));
            int itemCountNgay = comboboxNgaySinhGiaoVien.getItemCount();
            for (int i = 0; i <= itemCountNgay - 1; i++) {
                if (ngay.charAt(0) == '0') {
                    if ((String.valueOf(i)).equals(ngayString)) {
                        comboboxNgaySinhGiaoVien.setSelectedItem(ngay);
                    }
                } else {
                    if ((String.valueOf(i)).equals(ngay)) {
                        comboboxNgaySinhGiaoVien.setSelectedItem(ngay);
                    }
                }
            }
            int itemCountThang = comboboxNgaySinhGiaoVien.getItemCount();
            String thang = ngayThangNamDuoctach[1];
            String thangString = String.valueOf(thang.charAt(1));
            for (int i = 0; i <= itemCountThang - 1; i++) {
                if (thang.charAt(0) == '0') {
                    if ((String.valueOf(i)).equals(thangString)) {
                        comboboxThangSinhGiaoVien.setSelectedItem(thangString);
                    }
                } else {
                    if (String.valueOf(i).equals(thang)) {
                        comboboxThangSinhGiaoVien.setSelectedItem(thangString);
                    }
                }
            }
            textNamSinhGiaoVien.setText(ngayThangNamDuoctach[2]);

        }
    }

    public void suaThongTinGiaoVien(ActionListener listener) {
        btnSuaThongTinGiaoVien.addActionListener(listener);
    }

    public void setTextTenGiaoVien(String hoTen) {
        textHoTenGiaoVien.setText(hoTen);
    }

    public void xuLySuKienEnterChoTableGiaoVien(KeyAdapter lisAdapter) {
        tableGiaoVien.addKeyListener(lisAdapter);
    }

    public void timKiemGiaoVien(ActionListener listener) {
        btnTimKiemGiaoVien.addActionListener(listener);
    }

    public String getMaGiaoVien() {
        return textMaGiaovien.getText();
    }

    public int getColumGiaoVien() {
        return tableGiaoVien.getSelectedColumn();
    }

    public Object getVualueTableGiaoVien(int column) {
        return tableGiaoVien.getValueAt(0, column);
    }

    public int getRowCountGiaoVien() {
        return this.tableGiaoVien.getRowCount();
    }

    public void xoaInputTableGiaoVien() {
        textMaGiaovien.setText("");
        textHoTenGiaoVien.setText("");
        comboboxHocViGiaoVien.setSelectedIndex(0);
        comboboxGioiTinhGiaoVien.setSelectedIndex(0);
        comboboxNgaySinhGiaoVien.setSelectedIndex(0);
        comboboxThangSinhGiaoVien.setSelectedIndex(0);
        textNamSinhGiaoVien.setText("");
        textHeSoLuongGiaoVien.setText("");
        textLuongCoBanGiaoVien.setText("");
        comboboxMaKhoaGiaoVien.setSelectedItem(0);
    }

    public void tinhLuongGiaoVien(ActionListener listener) {
        btnTinhLuongGiaoVien.addActionListener(listener);
    }

    public void dieuHuong(ActionListener listener) {
        btnDieuHuong.addActionListener(listener);
    }

    public void anTruongHoc1View() {
        this.setVisible(false);
    }

    public void capNhapMaKhoaCuaGiaoVien(ActionListener listener) {
        btnCapNhapTuKhoa.addActionListener(listener);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dialogThongBaoTimKiemHocVien = new javax.swing.JDialog();
        panelThongBaoTimKiemHocVien = new javax.swing.JPanel();
        labelThongBaoTimKiem = new javax.swing.JLabel();
        btnThoatDialog = new javax.swing.JButton();
        buttonGroupGioiTinh = new javax.swing.ButtonGroup();
        dialogThongBaoChuaNhapThongTinHocVien = new javax.swing.JDialog();
        jPanel39 = new javax.swing.JPanel();
        labelThongBaoNhapKhongThanhCong = new javax.swing.JLabel();
        jPanel40 = new javax.swing.JPanel();
        btnThoatDialogChuaNhapThongTinSinhVien = new javax.swing.JButton();
        jTabbedPanelHocVien = new javax.swing.JTabbedPane();
        jPanelHocSinh = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableHocVien = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel56 = new javax.swing.JPanel();
        jPanel68 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jPanel69 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jPanel70 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jPanel57 = new javax.swing.JPanel();
        jPanel71 = new javax.swing.JPanel();
        textMaHocVienMuonTim = new javax.swing.JTextField();
        jPanel72 = new javax.swing.JPanel();
        textHoTenMuonTim = new javax.swing.JTextField();
        jPanel73 = new javax.swing.JPanel();
        textMaLop = new javax.swing.JTextField();
        jPanel34 = new javax.swing.JPanel();
        btnTimHocVien = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        textMaHocVien = new javax.swing.JTextField();
        jPanel22 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel23 = new javax.swing.JPanel();
        textHo = new javax.swing.JTextField();
        jPanel24 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel25 = new javax.swing.JPanel();
        textTen = new javax.swing.JTextField();
        jPanel26 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel27 = new javax.swing.JPanel();
        textNgaySinh = new javax.swing.JTextField();
        jPanel28 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel29 = new javax.swing.JPanel();
        radioButtonNu = new javax.swing.JRadioButton();
        radioButtonNam = new javax.swing.JRadioButton();
        jPanel30 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel31 = new javax.swing.JPanel();
        textNoiSinh = new javax.swing.JTextField();
        jPanel32 = new javax.swing.JPanel();
        jPanel35 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel33 = new javax.swing.JPanel();
        textMaLopDeChinhSuaThongTin = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel15 = new javax.swing.JPanel();
        jPanel37 = new javax.swing.JPanel();
        btnSuaThongTinHocVien = new javax.swing.JButton();
        btnXoaHocVien = new javax.swing.JButton();
        btnThemHocVien = new javax.swing.JButton();
        btnXoaHetDuLieuBang = new javax.swing.JButton();
        btnCapNhapLop = new javax.swing.JButton();
        btnNhapHocVien = new javax.swing.JButton();
        jPanelGiaoVien = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel36 = new javax.swing.JPanel();
        jPanel42 = new javax.swing.JPanel();
        jPanel44 = new javax.swing.JPanel();
        jPanel48 = new javax.swing.JPanel();
        jPanel41 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel49 = new javax.swing.JPanel();
        textMaGiaovien = new javax.swing.JTextField();
        jPanel45 = new javax.swing.JPanel();
        jPanel50 = new javax.swing.JPanel();
        jPanel74 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPanel51 = new javax.swing.JPanel();
        textHoTenGiaoVien = new javax.swing.JTextField();
        jPanel46 = new javax.swing.JPanel();
        jPanel52 = new javax.swing.JPanel();
        jPanel78 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jPanel53 = new javax.swing.JPanel();
        comboboxHocViGiaoVien = new javax.swing.JComboBox<>();
        jPanel47 = new javax.swing.JPanel();
        jPanel54 = new javax.swing.JPanel();
        jPanel79 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jPanel55 = new javax.swing.JPanel();
        comboboxGioiTinhGiaoVien = new javax.swing.JComboBox<>();
        jPanel43 = new javax.swing.JPanel();
        jPanel58 = new javax.swing.JPanel();
        jPanel59 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jPanel60 = new javax.swing.JPanel();
        textLuongCoBanGiaoVien = new javax.swing.JTextField();
        jPanel61 = new javax.swing.JPanel();
        jPanel64 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jPanel65 = new javax.swing.JPanel();
        textHeSoLuongGiaoVien = new javax.swing.JTextField();
        jPanel62 = new javax.swing.JPanel();
        jPanel66 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jPanel67 = new javax.swing.JPanel();
        comboboxMaKhoaGiaoVien = new javax.swing.JComboBox<>();
        jPanel63 = new javax.swing.JPanel();
        jPanel75 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jPanel76 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        comboboxNgaySinhGiaoVien = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        comboboxThangSinhGiaoVien = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        textNamSinhGiaoVien = new javax.swing.JTextField();
        jPanel38 = new javax.swing.JPanel();
        btnDieuHuong = new javax.swing.JButton();
        jPanel77 = new javax.swing.JPanel();
        btnXoaGiaoVien = new javax.swing.JButton();
        btnThemGiaoVien = new javax.swing.JButton();
        btnSuaThongTinGiaoVien = new javax.swing.JButton();
        btnXoaHetGiaoVien = new javax.swing.JButton();
        btnLoadGiaoVien = new javax.swing.JButton();
        btnTimKiemGiaoVien = new javax.swing.JButton();
        btnCapNhapTuKhoa = new javax.swing.JButton();
        btnTinhLuongGiaoVien = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableGiaoVien = new javax.swing.JTable();

        dialogThongBaoTimKiemHocVien.setTitle("Thong bao tim kiem");
        dialogThongBaoTimKiemHocVien.setMinimumSize(new java.awt.Dimension(300, 300));
        dialogThongBaoTimKiemHocVien.setModal(true);

        labelThongBaoTimKiem.setText("Không có thông tin bạn cần tìm");

        btnThoatDialog.setText("OK");

        javax.swing.GroupLayout panelThongBaoTimKiemHocVienLayout = new javax.swing.GroupLayout(panelThongBaoTimKiemHocVien);
        panelThongBaoTimKiemHocVien.setLayout(panelThongBaoTimKiemHocVienLayout);
        panelThongBaoTimKiemHocVienLayout.setHorizontalGroup(
            panelThongBaoTimKiemHocVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelThongBaoTimKiemHocVienLayout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addGroup(panelThongBaoTimKiemHocVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelThongBaoTimKiemHocVienLayout.createSequentialGroup()
                        .addComponent(labelThongBaoTimKiem)
                        .addGap(25, 25, 25))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelThongBaoTimKiemHocVienLayout.createSequentialGroup()
                        .addComponent(btnThoatDialog)
                        .addGap(74, 74, 74))))
        );
        panelThongBaoTimKiemHocVienLayout.setVerticalGroup(
            panelThongBaoTimKiemHocVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelThongBaoTimKiemHocVienLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(labelThongBaoTimKiem)
                .addGap(18, 18, 18)
                .addComponent(btnThoatDialog)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout dialogThongBaoTimKiemHocVienLayout = new javax.swing.GroupLayout(dialogThongBaoTimKiemHocVien.getContentPane());
        dialogThongBaoTimKiemHocVien.getContentPane().setLayout(dialogThongBaoTimKiemHocVienLayout);
        dialogThongBaoTimKiemHocVienLayout.setHorizontalGroup(
            dialogThongBaoTimKiemHocVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dialogThongBaoTimKiemHocVienLayout.createSequentialGroup()
                .addContainerGap(80, Short.MAX_VALUE)
                .addComponent(panelThongBaoTimKiemHocVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(93, 93, 93))
        );
        dialogThongBaoTimKiemHocVienLayout.setVerticalGroup(
            dialogThongBaoTimKiemHocVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogThongBaoTimKiemHocVienLayout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addComponent(panelThongBaoTimKiemHocVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(107, Short.MAX_VALUE))
        );

        dialogThongBaoChuaNhapThongTinHocVien.setTitle("Chưa nhập thông tin sinh viên");
        dialogThongBaoChuaNhapThongTinHocVien.setMinimumSize(new java.awt.Dimension(390, 129));
        dialogThongBaoChuaNhapThongTinHocVien.setModal(true);
        dialogThongBaoChuaNhapThongTinHocVien.getContentPane().setLayout(new javax.swing.BoxLayout(dialogThongBaoChuaNhapThongTinHocVien.getContentPane(), javax.swing.BoxLayout.Y_AXIS));

        labelThongBaoNhapKhongThanhCong.setText("Nội dung");

        javax.swing.GroupLayout jPanel39Layout = new javax.swing.GroupLayout(jPanel39);
        jPanel39.setLayout(jPanel39Layout);
        jPanel39Layout.setHorizontalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 393, Short.MAX_VALUE)
            .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel39Layout.createSequentialGroup()
                    .addGap(0, 171, Short.MAX_VALUE)
                    .addComponent(labelThongBaoNhapKhongThanhCong)
                    .addGap(0, 172, Short.MAX_VALUE)))
        );
        jPanel39Layout.setVerticalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 84, Short.MAX_VALUE)
            .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel39Layout.createSequentialGroup()
                    .addGap(0, 34, Short.MAX_VALUE)
                    .addComponent(labelThongBaoNhapKhongThanhCong)
                    .addGap(0, 34, Short.MAX_VALUE)))
        );

        dialogThongBaoChuaNhapThongTinHocVien.getContentPane().add(jPanel39);

        btnThoatDialogChuaNhapThongTinSinhVien.setText("OK");

        javax.swing.GroupLayout jPanel40Layout = new javax.swing.GroupLayout(jPanel40);
        jPanel40.setLayout(jPanel40Layout);
        jPanel40Layout.setHorizontalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 393, Short.MAX_VALUE)
            .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel40Layout.createSequentialGroup()
                    .addGap(0, 160, Short.MAX_VALUE)
                    .addComponent(btnThoatDialogChuaNhapThongTinSinhVien)
                    .addGap(0, 161, Short.MAX_VALUE)))
        );
        jPanel40Layout.setVerticalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 44, Short.MAX_VALUE)
            .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel40Layout.createSequentialGroup()
                    .addGap(0, 10, Short.MAX_VALUE)
                    .addComponent(btnThoatDialogChuaNhapThongTinSinhVien)
                    .addGap(0, 11, Short.MAX_VALUE)))
        );

        dialogThongBaoChuaNhapThongTinHocVien.getContentPane().add(jPanel40);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(0, 540));
        setResizable(false);
        setSize(new java.awt.Dimension(0, 0));

        jTabbedPanelHocVien.setMaximumSize(new java.awt.Dimension(1500, 32767));
        jTabbedPanelHocVien.setMinimumSize(new java.awt.Dimension(1500, 300));
        jTabbedPanelHocVien.setPreferredSize(new java.awt.Dimension(1500, 400));

        jPanelHocSinh.setBackground(new java.awt.Color(255, 255, 255));
        jPanelHocSinh.setForeground(new java.awt.Color(255, 255, 255));
        jPanelHocSinh.setMaximumSize(new java.awt.Dimension(1500, 32767));
        jPanelHocSinh.setMinimumSize(new java.awt.Dimension(1500, 0));
        jPanelHocSinh.setPreferredSize(new java.awt.Dimension(1500, 452));
        jPanelHocSinh.setLayout(new java.awt.GridLayout(1, 2));

        jScrollPane2.setBorder(null);

        tableHocVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã học viên", "Họ", "Tên", "Ngày sinh", "Giới tính", "Nơi sinh", "Mã lớp"
            }
        ));
        tableHocVien.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tableHocVien.setMaximumSize(new java.awt.Dimension(300, 80));
        jScrollPane2.setViewportView(tableHocVien);

        jPanelHocSinh.add(jScrollPane2);

        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.Y_AXIS));

        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.Y_AXIS));

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(0, 204, 0));
        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Anh/Unknown person.png"))); // NOI18N
        jLabel25.setText("Tìm kiếm học viên");
        jPanel5.add(jLabel25);

        jPanel2.add(jPanel5);

        jPanel6.setLayout(new java.awt.GridLayout(1, 0));

        jPanel56.setLayout(new javax.swing.BoxLayout(jPanel56, javax.swing.BoxLayout.Y_AXIS));

        jPanel68.setMaximumSize(new java.awt.Dimension(32767, 30));
        jPanel68.setPreferredSize(new java.awt.Dimension(322, 26));
        jPanel68.setLayout(new javax.swing.BoxLayout(jPanel68, javax.swing.BoxLayout.LINE_AXIS));

        jPanel7.setMaximumSize(new java.awt.Dimension(65, 32767));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 65, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );

        jPanel68.add(jPanel7);

        jLabel23.setText("Nhập mã học viên");
        jPanel68.add(jLabel23);

        jPanel56.add(jPanel68);

        jPanel69.setMaximumSize(new java.awt.Dimension(32767, 50));
        jPanel69.setMinimumSize(new java.awt.Dimension(0, 26));
        jPanel69.setPreferredSize(new java.awt.Dimension(322, 50));
        jPanel69.setLayout(new javax.swing.BoxLayout(jPanel69, javax.swing.BoxLayout.LINE_AXIS));

        jPanel8.setMaximumSize(new java.awt.Dimension(65, 32767));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 65, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 48, Short.MAX_VALUE)
        );

        jPanel69.add(jPanel8);

        jLabel24.setText("Nhập họ tên");
        jPanel69.add(jLabel24);

        jPanel56.add(jPanel69);

        jPanel70.setMaximumSize(new java.awt.Dimension(32767, 30));
        jPanel70.setLayout(new javax.swing.BoxLayout(jPanel70, javax.swing.BoxLayout.LINE_AXIS));

        jPanel9.setMaximumSize(new java.awt.Dimension(65, 32767));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 65, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 16, Short.MAX_VALUE)
        );

        jPanel70.add(jPanel9);

        jLabel26.setText("Nhập mã lớp");
        jPanel70.add(jLabel26);

        jPanel56.add(jPanel70);

        jPanel6.add(jPanel56);

        jPanel57.setLayout(new javax.swing.BoxLayout(jPanel57, javax.swing.BoxLayout.Y_AXIS));

        jPanel71.setMaximumSize(new java.awt.Dimension(2147483647, 30));
        jPanel71.setMinimumSize(new java.awt.Dimension(64, 30));
        jPanel71.setPreferredSize(new java.awt.Dimension(322, 30));
        jPanel71.setLayout(new javax.swing.BoxLayout(jPanel71, javax.swing.BoxLayout.Y_AXIS));

        textMaHocVienMuonTim.setMaximumSize(new java.awt.Dimension(2147483647, 22));
        jPanel71.add(textMaHocVienMuonTim);

        jPanel57.add(jPanel71);

        jPanel72.setMaximumSize(new java.awt.Dimension(2147483647, 30));
        jPanel72.setMinimumSize(new java.awt.Dimension(64, 30));
        jPanel72.setPreferredSize(new java.awt.Dimension(322, 30));
        jPanel72.setLayout(new javax.swing.BoxLayout(jPanel72, javax.swing.BoxLayout.Y_AXIS));

        textHoTenMuonTim.setMaximumSize(new java.awt.Dimension(2147483647, 22));
        textHoTenMuonTim.setMinimumSize(new java.awt.Dimension(64, 26));
        textHoTenMuonTim.setPreferredSize(new java.awt.Dimension(71, 30));
        jPanel72.add(textHoTenMuonTim);

        jPanel57.add(jPanel72);

        jPanel73.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel73.setMaximumSize(new java.awt.Dimension(2147483647, 30));
        jPanel73.setMinimumSize(new java.awt.Dimension(64, 30));
        jPanel73.setPreferredSize(new java.awt.Dimension(322, 30));
        jPanel73.setLayout(new javax.swing.BoxLayout(jPanel73, javax.swing.BoxLayout.Y_AXIS));

        textMaLop.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        textMaLop.setMaximumSize(new java.awt.Dimension(2147483647, 22));
        jPanel73.add(textMaLop);

        jPanel57.add(jPanel73);

        jPanel6.add(jPanel57);

        jPanel2.add(jPanel6);

        jPanel34.setPreferredSize(new java.awt.Dimension(150, 33));
        jPanel34.setLayout(new javax.swing.BoxLayout(jPanel34, javax.swing.BoxLayout.LINE_AXIS));

        btnTimHocVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Anh/TimKiem.png"))); // NOI18N
        btnTimHocVien.setText("Tìm kiếm");
        jPanel34.add(btnTimHocVien);

        jPanel2.add(jPanel34);

        jPanel1.add(jPanel2);

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator1);

        jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.Y_AXIS));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 204, 0));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Anh/ChiTiet.png"))); // NOI18N
        jLabel2.setText("Chi tiết sinh viên");
        jPanel18.add(jLabel2);

        jPanel3.add(jPanel18);

        jPanel19.setLayout(new javax.swing.BoxLayout(jPanel19, javax.swing.BoxLayout.Y_AXIS));

        jPanel14.setLayout(new java.awt.GridLayout(7, 2));

        jPanel21.setLayout(new javax.swing.BoxLayout(jPanel21, javax.swing.BoxLayout.LINE_AXIS));

        jPanel10.setMaximumSize(new java.awt.Dimension(65, 32767));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 65, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 31, Short.MAX_VALUE)
        );

        jPanel21.add(jPanel10);

        jLabel3.setText("Mã học viên");
        jPanel21.add(jLabel3);

        jPanel14.add(jPanel21);

        jPanel20.setLayout(new javax.swing.BoxLayout(jPanel20, javax.swing.BoxLayout.LINE_AXIS));

        textMaHocVien.setMaximumSize(new java.awt.Dimension(2147483647, 22));
        jPanel20.add(textMaHocVien);

        jPanel14.add(jPanel20);

        jPanel22.setMaximumSize(new java.awt.Dimension(32767, 26));
        jPanel22.setLayout(new javax.swing.BoxLayout(jPanel22, javax.swing.BoxLayout.LINE_AXIS));

        jPanel11.setMaximumSize(new java.awt.Dimension(65, 32767));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 65, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 31, Short.MAX_VALUE)
        );

        jPanel22.add(jPanel11);

        jLabel4.setText("Họ");
        jPanel22.add(jLabel4);

        jPanel14.add(jPanel22);

        jPanel23.setMaximumSize(new java.awt.Dimension(2147483647, 22));
        jPanel23.setLayout(new javax.swing.BoxLayout(jPanel23, javax.swing.BoxLayout.LINE_AXIS));

        textHo.setMaximumSize(new java.awt.Dimension(2147483647, 22));
        jPanel23.add(textHo);

        jPanel14.add(jPanel23);

        jPanel24.setLayout(new javax.swing.BoxLayout(jPanel24, javax.swing.BoxLayout.LINE_AXIS));

        jPanel12.setMaximumSize(new java.awt.Dimension(65, 32767));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 65, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 31, Short.MAX_VALUE)
        );

        jPanel24.add(jPanel12);

        jLabel5.setText("Tên");
        jPanel24.add(jLabel5);

        jPanel14.add(jPanel24);

        jPanel25.setLayout(new javax.swing.BoxLayout(jPanel25, javax.swing.BoxLayout.LINE_AXIS));

        textTen.setMaximumSize(new java.awt.Dimension(2147483647, 22));
        jPanel25.add(textTen);

        jPanel14.add(jPanel25);

        jPanel26.setLayout(new javax.swing.BoxLayout(jPanel26, javax.swing.BoxLayout.LINE_AXIS));

        jPanel13.setMaximumSize(new java.awt.Dimension(65, 32767));

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 65, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 31, Short.MAX_VALUE)
        );

        jPanel26.add(jPanel13);

        jLabel6.setText("Ngày sinh");
        jPanel26.add(jLabel6);

        jPanel14.add(jPanel26);

        jPanel27.setLayout(new javax.swing.BoxLayout(jPanel27, javax.swing.BoxLayout.LINE_AXIS));

        textNgaySinh.setMaximumSize(new java.awt.Dimension(2147483647, 22));
        jPanel27.add(textNgaySinh);

        jPanel14.add(jPanel27);

        jPanel28.setLayout(new javax.swing.BoxLayout(jPanel28, javax.swing.BoxLayout.LINE_AXIS));

        jPanel16.setMaximumSize(new java.awt.Dimension(65, 32767));

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 65, Short.MAX_VALUE)
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 31, Short.MAX_VALUE)
        );

        jPanel28.add(jPanel16);

        jLabel7.setText("Giới tính");
        jPanel28.add(jLabel7);

        jPanel14.add(jPanel28);

        jPanel29.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        radioButtonNu.setText("Nữ");
        jPanel29.add(radioButtonNu);

        radioButtonNam.setText("Nam");
        jPanel29.add(radioButtonNam);

        jPanel14.add(jPanel29);

        jPanel30.setLayout(new javax.swing.BoxLayout(jPanel30, javax.swing.BoxLayout.LINE_AXIS));

        jPanel17.setMaximumSize(new java.awt.Dimension(65, 32767));

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 65, Short.MAX_VALUE)
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 31, Short.MAX_VALUE)
        );

        jPanel30.add(jPanel17);

        jLabel8.setText("Nơi sinh");
        jPanel30.add(jLabel8);

        jPanel14.add(jPanel30);

        jPanel31.setLayout(new javax.swing.BoxLayout(jPanel31, javax.swing.BoxLayout.LINE_AXIS));

        textNoiSinh.setMaximumSize(new java.awt.Dimension(2147483647, 22));
        jPanel31.add(textNoiSinh);

        jPanel14.add(jPanel31);

        jPanel32.setLayout(new javax.swing.BoxLayout(jPanel32, javax.swing.BoxLayout.LINE_AXIS));

        jPanel35.setMaximumSize(new java.awt.Dimension(65, 32767));

        javax.swing.GroupLayout jPanel35Layout = new javax.swing.GroupLayout(jPanel35);
        jPanel35.setLayout(jPanel35Layout);
        jPanel35Layout.setHorizontalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 65, Short.MAX_VALUE)
        );
        jPanel35Layout.setVerticalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 31, Short.MAX_VALUE)
        );

        jPanel32.add(jPanel35);

        jLabel9.setText("Mã lớp");
        jPanel32.add(jLabel9);

        jPanel14.add(jPanel32);

        jPanel33.setLayout(new javax.swing.BoxLayout(jPanel33, javax.swing.BoxLayout.LINE_AXIS));

        textMaLopDeChinhSuaThongTin.setMaximumSize(new java.awt.Dimension(2147483647, 22));
        jPanel33.add(textMaLopDeChinhSuaThongTin);

        jPanel14.add(jPanel33);

        jPanel19.add(jPanel14);

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        jPanel19.add(jSeparator2);

        jPanel15.setMinimumSize(new java.awt.Dimension(265, 30));
        jPanel15.setPreferredSize(new java.awt.Dimension(387, 200));
        jPanel15.setLayout(new javax.swing.BoxLayout(jPanel15, javax.swing.BoxLayout.Y_AXIS));

        jPanel37.setMinimumSize(new java.awt.Dimension(387, 30));
        jPanel37.setPreferredSize(new java.awt.Dimension(387, 30));
        jPanel37.setLayout(new java.awt.GridLayout(2, 0));

        btnSuaThongTinHocVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Anh/Sua.png"))); // NOI18N
        btnSuaThongTinHocVien.setText("Sửa");
        btnSuaThongTinHocVien.setMinimumSize(new java.awt.Dimension(50, 31));
        jPanel37.add(btnSuaThongTinHocVien);

        btnXoaHocVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Anh/Xoa.png"))); // NOI18N
        btnXoaHocVien.setText("Xóa");
        jPanel37.add(btnXoaHocVien);

        btnThemHocVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Anh/Them.png"))); // NOI18N
        btnThemHocVien.setText("Thêm");
        jPanel37.add(btnThemHocVien);

        btnXoaHetDuLieuBang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Anh/Trash.png"))); // NOI18N
        btnXoaHetDuLieuBang.setText("Xóa hết");
        jPanel37.add(btnXoaHetDuLieuBang);

        btnCapNhapLop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Anh/CapNhap.png"))); // NOI18N
        btnCapNhapLop.setText("Cập nhập lớp");
        jPanel37.add(btnCapNhapLop);

        btnNhapHocVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Anh/Accept.png"))); // NOI18N
        btnNhapHocVien.setText("Load");
        jPanel37.add(btnNhapHocVien);

        jPanel15.add(jPanel37);

        jPanel19.add(jPanel15);

        jPanel3.add(jPanel19);

        jPanel1.add(jPanel3);

        jPanelHocSinh.add(jPanel1);

        jTabbedPanelHocVien.addTab("Học viên", jPanelHocSinh);

        jPanelGiaoVien.setPreferredSize(new java.awt.Dimension(32767, 448));
        jPanelGiaoVien.setLayout(new javax.swing.BoxLayout(jPanelGiaoVien, javax.swing.BoxLayout.Y_AXIS));

        jPanel36.setLayout(new java.awt.GridLayout(1, 2));

        jPanel42.setLayout(new java.awt.GridLayout(4, 0));

        jPanel44.setMaximumSize(new java.awt.Dimension(250, 32767));
        jPanel44.setMinimumSize(new java.awt.Dimension(80, 22));
        jPanel44.setPreferredSize(new java.awt.Dimension(250, 63));
        jPanel44.setLayout(new java.awt.GridLayout(1, 2));

        jPanel48.setMaximumSize(new java.awt.Dimension(50, 32767));
        jPanel48.setPreferredSize(new java.awt.Dimension(50, 68));
        jPanel48.setLayout(new javax.swing.BoxLayout(jPanel48, javax.swing.BoxLayout.LINE_AXIS));

        jPanel41.setMaximumSize(new java.awt.Dimension(20, 32767));

        javax.swing.GroupLayout jPanel41Layout = new javax.swing.GroupLayout(jPanel41);
        jPanel41.setLayout(jPanel41Layout);
        jPanel41Layout.setHorizontalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        jPanel41Layout.setVerticalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 68, Short.MAX_VALUE)
        );

        jPanel48.add(jPanel41);

        jLabel1.setText("Mã giáo viên");
        jPanel48.add(jLabel1);

        jPanel44.add(jPanel48);

        jPanel49.setLayout(new javax.swing.BoxLayout(jPanel49, javax.swing.BoxLayout.LINE_AXIS));

        textMaGiaovien.setMaximumSize(new java.awt.Dimension(2147483647, 26));
        textMaGiaovien.setPreferredSize(new java.awt.Dimension(71, 26));
        jPanel49.add(textMaGiaovien);

        jPanel44.add(jPanel49);

        jPanel42.add(jPanel44);

        jPanel45.setLayout(new java.awt.GridLayout(1, 2));

        jPanel50.setLayout(new javax.swing.BoxLayout(jPanel50, javax.swing.BoxLayout.LINE_AXIS));

        jPanel74.setMaximumSize(new java.awt.Dimension(20, 32767));

        javax.swing.GroupLayout jPanel74Layout = new javax.swing.GroupLayout(jPanel74);
        jPanel74.setLayout(jPanel74Layout);
        jPanel74Layout.setHorizontalGroup(
            jPanel74Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        jPanel74Layout.setVerticalGroup(
            jPanel74Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 68, Short.MAX_VALUE)
        );

        jPanel50.add(jPanel74);

        jLabel10.setText("Họ tên");
        jPanel50.add(jLabel10);

        jPanel45.add(jPanel50);

        jPanel51.setLayout(new javax.swing.BoxLayout(jPanel51, javax.swing.BoxLayout.LINE_AXIS));

        textHoTenGiaoVien.setMaximumSize(new java.awt.Dimension(2147483647, 26));
        textHoTenGiaoVien.setPreferredSize(new java.awt.Dimension(71, 26));
        jPanel51.add(textHoTenGiaoVien);

        jPanel45.add(jPanel51);

        jPanel42.add(jPanel45);

        jPanel46.setLayout(new java.awt.GridLayout(1, 2));

        jPanel52.setLayout(new javax.swing.BoxLayout(jPanel52, javax.swing.BoxLayout.LINE_AXIS));

        jPanel78.setMaximumSize(new java.awt.Dimension(20, 32767));

        javax.swing.GroupLayout jPanel78Layout = new javax.swing.GroupLayout(jPanel78);
        jPanel78.setLayout(jPanel78Layout);
        jPanel78Layout.setHorizontalGroup(
            jPanel78Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        jPanel78Layout.setVerticalGroup(
            jPanel78Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 68, Short.MAX_VALUE)
        );

        jPanel52.add(jPanel78);

        jLabel11.setText("Học vị");
        jPanel52.add(jLabel11);

        jPanel46.add(jPanel52);

        jPanel53.setLayout(new javax.swing.BoxLayout(jPanel53, javax.swing.BoxLayout.LINE_AXIS));

        comboboxHocViGiaoVien.setMaximumSize(new java.awt.Dimension(32767, 26));
        comboboxHocViGiaoVien.setPreferredSize(new java.awt.Dimension(72, 26));
        jPanel53.add(comboboxHocViGiaoVien);

        jPanel46.add(jPanel53);

        jPanel42.add(jPanel46);

        jPanel47.setLayout(new java.awt.GridLayout(1, 2));

        jPanel54.setLayout(new javax.swing.BoxLayout(jPanel54, javax.swing.BoxLayout.LINE_AXIS));

        jPanel79.setMaximumSize(new java.awt.Dimension(20, 32767));

        javax.swing.GroupLayout jPanel79Layout = new javax.swing.GroupLayout(jPanel79);
        jPanel79.setLayout(jPanel79Layout);
        jPanel79Layout.setHorizontalGroup(
            jPanel79Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        jPanel79Layout.setVerticalGroup(
            jPanel79Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 68, Short.MAX_VALUE)
        );

        jPanel54.add(jPanel79);

        jLabel12.setText("Giới tính");
        jPanel54.add(jLabel12);

        jPanel47.add(jPanel54);

        jPanel55.setLayout(new javax.swing.BoxLayout(jPanel55, javax.swing.BoxLayout.LINE_AXIS));

        comboboxGioiTinhGiaoVien.setMaximumSize(new java.awt.Dimension(32767, 26));
        comboboxGioiTinhGiaoVien.setPreferredSize(new java.awt.Dimension(72, 26));
        jPanel55.add(comboboxGioiTinhGiaoVien);

        jPanel47.add(jPanel55);

        jPanel42.add(jPanel47);

        jPanel36.add(jPanel42);

        jPanel43.setLayout(new java.awt.GridLayout(4, 0));

        jPanel58.setLayout(new java.awt.GridLayout(1, 2));

        jLabel13.setText("Lương cơ bản");

        javax.swing.GroupLayout jPanel59Layout = new javax.swing.GroupLayout(jPanel59);
        jPanel59.setLayout(jPanel59Layout);
        jPanel59Layout.setHorizontalGroup(
            jPanel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel59Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel13)
                .addContainerGap(54, Short.MAX_VALUE))
        );
        jPanel59Layout.setVerticalGroup(
            jPanel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel59Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel13)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jPanel58.add(jPanel59);

        jPanel60.setLayout(new javax.swing.BoxLayout(jPanel60, javax.swing.BoxLayout.LINE_AXIS));

        textLuongCoBanGiaoVien.setMaximumSize(new java.awt.Dimension(2147483647, 26));
        jPanel60.add(textLuongCoBanGiaoVien);

        jPanel58.add(jPanel60);

        jPanel43.add(jPanel58);

        jPanel61.setLayout(new java.awt.GridLayout(1, 0));

        jLabel14.setText("Hệ số");

        javax.swing.GroupLayout jPanel64Layout = new javax.swing.GroupLayout(jPanel64);
        jPanel64.setLayout(jPanel64Layout);
        jPanel64Layout.setHorizontalGroup(
            jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel64Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel14)
                .addContainerGap(96, Short.MAX_VALUE))
        );
        jPanel64Layout.setVerticalGroup(
            jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel64Layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(jLabel14)
                .addGap(25, 25, 25))
        );

        jPanel61.add(jPanel64);

        jPanel65.setLayout(new javax.swing.BoxLayout(jPanel65, javax.swing.BoxLayout.LINE_AXIS));

        textHeSoLuongGiaoVien.setMaximumSize(new java.awt.Dimension(2147483647, 26));
        jPanel65.add(textHeSoLuongGiaoVien);

        jPanel61.add(jPanel65);

        jPanel43.add(jPanel61);

        jPanel62.setLayout(new java.awt.GridLayout(1, 2));

        jLabel15.setText("Mã khoa");

        javax.swing.GroupLayout jPanel66Layout = new javax.swing.GroupLayout(jPanel66);
        jPanel66.setLayout(jPanel66Layout);
        jPanel66Layout.setHorizontalGroup(
            jPanel66Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel66Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel15)
                .addContainerGap(82, Short.MAX_VALUE))
        );
        jPanel66Layout.setVerticalGroup(
            jPanel66Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel66Layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(jLabel15)
                .addGap(25, 25, 25))
        );

        jPanel62.add(jPanel66);

        jPanel67.setLayout(new javax.swing.BoxLayout(jPanel67, javax.swing.BoxLayout.LINE_AXIS));

        comboboxMaKhoaGiaoVien.setMaximumSize(new java.awt.Dimension(32767, 26));
        comboboxMaKhoaGiaoVien.setPreferredSize(new java.awt.Dimension(72, 26));
        jPanel67.add(comboboxMaKhoaGiaoVien);

        jPanel62.add(jPanel67);

        jPanel43.add(jPanel62);

        jPanel63.setLayout(new java.awt.GridLayout(2, 0));

        jLabel16.setText("Ngày tháng năm sinh");
        jPanel75.add(jLabel16);

        jPanel63.add(jPanel75);

        jLabel17.setText("Ngày");
        jPanel76.add(jLabel17);

        comboboxNgaySinhGiaoVien.setPreferredSize(new java.awt.Dimension(40, 22));
        jPanel76.add(comboboxNgaySinhGiaoVien);

        jLabel18.setText("Tháng");
        jPanel76.add(jLabel18);

        comboboxThangSinhGiaoVien.setPreferredSize(new java.awt.Dimension(40, 22));
        jPanel76.add(comboboxThangSinhGiaoVien);

        jLabel19.setText("Năm");
        jPanel76.add(jLabel19);

        textNamSinhGiaoVien.setPreferredSize(new java.awt.Dimension(35, 22));
        jPanel76.add(textNamSinhGiaoVien);

        jPanel63.add(jPanel76);

        jPanel43.add(jPanel63);

        jPanel36.add(jPanel43);

        jPanel38.setMaximumSize(new java.awt.Dimension(500, 32767));
        jPanel38.setPreferredSize(new java.awt.Dimension(500, 304));

        btnDieuHuong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Anh/Điều hướng.png"))); // NOI18N
        btnDieuHuong.setText("Điều hướng");

        btnXoaGiaoVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Anh/Xoa.png"))); // NOI18N
        btnXoaGiaoVien.setText("Xóa");

        btnThemGiaoVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Anh/Them.png"))); // NOI18N
        btnThemGiaoVien.setText("Thêm");

        btnSuaThongTinGiaoVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Anh/Sua.png"))); // NOI18N
        btnSuaThongTinGiaoVien.setText("Sửa");

        btnXoaHetGiaoVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Anh/Trash.png"))); // NOI18N
        btnXoaHetGiaoVien.setText("Xóa hết");

        btnLoadGiaoVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Anh/CapNhap.png"))); // NOI18N
        btnLoadGiaoVien.setText("Load");

        btnTimKiemGiaoVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Anh/TimKiem.png"))); // NOI18N
        btnTimKiemGiaoVien.setText("Tìm");
        btnTimKiemGiaoVien.setMaximumSize(new java.awt.Dimension(124, 84));
        btnTimKiemGiaoVien.setMinimumSize(new java.awt.Dimension(124, 84));
        btnTimKiemGiaoVien.setPreferredSize(new java.awt.Dimension(124, 31));

        btnCapNhapTuKhoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Anh/Add to basket.png"))); // NOI18N
        btnCapNhapTuKhoa.setText("Cập nhập từ khoa");

        btnTinhLuongGiaoVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Anh/Numbered list.png"))); // NOI18N
        btnTinhLuongGiaoVien.setText("Tính lương");

        javax.swing.GroupLayout jPanel77Layout = new javax.swing.GroupLayout(jPanel77);
        jPanel77.setLayout(jPanel77Layout);
        jPanel77Layout.setHorizontalGroup(
            jPanel77Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel77Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel77Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnSuaThongTinGiaoVien, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThemGiaoVien, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimKiemGiaoVien, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCapNhapTuKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel77Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnXoaGiaoVien, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoaHetGiaoVien, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLoadGiaoVien, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTinhLuongGiaoVien, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(76, 76, 76))
        );
        jPanel77Layout.setVerticalGroup(
            jPanel77Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel77Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel77Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemGiaoVien)
                    .addComponent(btnXoaGiaoVien))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel77Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSuaThongTinGiaoVien)
                    .addComponent(btnXoaHetGiaoVien))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel77Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLoadGiaoVien)
                    .addComponent(btnTimKiemGiaoVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel77Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCapNhapTuKhoa)
                    .addComponent(btnTinhLuongGiaoVien))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel38Layout = new javax.swing.GroupLayout(jPanel38);
        jPanel38.setLayout(jPanel38Layout);
        jPanel38Layout.setHorizontalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addComponent(jPanel77, javax.swing.GroupLayout.PREFERRED_SIZE, 414, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel38Layout.createSequentialGroup()
                .addGap(0, 239, Short.MAX_VALUE)
                .addComponent(btnDieuHuong)
                .addGap(61, 61, 61))
        );
        jPanel38Layout.setVerticalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnDieuHuong)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                .addComponent(jPanel77, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel38, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel36, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel38, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanelGiaoVien.add(jPanel4);

        tableGiaoVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã giáo viên", "Họ tên", "Học vị", "Giới tính", "Ngày sinh", "Hệ số", "Lương cơ bản", "Lương", "Khoa"
            }
        ));
        tableGiaoVien.setMaximumSize(new java.awt.Dimension(2147483647, 300));
        tableGiaoVien.setMinimumSize(new java.awt.Dimension(60, 200));
        tableGiaoVien.setPreferredSize(new java.awt.Dimension(300, 250));
        jScrollPane1.setViewportView(tableGiaoVien);

        jPanelGiaoVien.add(jScrollPane1);

        jTabbedPanelHocVien.addTab("Giáo viên", jPanelGiaoVien);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPanelHocVien, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jTabbedPanelHocVien, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCapNhapLop;
    private javax.swing.JButton btnCapNhapTuKhoa;
    private javax.swing.JButton btnDieuHuong;
    private javax.swing.JButton btnLoadGiaoVien;
    private javax.swing.JButton btnNhapHocVien;
    private javax.swing.JButton btnSuaThongTinGiaoVien;
    private javax.swing.JButton btnSuaThongTinHocVien;
    private javax.swing.JButton btnThemGiaoVien;
    private javax.swing.JButton btnThemHocVien;
    private javax.swing.JButton btnThoatDialog;
    private javax.swing.JButton btnThoatDialogChuaNhapThongTinSinhVien;
    private javax.swing.JButton btnTimHocVien;
    private javax.swing.JButton btnTimKiemGiaoVien;
    private javax.swing.JButton btnTinhLuongGiaoVien;
    private javax.swing.JButton btnXoaGiaoVien;
    private javax.swing.JButton btnXoaHetDuLieuBang;
    private javax.swing.JButton btnXoaHetGiaoVien;
    private javax.swing.JButton btnXoaHocVien;
    private javax.swing.ButtonGroup buttonGroupGioiTinh;
    private javax.swing.JComboBox<String> comboboxGioiTinhGiaoVien;
    private javax.swing.JComboBox<String> comboboxHocViGiaoVien;
    private javax.swing.JComboBox<String> comboboxMaKhoaGiaoVien;
    private javax.swing.JComboBox<String> comboboxNgaySinhGiaoVien;
    private javax.swing.JComboBox<String> comboboxThangSinhGiaoVien;
    private javax.swing.JDialog dialogThongBaoChuaNhapThongTinHocVien;
    private javax.swing.JDialog dialogThongBaoTimKiemHocVien;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel42;
    private javax.swing.JPanel jPanel43;
    private javax.swing.JPanel jPanel44;
    private javax.swing.JPanel jPanel45;
    private javax.swing.JPanel jPanel46;
    private javax.swing.JPanel jPanel47;
    private javax.swing.JPanel jPanel48;
    private javax.swing.JPanel jPanel49;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel50;
    private javax.swing.JPanel jPanel51;
    private javax.swing.JPanel jPanel52;
    private javax.swing.JPanel jPanel53;
    private javax.swing.JPanel jPanel54;
    private javax.swing.JPanel jPanel55;
    private javax.swing.JPanel jPanel56;
    private javax.swing.JPanel jPanel57;
    private javax.swing.JPanel jPanel58;
    private javax.swing.JPanel jPanel59;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel60;
    private javax.swing.JPanel jPanel61;
    private javax.swing.JPanel jPanel62;
    private javax.swing.JPanel jPanel63;
    private javax.swing.JPanel jPanel64;
    private javax.swing.JPanel jPanel65;
    private javax.swing.JPanel jPanel66;
    private javax.swing.JPanel jPanel67;
    private javax.swing.JPanel jPanel68;
    private javax.swing.JPanel jPanel69;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel70;
    private javax.swing.JPanel jPanel71;
    private javax.swing.JPanel jPanel72;
    private javax.swing.JPanel jPanel73;
    private javax.swing.JPanel jPanel74;
    private javax.swing.JPanel jPanel75;
    private javax.swing.JPanel jPanel76;
    private javax.swing.JPanel jPanel77;
    private javax.swing.JPanel jPanel78;
    private javax.swing.JPanel jPanel79;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel jPanelGiaoVien;
    private javax.swing.JPanel jPanelHocSinh;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTabbedPane jTabbedPanelHocVien;
    private javax.swing.JLabel labelThongBaoNhapKhongThanhCong;
    private javax.swing.JLabel labelThongBaoTimKiem;
    private javax.swing.JPanel panelThongBaoTimKiemHocVien;
    private javax.swing.JRadioButton radioButtonNam;
    private javax.swing.JRadioButton radioButtonNu;
    private javax.swing.JTable tableGiaoVien;
    private javax.swing.JTable tableHocVien;
    private javax.swing.JTextField textHeSoLuongGiaoVien;
    private javax.swing.JTextField textHo;
    private javax.swing.JTextField textHoTenGiaoVien;
    private javax.swing.JTextField textHoTenMuonTim;
    private javax.swing.JTextField textLuongCoBanGiaoVien;
    private javax.swing.JTextField textMaGiaovien;
    private javax.swing.JTextField textMaHocVien;
    private javax.swing.JTextField textMaHocVienMuonTim;
    private javax.swing.JTextField textMaLop;
    private javax.swing.JTextField textMaLopDeChinhSuaThongTin;
    private javax.swing.JTextField textNamSinhGiaoVien;
    private javax.swing.JTextField textNgaySinh;
    private javax.swing.JTextField textNoiSinh;
    private javax.swing.JTextField textTen;
    // End of variables declaration//GEN-END:variables

}
