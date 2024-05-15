/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InputThongTin;

import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class InputThongTin {

    public static boolean kiemTraInputRong(ArrayList<Object> cacInput) {
        for (Object input : cacInput) {
            if (input.equals("")) {
                return false;
            }
        }

        return true;
    }

    public static boolean kiemTraHoTen(ArrayList<Object> cacInput) {
        String hoTen = (String) cacInput.get(1);
        for (int i = 0; i <= hoTen.length() - 1; i++) {
            if (hoTen.charAt(i) >= '0' && hoTen.charAt(i) <= '9') {
                return false;
            }
        }
        return true;
    }

    public static boolean kiemTraLuongCoBan(ArrayList<Object> cacInput) {
        String luongCoBan = (String) cacInput.get(7);
        for (int i = 0; i <= luongCoBan.length() - 1; i++) {
            if (luongCoBan.charAt(i) <= 'z' && luongCoBan.charAt(i) >= 'a') {
                return false;
            }
        }
        return true;
    }

    public static boolean kiemTraLuongHeSo(ArrayList<Object> cacInput) {
        String heSo = (String) cacInput.get(8);
        for (int i = 0; i <= heSo.length() - 1; i++) {
            if (heSo.charAt(i) <= 'z' && heSo.charAt(i) >= 'a') {
                return false;
            }
        }
        return true;
    }

    public static boolean kiemTraNgayThangNam(ArrayList<Object> cacInput) {
        String namSinh = (String) cacInput.get(6);
        for (int i = 0; i <= namSinh.length() - 1; i++) {
            if (!(namSinh.charAt(i) >= '0' && namSinh.charAt(i) <= '9')) {
                return false;
            }
        }
        int namSinhDuocEpKieu = Integer.parseInt(namSinh);
        int ngaySinh = Integer.parseInt((String) cacInput.get(4));
        int thangSinh = Integer.parseInt((String) cacInput.get(5));
        if (namSinhDuocEpKieu >= 0) {
            if (ngaySinh == 31 && (thangSinh == 2 || thangSinh == 4 || thangSinh == 6 || thangSinh == 9 || thangSinh == 11)) {
                return false;
            }
            if (thangSinh == 2) {
                if (ngaySinh == 30) {
                    return false;
                }
                if (namSinhDuocEpKieu % 4 != 0 && ngaySinh == 29) {
                    return false;
                }
            }
            return true;
        }

        return namSinhDuocEpKieu >= 0;

    }

    public static boolean kiemTraToanBoThongTinInput(ArrayList<Object> thongTinInputGiaoVien) {
        return !(!InputThongTin.kiemTraNgayThangNam(thongTinInputGiaoVien)
                || !InputThongTin.kiemTraHoTen(thongTinInputGiaoVien)
                || !InputThongTin.kiemTraLuongCoBan(thongTinInputGiaoVien)
                || !InputThongTin.kiemTraLuongHeSo(thongTinInputGiaoVien));
    }

}
