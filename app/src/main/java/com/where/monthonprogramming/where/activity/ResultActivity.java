package com.where.monthonprogramming.where.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.where.monthonprogramming.where.R;
import com.where.monthonprogramming.where.fragment.ResultFragment;

public class ResultActivity extends AppCompatActivity {

    String var;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        if (savedInstanceState == null){
            //First create

            Intent intent = getIntent();
            var = intent.getStringExtra("var");

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.contentContainer, ResultFragment.newInstance(var))
                    .commit();
        }

    }
}
