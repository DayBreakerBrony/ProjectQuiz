package com.example.projectquiz.views;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.projectquiz.R;

import java.util.Random;



public class QuizACT extends AppCompatActivity implements View.OnClickListener  {


    Button button1, button2, button3, button4;
    TextView mqs;
    private QuestionParsing question = new QuestionParsing();
    private String answer;
    private int questionLength = QuestionParsing.quest.length;
    Random random; //Пока что порядок вопросов будет случайным


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_activity);
        random = new Random();


        button1 = findViewById(R.id.button1);
        button1.setOnClickListener(this);
        button2 = findViewById(R.id.button2);
        button2.setOnClickListener(this);
        button3 = findViewById(R.id.button3);
        button3.setOnClickListener(this);
        button4 = findViewById(R.id.button4);
        button4.setOnClickListener(this);

        mqs = findViewById(R.id.tv_question);

        NextQuestion(random.nextInt(questionLength)); //Задаём вопросы в случайном порядке
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            //При нажатии на первую кнопку вызываем текст из неё и сверяем с ответом
            case R.id.button1:
                if(button1.getText() == answer){
                    //Если проверка проходит выдаём тост, что ответ правильный и идём дальше
                    Toast.makeText(QuizACT.this, "Правильный ответ", Toast.LENGTH_SHORT).show();
                    NextQuestion(random.nextInt(questionLength));
                }else{
                    //Иначе вызываем геймовер
                    GameOver();
                }

                break;

            case R.id.button2:
                if(button2.getText() == answer){
                    //То же самое и с остальными кнопками
                    Toast.makeText(QuizACT.this, "Правильный ответ", Toast.LENGTH_SHORT).show();
                    NextQuestion(random.nextInt(questionLength));
                }else{
                    GameOver();
                }

                break;

            case R.id.button3:
                if(button3.getText() == answer){
                    Toast.makeText(QuizACT.this, "Правильный ответ", Toast.LENGTH_SHORT).show();
                    NextQuestion(random.nextInt(questionLength));
                }else{
                    GameOver();
                }

                break;

            case R.id.button4:
                if(button4.getText() == answer){
                    Toast.makeText(QuizACT.this, "Правильный ответ", Toast.LENGTH_SHORT).show();
                    NextQuestion(random.nextInt(questionLength));
                }else{
                    GameOver();
                }

                break;
        }
    }
    /* А теперь опишем функцию Game Over,
     которая завершит игру в случае неправильного ответа
       */
    private void GameOver(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(QuizACT.this);
        alertDialogBuilder
                .setMessage("Вы проиграли")
                .setCancelable(false)
                .setPositiveButton("Начать заново", (dialog, which) -> {
                    finish();
                    startActivity(new Intent(getApplicationContext(), QuizACT.class));
                })
                .setNegativeButton("Выйти в меню", (dialog, which) -> startActivity(new Intent(getApplicationContext(), MenuACT.class)));

        alertDialogBuilder.show();

    }
    /*Описываем функцию выбора следующего вопроса, которая у нас... случайная. Пока что.
    Эта функция, если что, вызывает на экран и вопрос, и ответы, и сразу же присваивает
     новый ответ полю answer для проверки*/
    private void NextQuestion(int num){
        mqs.setText(question.getQuest(num));
        button1.setText(question.getAnws(num));
        button2.setText(question.getAnws2(num));
        button3.setText(question.getAnws3(num));
        button4.setText(question.getAnws4(num));

        answer = question.getCorrect(num);
    }
}