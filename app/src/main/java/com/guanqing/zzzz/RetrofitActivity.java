package com.guanqing.zzzz;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.guanqing.zzzz.retrofit.ImgurImage;
import com.guanqing.zzzz.retrofit.ImgurService;
import com.squareup.okhttp.ResponseBody;

import java.io.IOException;

import retrofit.Call;
import retrofit.Callback;
import retrofit.JacksonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class RetrofitActivity extends AppCompatActivity {
    ImgurService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        final ImageView ivTest = (ImageView)findViewById(R.id.ivTest);
        final TextView tvTest = (TextView)findViewById(R.id.tvTest);
        setSupportActionBar(toolbar);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.imgur.com/3")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
        service = retrofit.create(ImgurService.class);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                Call call = service.getData("FX3rk8d");
                call.enqueue(new Callback<ImgurImage>() {
                    @Override
                    public void onResponse(Response<ImgurImage> response, Retrofit retrofit) {
                        ImgurImage image = response.body();

                        if (image == null) {
                            //404 or the response cannot be converted to User.
                            ResponseBody responseBody = response.errorBody();
                            if (responseBody != null) {
                                try {
                                    tvTest.setText("responseBody = " + responseBody.string());
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            } else {
                                tvTest.setText("responseBody = null");
                            }
                        } else {
                            //200
                            Glide.with(getApplicationContext()).load(image.getData().getLink()).into(ivTest);
                            tvTest.setText("url : " + image.getData().getLink());
                        }
                    }

                    @Override
                    public void onFailure(Throwable t) {
                        tvTest.setText("t = " + t.getMessage());
                    }
                });
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
