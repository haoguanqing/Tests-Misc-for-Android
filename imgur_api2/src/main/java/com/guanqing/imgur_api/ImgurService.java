package com.guanqing.imgur_api;

import com.example.Account;
import com.example.Image;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by Guanqing on 2016/2/9.
 */
public interface ImgurService {
    String IMGUR_ENDPOINT = "https://api.imgur.com/3/";
    String CLIENT_ID = "e7a200f58cc6e9c";

    //@Headers("Authorization: Client-ID " + CLIENT_ID)
    @GET("account/{username}")
    Observable<Account> getAccount(@Path("username") String username);

    //@Headers("Authorization: Client-ID " + CLIENT_ID)
    @GET("image/{imageId}")
    Observable<Image> getImage(@Path("imageId") String id);
}


