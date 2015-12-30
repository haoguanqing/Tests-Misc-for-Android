package com.guanqing.zzzz.retrofit;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by Guanqing on 2015/12/30.
 */
public interface ImgurService {

    @GET("/image/{id}")
    Call<ImgurImage> getData(@Path("id") String imageId);
}
