package com.where.monthonprogramming.where.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.where.monthonprogramming.where.dao.BooksDao;

/**
 * Created by Barenz on 11/14/2016.
 */

public class BookAdapter extends BaseAdapter {
    @Override
    public int getCount() {
        return 1000;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
