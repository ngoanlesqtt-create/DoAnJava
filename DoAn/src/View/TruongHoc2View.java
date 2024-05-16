/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import ModelGiaoVien.GiaoVien;
import ModelHocVien.HocVien;
import ModelKhoa.Khoa;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PC
 */
public final class TruongHoc2View extends javax.swing.JFrame {

    private ArrayList<String> maLopTruong;
    private final JComboBox jComboBox;
    private int namThanhLapKhoa;

    /**
     * Creates new form TruongHoc2View
     *
     * @param danhSachHocVien
     * @param danhSachGiaoVien
     * @param danhSachMaGiaoVien
     * @param maGiaoVienDangLaChuNhiemKhoa
     * @param danhSachMaMonHoc
     */
    public TruongHoc2View(ArrayList<HocVien> danhSachHocVien, ArrayList<GiaoVien> danhSachGiaoVien,
            ArrayList<String> danhSachMaGiaoVien,
            ArrayList<String> maGiaoVienDangLaChuNhiemKhoa, ArrayList<String> danhSachMaMonHoc) {

        initComponents();
        this.jComboBox = new JComboBox();
        showMaLopTruong(danhSachHocVien);
        showMaGiaoVienChuNhiem(danhSachGiaoVien);
        setComboBoxChoBangKhoa(danhSachMaGiaoVien, maGiaoVienDangLaChuNhiemKhoa);
        this.resetComboBoxNamThanhLapKhoa();
        this.showComboBoxMaHocVienTrenBangKetQuaThi(danhSachHocVien);
        this.showComboBoxMaMonHocTrenBangKetQuaThi(danhSachMaMonHoc);
        this.showLanThi();
        this.showDiemThi();
        this.showNgayThangNamKetQuaThi();
        //this.setAlwaysOnTop(true);
    }

    /**
     * @param danhSachHocVien
     *
     */
    public void showMaLopTruong(ArrayList<HocVien> danhSachHocVien) {
        for (HocVien hocVien : danhSachHocVien) {
            comboboxLopTruongLopHoc.addItem(hocVien.getMaHocVien());
        }
    }

    public void xoaCombobox() {
        comboboxLopTruongLopHoc.removeAllItems();
        comboboxmaGiaoVienChuNhiem.removeAllItems();
    }

    public void showMaGiaoVienChuNhiem(ArrayList<GiaoVien> danhSachGiaoVien) {
        for (GiaoVien giaoVien : danhSachGiaoVien) {
            comboboxmaGiaoVienChuNhiem.addItem(giaoVien.getMaGiaoVien());
        }
    }

    public void loadLopHoc(ActionListener listener) {
        btnLoadLopHoc.addActionListener(listener);
    }

    public void hienThiLopHocTrenTable(Object[][] data, String[] column) {
        DefaultTableModel defaultTableModel = new DefaultTableModel(data, column);
        tableLopHoc.setModel(defaultTableModel);
    }

    public void themLopHoc(ActionListener listener) {
        btnThemGiaoVien.addActionListener(listener);
    }

    public ArrayList getInputLopHoc() {
        ArrayList<Object> inputLopHoc = new ArrayList<>();
        inputLopHoc.add(textMaLopHoc.getText());
        inputLopHoc.add(textTenLopHoc.getText());
        inputLopHoc.add(comboboxLopTruongLopHoc.getSelectedItem());
        inputLopHoc.add(comboboxmaGiaoVienChuNhiem.getSelectedItem());
        return inputLopHoc;
    }

    public String getMaSoLopTruong() {
        return (String) comboboxLopTruongLopHoc.getSelectedItem();
    }

    public void capNhapLopTruong(ActionListener listener) {
        btnCapNhapLopTruong.addActionListener(listener);
    }

    public void layDongTrenBangLopHocDeXuLy(ListSelectionListener listener) {
        ListSelectionModel listSelectionModel = tableLopHoc.getSelectionModel();
        listSelectionModel.addListSelectionListener(listener);
    }

    public int getRowLopHoc() {
        return tableLopHoc.getSelectedRow();
    }

    public void setInputKhiDuocChonVaoTrenBangLopHoc(int row) {
        if (row != -1) {
            textMaLopHoc.setText((String) tableLopHoc.getValueAt(row, 0));
            textTenLopHoc.setText((String) tableLopHoc.getValueAt(row, 1));
            comboboxLopTruongLopHoc.setSelectedItem((String) tableLopHoc.getValueAt(row, 2));
            comboboxmaGiaoVienChuNhiem.setSelectedItem((String) tableLopHoc.getValueAt(row, 4));
        }

    }

