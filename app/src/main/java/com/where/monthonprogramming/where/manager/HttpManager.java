package com.where.monthonprogramming.where.manager;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.where.monthonprogramming.where.Util.Contextor;
import com.where.monthonprogramming.where.dao.BooksDao;
import com.where.monthonprogramming.where.manager.http.ApiService;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
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
    private final ApiService service;

    private HttpManager() {
        mContext =  Contextor.getInstance().getContext();

        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssz")
                .create();



        Retrofit retrofit = new Retrofit.Builder()
                //ใส่ base url ของ service เรา
                .baseUrl("https://radiant-brook-60185.herokuapp.com")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();




        service = retrofit.create(ApiService.class);

    }

    public ApiService getService() {
        return service;
    }


}
