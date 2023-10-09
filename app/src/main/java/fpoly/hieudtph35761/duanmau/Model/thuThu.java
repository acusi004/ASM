package fpoly.hieudtph35761.duanmau.Model;

public class thuThu {
    private String matt;
    private String hoTen;
    private String passWord;

    public thuThu() {
    }

    public thuThu(String matt, String hoTen, String passWord) {
        this.matt = matt;
        this.hoTen = hoTen;
        this.passWord = passWord;
    }

    public String getMatt() {
        return matt;
    }

    public void setMatt(String matt) {
        this.matt = matt;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
