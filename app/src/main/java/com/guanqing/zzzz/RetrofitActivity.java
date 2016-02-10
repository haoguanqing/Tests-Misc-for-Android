package com.guanqing.zzzz;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import com.bumptech.glide.Glide;
import com.guanqing.zzzz.retrofit.Imgur.ImgurService;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.net.URL;

import retrofit.JacksonConverterFactory;
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
        final VideoView videoView = (VideoView)findViewById(R.id.vvTest);
        final VideoView videoView2 = (VideoView)findViewById(R.id.vvTest2);
        setSupportActionBar(toolbar);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.imgur.com")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
        service = retrofit.create(ImgurService.class);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                new AsyncTask<String, Void, String>() {
                    @Override
                    protected String doInBackground(String... params) {
                        String url = null;
                        try {
                            url = getImageLink(params[0]);
                            Snackbar.make(view, url, Snackbar.LENGTH_LONG)
                                    .setAction("Action", null).show();
                            return url;
                        } catch (FileNotFoundException e) {
                            url = params[0].replace("imgur.com", "i.imgur.com") + ".mp4";
                            return url;
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        return null;
                    }

                    @Override
                    protected void onPostExecute(String s) {
                        super.onPostExecute(s);
                        Glide.with(getApplicationContext()).load(s).into(ivTest);
                        ivTest.invalidate();
                        Uri uri = Uri.parse("http://i.imgur.com/fYNRbM3.mp4");
                        videoView.setVideoURI(uri);
                        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                            @Override
                            public void onPrepared(MediaPlayer mp) {
                                videoView.setVisibility(View.VISIBLE);
                                mp.setLooping(true);
                                videoView.start();
                            }
                        });
                        videoView.setOnErrorListener(new MediaPlayer.OnErrorListener() {
                            @Override
                            public boolean onError(MediaPlayer mp, int what, int extra) {
                                videoView.setVisibility(View.INVISIBLE);
                                return false;
                            }
                        });
                    }
                }.execute("http://imgur.com/xj6azwG");

            }
        });

        Uri uri2 = Uri.parse("http://i.imgur.com/fYNRbM3.mp4");
        videoView2.setVideoURI(uri2);
        videoView2.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
                videoView2.start();
            }
        });


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


    public static String getImageLink(String s) throws Exception{
        String url = convertImgurUrl(s);
        String json = readUrl(url);
        Log.e("HGQQQ", "json string = "+json);
        JSONObject data = new JSONObject(json).getJSONObject("data");
        if(data.getString("type").equals("image/gif")){
            return data.getString("mp4");
        }
        return data.getString("link");
    }

    private static String convertImgurUrl(String url){
        return url.replace("http://imgur.com/", "https://api.imgur.com/3/image/");
    }

    //read json string from url
    private static String readUrl(String urlString) throws Exception {
        BufferedReader reader = null;
        try {
            URL url = new URL(urlString);
            reader = new BufferedReader(new InputStreamReader(url.openStream()));
            StringBuffer buffer = new StringBuffer();
            int read;
            char[] chars = new char[1024];
            while ((read = reader.read(chars)) != -1)
                buffer.append(chars, 0, read);

            return buffer.toString();
        } finally {
            if (reader != null)
                reader.close();
        }
    }
}
