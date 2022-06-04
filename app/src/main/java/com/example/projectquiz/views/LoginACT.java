package com.example.projectquiz.views;

import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.projectquiz.R;

public class LoginACT extends AppCompatActivity {

    protected EditText Name, PassW;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);


    }

}