    public void xoaLopHoc(ActionListener listener) {
        btnXoaLopHoc.addActionListener(listener);
    }

    public void capNhapSiSoLopHoc(ActionListener listener) {
        btnCapNhapSiSoLopHoc.addActionListener(listener);
    }

    public void suaLopHoc(ActionListener listener) {
        btnSuaLopHoc.addActionListener(listener);
    }

//Khoa
    public void loadKhoa(ActionListener listener) {
        btnLoadKhoa.addActionListener(listener);
    }

    public void hienThiTrenTableKhoa(Object[][] data, String[] column) {
        DefaultTableModel defaultTableModel = new DefaultTableModel(data, column);
        tableKhoa.setModel(defaultTableModel);
    }

    public void setComboBoxChoBangKhoa(ArrayList<String> danhSachMaGiaoVien, ArrayList<String> maGiaoVienDangLaChuNhiemKhoa) {
        this.jComboBox.removeAllItems();
        comboboxTruongKhoa.removeAllItems();
        comboboxNgayThanhLapKhoa.removeAllItems();
        comboboxThangThanhLapKhoa.removeAllItems();
        for (String maGiaoVien : danhSachMaGiaoVien) {
            this.jComboBox.addItem(maGiaoVien);
            comboboxTruongKhoa.addItem(maGiaoVien);
        }
        for (String maGiaoVien : danhSachMaGiaoVien) {
            for (String maGiaoVienDangLaNhiemKhoa : maGiaoVienDangLaChuNhiemKhoa) {
                if (maGiaoVien.equalsIgnoreCase(maGiaoVienDangLaNhiemKhoa)) {
                    this.jComboBox.removeItem(maGiaoVien);
                    comboboxTruongKhoa.removeItem(maGiaoVien);
                }
            }
        }
        for (int i = 1; i <= 12; i++) {
            comboboxThangThanhLapKhoa.addItem(String.valueOf(i));
        }
        this.xacThucNgayThangNam();
        tableKhoa.getColumnModel().getColumn(4).setCellEditor(new DefaultCellEditor(jComboBox));
    }

    public void batSuKienThangThanhLapKhoa(ItemListener aListener) {
        comboboxThangThanhLapKhoa.addItemListener(aListener);
    }

    public void batSuKienNamThanhLapKhoa(ItemListener aListener) {
        comboboxNamThanhLapKhoa.addItemListener(aListener);
    }

    public JComboBox getJcomboboxThangThanhLapKhoa() {
        return this.comboboxThangThanhLapKhoa;
    }

    public JComboBox getJcomboboxNamThanhLapKhoa() {
        return this.comboboxNamThanhLapKhoa;
    }

    public void xacThucNgayThangNam() {
        comboboxNgayThanhLapKhoa.removeAllItems();
        switch (comboboxThangThanhLapKhoa.getSelectedIndex()) {
            case 0, 2, 4, 6, 7, 9, 11 -> {
                for (int i = 1; i <= 31; i++) {
                    comboboxNgayThanhLapKhoa.addItem(String.valueOf(i));
                }
            }
            case 3, 5, 8, 10 -> {
                for (int i = 1; i <= 30; i++) {
                    comboboxNgayThanhLapKhoa.addItem(String.valueOf(i));
                }
            }
            case 1 -> {
                System.out.println("Nam sau khi duoc click:" + comboboxNamThanhLapKhoa.getSelectedItem());
                if (Integer.parseInt((String) comboboxNamThanhLapKhoa.getSelectedItem()) % 4 == 0) {
                    for (int i = 1; i <= 29; i++) {
                        comboboxNgayThanhLapKhoa.addItem(String.valueOf(i));
                    }
                } else {
                    for (int i = 1; i <= 28; i++) {
                        comboboxNgayThanhLapKhoa.addItem(String.valueOf(i));
                    }
                }
            }
            default -> {
            }
        }

    }

    public void renderNamThanhLapKhoa(KeyAdapter listener) {
        comboboxNamThanhLapKhoa.addKeyListener(listener);
    }

    public void tangThemNamThanhLapKhoa() {
        this.namThanhLapKhoa--;
        comboboxNamThanhLapKhoa.addItem(String.valueOf(this.namThanhLapKhoa));
    }

