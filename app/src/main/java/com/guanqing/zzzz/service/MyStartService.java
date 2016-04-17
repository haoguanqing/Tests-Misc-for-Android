package com.guanqing.zzzz.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by Guanqing on 2016/4/17.
 */
public class MyStartService extends Service{

    @Override
    public void onCreate() {
        System.out.println("service - onCreate();");
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        System.out.println("service - onStartCommand();");

        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        System.out.println("service - onBind();");
        return null;
    }

    @Override
    public void onDestroy() {
        System.out.println("service - onDestroy();");
        super.onDestroy();
    }
}
