package com.where.monthonprogramming.where.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.where.monthonprogramming.where.R;
import com.where.monthonprogramming.where.fragment.SplashFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null){
            //First create

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.contentContainer, new SplashFragment())
                    .commit();
        }
    }
}
