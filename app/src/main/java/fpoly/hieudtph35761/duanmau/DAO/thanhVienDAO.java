package fpoly.hieudtph35761.duanmau.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import fpoly.hieudtph35761.duanmau.Database.DbHelper;
import fpoly.hieudtph35761.duanmau.Model.thanhVien;

public class thanhVienDAO {

    DbHelper dbHelper;

    ArrayList<thanhVien> list;

    SQLiteDatabase database;

    public thanhVienDAO(Context context) {
        dbHelper = new DbHelper(context);
    }

    public ArrayList<thanhVien> getALl(){
        ArrayList<thanhVien> list = new ArrayList<>();
        database = dbHelper.getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM THANHVIEN", null);
        if (cursor.getCount()>0){
            cursor.moveToFirst();
            do {
                list.add(new thanhVien(cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2)));
            }while (cursor.moveToNext());
        }
        return list;
    }

    public boolean delete(int id){
        database = dbHelper.getWritableDatabase();
        int row = database.delete("THANHVIEN", "matv =?", new String[]{String.valueOf(id)});
        return row != -1;
    }
    public boolean add(thanhVien tv){
        database = dbHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("HOTEN",tv.getHoTen());
        cv.put("NAMSINH",tv.getNamSinh());
        long Tv = database.insert("THANHVIEN", null,cv);
        if (Tv==-1){
            return false;
        }else{
            return true;
        }
    }

}
