package fpoly.hieudtph35761.duanmau.Model;

public class thanhVien {
    private int matv;
    private String hoTen;
    private String namSinh;

    public thanhVien(int matv, String hoTen, String namSinh) {
        this.matv = matv;
        this.hoTen = hoTen;
        this.namSinh = namSinh;
    }

    public thanhVien() {
    }

    public int getMatv() {
        return matv;
    }

    public void setMatv(int matv) {
        this.matv = matv;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(String namSinh) {
        this.namSinh = namSinh;
    }
}
