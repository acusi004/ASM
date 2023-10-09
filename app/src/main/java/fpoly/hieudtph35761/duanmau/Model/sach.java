package fpoly.hieudtph35761.duanmau.Model;

public class sach {
    private int sach;
    private String tenSach;
    private int giaThue;
    private int maLoai;
    private  int sachNhieuNhat;

    public sach() {
    }

    public sach(int sach, String tenSach, int sachNhieuNhat) {
        this.sach = sach;
        this.tenSach = tenSach;
        this.sachNhieuNhat = sachNhieuNhat;
    }

    public sach(int sach, String tenSach, int giaThue, int maLoai) {
        this.sach = sach;
        this.tenSach = tenSach;
        this.giaThue = giaThue;
        this.maLoai = maLoai;
    }

    public int getSach() {
        return sach;
    }

    public void setSach(int sach) {
        this.sach = sach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public int getGiaThue() {
        return giaThue;
    }

    public void setGiaThue(int giaThue) {
        this.giaThue = giaThue;
    }

    public int getMaLoai() {
        return maLoai;
    }

    public void setMaLoai(int maLoai) {
        this.maLoai = maLoai;
    }

    public int getSachNhieuNhat() {
        return sachNhieuNhat;
    }

    public void setSachNhieuNhat(int sachNhieuNhat) {
        this.sachNhieuNhat = sachNhieuNhat;
    }
}
