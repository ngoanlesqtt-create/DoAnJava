/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Main;

import Controller.GiaoVienController;
import Controller.HocVienController;
import Controller.TruongHocController;
import java.sql.SQLException;

/**
 *
 * @author PC
 */
public class Main {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        TruongHocController truongHocController = new TruongHocController();
        GiaoVienController giaoVienController = new GiaoVienController();
        HocVienController hocVienController = new HocVienController();
    }

}
