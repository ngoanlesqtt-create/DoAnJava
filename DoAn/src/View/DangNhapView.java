/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author PC
 */
public class DangNhapView extends javax.swing.JFrame {

    /**
     * Creates new form DangNhap
     */
    public DangNhapView() {
        initComponents();
    }

    public void thoatDangNhap(ActionListener listener) {
        btnThoat.addActionListener(listener);
    }

    public void dangNhap(ActionListener listener) {
        btnDangNhap.addActionListener(listener);
    }

    public boolean kiemTraDangNhap() {
        System.out.println(("Hello"));
        StringBuilder stringBuilder = new StringBuilder();
        if (textTenDangNhap.getText().equals("")) {
            stringBuilder.append("Bạn chưa nhập tên đăng nhập \n");
            textTenDangNhap.setBackground(Color.RED);
            textTenDangNhap.requestFocus();
        } else {
            textTenDangNhap.setBackground(Color.white);
        }
        String password = new String(textMatKhau.getPassword());
        if (password.equals("")) {
            stringBuilder.append("Bạn chưa nhập mật khẩu");
            textMatKhau.setBackground(Color.red);
            textMatKhau.requestFocus();
        } else {
            textMatKhau.setBackground(Color.white);
        }
        String matKhauDuocXacNhan = new String(textXacNhanMatKhau.getPassword());
        if (!password.equals("") && !password.equals(matKhauDuocXacNhan)) {
            stringBuilder.append("Mật khẩu xác nhận của bạn không giống với mật khẩu\n");
            textMatKhau.setBackground(Color.red);
            textXacNhanMatKhau.setBackground(Color.red);
            textXacNhanMatKhau.requestFocus();
        } else {
            textMatKhau.setBackground(Color.white);
            textXacNhanMatKhau.setBackground(Color.white);
        }
        if (stringBuilder.length() > 0) {
            int x = JOptionPane.showConfirmDialog(this, stringBuilder.toString(), "Thông báo", JOptionPane.ERROR_MESSAGE);
            if (x == JOptionPane.YES_OPTION) {
                textTenDangNhap.setText("");
                textMatKhau.setText("");
                textXacNhanMatKhau.setText("");
                textMatKhau.setBackground(Color.white);
                textXacNhanMatKhau.setBackground(Color.white);
                textTenDangNhap.requestFocus();
            }
            return false;
        }
        JOptionPane.showMessageDialog(this, "Bạn đã đăng nhập thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        this.setVisible(false);
        return true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jPanel11 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        textTenDangNhap = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        textMatKhau = new javax.swing.JPasswordField();
        jPanel16 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        textXacNhanMatKhau = new javax.swing.JPasswordField();
        jPanel17 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        btnDangNhap = new javax.swing.JButton();
        btnThoat = new javax.swing.JButton();

        jLabel3.setText("jLabel3");

        jTextField1.setText("jTextField1");

        jTextField2.setText("jTextField2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Đăng nhập");
        setResizable(false);
        setSize(new java.awt.Dimension(0, 0));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Anh/AnhNen.jpg"))); // NOI18N
        getContentPane().add(jLabel2, java.awt.BorderLayout.PAGE_START);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setMaximumSize(new java.awt.Dimension(32767, 40));
        jPanel8.setMinimumSize(new java.awt.Dimension(148, 40));
        jPanel8.setPreferredSize(new java.awt.Dimension(162, 100));
        jPanel8.setLayout(new javax.swing.BoxLayout(jPanel8, javax.swing.BoxLayout.Y_AXIS));

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setMaximumSize(new java.awt.Dimension(32767, 10));
        jPanel8.add(jPanel12);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setMaximumSize(new java.awt.Dimension(32767, 22));
        jPanel2.setMinimumSize(new java.awt.Dimension(148, 22));
        jPanel2.setLayout(new java.awt.GridLayout(1, 2));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new javax.swing.BoxLayout(jPanel5, javax.swing.BoxLayout.LINE_AXIS));

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));
        jPanel15.setMaximumSize(new java.awt.Dimension(65, 32767));
        jPanel15.setPreferredSize(new java.awt.Dimension(10, 10));

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 65, Short.MAX_VALUE)
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 22, Short.MAX_VALUE)
        );

        jPanel5.add(jPanel15);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("Tên đăng nhập");
        jPanel5.add(jLabel1);

        jPanel2.add(jPanel5);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new javax.swing.BoxLayout(jPanel6, javax.swing.BoxLayout.LINE_AXIS));
        jPanel6.add(textTenDangNhap);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.add(jPanel7);

        jPanel2.add(jPanel6);

        jPanel8.add(jPanel2);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setMaximumSize(new java.awt.Dimension(32767, 22));
        jPanel3.setMinimumSize(new java.awt.Dimension(148, 22));
        jPanel3.setLayout(new java.awt.GridLayout(1, 2));

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setLayout(new javax.swing.BoxLayout(jPanel9, javax.swing.BoxLayout.LINE_AXIS));

        jPanel18.setBackground(new java.awt.Color(255, 255, 255));
        jPanel18.setMaximumSize(new java.awt.Dimension(65, 32767));

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 65, Short.MAX_VALUE)
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 22, Short.MAX_VALUE)
        );

        jPanel9.add(jPanel18);

        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText("Mật khẩu");
        jPanel9.add(jLabel4);

        jPanel3.add(jPanel9);

        jPanel10.setLayout(new javax.swing.BoxLayout(jPanel10, javax.swing.BoxLayout.LINE_AXIS));
        jPanel10.add(textMatKhau);

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.add(jPanel16);

        jPanel3.add(jPanel10);

        jPanel8.add(jPanel3);

        jPanel4.setMaximumSize(new java.awt.Dimension(32767, 22));
        jPanel4.setMinimumSize(new java.awt.Dimension(148, 22));
        jPanel4.setLayout(new java.awt.GridLayout(1, 2));

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setLayout(new javax.swing.BoxLayout(jPanel13, javax.swing.BoxLayout.LINE_AXIS));

        jPanel19.setBackground(new java.awt.Color(255, 255, 255));
        jPanel19.setMaximumSize(new java.awt.Dimension(65, 32767));

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 65, Short.MAX_VALUE)
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 22, Short.MAX_VALUE)
        );

        jPanel13.add(jPanel19);

        jLabel5.setForeground(new java.awt.Color(255, 0, 0));
        jLabel5.setText("Xác nhận mật khẩu");
        jPanel13.add(jLabel5);

        jPanel4.add(jPanel13);

        jPanel14.setLayout(new javax.swing.BoxLayout(jPanel14, javax.swing.BoxLayout.LINE_AXIS));
        jPanel14.add(textXacNhanMatKhau);

        jPanel17.setBackground(new java.awt.Color(255, 255, 255));
        jPanel14.add(jPanel17);

        jPanel4.add(jPanel14);

        jPanel8.add(jPanel4);

        getContentPane().add(jPanel8, java.awt.BorderLayout.CENTER);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel21.setBackground(new java.awt.Color(255, 255, 255));

        btnDangNhap.setBackground(new java.awt.Color(0, 255, 51));
        btnDangNhap.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDangNhap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Anh/Accept.png"))); // NOI18N
        btnDangNhap.setText("Đăng nhập");
        jPanel21.add(btnDangNhap);

        btnThoat.setBackground(new java.awt.Color(0, 255, 51));
        btnThoat.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnThoat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Anh/Exit.png"))); // NOI18N
        btnThoat.setText("Thoát");
        jPanel21.add(btnThoat);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDangNhap;
    private javax.swing.JButton btnThoat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
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
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JPasswordField textMatKhau;
    private javax.swing.JTextField textTenDangNhap;
    private javax.swing.JPasswordField textXacNhanMatKhau;
    // End of variables declaration//GEN-END:variables
}
