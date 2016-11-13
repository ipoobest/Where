package com.where.monthonprogramming.where.manager;

import android.content.Context;

import com.where.monthonprogramming.where.Util.Contextor;
import com.where.monthonprogramming.where.manager.http.ApiService;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class HttpManager {

    private static HttpManager instance;

    public static HttpManager getInstance() {
        if (instance == null)
            instance = new HttpManager();
        return instance;
    }

    private Context mContext;
    private ApiService service;

    private HttpManager() {
        mContext =  Contextor.getInstance().getContext();


        Retrofit retrofit = new Retrofit.Builder()
                //ใส่ base url ของ service เรา
                .baseUrl("http://192.168.43.92:3000/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(ApiService.class);

    }

    public ApiService getService() {
        return service;
    }


}
