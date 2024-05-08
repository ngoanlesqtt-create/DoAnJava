/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import View.TruongHoc2View;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author PC
 */
public class TruongHoc2Controller {

    private final TruongHoc2View view;

    public TruongHoc2Controller() {
        this.view = new TruongHoc2View();
        view.demoNut(new NutDuocDemo());
    }

    private class NutDuocDemo implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Hello");
        }

    }

}
