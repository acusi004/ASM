package fpoly.hieudtph35761.duanmau.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import fpoly.hieudtph35761.duanmau.Database.DbHelper;
import fpoly.hieudtph35761.duanmau.Model.thuThu;

public class thuThuDAO {
    DbHelper dbHelper;

    SQLiteDatabase database;

    public thuThuDAO(Context context) {
        dbHelper = new DbHelper(context);
    }



    public ArrayList<thuThu> getALl(){
        ArrayList<thuThu> list = new ArrayList<>();
        database = dbHelper.getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM THUTHU", null);
        if (cursor.getCount()>0){
            cursor.moveToFirst();
            do {
                list.add(new thuThu(cursor.getString(0),
                        cursor.getString(1),
                        cursor.getString(2)));
            }while (cursor.moveToNext());
        }
        return list;
    }


    public boolean insertData (String matt, String pass){
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("MATT", matt);
        cv.put("PASSWORD", pass);
        long result = database.insert("THUTHU", null, cv);
        if (result == -1){
            return false;
        }else{
            return true;
        }
    }

    public boolean checkMatt(String matt){
        SQLiteDatabase database = dbHelper.getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM THUTHU WHERE MATT = ?", new String[]{matt});
        if (cursor.getCount()>0){
            return  true;
        }else {
            return false;
        }
    }


    public boolean checkMattPass(String matt, String pass){
        SQLiteDatabase database = dbHelper.getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM THUTHU WHERE MATT = ? AND PASSWORD = ?", new String[]{matt, pass});
        if (cursor.getCount()>0){
            return true;
        }else{
            return false;
        }
    }

    public boolean updatePassword(String username, String oldpassword, String newpassword){
        database = dbHelper.getWritableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM THUTHU WHERE MATT =? AND PASSWORD =?", new String[]{username, oldpassword});
        if (cursor.getCount()>0){
            ContentValues cv = new ContentValues();
            cv.put("PASSWORD", newpassword);
            long check = database.update("THUTHU",cv, "matt =?", new String[]{username});
            if (check == -1){
                return false;
            }else{
                return true;
            }
        }
        return false;

    }

}
