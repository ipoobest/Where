package com.where.monthonprogramming.where.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.where.monthonprogramming.where.R;
import com.where.monthonprogramming.where.fragment.ResultFragment;

public class ResultActivity extends AppCompatActivity {

    String var;
    String bookFloor;
    String isbn;
    String bookName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        if (savedInstanceState == null){
            //First create


            //get value from searchFragment.
            Intent intent = getIntent();
            var = intent.getStringExtra("var");
            bookFloor = intent.getStringExtra("bookFloor");
            isbn = intent.getStringExtra("isbn");
            bookName = intent.getStringExtra("bookName");


            getSupportFragmentManager().beginTransaction() //sent id view ,floor ,book name and isbn to fragment
                    .add(R.id.contentContainer, ResultFragment.newInstance(var,bookFloor,bookName,isbn))
                    .commit();
        }

    }
}
