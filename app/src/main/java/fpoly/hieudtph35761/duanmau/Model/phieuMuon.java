package fpoly.hieudtph35761.duanmau.Model;

public class phieuMuon {
    private int mapm;
    private int matv;
    private String matt;
    private int maSach;
    private String ngay;
    private int traSach;
    private int tienThue;
    private String tenTv;
    private String tenTT;
    private String tenSach;

    public phieuMuon() {
    }

    public phieuMuon(int mapm, int matv,String tenTv, String matt, String tenTT, int maSach, String tenSach, String ngay, int traSach, int tienThue) {
        this.mapm = mapm;
        this.matv = matv;
        this.matt = matt;
        this.maSach = maSach;
        this.ngay = ngay;
        this.traSach = traSach;
        this.tienThue = tienThue;
        this.tenTv = tenTv;
        this.tenTT = tenTT;
        this.tenSach = tenSach;
    }


    public phieuMuon( int matv, String matt, int maSach, String ngay, int traSach, int tienThue) {
        this.matv = matv;
        this.matt = matt;
        this.maSach = maSach;
        this.ngay = ngay;
        this.traSach = traSach;
        this.tienThue = tienThue;
    }

    public int getMapm() {
        return mapm;
    }

    public void setMapm(int mapm) {
        this.mapm = mapm;
    }

    public int getMatv() {
        return matv;
    }

    public void setMatv(int matv) {
        this.matv = matv;
    }

    public String getMatt() {
        return matt;
    }

    public void setMatt(String matt) {
        this.matt = matt;
    }

    public int getMaSach() {
        return maSach;
    }

    public void setMaSach(int maSach) {
        this.maSach = maSach;
    }

    public String getNgay() {
        return ngay;
    }

    public void setNgay(String ngay) {
        this.ngay = ngay;
    }

    public int getTraSach() {
        return traSach;
    }

    public void setTraSach(int traSach) {
        this.traSach = traSach;
    }

    public int getTienThue() {
        return tienThue;
    }

    public void setTienThue(int tienThue) {
        this.tienThue = tienThue;
    }

    public String getTenTv() {
        return tenTv;
    }

    public void setTenTv(String tenTv) {
        this.tenTv = tenTv;
    }

    public String getTenTT() {
        return tenTT;
    }

    public void setTenTT(String tenTT) {
        this.tenTT = tenTT;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }
}
