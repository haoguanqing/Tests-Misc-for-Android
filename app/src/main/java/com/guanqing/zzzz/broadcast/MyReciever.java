package com.guanqing.zzzz.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

/**
 * Created by Guanqing on 2016/4/16.
 */
public class MyReciever extends BroadcastReceiver{

    @Override
    public void onReceive(Context context, Intent intent) {
        String s = intent.getStringExtra("msg");
        System.out.println("reciever1 msg: " + s);

        Toast.makeText(context, s, Toast.LENGTH_SHORT).show();

        Bundle bundle = new Bundle();
        bundle.putString("test", "ordered bc bundle");
        setResultExtras(bundle);
    }
}
