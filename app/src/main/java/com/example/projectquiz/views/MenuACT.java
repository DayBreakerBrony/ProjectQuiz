package com.example.projectquiz.views;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.projectquiz.R;

public class MenuACT extends AppCompatActivity implements View.OnClickListener{
    Button begin1, exit, begin2 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_activity);
        begin2 = findViewById(R.id.bEnterQuiz2);
        begin2.setOnClickListener(this);
        begin1 = findViewById(R.id.bStartQuiz);
        begin1.setOnClickListener(this);
        exit = findViewById(R.id.bMenuExit);
        exit.setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.bStartQuiz:{

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                startActivity(new Intent(MenuACT.this,
                    QuizACT.class));}
                break;
            case R.id.bMenuExit: finish();
                break;
            case R.id.bEnterQuiz2:{
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                startActivity(new Intent(MenuACT.this,
                    DemoACT.class));}
        }
    }
}
