package com.guanqing.zzzz;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class HandlerActivity extends AppCompatActivity {

    @Bind(R.id.tvThread)
    TextView tvThread;
    @Bind(R.id.btnThread)
    Button btnStart;
    @Bind(R.id.btnThread2)
    Button btnStop;

    Handler handler;
    private Thread thread;

    int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);
        ButterKnife.bind(this);

        handler = new Handler(Looper.getMainLooper());
        count = 0;

        setListeners();
        if (savedInstanceState != null){
            count = savedInstanceState.getInt("COUNT");
            boolean isInterrupted = savedInstanceState.getBoolean("INTERRUPTED");
            Log.d("HGQ", "saved instance not null. Count = " + count + ", interrupted = " + isInterrupted);
            tvThread.setText(Integer.toString(count));
            thread = new Thread(new MyRunnable(count));
            if (!isInterrupted){
                thread.start();
            }
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putInt("COUNT", count);
        outState.putBoolean("INTERRUPTED", thread.isInterrupted());
        thread.interrupt();
        super.onSaveInstanceState(outState);
    }

    private void setListeners(){

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thread = new Thread(new MyRunnable(count));
                thread.start();
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thread.interrupt();
            }
        });
    }

    class MyRunnable implements Runnable{
        private int i;

        public MyRunnable(int i){
            this.i = i;
        }

        @Override
        public void run() {
            android.os.Process.setThreadPriority(Process.THREAD_PRIORITY_BACKGROUND);

            try {
                while (i < 500) {
                    Thread.sleep(1000);
                    Log.d("HGQ", i++ + "");

                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            tvThread.setText(Integer.toString(i));
                            count = i;
                        }
                    });
                }
            }catch (InterruptedException e){
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        tvThread.setText("Interrupted at " +Integer.toString(i));
                    }
                });
            }
        }
    }

}
