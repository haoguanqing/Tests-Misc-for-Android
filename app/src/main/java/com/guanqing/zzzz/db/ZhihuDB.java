package com.guanqing.zzzz.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Guanqing on 2015/11/10.
 */
public class ZhihuDB {
    Context mContext;
    public final String ZHIHU_DB = "Zhihu_Database";
    public final String COLUMN_TITLE = "TITLE";


    public ZhihuDB(Context context){
        mContext = context;
    }

    public void createDB(){
        SQLiteDatabase db = mContext.openOrCreateDatabase(ZHIHU_DB, Context.MODE_PRIVATE, null);
        db.execSQL("create TABLE IF NOT EXISTS zhihu(_id INTEGER PRIMARY KEY, _title TEXT, _content TEXT);");
        /*ContentValues values = new ContentValues();
        values.put("_title", "First Article Title");
        values.put("_content", "First Article Content");
        db.insert("zhihu", "", values);

        ContentValues values2 = new ContentValues();
        values.put("_title", "Second Article Title");
        values.put("_content", "Second Article Content");
        db.insert("zhihu", "", values2);*/

        db.execSQL("INSERT INTO zhihu VALUES(12321,'title','content');");

        db.close();
        db=null;
    }
}
