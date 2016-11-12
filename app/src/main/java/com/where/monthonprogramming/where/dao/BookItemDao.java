package com.where.monthonprogramming.where.dao;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Barenz on 11/12/2016.
 */

public class BookItemDao {
    @SerializedName("id") private String id;
    @SerializedName("bookName") private String bookName;
    @SerializedName("floor") private String floor;
    @SerializedName("viewId") private String viewId;
    @SerializedName("nfcId") private String nfcId;

    public String getNfcId() {
        return nfcId;
    }

    public void setNfcId(String nfcId) {
        this.nfcId = nfcId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getViewId() {
        return viewId;
    }

    public void setViewId(String viewId) {
        this.viewId = viewId;
    }
}