    public void batSuKienChoJpanel(MouseAdapter lisAdapter) {
        jPanelKhoa.addMouseListener(lisAdapter);
    }

    public void resetComboBoxNamThanhLapKhoa() {
        comboboxNamThanhLapKhoa.removeAllItems();
        this.namThanhLapKhoa = 2000;
        for (int i = 2024; 2000 <= i; i--) {
            comboboxNamThanhLapKhoa.addItem(String.valueOf(i));
        }
    }

    public void themKhoa(ActionListener listener) {
        btnThemKhoa.addActionListener(listener);
    }

    public ArrayList<Object> getInputKhoa() {
        ArrayList<Object> inputKhoa = new ArrayList<>();
        inputKhoa.add(textMaKhoa.getText());
        inputKhoa.add(textTenKhoa.getText());
        inputKhoa.add(comboboxNgayThanhLapKhoa.getSelectedItem());
        inputKhoa.add(comboboxThangThanhLapKhoa.getSelectedItem());
        inputKhoa.add(comboboxNamThanhLapKhoa.getSelectedItem());
        inputKhoa.add(comboboxTruongKhoa.getSelectedItem());
        return inputKhoa;
    }

    public void capNhapGiaoVienTrenBangKhoa(ActionListener listener) {
        btnCapNhapSoLuongGiaoVien.addActionListener(listener);
    }

    public void xoaKhoa(ActionListener listener) {
        btnXoaKhoa.addActionListener(listener);
    }

    public void batSuKienEnterTrenBangKhoa(KeyAdapter keyAdapter) {
        tableKhoa.addKeyListener(keyAdapter);
    }

    public void xuLiSuKienTungDongTrenBangKhoa(ListSelectionListener listSelectionListener) {
        ListSelectionModel listSelectionModel = tableKhoa.getSelectionModel();
        listSelectionModel.addListSelectionListener(listSelectionListener);
    }

    public int getRowTableKhoa() {
        return tableKhoa.getSelectedRow();
    }

    public void hienThiBangKhoaBangAbstractTableModel(AbstractTableModel abStractTableModel) {
        tableKhoa.setModel(abStractTableModel);
    }

    public void locMaGiaoVienDeLamTruongKhoa(ArrayList<Khoa> danhSachKhoa, ArrayList<GiaoVien> danhSachGiaoVien, int row) {
        this.jComboBox.removeAllItems();
        for (GiaoVien giaoVien : danhSachGiaoVien) {
            if (danhSachKhoa.get(row).getMaKhoa().contains(giaoVien.getMaKhoa())) {
                this.jComboBox.addItem(giaoVien.getMaGv());
            }
        }

    }

    public void batSuKienJcomboBoxTrongBangKhoa(ActionListener listener) {
        this.jComboBox.addActionListener(listener);
    }

    public void showThongTinKhoaTrenInput(int row) {
        textMaKhoa.setText((String) tableKhoa.getValueAt(row, 0));
        this.textTenKhoa.setText((String) tableKhoa.getValueAt(row, 1));

    }

    //ket qua thi
    public void hienThiBangKetQuaThi(Object[][] data, String[] column) {
        DefaultTableModel defaultTableModel = new DefaultTableModel(data, column);
        this.tableKetQuaThi.setModel(defaultTableModel);
    }

    public void loadKetQuaThi(ActionListener listener) {
        this.btnLoadKetQuaThi.addActionListener(listener);
    }
//KetQuaThi

    public void showComboBoxMaHocVienTrenBangKetQuaThi(ArrayList<HocVien> danhSachHocVien) {
        this.comboBoxMaHocVienBangKetQuaThi.removeAllItems();
        for (HocVien hocVien : danhSachHocVien) {
            comboBoxMaHocVienBangKetQuaThi.addItem(hocVien.getMaHocVien());
        }
    }

    private void showComboBoxMaMonHocTrenBangKetQuaThi(ArrayList<String> danhSachMaMonHoc) {
        comboBoxMaMonHoc.removeAllItems();
        for (String maMonHoc : danhSachMaMonHoc) {
            comboBoxMaMonHoc.addItem(maMonHoc);
        }
    }

    public void hienThiBangKetQuaThiBangAbstractModel(AbstractTableModel abstractTableModel) {
        tableKetQuaThi.setModel(abstractTableModel);
    }

    public void capNhapMaHocVienTheoKhoa(ActionListener listener) {
        btnCapNhapMaHocVienTheoKhoa.addActionListener(listener);
    }

