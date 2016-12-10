package com.where.monthonprogramming.where.dao;

/**
 * Created by Barenz on 11/13/2016.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NfcsDao {

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("nfcId")
    @Expose
    private String nfcId;
    @SerializedName("floor")
    @Expose
    private String floor;
    @SerializedName("viewId")
    @Expose
    private String viewId;
    @SerializedName("__v")
    @Expose
    private Integer v;

    /**
     *
     * @return
     * The id
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @param id
     * The _id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     *
     * @return
     * The nfcId
     */
    public String getNfcId() {
        return nfcId;
    }

    /**
     *
     * @param nfcId
     * The nfcId
     */
    public void setNfcId(String nfcId) {
        this.nfcId = nfcId;
    }

    /**
     *
     * @return
     * The floor
     */
    public String getFloor() {
        return floor;
    }

    /**
     *
     * @param floor
     * The floor
     */
    public void setFloor(String floor) {
        this.floor = floor;
    }

    /**
     *
     * @return
     * The viewId
     */
    public String getViewId() {
        return viewId;
    }

    /**
     *
     * @param viewId
     * The viewId
     */
    public void setViewId(String viewId) {
        this.viewId = viewId;
    }

    /**
     *
     * @return
     * The v
     */
    public Integer getV() {
        return v;
    }

    /**
     *
     * @param v
     * The __v
     */
    public void setV(Integer v) {
        this.v = v;
    }
}