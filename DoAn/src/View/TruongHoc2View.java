/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import ModelGiaoVien.GiaoVien;
import ModelHocVien.HocVien;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PC
 */
public final class TruongHoc2View extends javax.swing.JFrame {

    private ArrayList<String> maLopTruong;
    private JComboBox jComboBox;

    /**
     * Creates new form TruongHoc2View
     *
     * @param danhSachHocVien
     * @param danhSachGiaoVien
     * @param danhSachMaGiaoVien
     * @param maGiaoVienDangLaChuNhiemKhoa
     */
    public TruongHoc2View(ArrayList<HocVien> danhSachHocVien, ArrayList<GiaoVien> danhSachGiaoVien, ArrayList<String> danhSachMaGiaoVien, ArrayList<String> maGiaoVienDangLaChuNhiemKhoa) {
        initComponents();
        this.jComboBox = new JComboBox();
        showMaLopTruong(danhSachHocVien);
        showMaGiaoVienChuNhiem(danhSachGiaoVien);
        setComboBoxChoBangKhoa(danhSachMaGiaoVien, maGiaoVienDangLaChuNhiemKhoa);
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
        for (int i = 1; i <= 31; i++) {
            comboboxNgayThanhLapKhoa.addItem(String.valueOf(i));
        }
        for (int i = 2024; 2000 <= i; i--) {
            comboboxNamThanhLapKhoa.addItem(String.valueOf(i));
        }
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

        tableKhoa.getColumnModel().getColumn(4).setCellEditor(new DefaultCellEditor(jComboBox));

    }

    public void renderNamThanhLapKhoa(MouseAdapter listener) {
        comboboxNamThanhLapKhoa.addMouseListener(listener);
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
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableKhoa = new javax.swing.JTable();
        btnLoadKhoa = new javax.swing.JButton();
        btnThemKhoa = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        comboboxNgayThanhLapKhoa = new javax.swing.JComboBox<>();
        comboboxThangThanhLapKhoa = new javax.swing.JComboBox<>();
        comboboxNamThanhLapKhoa = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        comboboxTruongKhoa = new javax.swing.JComboBox<>();

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
                        .addGap(28, 28, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 617, Short.MAX_VALUE)
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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jTextField2)
                                    .addComponent(btnLoadKhoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(btnThemKhoa)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 448, Short.MAX_VALUE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(30, 30, 30)
                                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(comboboxNgayThanhLapKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(comboboxThangThanhLapKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(comboboxNamThanhLapKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(jLabel5)
                                .addGap(103, 103, 103)
                                .addComponent(jLabel6)
                                .addGap(135, 135, 135)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(comboboxTruongKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8))
                                .addGap(57, 57, 57)))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboboxNgayThanhLapKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboboxThangThanhLapKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboboxNamThanhLapKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboboxTruongKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 132, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLoadKhoa)
                    .addComponent(btnThemKhoa))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Khoa", jPanel2);

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
    private javax.swing.JButton btnCapNhapLopTruong;
    private javax.swing.JButton btnCapNhapSiSoLopHoc;
    private javax.swing.JButton btnLoadKhoa;
    private javax.swing.JButton btnLoadLopHoc;
    private javax.swing.JButton btnSuaLopHoc;
    private javax.swing.JButton btnThemGiaoVien;
    private javax.swing.JButton btnThemKhoa;
    private javax.swing.JButton btnXoaLopHoc;
    private javax.swing.JComboBox<String> comboboxLopTruongLopHoc;
    private javax.swing.JComboBox<String> comboboxNamThanhLapKhoa;
    private javax.swing.JComboBox<String> comboboxNgayThanhLapKhoa;
    private javax.swing.JComboBox<String> comboboxThangThanhLapKhoa;
    private javax.swing.JComboBox<String> comboboxTruongKhoa;
    private javax.swing.JComboBox<String> comboboxmaGiaoVienChuNhiem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTable tableKhoa;
    private javax.swing.JTable tableLopHoc;
    private javax.swing.JTextField textMaLopHoc;
    private javax.swing.JTextField textTenLopHoc;
    // End of variables declaration//GEN-END:variables

    public void anTruongHoc2View() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
