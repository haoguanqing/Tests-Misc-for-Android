package com.guanqing.zzzz.service;

import android.app.Service;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by Guanqing on 2016/4/17.
 */
public class MyBindService extends Service {

    @Override
    public void onCreate() {
        System.out.println("bindService - onCreate();");
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        System.out.println("bindService - onStartCommand();");
        return super.onStartCommand(intent, flags, startId);
    }

    public class MyBinder extends Binder{
        public MyBindService getService(){
            return MyBindService.this;
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        System.out.println("bindService - onBind();");
        return new MyBinder();
    }

    @Override
    public void unbindService(ServiceConnection conn) {
        System.out.println("bindService - unbindService();");
        super.unbindService(conn);
    }

    @Override
    public void onDestroy() {
        System.out.println("bindService - onDestroy();");
        super.onDestroy();
    }

    public void play(){
        System.out.println("bindService - play();");
    }
    public void stop(){
        System.out.println("bindService - stop();");
    }
    public void prev(){
        System.out.println("bindService - prev();");
    }
    public void next(){
        System.out.println("bindService - next();");
    }
}
