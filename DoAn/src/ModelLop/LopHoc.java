/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModelLop;

/**
 *
 * @author PC
 */
public class LopHoc {

    private final String maLop;
    private final String tenLop;
    private String truongLop;
    private final int siSo;
    private final String maGiaoVienChuNhiem;

    public LopHoc(String maLop, String tenLop, String truongLop, int siSo, String maGiaoVienChuNhiem) {
        this.maLop = maLop;
        this.tenLop = tenLop;
        this.truongLop = truongLop;
        this.siSo = siSo;
        this.maGiaoVienChuNhiem = maGiaoVienChuNhiem;
    }

    public String getMaLop() {
        return maLop;
    }

    public String getTenLop() {
        return tenLop;
    }

    public String getTruongLop() {
        return truongLop;
    }

    public int getSiSo() {
        return siSo;
    }

    public String getMaGiaoVienChuNhiem() {
        return maGiaoVienChuNhiem;
    }

    public Object[] getDataLopHoc() {
        Object[] data = {this.maLop, this.tenLop, this.truongLop, this.siSo, this.maGiaoVienChuNhiem};
        return data;
    }

    void setMaLopTruong(String maLopTruongDuocThayThe) {
        this.truongLop = maLopTruongDuocThayThe;
    }
}
