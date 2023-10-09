package fpoly.hieudtph35761.duanmau.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import fpoly.hieudtph35761.duanmau.Database.DbHelper;
import fpoly.hieudtph35761.duanmau.Model.sach;

public class sachDAO {
    DbHelper dbHelper;
    SQLiteDatabase database;

    public sachDAO(Context context) {
        dbHelper = new DbHelper(context);
    }

    public ArrayList<sach>getall(){
        ArrayList<sach> list = new ArrayList<>();
        database = dbHelper.getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM SACH", null);
        if (cursor.getCount()>0){
            cursor.moveToFirst();
            do {
                list.add(new sach(cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getInt(2),
                        cursor.getInt(3)));
            }while (cursor.moveToNext());
        }
        return list;
    }


    public boolean delete(int id){
        database = dbHelper.getWritableDatabase();
        int row = database.delete("SACH", "masach =?", new String[]{String.valueOf(id)});
        return row != -1;
    }

    public boolean add(sach sc){
        database = dbHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("TENSACH",sc.getTenSach());
        cv.put("GIATHUE",sc.getGiaThue());
        cv.put("MALOAI",sc.getMaLoai());
        long result = database.insert("SACH", null, cv);
        if (result == -1) {
            return false;
        }else {
            return true;
        }
    }

    public ArrayList<sach> getSachNhieuNhat(){
        ArrayList<sach> list = new ArrayList<>();
        database = dbHelper.getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT pm.masach, sc.tensach, COUNT (pm.masach) FROM PHIEUMUON pm, SACH sc WHERE pm.masach = sc.masach GROUP BY pm.masach, sc.tensach ORDER BY COUNT (pm.masach) DESC LIMIT 10", null);
        if (cursor.getCount()>0){
            cursor.moveToFirst();
            do {
                list.add(new sach(cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getInt(2)));
            }while (cursor.moveToNext());
        }
        return list;
    }
}
