package ru.samsung.final_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static ru.samsung.final_project.R.string.QuestionNumber;
import static ru.samsung.final_project.R.string.start;

public class TestSoftwareActivity extends AppCompatActivity {


    long userId = 0; // ID текущего пользователя
    Button btn1, btn2, btn3, btn4, exitFromTestSoftware;
    TextView num, question, wordQuestion;

    private List<Word> words = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_software);

        Bundle extras = getIntent().getExtras();
        if(extras.get("id") != null){
            userId = extras.getLong("id");
        }

        exitFromTestSoftware = findViewById(R.id.exitFromTestSoftware);
        btn1 = findViewById(R.id.answer1Software);
        btn2 = findViewById(R.id.answer2Software);
        btn3 = findViewById(R.id.answer3Software);
        btn4 = findViewById(R.id.answer4Software);
        num = findViewById(R.id.numOfQuestionSoftware);
        question = findViewById(R.id.questionSoftware);
        wordQuestion = findViewById(R.id.wordForQuestionSoftware);
        setInitData();
        final Tester tester = new Tester(words, btn1, btn2, btn3, btn4, num, question, wordQuestion);

        boolean resOfQuery = tester.Change();
        if (!resOfQuery){
            Toast.makeText(getApplicationContext(), "Подсчёт результата...", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(TestSoftwareActivity.this, SoftwareActivity.class);
            intent.putExtra("RESULT" ,tester.getPoints());
            intent.putExtra("AT_ALL", tester.getWordsSize());
            intent.putExtra("MISTAKES" , (Serializable)tester.getMistakes());
            intent.putExtra("id", userId); // id выбранного пользователя
            startActivity(intent);
        }

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tester.CheckAnswer(1);
                boolean resOfQuery = tester.Change();
                if (!resOfQuery){
                    Toast.makeText(getApplicationContext(), "Подсчёт результата...", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(TestSoftwareActivity.this, SoftwareActivity.class);
                    intent.putExtra("RESULT" ,tester.getPoints());
                    intent.putExtra("AT_ALL", tester.getWordsSize());
                    intent.putExtra("MISTAKES" , (Serializable)tester.getMistakes());
                    intent.putExtra("id", userId); // id выбранного пользователя
                    startActivity(intent);
                }
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tester.CheckAnswer(2);
                boolean resOfQuery = tester.Change();
                if (!resOfQuery){
                    Toast.makeText(getApplicationContext(), "Подсчёт результата...", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(TestSoftwareActivity.this, SoftwareActivity.class);
                    intent.putExtra("RESULT" ,tester.getPoints());
                    intent.putExtra("AT_ALL", tester.getWordsSize());
                    intent.putExtra("MISTAKES" , (Serializable)tester.getMistakes());
                    intent.putExtra("id", userId); // id выбранного пользователя
                    startActivity(intent);
                }
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tester.CheckAnswer(3);
                boolean resOfQuery = tester.Change();
                if (!resOfQuery){
                    Toast.makeText(getApplicationContext(), "Подсчёт результата...", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(TestSoftwareActivity.this, SoftwareActivity.class);
                    intent.putExtra("RESULT" ,tester.getPoints());
                    intent.putExtra("AT_ALL", tester.getWordsSize());
                    intent.putExtra("MISTAKES" , (Serializable)tester.getMistakes());
                    intent.putExtra("id", userId); // id выбранного пользователя
                    startActivity(intent);
                }
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tester.CheckAnswer(4);
                boolean resOfQuery = tester.Change();
                if (!resOfQuery){
                    Toast.makeText(getApplicationContext(), "Подсчёт результата...", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(TestSoftwareActivity.this, SoftwareActivity.class);
                    intent.putExtra("RESULT" ,tester.getPoints());
                    intent.putExtra("AT_ALL", tester.getWordsSize());
                    intent.putExtra("MISTAKES" , (Serializable)tester.getMistakes());
                    intent.putExtra("id", userId); // id выбранного пользователя
                    startActivity(intent);
                }
            }
        });

        exitFromTestSoftware.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TestSoftwareActivity.this, SoftwareActivity.class);
                intent.putExtra("id", userId); // id выбранного пользователя
                startActivity(intent);
            }
        });
    }


    protected void setInitData(){
        WordList wl = new WordList();
        wl.ForTestSoftware();
        words = wl.getWordList();
    }
}