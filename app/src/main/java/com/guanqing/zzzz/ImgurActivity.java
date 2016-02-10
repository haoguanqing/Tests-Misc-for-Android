package com.guanqing.zzzz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.Account;
import com.example.AccountData;
import com.example.Image;
import com.guanqing.imgur_api.ImgurService;
import com.guanqing.imgur_api.RetrofitServiceFactory;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class ImgurActivity extends AppCompatActivity {

    private Button button1;
    private ImageView imageView;
    private TextView textView;
    private Button button2;

    private int count = 0;
    private static final String[] imageList = {"8NPKVbC", "QyM9J46", "RuP8AF5", "k3HHW7B", "8ZUchRz", "8Y2EUq9"};
    private static final String[] userList = {"VFCB", "besttth9", "MrEase", "Venamelon", "top1126", "TysoniusMaximusThePatronSaintofOffBrandBreakfastCereals"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imgur);
        button1 = (Button) findViewById(R.id.button);
        imageView = (ImageView) findViewById(R.id.imageView);
        textView = (TextView) findViewById(R.id.textView);
        button2 = (Button) findViewById(R.id.button2);

        final ImgurService service = RetrofitServiceFactory.createRetrofitService(ImgurService.class, ImgurService.IMGUR_ENDPOINT);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                service.getAccount(userList[count])
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Subscriber<Account>() {
                            @Override
                            public void onCompleted() {
                                Toast.makeText(getApplicationContext(), "load complete", Toast.LENGTH_LONG).show();
                            }

                            @Override
                            public void onError(Throwable e) {
                                Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
                            }

                            @Override
                            public void onNext(Account account) {
                                StringBuilder builder = new StringBuilder();
                                AccountData data = account.getData();
                                builder.append("id: " + data.getId() + "\n");
                                builder.append("url: " + data.getUrl() + "\n");
                                builder.append("created: " + data.getCreated() + "\n");
                                builder.append("pro expiration: " + data.getProExpiration() + "\n");

                                textView.setText(builder.toString());
                            }
                        });
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                service.getImage(imageList[count])
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Subscriber<Image>() {
                            @Override
                            public void onCompleted() {

                            }

                            @Override
                            public void onError(Throwable e) {
                                Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
                            }

                            @Override
                            public void onNext(Image image) {
                                Glide.with(getApplicationContext())
                                        .load(image.getData().getLink())
                                        .thumbnail(0.1f)
                                        .crossFade()
                                        .into(imageView);
                            }
                        });
                count = (count + 1) % 6;
            }
        });
    }
}
