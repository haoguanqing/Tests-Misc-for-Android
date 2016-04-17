package com.guanqing.zzzz.broadcast;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.guanqing.zzzz.R;

public class BroadcastActivity extends AppCompatActivity {

    IntentFilter filter;
    MyReciever2 reciever;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast);

        //reciever registered dynamically has higher priority
        //but only registered after running the codes
        /*IntentFilter filter = new IntentFilter("BC_NORMAL");
        MyReciever2 reciever = new MyReciever2();
        registerReceiver(reciever, filter);*/
    }

    public void sendBroadcast(View v){
        switch (v.getId()){
            case R.id.send1://send a normal broadcast
                Intent intent = new Intent();
                intent.putExtra("msg", "This is a normal broadcast!");
                intent.setAction("BC_NORMAL");
                sendBroadcast(intent);
                break;

            case R.id.send2://send an ordered broadcast
                Intent intent2 = new Intent();
                intent2.putExtra("msg", "This is an ordered broadcast!");
                intent2.setAction("BC_NORMAL");
                sendOrderedBroadcast(intent2, null);
                break;

            default:
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (reciever!=null) unregisterReceiver(reciever);
    }
}
