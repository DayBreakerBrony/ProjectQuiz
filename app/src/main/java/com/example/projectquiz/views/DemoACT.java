package com.example.projectquiz.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.projectquiz.R;

public class DemoACT extends AppCompatActivity implements View.OnClickListener {
    Button b_answer;
    EditText et_answer;
    TextView tv_quest;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo_quiz_activity);
        b_answer = findViewById(R.id.b1QuestAnswer);
        b_answer.setOnClickListener(this);
        et_answer = findViewById(R.id.et1QuestAnswer);
        tv_quest = findViewById(R.id.tvDemoQuizQuest1);





    }

    @Override
    public void onClick(View v) {
        String answer = et_answer.getText().toString();
        if (answer.equals("100100")) {
            Toast.makeText(DemoACT.this, "Ответ верный!", Toast.LENGTH_SHORT).show();
        }
        else {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(DemoACT.this);
            alertDialogBuilder
                    .setMessage("Вы проиграли")
                    .setCancelable(false)
                    .setPositiveButton("Начать заново", (dialog, which) -> {
                        finish();
                        startActivity(new Intent(getApplicationContext(), DemoACT.class));
                    })
                    .setNegativeButton("Выйти в меню", (dialog, which) -> startActivity(new Intent(getApplicationContext(), MenuACT.class)));

            alertDialogBuilder.show();
        }


    }
}



