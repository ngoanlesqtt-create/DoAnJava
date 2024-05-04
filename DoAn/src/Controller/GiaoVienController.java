/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Data.DataGiaoVien;
import ModelGiaoVien.GiaoVienModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

/**
 *
 * @author PC
 */
public class GiaoVienController extends TruongHocController {
//

    GiaoVienModel model;
    DataGiaoVien dataGiaoVien;

    public GiaoVienController() throws SQLException {
        this.dataGiaoVien = new DataGiaoVien();
        this.model = new GiaoVienModel(this.dataGiaoVien.getDataGiaoVien());
        view.loadGiaoVienBangClickButton(new DataGiaoVienDuocLoad());
    }

    private class DataGiaoVienDuocLoad implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Hello");
        }

    }
}
