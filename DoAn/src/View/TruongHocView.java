/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import ModelGiaoVien.GiaoVienModel;
import ModelHocVien.HocVien;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PC
 */
public class TruongHocView extends javax.swing.JFrame {

    private int hangNgang;

    /**
     * Creates new form QLGVView
     */
    public TruongHocView() {
        initComponents();
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

    public int getDoDaiBang() {
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

    public void xoaInput() {
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

    //Giáo viên
    public void loadGiaoVienBangClickButton(ActionListener listener) {
        btnLoadGiaoVien.addActionListener(listener);
    }

    public void loadGiaoVien(GiaoVienModel modelGiaoVien) {
        tableGiaoVien.setModel(modelGiaoVien);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jMenu1 = new javax.swing.JMenu();
        jFrame1 = new javax.swing.JFrame();
        dialogThongBaoTimKiemHocVien = new javax.swing.JDialog();
        panelThongBaoTimKiemHocVien = new javax.swing.JPanel();
        labelThongBaoTimKiem = new javax.swing.JLabel();
        btnThoatDialog = new javax.swing.JButton();
        dialogThongBaoChuaNhapThongTinHocVien = new javax.swing.JDialog();
        jPanel4 = new javax.swing.JPanel();
        labelThongBaoNhapKhongThanhCong = new javax.swing.JLabel();
        btnThoatDialogChuaNhapThongTinSinhVien = new javax.swing.JButton();
        buttonGroupGioiTinh = new javax.swing.ButtonGroup();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        jTabbedPanelHocVien = new javax.swing.JTabbedPane();
        jPanelGiaoVien = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tableGiaoVien = new javax.swing.JTable();
        btnLoadGiaoVien = new javax.swing.JButton();
        jPanelHocSinh = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableHocVien = new javax.swing.JTable();
        btnTimHocVien = new javax.swing.JButton();
        textMaHocVienMuonTim = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        textHoTenMuonTim = new javax.swing.JTextField();
        textMaLop = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        textMaHocVien = new javax.swing.JTextField();
        textHo = new javax.swing.JTextField();
        textTen = new javax.swing.JTextField();
        textNgaySinh = new javax.swing.JTextField();
        textNoiSinh = new javax.swing.JTextField();
        textMaLopDeChinhSuaThongTin = new javax.swing.JTextField();
        btnXoaHocVien = new javax.swing.JButton();
        btnNhapHocVien = new javax.swing.JButton();
        btnThemHocVien = new javax.swing.JButton();
        btnSuaThongTinHocVien = new javax.swing.JButton();
        radioButtonNam = new javax.swing.JRadioButton();
        radioButtonNu = new javax.swing.JRadioButton();
        btnXoaHetDuLieuBang = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jMenu1.setText("jMenu1");

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

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
        dialogThongBaoChuaNhapThongTinHocVien.setMinimumSize(new java.awt.Dimension(300, 300));
        dialogThongBaoChuaNhapThongTinHocVien.setModal(true);

        labelThongBaoNhapKhongThanhCong.setText("Bạn chưa nhập thông tin sinh viên");

        btnThoatDialogChuaNhapThongTinSinhVien.setText("OK");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addComponent(labelThongBaoNhapKhongThanhCong)
                .addGap(23, 23, 23))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addComponent(btnThoatDialogChuaNhapThongTinSinhVien)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(labelThongBaoNhapKhongThanhCong)
                .addGap(18, 18, 18)
                .addComponent(btnThoatDialogChuaNhapThongTinSinhVien)
                .addContainerGap(55, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout dialogThongBaoChuaNhapThongTinHocVienLayout = new javax.swing.GroupLayout(dialogThongBaoChuaNhapThongTinHocVien.getContentPane());
        dialogThongBaoChuaNhapThongTinHocVien.getContentPane().setLayout(dialogThongBaoChuaNhapThongTinHocVienLayout);
        dialogThongBaoChuaNhapThongTinHocVienLayout.setHorizontalGroup(
            dialogThongBaoChuaNhapThongTinHocVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogThongBaoChuaNhapThongTinHocVienLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(73, Short.MAX_VALUE))
        );
        dialogThongBaoChuaNhapThongTinHocVienLayout.setVerticalGroup(
            dialogThongBaoChuaNhapThongTinHocVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dialogThongBaoChuaNhapThongTinHocVienLayout.createSequentialGroup()
                .addContainerGap(45, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );

        jButton1.setText("jButton1");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable1);

        jScrollPane3.setViewportView(jTree1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tableGiaoVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã giáo viên", "Họ tên", "Học vị", "Giới tính", "Ngày sinh", "Lương cơ bản", "Hệ số", "Mức lương", "Mã khoa"
            }
        ));
        jScrollPane4.setViewportView(tableGiaoVien);

        btnLoadGiaoVien.setText("Load");

        javax.swing.GroupLayout jPanelGiaoVienLayout = new javax.swing.GroupLayout(jPanelGiaoVien);
        jPanelGiaoVien.setLayout(jPanelGiaoVienLayout);
        jPanelGiaoVienLayout.setHorizontalGroup(
            jPanelGiaoVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelGiaoVienLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 810, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelGiaoVienLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLoadGiaoVien)
                .addGap(36, 36, 36))
        );
        jPanelGiaoVienLayout.setVerticalGroup(
            jPanelGiaoVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelGiaoVienLayout.createSequentialGroup()
                .addContainerGap(132, Short.MAX_VALUE)
                .addComponent(btnLoadGiaoVien)
                .addGap(32, 32, 32)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPanelHocVien.addTab("Giáo viên", jPanelGiaoVien);

        jPanelHocSinh.setBackground(new java.awt.Color(255, 255, 255));
        jPanelHocSinh.setForeground(new java.awt.Color(255, 255, 255));

        tableHocVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã học viên", "Họ", "Tên", "Ngày sinh", "Giới tính", "Nơi sinh", "Mã lớp"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tableHocVien.setAutoscrolls(false);
        tableHocVien.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setViewportView(tableHocVien);

        btnTimHocVien.setText("Tìm học viên");

        jLabel1.setText("Nhập mã học viên ");

        jLabel2.setText("Tìm kiếm");

        jLabel3.setText("Nhập họ tên");
        jLabel3.setAlignmentX(0.5F);

        jLabel4.setText("Nhập mã lớp");

        jLabel5.setText("Mã học viên");

        jLabel6.setText("Chi tiết sinh viên");

        jLabel7.setText("Họ");

        jLabel8.setText("Tên");

        jLabel9.setText("Ngày sinh");

        jLabel10.setText("Giới tính");

        jLabel11.setText("Nơi sinh");

        jLabel12.setText("Mã lớp");

        btnXoaHocVien.setText("Xóa");

        btnNhapHocVien.setText("Load");

        btnThemHocVien.setText("Thêm");

        btnSuaThongTinHocVien.setText("Cập nhập");

        buttonGroupGioiTinh.add(radioButtonNam);
        radioButtonNam.setText("Nam");

        buttonGroupGioiTinh.add(radioButtonNu);
        radioButtonNu.setText("Nữ");

        btnXoaHetDuLieuBang.setText("Xóa hết");

        javax.swing.GroupLayout jPanelHocSinhLayout = new javax.swing.GroupLayout(jPanelHocSinh);
        jPanelHocSinh.setLayout(jPanelHocSinhLayout);
        jPanelHocSinhLayout.setHorizontalGroup(
            jPanelHocSinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelHocSinhLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 549, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanelHocSinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelHocSinhLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelHocSinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanelHocSinhLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanelHocSinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(btnTimHocVien))
                                .addGap(51, 51, 51))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelHocSinhLayout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addGroup(jPanelHocSinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel7))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(38, 38, 38))
                    .addGroup(jPanelHocSinhLayout.createSequentialGroup()
                        .addGroup(jPanelHocSinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelHocSinhLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(jPanelHocSinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanelHocSinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addGroup(jPanelHocSinhLayout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addGroup(jPanelHocSinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanelHocSinhLayout.createSequentialGroup()
                                                .addComponent(radioButtonNam)
                                                .addGap(18, 18, 18)
                                                .addComponent(radioButtonNu))
                                            .addGroup(jPanelHocSinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(textMaHocVien, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(jPanelHocSinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(textHoTenMuonTim, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(textMaHocVienMuonTim, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(textMaLop, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addComponent(textHo, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(textTen, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(textNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(textNoiSinh, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(textMaLopDeChinhSuaThongTin, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                            .addGroup(jPanelHocSinhLayout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addGroup(jPanelHocSinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnSuaThongTinHocVien, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnThemHocVien, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelHocSinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnXoaHocVien, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                                    .addComponent(btnXoaHetDuLieuBang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelHocSinhLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnNhapHocVien, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(86, 86, 86))))
        );
        jPanelHocSinhLayout.setVerticalGroup(
            jPanelHocSinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelHocSinhLayout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(5, 5, 5)
                .addGroup(jPanelHocSinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(textMaHocVienMuonTim, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelHocSinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(textHoTenMuonTim, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelHocSinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(textMaLop, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnTimHocVien)
                .addGap(35, 35, 35)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addGroup(jPanelHocSinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(textMaHocVien, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelHocSinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(textHo, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelHocSinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(textTen, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelHocSinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(textNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelHocSinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(radioButtonNam)
                    .addComponent(radioButtonNu))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelHocSinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(textNoiSinh, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelHocSinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(textMaLopDeChinhSuaThongTin, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelHocSinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnXoaHocVien)
                    .addComponent(btnSuaThongTinHocVien))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelHocSinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemHocVien)
                    .addComponent(btnXoaHetDuLieuBang))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnNhapHocVien)
                .addGap(44, 44, 44))
            .addComponent(jScrollPane1)
        );

        jTabbedPanelHocVien.addTab("Học viên", jPanelHocSinh);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPanelHocVien)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPanelHocVien)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLoadGiaoVien;
    private javax.swing.JButton btnNhapHocVien;
    private javax.swing.JButton btnSuaThongTinHocVien;
    private javax.swing.JButton btnThemHocVien;
    private javax.swing.JButton btnThoatDialog;
    private javax.swing.JButton btnThoatDialogChuaNhapThongTinSinhVien;
    private javax.swing.JButton btnTimHocVien;
    private javax.swing.JButton btnXoaHetDuLieuBang;
    private javax.swing.JButton btnXoaHocVien;
    private javax.swing.ButtonGroup buttonGroupGioiTinh;
    private javax.swing.JDialog dialogThongBaoChuaNhapThongTinHocVien;
    private javax.swing.JDialog dialogThongBaoTimKiemHocVien;
    private javax.swing.JButton jButton1;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanelGiaoVien;
    private javax.swing.JPanel jPanelHocSinh;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPanelHocVien;
    private javax.swing.JTable jTable1;
    private javax.swing.JTree jTree1;
    private javax.swing.JLabel labelThongBaoNhapKhongThanhCong;
    private javax.swing.JLabel labelThongBaoTimKiem;
    private javax.swing.JPanel panelThongBaoTimKiemHocVien;
    private javax.swing.JRadioButton radioButtonNam;
    private javax.swing.JRadioButton radioButtonNu;
    private javax.swing.JTable tableGiaoVien;
    private javax.swing.JTable tableHocVien;
    private javax.swing.JTextField textHo;
    private javax.swing.JTextField textHoTenMuonTim;
    private javax.swing.JTextField textMaHocVien;
    private javax.swing.JTextField textMaHocVienMuonTim;
    private javax.swing.JTextField textMaLop;
    private javax.swing.JTextField textMaLopDeChinhSuaThongTin;
    private javax.swing.JTextField textNgaySinh;
    private javax.swing.JTextField textNoiSinh;
    private javax.swing.JTextField textTen;
    // End of variables declaration//GEN-END:variables

}