    public void timKetQuaThi(ActionListener listener) {
        btnTimKetQuaThi.addActionListener(listener);
    }

    public ArrayList<Object> getInputBangKetQuaThi() {
        ArrayList<Object> ketQuaInput = new ArrayList<>();
        ketQuaInput.add(this.comboBoxMaHocVienBangKetQuaThi.getSelectedItem());
        ketQuaInput.add(this.comboBoxMaMonHoc.getSelectedItem());
        return ketQuaInput;
    }

    public void themKetQuaThi(ActionListener listener) {
        btnThemKetQuaThi.addActionListener(listener);
    }

    public void showLanThi() {
        for (int i = 1; i <= 3; i++) {
            comboBoxLanThi.addItem(String.valueOf(i));
        }
    }

    public void showDiemThi() {
        for (float i = 0; i <= 10; i += 0.25) {
            this.comboBoxDiemThi.addItem(String.valueOf(i));
        }
    }

    public void showNgayThangNamKetQuaThi() {
        for (int i = 1; i <= 31; i++) {
            this.comboBoxNgayThi.addItem(String.valueOf(i));
        }
        for (int i = 1; i <= 12; i++) {
            this.comboBoxThangThi.addItem(String.valueOf(i));
        }
        for (int i = 2024; 2000 <= i; i--) {
            this.comboBoxNamThi.addItem(String.valueOf(i));
        }
    }

    public ArrayList<Object> getInputKetQuaThiDeThem() {
        ArrayList<Object> ketQuaInputKetQuaThiDeThemVao = new ArrayList<>();
        String ngay = (String) this.comboBoxNgayThi.getSelectedItem();
        String thang = (String) this.comboBoxThangThi.getSelectedItem();
        String nam = (String) this.comboBoxNamThi.getSelectedItem();
        String ngayThangNam = ngay + "/" + thang + "/" + nam;
        ketQuaInputKetQuaThiDeThemVao.add(this.comboBoxMaHocVienBangKetQuaThi.getSelectedItem());
        ketQuaInputKetQuaThiDeThemVao.add(this.comboBoxMaMonHoc.getSelectedItem());
        ketQuaInputKetQuaThiDeThemVao.add(this.comboBoxLanThi.getSelectedItem());
        ketQuaInputKetQuaThiDeThemVao.add(ngayThangNam);
        ketQuaInputKetQuaThiDeThemVao.add(this.comboBoxDiemThi.getSelectedItem());
        return ketQuaInputKetQuaThiDeThemVao;
    }

    public void xuLiSuKienKhiClickTungDongBangKetQuaThi(ListSelectionListener listSelectionListener) {
        ListSelectionModel listSelectionModel = tableKetQuaThi.getSelectionModel();
        listSelectionModel.addListSelectionListener(listSelectionListener);
    }

    public void xoaKetQuaThi(ActionListener listener) {
        btnXoaKetQuaThi.addActionListener(listener);
    }

    public int[] getNhieuChiSoDongBangKetQuaThi() {
        return tableKetQuaThi.getSelectedRows();
    }

    public void xoaHetKetQuaThi(ActionListener listener) {
        btnXoaHetKetQuaThi.addActionListener(listener);
    }

    public int getDoDaiBangKetQuaThi() {
        return tableKetQuaThi.getRowCount();
    }

    public void capNhapKetQuaTrenBangKetQuaThi(ActionListener listener) {
        btnCapNhapKetQuaBangKetQuaThi.addActionListener(listener);
    }

