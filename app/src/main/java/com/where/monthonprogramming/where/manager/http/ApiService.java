package com.where.monthonprogramming.where.manager.http;

import com.where.monthonprogramming.where.dao.BooksDao;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by ipoobest on 11/10/2016.
 */

public interface ApiService {

    @GET("api/books")
    Call<List<BooksDao>> all();

    @GET("api/books/{name}")
    Call<BooksDao> get(@Path("name") String name);

    @POST("books/new")
    Call<BooksDao> create(@Body BooksDao book);


}
