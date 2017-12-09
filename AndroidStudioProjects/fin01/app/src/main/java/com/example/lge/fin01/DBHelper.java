package com.example.lge.fin01;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by lge on 2017-12-09.
 */

public class DBHelper extends SQLiteOpenHelper {
    DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE Diary (_id INTEGER PRIMARY KEY AUTOINCREMENT, menu TEXT, price INTEGER, create_at TEXT);");
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    void add(String create_at, String menu, int price) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("ADD INTO Diary VALUES(null, '" + menu + "', " + price + ", '" + create_at + "');");
        db.close();
    }


    void delete(String menu) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM Diary WHERE menu='" + menu + "';");
        db.close();
    }

    String getResult() {
        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM Diary", null);
        while (cursor.moveToNext()) {
            String result = cursor.getString(0)
                    + " : "
                    + cursor.getString(1)
                    + " | "
                    + " won "
                    + cursor.getString(3)
                    + "\n";
        }
        return getResult();

    }
}


