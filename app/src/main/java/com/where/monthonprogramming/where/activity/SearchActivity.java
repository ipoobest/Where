package com.where.monthonprogramming.where.activity;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.where.monthonprogramming.where.R;
import com.where.monthonprogramming.where.fragment.SearchFragment;

public class SearchActivity extends AppCompatActivity {



    String result;
    String nfcFloor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        //get viewId from LandingActivity
        Intent intent = getIntent();
        result = intent.getStringExtra("result");
        nfcFloor = intent.getStringExtra("nfcFloor");

        if (savedInstanceState == null) {
            //First create

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.contentContainer, SearchFragment.newInstance(result,nfcFloor)) //sent viewId and floorId to SearchFragment
                    .commit();

            initInstances();
        }



    }

    private void initInstances() {

    }




}

