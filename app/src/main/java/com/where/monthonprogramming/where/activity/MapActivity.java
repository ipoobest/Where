package com.where.monthonprogramming.where.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.where.monthonprogramming.where.R;
import com.where.monthonprogramming.where.fragment.MapFragment;

public class MapActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        if (savedInstanceState == null){
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.contentContainer, new MapFragment())
                    .commit();
        }
    }
}
