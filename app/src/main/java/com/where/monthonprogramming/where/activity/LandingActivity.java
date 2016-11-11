package com.where.monthonprogramming.where.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;

import com.where.monthonprogramming.where.R;
import com.where.monthonprogramming.where.fragment.LandingFragment;
import com.where.monthonprogramming.where.fragment.NfctabFragment;
import com.where.monthonprogramming.where.fragment.SearchFragment;


public class LandingActivity extends AppCompatActivity
        implements LandingFragment.Fragmentlistener{

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);

        if (savedInstanceState == null){
            //First create

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.contentContainer, new LandingFragment())
                    .commit();
        }

        initInstances();
    }

    private void initInstances() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



    }


    @Override
    public void onButtonClickNFC(ImageButton btnNfc) {
        //TODO Handle
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.contentContainer, new NfctabFragment())
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void onButtonClickSearch(ImageButton btnSearch) {
        Intent intent = new Intent(LandingActivity.this, SearchActivity.class);
        startActivity(intent);

    }

    @Override
    public void onButtonClickMap(ImageButton btnMap) {
        Intent intent = new Intent(LandingActivity.this, MapActivity.class);
        startActivity(intent);
    }

//    @Override
//    public void onButtonClickMap(ImageButton btnNap) {
//        getSupportFragmentManager().beginTransaction()
//                .add(R.id.contentContainer, new NfctabFragment())
//                .addToBackStack(null)
//                .commit();

    }
