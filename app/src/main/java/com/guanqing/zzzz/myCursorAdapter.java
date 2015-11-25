package com.guanqing.zzzz;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Guanqing on 2015/11/12.
 */
public class myCursorAdapter extends android.widget.CursorAdapter {
    Context mContext;

    public myCursorAdapter(Context context, Cursor c, int flags){
        super(context, c, 0);
        mContext = context;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        //findViewById
        //cursor.getString(cursor.getColumnIndexOrThrow("name"));
        //setText
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        //return LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        return null;
    }
}