    public void tinhDiemTrungBinhKetQuaThi(ActionListener listener) {
        btnTinhDiemTrungBinhKetQuaThi.addActionListener(listener);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        comboBoxThangThi1 = new javax.swing.JComboBox<>();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        textMaLopHoc = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        textTenLopHoc = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        comboboxLopTruongLopHoc = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        comboboxmaGiaoVienChuNhiem = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        btnThemGiaoVien = new javax.swing.JButton();
        btnCapNhapLopTruong = new javax.swing.JButton();
        btnXoaLopHoc = new javax.swing.JButton();
        btnCapNhapSiSoLopHoc = new javax.swing.JButton();
        btnSuaLopHoc = new javax.swing.JButton();
        btnLoadLopHoc = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tableLopHoc = new javax.swing.JTable();
        jPanelKhoa = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        textMaKhoa = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        textTenKhoa = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        comboboxTruongKhoa = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        comboboxNgayThanhLapKhoa = new javax.swing.JComboBox<>();
        jLabel20 = new javax.swing.JLabel();
        comboboxThangThanhLapKhoa = new javax.swing.JComboBox<>();
        jLabel21 = new javax.swing.JLabel();
        comboboxNamThanhLapKhoa = new javax.swing.JComboBox<>();
        jPanel6 = new javax.swing.JPanel();
        btnThemKhoa = new javax.swing.JButton();
        btnCapNhapSoLuongGiaoVien = new javax.swing.JButton();
        btnXoaKhoa = new javax.swing.JButton();
        btnLoadKhoa = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableKhoa = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        comboBoxMaHocVienBangKetQuaThi = new javax.swing.JComboBox<>();
        jPanel18 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        comboBoxMaMonHoc = new javax.swing.JComboBox<>();
        jPanel19 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        comboBoxLanThi = new javax.swing.JComboBox<>();
        jPanel20 = new javax.swing.JPanel();
        jPanel22 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        comboBoxNgayThi = new javax.swing.JComboBox<>();
        jPanel23 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        comboBoxThangThi = new javax.swing.JComboBox<>();
        jPanel24 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        comboBoxNamThi = new javax.swing.JComboBox<>();
        jPanel21 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        comboBoxDiemThi = new javax.swing.JComboBox<>();
        jPanel16 = new javax.swing.JPanel();
        jPanel25 = new javax.swing.JPanel();
        btnThemKetQuaThi = new javax.swing.JButton();
        btnTimKetQuaThi = new javax.swing.JButton();
        jPanel26 = new javax.swing.JPanel();
        btnCapNhapMaHocVienTheoKhoa = new javax.swing.JButton();
        btnCapNhapKetQuaBangKetQuaThi = new javax.swing.JButton();
        jPanel27 = new javax.swing.JPanel();
        btnXoaKetQuaThi = new javax.swing.JButton();
        btnXoaHetKetQuaThi = new javax.swing.JButton();
        jPanel28 = new javax.swing.JPanel();
        btnTinhDiemTrungBinhKetQuaThi = new javax.swing.JButton();
        btnLoadKetQuaThi = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableKetQuaThi = new javax.swing.JTable();

        jTextField1.setText("jTextField1");

        jTextField4.setText("jTextField4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.Y_AXIS));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nhập thông tin lớp", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(0, 204, 0))); // NOI18N
        jPanel3.setPreferredSize(new java.awt.Dimension(633, 100));

        jLabel1.setText("Mã lớp");

        jLabel2.setText("Tên lớp");

        jLabel3.setText("Lớp trưởng");

