/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import View.DangNhapView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class DangNhapController {

    private String userName;
    private String password;
    private DangNhapView view;
    private TruongHoc1Controller truongHocController1;

    public DangNhapController() {
        this.userName = "";
        this.password = "";
        this.view = new DangNhapView();
        this.view.setLocationRelativeTo(null);
        this.view.setVisible(true);
        this.view.thoatDangNhap(new FormDangNhapDuocThoat());
        this.view.dangNhap(new FormDangNhap());
    }

    private class FormDangNhapDuocThoat implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }

    }

    private class FormDangNhap implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            view.kiemTraDangNhap();

            try {
                truongHocController1 = new TruongHoc1Controller();
            } catch (SQLException ex) {
            }
        }

    }
}
