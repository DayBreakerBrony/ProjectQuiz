package com.example.projectquiz.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.projectquiz.R;

public class ResultACT extends AppCompatActivity implements View.OnClickListener {
    Button retry, exit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_screen);
        retry = findViewById(R.id.bRetry);
        retry.setOnClickListener(this);
        exit = findViewById(R.id.bFExit);
        exit.setOnClickListener(this);


    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bRetry:{

                startActivity(new Intent(ResultACT.this,
                    QuizACT.class));}

            break;
            case R.id.bFExit: System.exit(0);
            break;
        }
        }
    }
