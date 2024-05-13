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
        comboboxNamThanhLapKhoa.removeAllItems();
        
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
    
    public void batSuKienNgayThangNam(ItemListener aListener) {
        comboboxThangThanhLapKhoa.addItemListener(aListener);
    }
    
    public JComboBox getJcombobox() {
        return this.comboboxThangThanhLapKhoa;
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tableLopHoc = new javax.swing.JTable();
        btnLoadLopHoc = new javax.swing.JButton();
        btnThemGiaoVien = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        textMaLopHoc = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        textTenLopHoc = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        comboboxLopTruongLopHoc = new javax.swing.JComboBox<>();
        comboboxmaGiaoVienChuNhiem = new javax.swing.JComboBox<>();
        btnCapNhapLopTruong = new javax.swing.JButton();
        btnXoaLopHoc = new javax.swing.JButton();
        btnCapNhapSiSoLopHoc = new javax.swing.JButton();
        btnSuaLopHoc = new javax.swing.JButton();
        jPanelKhoa = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableKhoa = new javax.swing.JTable();
        btnLoadKhoa = new javax.swing.JButton();
        btnThemKhoa = new javax.swing.JButton();
        textMaKhoa = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        textTenKhoa = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        comboboxNgayThanhLapKhoa = new javax.swing.JComboBox<>();
        comboboxThangThanhLapKhoa = new javax.swing.JComboBox<>();
        comboboxNamThanhLapKhoa = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        comboboxTruongKhoa = new javax.swing.JComboBox<>();
        btnCapNhapSoLuongGiaoVien = new javax.swing.JButton();
        btnXoaKhoa = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableKetQuaThi = new javax.swing.JTable();
        btnLoadKetQuaThi = new javax.swing.JButton();
        btnThemKetQuaThi = new javax.swing.JButton();
        comboBoxMaHocVienBangKetQuaThi = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        comboBoxMaMonHoc = new javax.swing.JComboBox<>();
        btnCapNhapMaHocVienTheoKhoa = new javax.swing.JButton();
        btnTimKetQuaThi = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        comboBoxLanThi = new javax.swing.JComboBox<>();
        comboBoxNgayThi = new javax.swing.JComboBox<>();
        comboBoxThangThi = new javax.swing.JComboBox<>();
        comboBoxNamThi = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        comboBoxDiemThi = new javax.swing.JComboBox<>();
        btnXoaKetQuaThi = new javax.swing.JButton();
        btnXoaHetKetQuaThi = new javax.swing.JButton();
        btnCapNhapKetQuaBangKetQuaThi = new javax.swing.JButton();
        btnTinhDiemTrungBinhKetQuaThi = new javax.swing.JButton();

        jTextField1.setText("jTextField1");

        jTextField4.setText("jTextField4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tableLopHoc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã lớp", "Tên lớp", "Lớp trưởng", "Sĩ số", "Mã giáo viên chủ nhiệm"
            }
        ));
        jScrollPane1.setViewportView(tableLopHoc);

        btnLoadLopHoc.setText("Load");

        btnThemGiaoVien.setText("Thêm");

        jLabel1.setText("Mã lớp");

        jLabel2.setText("Tên lớp");

        jLabel3.setText("Lớp trưởng");

        jLabel4.setText("Mã giáo viên chủ nhiệm");

        btnCapNhapLopTruong.setText("Cập nhập lớp trưởng");

        btnXoaLopHoc.setText("Xóa");

        btnCapNhapSiSoLopHoc.setText("Cập nhập sĩ số");

        btnSuaLopHoc.setText("Sửa");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(textTenLopHoc))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(18, 18, 18)
                                        .addComponent(textMaLopHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(comboboxLopTruongLopHoc, 0, 100, Short.MAX_VALUE)
                                    .addComponent(comboboxmaGiaoVienChuNhiem, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(btnThemGiaoVien)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnCapNhapLopTruong)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnXoaLopHoc)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnLoadLopHoc)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnCapNhapSiSoLopHoc)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnSuaLopHoc)))
                        .addGap(32, 32, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 621, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(textMaLopHoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(comboboxLopTruongLopHoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(textTenLopHoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(comboboxmaGiaoVienChuNhiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 177, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLoadLopHoc)
                    .addComponent(btnThemGiaoVien)
                    .addComponent(btnCapNhapLopTruong)
                    .addComponent(btnXoaLopHoc)
                    .addComponent(btnCapNhapSiSoLopHoc)
                    .addComponent(btnSuaLopHoc))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Lớp học", jPanel1);

        tableKhoa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã khoa", "Tên khoa", "Ngày thành lập", "Số lượng giáo viên", "Trưởng khoa"
            }
        ));
        jScrollPane2.setViewportView(tableKhoa);

        btnLoadKhoa.setText("Load");

        btnThemKhoa.setText("Thêm");

        jLabel5.setText("Mã khoa");

        jLabel6.setText("Tên khoa");

        jLabel7.setText("Ngày thành lập");

        comboboxNgayThanhLapKhoa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel8.setText("Trưởng khoa");

        btnCapNhapSoLuongGiaoVien.setText("Cập nhập số lượng giáo viên");

        btnXoaKhoa.setText("Xóa");

        javax.swing.GroupLayout jPanelKhoaLayout = new javax.swing.GroupLayout(jPanelKhoa);
        jPanelKhoa.setLayout(jPanelKhoaLayout);
        jPanelKhoaLayout.setHorizontalGroup(
            jPanelKhoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelKhoaLayout.createSequentialGroup()
                .addGroup(jPanelKhoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelKhoaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanelKhoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanelKhoaLayout.createSequentialGroup()
                                .addComponent(textMaKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanelKhoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelKhoaLayout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addComponent(btnLoadKhoa)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnThemKhoa))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelKhoaLayout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addComponent(textTenKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanelKhoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelKhoaLayout.createSequentialGroup()
                                        .addComponent(comboboxNgayThanhLapKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanelKhoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel7)
                                            .addGroup(jPanelKhoaLayout.createSequentialGroup()
                                                .addComponent(comboboxThangThanhLapKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(comboboxNamThanhLapKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(jPanelKhoaLayout.createSequentialGroup()
                                        .addComponent(btnCapNhapSoLuongGiaoVien)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnXoaKhoa)))
                                .addGap(0, 73, Short.MAX_VALUE))
                            .addGroup(jPanelKhoaLayout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(jLabel5)
                                .addGap(103, 103, 103)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanelKhoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(comboboxTruongKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8))
                                .addGap(57, 57, 57)))))
                .addContainerGap())
        );
        jPanelKhoaLayout.setVerticalGroup(
            jPanelKhoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelKhoaLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanelKhoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelKhoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textMaKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textTenKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboboxNgayThanhLapKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboboxThangThanhLapKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboboxNamThanhLapKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboboxTruongKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 132, Short.MAX_VALUE)
                .addGroup(jPanelKhoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLoadKhoa)
                    .addComponent(btnThemKhoa)
                    .addComponent(btnCapNhapSoLuongGiaoVien)
                    .addComponent(btnXoaKhoa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Khoa", jPanelKhoa);

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
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã học viên", "Mã môn học", "Lần thi", "Ngày thi", "Điểm", "Kết quả"
            }
        ));
        jScrollPane3.setViewportView(tableKetQuaThi);

        btnLoadKetQuaThi.setText("Load");

        btnThemKetQuaThi.setText("Thêm");

        jLabel9.setText("Mã học viên");

        jLabel10.setText("Mã môn học");

        btnCapNhapMaHocVienTheoKhoa.setText("Cập nhập mã học viên");

        btnTimKetQuaThi.setText("Tìm");

        jLabel11.setText("Ngày tháng năm");

        jLabel12.setText("Lần thi");

        jLabel13.setText("Điểm");

        btnXoaKetQuaThi.setText("Xóa");

        btnXoaHetKetQuaThi.setText("Xóa hết");

        btnCapNhapKetQuaBangKetQuaThi.setText("Cập nhập kết quả");

        btnTinhDiemTrungBinhKetQuaThi.setText("Tính điểm trung bình");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane3)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(comboBoxMaHocVienBangKetQuaThi, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(comboBoxMaMonHoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(jLabel9)
                                .addGap(54, 54, 54)
                                .addComponent(jLabel10)))
                        .addGap(48, 48, 48)
                        .addComponent(comboBoxLanThi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(comboBoxNgayThi, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(comboBoxThangThi, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboBoxNamThi, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnCapNhapKetQuaBangKetQuaThi)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnLoadKetQuaThi)
                                .addGap(18, 18, 18)
                                .addComponent(btnCapNhapMaHocVienTheoKhoa)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(btnTimKetQuaThi))))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(jLabel11))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(btnThemKetQuaThi)
                                .addGap(18, 18, 18)
                                .addComponent(btnXoaKetQuaThi))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(btnTinhDiemTrungBinhKetQuaThi)))))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(56, 56, 56))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(comboBoxDiemThi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnXoaHetKetQuaThi)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBoxMaHocVienBangKetQuaThi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBoxMaMonHoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBoxLanThi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBoxNgayThi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBoxThangThi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBoxNamThi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBoxDiemThi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCapNhapKetQuaBangKetQuaThi)
                    .addComponent(btnTinhDiemTrungBinhKetQuaThi))
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLoadKetQuaThi)
                    .addComponent(btnThemKetQuaThi)
                    .addComponent(btnCapNhapMaHocVienTheoKhoa)
                    .addComponent(btnTimKetQuaThi)
                    .addComponent(btnXoaKetQuaThi)
                    .addComponent(btnXoaHetKetQuaThi))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

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
                .addComponent(jTabbedPane1)
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
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelKhoa;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
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
