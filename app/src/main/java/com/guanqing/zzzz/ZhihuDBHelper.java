package com.guanqing.zzzz;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Guanqing on 2015/11/12.
 */
public class ZhihuDBHelper extends SQLiteOpenHelper {
    private static final String TABLE_NAME = "zhihu_database_table";
    public static final String DATABASE_NAME = "zhihu_database";
    private static final int DATABASE_VERSION = 1;

    public ZhihuDBHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE IF NOT EXISTS TABLE " + TABLE_NAME + "(_id INTEGER PRIMARY KEY AUTOINCREMENT, _title TEXT NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop if exists table "+ TABLE_NAME);
        onCreate(db);
    }

    public List<String> getAllTitles(){
        List<String> titleList = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor = db.query(TABLE_NAME, new String[]{"_title"}, null, null, null, null, null);
        if (cursor!=null){
            cursor.moveToFirst();
            while(!cursor.isAfterLast()){
                titleList.add(cursor.getString(0));
                cursor.moveToNext();
            }
            cursor.close();
        }
        db.close();
        return titleList;
    }
}
