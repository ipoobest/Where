package com.where.monthonprogramming.where.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.where.monthonprogramming.where.R;
import com.where.monthonprogramming.where.fragment.LandingFragment;


public class LandingActivity extends AppCompatActivity {

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
}
