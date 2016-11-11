package com.where.monthonprogramming.where.manager.http;

import android.app.Fragment;

import com.where.monthonprogramming.where.dao.BookItemDao;
import com.where.monthonprogramming.where.fragment.SearchFragment;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.http.POST;

/**
 * Created by ipoobest on 11/10/2016.
 */

public interface ApiService {
    @POST("list")
    Call<BookItemDao> loadPhotolist();

}
