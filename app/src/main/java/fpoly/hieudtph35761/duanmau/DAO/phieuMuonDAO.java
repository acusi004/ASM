package fpoly.hieudtph35761.duanmau.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import fpoly.hieudtph35761.duanmau.Database.DbHelper;
import fpoly.hieudtph35761.duanmau.Model.phieuMuon;

public class phieuMuonDAO {
    DbHelper dbHelper;
    SQLiteDatabase database;


    public phieuMuonDAO(Context context) {
        dbHelper = new DbHelper(context);
    }

    public ArrayList<phieuMuon> getAllPhieuMuon(){
        ArrayList<phieuMuon> list = new ArrayList<>();
        database = dbHelper.getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT pm.mapm, pm.matv, tv.hoten, pm.matt, tt.hoten, pm.masach, sc.tensach, pm.ngay, pm.trasach, pm.tienthue FROM PHIEUMUON pm, THANHVIEN tv, THUTHU tt, SACH sc WHERE pm.matv = tv.matv and pm.matt = tt.matt AND pm.masach = sc.masach",null);
        if (cursor.getCount()>0){
            cursor.moveToFirst();
            do {
                list.add(new phieuMuon(cursor.getInt(0),
                        cursor.getInt(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4),
                        cursor.getInt(5),
                        cursor.getString(6),
                        cursor.getString(7),
                        cursor.getInt(8),
                        cursor.getInt(9)));
            }while (cursor.moveToNext());
        }
        return list;
    }

    public boolean updateTrangThai(int mapm){
        database = dbHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("TRASACH", 1);
        long check = database.update("PHIEUMUON",cv, "mapm = ?", new String[]{String.valueOf(mapm)});
        if (check == -1){
            return false;
        }else{
            return true;
        }
    }

    public boolean themPM(phieuMuon pm){
        database = dbHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("MATV",pm.getMatv() );
        cv.put("MATT", pm.getMatt());
        cv.put("MASACH", pm.getMaSach());
        cv.put("NGAY", pm.getNgay());
        cv.put("TRASACH", pm.getTraSach());
        cv.put("TIENTHUE", pm.getTienThue());
        long result = database.insert("PHIEUMUON", null, cv);
        if(result == -1){
            return false;
        }else {
            return true;
        }
    }
    public boolean delete(int id){
        database = dbHelper.getWritableDatabase();
        int row = database.delete("PHIEUMUON", "mapm =?", new String[]{String.valueOf(id)});
        return row != -1;
    }
}
