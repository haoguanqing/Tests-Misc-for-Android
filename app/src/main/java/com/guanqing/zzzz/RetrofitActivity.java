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

import com.guanqing.zzzz.retrofit.ImgurService;

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
        setSupportActionBar(toolbar);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.imgur.com/3")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
        service = retrofit.create(ImgurService.class);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                new AsyncTask<String, Void, String>(){
                    @Override
                    protected String doInBackground(String... params) {
                        String url = null;
                        try{
                            url = getImageLink(params[0]);
                            Snackbar.make(view, url, Snackbar.LENGTH_LONG)
                                    .setAction("Action", null).show();
                            return url;
                        }catch (FileNotFoundException e){
                            url = params[0].replace("imgur.com", "i.imgur.com") + ".mp4";
                            return url;
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                        return null;
                    }

                    @Override
                    protected void onPostExecute(String s) {
                        super.onPostExecute(s);
                        /*Glide.with(getApplicationContext()).load(s).into(ivTest);
                        ivTest.invalidate();*/
                        Uri uri = Uri.parse(s);
                        videoView.setVideoURI(uri);
                        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                            @Override
                            public void onPrepared(MediaPlayer mp) {
                                mp.setLooping(true);
                            }
                        });
                        videoView.setOnErrorListener(new MediaPlayer.OnErrorListener() {
                            @Override
                            public boolean onError(MediaPlayer mp, int what, int extra) {
                                videoView.setVisibility(View.INVISIBLE);
                                return false;
                            }
                        });
                        videoView.start();
                    }
                }.execute("http://imgur.com/ps4X35C");


                /*Call call = service.getData("o4a1Udb");
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
                });*/
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
