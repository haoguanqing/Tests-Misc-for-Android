package com.guanqing.zzzz.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by Guanqing on 2016/4/16.
 */
public class MyReciever2 extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String s = intent.getStringExtra("msg");
        System.out.println("reciever2 msg: " + s);
        System.out.println("reciever2 bundle: " + getResultExtras(true).getString("test"));
    }
}
