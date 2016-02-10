package com.guanqing.zzzz.retrofit.Imgur;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Headers;
import retrofit.http.Path;

/**
 * Created by Guanqing on 2015/12/30.
 */
public interface ImgurService {

    @Headers("Authorization: Client-ID " + ServiceClient.IMGUR_CLIENT_ID)
    @GET("/3/image/{id}")
    Call<ImgurImage> getData(@Path("id") String imageId);
}
