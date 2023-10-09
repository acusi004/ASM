package fpoly.hieudtph35761.duanmau.Database;

import android.content.Context;
import android.content.IntentFilter;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    public DbHelper( Context context) {
        super(context, "thuvien", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String thuThu = "CREATE TABLE THUTHU(MATT TEXT PRIMARY KEY ,HOTEN TEXT, PASSWORD TEXT)";
        db.execSQL(thuThu);

        String thanhVien = "CREATE TABLE THANHVIEN(MATV INTEGER PRIMARY KEY AUTOINCREMENT, HOTEN TEXT, NAMSINH TEXT)";
        db.execSQL(thanhVien);

        String loaiSach = "CREATE TABLE LOAISACH(MALOAI INTEGER PRIMARY KEY AUTOINCREMENT, TENLOAI TEXT)";
        db.execSQL(loaiSach);

        String sach = "CREATE TABLE SACH(MASACH INTEGER PRIMARY KEY AUTOINCREMENT,TENSACH TEXT, GIATHUE INTEGER, MALOAI INTEGER REFERENCES LOAISACH(MALOAI))";
        db.execSQL(sach);

        String phieuMuon = "CREATE TABLE PHIEUMUON(MAPM INTEGER PRIMARY KEY AUTOINCREMENT, MATV TEXT REFERENCES THANHVIEN(MATV), MATT TEXT REFERENCES THUTHU(MATT), MASACH INTEGER REFERENCES SACH(MASACH), NGAY TEXT, TRASACH INTEGER, TIENTHUE)";
        db.execSQL(phieuMuon);


        db.execSQL("INSERT INTO LOAISACH VALUES (1, 'Thiếu nhi'),(2,'Tình cảm'),(3, 'Giáo khoa')");
        db.execSQL("INSERT INTO SACH VALUES (1, 'Hãy đợi đấy', 2500, 1), (2, 'Thằng cuội', 1000, 1), (3, 'Lập trình Android', 2000, 3)");
        db.execSQL("INSERT INTO THUTHU VALUES ('thuthu01','Nguyễn Văn Anh','abc123'),('thuthu02','Trần Văn Hùng','123abc')");
        db.execSQL("INSERT INTO THANHVIEN VALUES (1,'Cao Thu Trang','2000'),(2,'Trần Mỹ Kim','2000')");
        //trả sách: 1: đã trả - 0: chưa trả
        db.execSQL("INSERT INTO PHIEUMUON VALUES (1,1,'thuthu01', 1, '19/03/2022', 1, 2500),(2,1,'thuthu01', 3, '19/03/2022', 0, 2000),(3,2,'thuthu02', 1, '19/03/2022', 1, 2000)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        if (i != i1){
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS THUTHU");
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS THANHVIEN");
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS LOAISACH");
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS SACH");
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS PHIEUMUON");
            onCreate(sqLiteDatabase);
        }
    }
}
