package com.example.projectquiz.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.projectquiz.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;

import java.util.Objects;

import contoller.AuthC;

public class RegistrationACT extends AppCompatActivity {

     EditText Name, PassW, Email;
     Button bRegister;
     AuthC authC;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity);

        Name = findViewById(R.id.etNickname);
        PassW = findViewById(R.id.etPassword);
        Email = findViewById(R.id.etEmail);
        authC = new AuthC();
        bRegister = findViewById(R.id.bRegister);

        if (authC.isRegistered()) {

            startActivity(new Intent(RegistrationACT.this,
                     MenuACT.class));
        }
        bRegister.setOnClickListener(v -> {
            //String nick = Name.getText().toString();
            String pass = PassW.getText().toString();
            String email = Email.getText().toString();


            authC.registerUser(email, pass, task -> {
                if(task.isSuccessful()) {
                    startActivity(new Intent(RegistrationACT.this,
                            MenuACT.class));
                    Toast.makeText(RegistrationACT.this,
                            authC.getUser().getEmail(),
                            Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(RegistrationACT.this,
                            Objects.requireNonNull
                                    (task.getException())
                                    .getMessage(), Toast.LENGTH_SHORT).show();
                }
            });

        });
    }

}
