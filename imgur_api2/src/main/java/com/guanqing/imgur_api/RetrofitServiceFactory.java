package com.guanqing.imgur_api;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Guanqing on 2016/2/9.
 */
public class RetrofitServiceFactory {
    /**
     *
     * @param clazz
     * @param endPoint
     * @param <T>
     * @return
     */
    public static <T> T createRetrofitService(final Class<T> clazz, final String endPoint){

        final Retrofit.Builder builder = new Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(endPoint);

        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                Request newRequest = request.newBuilder()
                        .addHeader("Authorization", "Client-ID " + ImgurService.CLIENT_ID)
                        .build();
                return chain.proceed(newRequest);
            }
        }).build();

        builder.client(client);

        T service = builder.build().create(clazz);
        return service;
    }
}
