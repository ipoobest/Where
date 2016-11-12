package com.where.monthonprogramming.where.activity;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;

import com.where.monthonprogramming.where.R;
import com.where.monthonprogramming.where.fragment.MapFragment;

public class MapActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        initInstances();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.contentContainer, new MapFragment())
                    .commit();
        }
    }

    private void initInstances() {
        drawerLayout = (DrawerLayout) findViewById(R.id.activity_map);
        actionBarDrawerToggle = new ActionBarDrawerToggle(
                MapActivity.this,
                drawerLayout, R.string.open_drawer, R.string.close_drawer
        );

}}
