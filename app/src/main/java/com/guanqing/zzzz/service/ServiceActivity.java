package com.guanqing.zzzz.service;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.guanqing.zzzz.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ServiceActivity extends AppCompatActivity {

    @Bind(R.id.btnStartS) Button btnStartS;
    @Bind(R.id.btnStopS) Button btnStopS;
    @Bind(R.id.btnBindS) Button btnBindS;
    @Bind(R.id.btnUnbindS) Button btnUnbindS;
    @Bind(R.id.btnPlay) Button btnPlay;
    @Bind(R.id.btnPrev) Button btnPrev;
    @Bind(R.id.btnNext) Button btnNext;
    @Bind(R.id.btnStop) Button btnStop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
        ButterKnife.bind(this);
    }

    Intent intent1;
    Intent intent2;
    MyBindService service;
    ServiceConnection conn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder binder) {
            service = ((MyBindService.MyBinder)binder).getService();
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };
    public void onClick(View v){
        switch (v.getId()){
            case R.id.btnStartS:
                intent1 = new Intent(ServiceActivity.this, MyStartService.class);
                startService(intent1);
                break;
            case R.id.btnStopS:
                stopService(intent1);
                break;
            case R.id.btnBindS:
                intent2 = new Intent(ServiceActivity.this, MyBindService.class);
                bindService(intent2, conn, Service.BIND_AUTO_CREATE);
                break;
            case R.id.btnUnbindS:
                unbindService(conn);
                break;
            case R.id.btnPlay:
                service.play();
                break;
            case R.id.btnStop:
                service.stop();
                break;
            case R.id.btnNext:
                service.next();
                break;
            case R.id.btnPrev:
                service.prev();
                break;
            default:
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        stopService(intent1);
        unbindService(conn);
    }
}
