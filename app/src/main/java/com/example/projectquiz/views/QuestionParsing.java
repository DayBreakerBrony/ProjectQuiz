package com.example.projectquiz.views;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class QuestionParsing {


    public static String[] quest = {
            //Создаём поле для вопросов
            "Что из данного является языком программирования?",
            "Что такое i?",
            "Для чего используется цикл с параметром?"
    };



    public String[][] anws = {
            //Создаём двумерное поле из вариантов ответа: На каждый вопрос 4 варианта
            {"HTML", "CSS", "Vala", "PHP"},
            {"Информационный вес символа", "Общее количество информации",
                    "Служебный символ", "Ничего из этого"},
            {"Для выполнения цикла N раз",
                    "Для выполнения цикла, до тех пор пока выполняется условие",
                    "Для выполнения цикла, до тех пор пока НЕ выполняется условие",
                    "Для выполнения цикла 1 раз"}
    };

    public String correct[] = {
            /*Создаём поле для правильных вариантов ответа:
            Правильный вариант из четырёх,
            что представлены выше
             */
            "PHP",
            "Информационный вес символа",
            "Для выполнения цикла N раз"
    };
    //Создадим функции вызова нужных вопросов и ответов, а также правильного ответа из полей
    public String getQuest(int a){
        return quest[a];
    }

    public String getAnws(int a){
        return anws[a][0];
    }

    public String getAnws2(int a){
        return anws[a][1];
    }

    public String getAnws3(int a){
        return anws[a][2];
    }

    public String getAnws4(int a){
        return anws[a][3];
    }

    public String getCorrect(int a){
        return correct[a];
    }
}