        jLabel4.setText("Mã GVCN");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(163, 163, 163)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textTenLopHoc))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(textMaLopHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(4, 4, 4)
                        .addComponent(comboboxLopTruongLopHoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(comboboxmaGiaoVienChuNhiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(470, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(textMaLopHoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(comboboxLopTruongLopHoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(textTenLopHoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(comboboxmaGiaoVienChuNhiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chức năng", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(0, 204, 0))); // NOI18N

        btnThemGiaoVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Anh/Them.png"))); // NOI18N
        btnThemGiaoVien.setText("Thêm");
        jPanel4.add(btnThemGiaoVien);

        btnCapNhapLopTruong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Anh/Unknown person.png"))); // NOI18N
        btnCapNhapLopTruong.setText("Cập nhập lớp trưởng");
        jPanel4.add(btnCapNhapLopTruong);

        btnXoaLopHoc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Anh/Xoa.png"))); // NOI18N
        btnXoaLopHoc.setText("Xóa");
        jPanel4.add(btnXoaLopHoc);

        btnCapNhapSiSoLopHoc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Anh/Users.png"))); // NOI18N
        btnCapNhapSiSoLopHoc.setText("Cập nhập sĩ số");
        jPanel4.add(btnCapNhapSiSoLopHoc);

        btnSuaLopHoc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Anh/Sua.png"))); // NOI18N
        btnSuaLopHoc.setText("Sửa");
        jPanel4.add(btnSuaLopHoc);

        btnLoadLopHoc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Anh/CapNhap.png"))); // NOI18N
        btnLoadLopHoc.setText("Load");
        jPanel4.add(btnLoadLopHoc);

        jPanel1.add(jPanel4);

        jScrollPane4.setPreferredSize(new java.awt.Dimension(452, 200));

        tableLopHoc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(tableLopHoc);

        jPanel1.add(jScrollPane4);

        jTabbedPane1.addTab("Lớp học", jPanel1);

        jPanelKhoa.setLayout(new javax.swing.BoxLayout(jPanelKhoa, javax.swing.BoxLayout.Y_AXIS));

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nhập thông tin", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(0, 204, 0))); // NOI18N
        jPanel5.setLayout(new java.awt.GridLayout(2, 0));

        jPanel7.setLayout(new java.awt.GridLayout(3, 0));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 918, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 32, Short.MAX_VALUE)
        );

        jPanel7.add(jPanel9);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 918, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 32, Short.MAX_VALUE)
        );

        jPanel7.add(jPanel10);

        jLabel16.setText("Mã khoa");
        jPanel11.add(jLabel16);

        textMaKhoa.setMaximumSize(new java.awt.Dimension(100, 22));
        textMaKhoa.setMinimumSize(new java.awt.Dimension(100, 22));
        textMaKhoa.setPreferredSize(new java.awt.Dimension(70, 22));
        jPanel11.add(textMaKhoa);

        jLabel17.setText("Tên khoa");
        jPanel11.add(jLabel17);

        textTenKhoa.setPreferredSize(new java.awt.Dimension(120, 22));
        jPanel11.add(textTenKhoa);

        jLabel18.setText("Trưởng khoa");
        jPanel11.add(jLabel18);

        comboboxTruongKhoa.setMaximumSize(new java.awt.Dimension(32767, 22));
        comboboxTruongKhoa.setPreferredSize(new java.awt.Dimension(100, 22));
        jPanel11.add(comboboxTruongKhoa);

        jLabel19.setText("Ngày");
        jPanel11.add(jLabel19);

        comboboxNgayThanhLapKhoa.setMaximumSize(new java.awt.Dimension(32767, 22));
        comboboxNgayThanhLapKhoa.setMinimumSize(new java.awt.Dimension(100, 22));
        comboboxNgayThanhLapKhoa.setPreferredSize(new java.awt.Dimension(100, 22));
        jPanel11.add(comboboxNgayThanhLapKhoa);

        jLabel20.setText("Tháng");
        jPanel11.add(jLabel20);

        comboboxThangThanhLapKhoa.setPreferredSize(new java.awt.Dimension(100, 22));
        jPanel11.add(comboboxThangThanhLapKhoa);

        jLabel21.setText("Năm");
        jPanel11.add(jLabel21);

        comboboxNamThanhLapKhoa.setMinimumSize(new java.awt.Dimension(80, 22));
        comboboxNamThanhLapKhoa.setPreferredSize(new java.awt.Dimension(100, 22));
        jPanel11.add(comboboxNamThanhLapKhoa);

        jPanel7.add(jPanel11);

        jPanel5.add(jPanel7);

        jPanelKhoa.add(jPanel5);

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chức năng", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(0, 204, 0))); // NOI18N

        btnThemKhoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Anh/Them.png"))); // NOI18N
        btnThemKhoa.setText("Thêm");
        jPanel6.add(btnThemKhoa);

        btnCapNhapSoLuongGiaoVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Anh/List.png"))); // NOI18N
        btnCapNhapSoLuongGiaoVien.setText("Cập nhập số lượng giáo viên");
        jPanel6.add(btnCapNhapSoLuongGiaoVien);

        btnXoaKhoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Anh/Xoa.png"))); // NOI18N
        btnXoaKhoa.setText("Xóa");
        jPanel6.add(btnXoaKhoa);

        btnLoadKhoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Anh/CapNhap.png"))); // NOI18N
        btnLoadKhoa.setText("Load");
        jPanel6.add(btnLoadKhoa);

        jPanelKhoa.add(jPanel6);

        jScrollPane1.setMaximumSize(new java.awt.Dimension(32767, 200));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(452, 200));

        tableKhoa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableKhoa.setMaximumSize(new java.awt.Dimension(100, 100));
        tableKhoa.setPreferredSize(new java.awt.Dimension(300, 100));
        jScrollPane1.setViewportView(tableKhoa);

        jPanelKhoa.add(jScrollPane1);

        jTabbedPane1.addTab("Khoa", jPanelKhoa);

        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.Y_AXIS));

        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nhập thông tin", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(0, 204, 0))); // NOI18N
        jPanel15.setPreferredSize(new java.awt.Dimension(675, 100));
        jPanel15.setLayout(new java.awt.GridLayout());

        jPanel17.setMaximumSize(new java.awt.Dimension(120, 32767));
        jPanel17.setMinimumSize(new java.awt.Dimension(120, 32));
        jPanel17.setPreferredSize(new java.awt.Dimension(100, 50));

        jLabel5.setText("Mã học viên");
        jPanel17.add(jLabel5);

        comboBoxMaHocVienBangKetQuaThi.setMaximumSize(new java.awt.Dimension(90, 32767));
        comboBoxMaHocVienBangKetQuaThi.setMinimumSize(new java.awt.Dimension(60, 22));
        comboBoxMaHocVienBangKetQuaThi.setPreferredSize(new java.awt.Dimension(70, 22));
        jPanel17.add(comboBoxMaHocVienBangKetQuaThi);

        jPanel15.add(jPanel17);

        jLabel6.setText("Mã môn học");
        jPanel18.add(jLabel6);

        comboBoxMaMonHoc.setPreferredSize(new java.awt.Dimension(70, 22));
        jPanel18.add(comboBoxMaMonHoc);

        jPanel15.add(jPanel18);

        jLabel7.setText("Lần thi");
        jPanel19.add(jLabel7);

        comboBoxLanThi.setMinimumSize(new java.awt.Dimension(50, 22));
        comboBoxLanThi.setPreferredSize(new java.awt.Dimension(70, 22));
        jPanel19.add(comboBoxLanThi);

        jPanel15.add(jPanel19);

        jPanel20.setLayout(new java.awt.GridLayout(3, 0));

        jLabel9.setText("Ngày");
        jLabel9.setPreferredSize(new java.awt.Dimension(33, 16));
        jPanel22.add(jLabel9);

        comboBoxNgayThi.setMaximumSize(new java.awt.Dimension(72, 22));
        jPanel22.add(comboBoxNgayThi);

        jPanel20.add(jPanel22);

        jLabel10.setText("Tháng");
        jPanel23.add(jLabel10);

        comboBoxThangThi.setMaximumSize(new java.awt.Dimension(72, 22));
        jPanel23.add(comboBoxThangThi);

        jPanel20.add(jPanel23);

        jLabel11.setText("Năm");
        jLabel11.setPreferredSize(new java.awt.Dimension(33, 16));
        jPanel24.add(jLabel11);

        comboBoxNamThi.setMaximumSize(new java.awt.Dimension(72, 22));
        jPanel24.add(comboBoxNamThi);

        jPanel20.add(jPanel24);

        jPanel15.add(jPanel20);

        jLabel8.setText("Điểm");
        jPanel21.add(jLabel8);

        comboBoxDiemThi.setPreferredSize(new java.awt.Dimension(70, 22));
        jPanel21.add(comboBoxDiemThi);

        jPanel15.add(jPanel21);

        jPanel2.add(jPanel15);

        jPanel16.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chức năng", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(0, 204, 0))); // NOI18N
        jPanel16.setLayout(new java.awt.GridLayout(4, 0));

        btnThemKetQuaThi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Anh/Them.png"))); // NOI18N
        btnThemKetQuaThi.setText("Thêm");
        btnThemKetQuaThi.setPreferredSize(new java.awt.Dimension(177, 31));
        jPanel25.add(btnThemKetQuaThi);

        btnTimKetQuaThi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Anh/TimKiem.png"))); // NOI18N
        btnTimKetQuaThi.setText("Tìm");
        btnTimKetQuaThi.setPreferredSize(new java.awt.Dimension(177, 31));
        jPanel25.add(btnTimKetQuaThi);

        jPanel16.add(jPanel25);

        btnCapNhapMaHocVienTheoKhoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Anh/ChiTiet.png"))); // NOI18N
        btnCapNhapMaHocVienTheoKhoa.setText("Cập nhập mã học viên");
        jPanel26.add(btnCapNhapMaHocVienTheoKhoa);

        btnCapNhapKetQuaBangKetQuaThi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Anh/Best.png"))); // NOI18N
        btnCapNhapKetQuaBangKetQuaThi.setText("Cập nhập kết quả");
        btnCapNhapKetQuaBangKetQuaThi.setPreferredSize(new java.awt.Dimension(177, 31));
        jPanel26.add(btnCapNhapKetQuaBangKetQuaThi);

        jPanel16.add(jPanel26);

        btnXoaKetQuaThi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Anh/Xoa.png"))); // NOI18N
        btnXoaKetQuaThi.setText("Xóa");
        btnXoaKetQuaThi.setPreferredSize(new java.awt.Dimension(177, 31));
        jPanel27.add(btnXoaKetQuaThi);

        btnXoaHetKetQuaThi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Anh/Trash.png"))); // NOI18N
        btnXoaHetKetQuaThi.setText("Xóa hết");
        btnXoaHetKetQuaThi.setPreferredSize(new java.awt.Dimension(177, 31));
        jPanel27.add(btnXoaHetKetQuaThi);

        jPanel16.add(jPanel27);

        btnTinhDiemTrungBinhKetQuaThi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Anh/Numbered list.png"))); // NOI18N
        btnTinhDiemTrungBinhKetQuaThi.setText("Tính điểm trung bình");
        btnTinhDiemTrungBinhKetQuaThi.setPreferredSize(new java.awt.Dimension(177, 31));
        jPanel28.add(btnTinhDiemTrungBinhKetQuaThi);

        btnLoadKetQuaThi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Anh/CapNhap.png"))); // NOI18N
        btnLoadKetQuaThi.setText("Load");
        btnLoadKetQuaThi.setPreferredSize(new java.awt.Dimension(177, 31));
        jPanel28.add(btnLoadKetQuaThi);

        jPanel16.add(jPanel28);

        jPanel2.add(jPanel16);

        tableKetQuaThi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã học viên", "Mã môn học", "Lần thi", "Ngày thi", "Điểm", "Kết quả"
            }
        ));
        jScrollPane2.setViewportView(tableKetQuaThi);

        jPanel2.add(jScrollPane2);

        jTabbedPane1.addTab("Kết quả thi", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 501, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCapNhapKetQuaBangKetQuaThi;
    private javax.swing.JButton btnCapNhapLopTruong;
    private javax.swing.JButton btnCapNhapMaHocVienTheoKhoa;
    private javax.swing.JButton btnCapNhapSiSoLopHoc;
    private javax.swing.JButton btnCapNhapSoLuongGiaoVien;
    private javax.swing.JButton btnLoadKetQuaThi;
    private javax.swing.JButton btnLoadKhoa;
    private javax.swing.JButton btnLoadLopHoc;
    private javax.swing.JButton btnSuaLopHoc;
    private javax.swing.JButton btnThemGiaoVien;
    private javax.swing.JButton btnThemKetQuaThi;
    private javax.swing.JButton btnThemKhoa;
    private javax.swing.JButton btnTimKetQuaThi;
    private javax.swing.JButton btnTinhDiemTrungBinhKetQuaThi;
    private javax.swing.JButton btnXoaHetKetQuaThi;
    private javax.swing.JButton btnXoaKetQuaThi;
    private javax.swing.JButton btnXoaKhoa;
    private javax.swing.JButton btnXoaLopHoc;
    private javax.swing.JComboBox<String> comboBoxDiemThi;
    private javax.swing.JComboBox<String> comboBoxLanThi;
    private javax.swing.JComboBox<String> comboBoxMaHocVienBangKetQuaThi;
    private javax.swing.JComboBox<String> comboBoxMaMonHoc;
    private javax.swing.JComboBox<String> comboBoxNamThi;
    private javax.swing.JComboBox<String> comboBoxNgayThi;
    private javax.swing.JComboBox<String> comboBoxThangThi;
    private javax.swing.JComboBox<String> comboBoxThangThi1;
    private javax.swing.JComboBox<String> comboboxLopTruongLopHoc;
    private javax.swing.JComboBox<String> comboboxNamThanhLapKhoa;
    private javax.swing.JComboBox<String> comboboxNgayThanhLapKhoa;
    private javax.swing.JComboBox<String> comboboxThangThanhLapKhoa;
    private javax.swing.JComboBox<String> comboboxTruongKhoa;
    private javax.swing.JComboBox<String> comboboxmaGiaoVienChuNhiem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel jPanelKhoa;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTable tableKetQuaThi;
    private javax.swing.JTable tableKhoa;
    private javax.swing.JTable tableLopHoc;
    private javax.swing.JTextField textMaKhoa;
    private javax.swing.JTextField textMaLopHoc;
    private javax.swing.JTextField textTenKhoa;
    private javax.swing.JTextField textTenLopHoc;
    // End of variables declaration//GEN-END:variables

}
