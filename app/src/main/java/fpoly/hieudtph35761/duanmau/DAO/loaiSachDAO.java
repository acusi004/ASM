package fpoly.hieudtph35761.duanmau.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import fpoly.hieudtph35761.duanmau.Database.DbHelper;
import fpoly.hieudtph35761.duanmau.Model.loaiSach;

public class loaiSachDAO {
    SQLiteDatabase database;
    DbHelper dbHelper;

    public loaiSachDAO(Context context) {
        dbHelper = new DbHelper(context);
    }

    public ArrayList<loaiSach> getALl(){
        ArrayList<loaiSach> list = new ArrayList<>();
        database = dbHelper.getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM LOAISACH", null);
        if (cursor.getCount()>0){
            cursor.moveToFirst();
            do {
                list.add(new loaiSach(cursor.getInt(0),
                        cursor.getString(1)));
            }while (cursor.moveToNext());
        }
        return list;
    }

    public int delete(int id){
        database = dbHelper.getWritableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM LOAISACH WHERE MALOAI=?", new String[]{String.valueOf(id)});
        if (cursor.getCount()!=0){
            return -1;
        }
        long row = database.delete("LOAISACH", "maloai =?", new String[]{String.valueOf(id)});
        if (row==-1){
            return 0;
        }else{
            return 1;
        }
    }

    public boolean add(String ls){
        database = dbHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("TENLOAI", ls);
        long lS = database.insert("LOAISACH", null, cv);
        if (lS == -1){
            return false;
        }else{
            return true;
        }
    }



}
