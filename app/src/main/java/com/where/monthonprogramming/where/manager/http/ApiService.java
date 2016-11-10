package com.where.monthonprogramming.where.manager.http;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.http.POST;

/**
 * Created by ipoobest on 11/10/2016.
 */

public interface ApiService {
    @POST("book")
    Call<Objects> loadBooklist();
}
