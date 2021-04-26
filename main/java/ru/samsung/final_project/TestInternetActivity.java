package ru.samsung.final_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TestInternetActivity extends AppCompatActivity {

    Button btn1, btn2, btn3, btn4, exitFromTestInternet;
    TextView num, question, wordQuestion;

    private List<Word> words = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_internet);
        exitFromTestInternet = findViewById(R.id.exitFromTestInternet);
        btn1 = findViewById(R.id.answer1Internet);
        btn2 = findViewById(R.id.answer2Internet);
        btn3 = findViewById(R.id.answer3Internet);
        btn4 = findViewById(R.id.answer4Internet);
        num = findViewById(R.id.numOfQuestionInternet);
        question = findViewById(R.id.questionInternet);
        wordQuestion = findViewById(R.id.wordForQuestionInternet);
        setInitData();
        final Tester tester = new Tester(words, btn1, btn2, btn3, btn4, num, question, wordQuestion);

        boolean resOfQuery = tester.Change();
        if (!resOfQuery){
            Toast.makeText(getApplicationContext(), "Подсчёт результата...", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(TestInternetActivity.this, InternetActivity.class);
            intent.putExtra("RESULT" ,tester.getPoints());
            intent.putExtra("AT_ALL", tester.getWordsSize());
            intent.putExtra("MISTAKES" , (Serializable)tester.getMistakes());
            startActivity(intent);
        }

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tester.CheckAnswer(1);
                boolean resOfQuery = tester.Change();
                if (!resOfQuery){
                    Toast.makeText(getApplicationContext(), "Подсчёт результата...", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(TestInternetActivity.this, InternetActivity.class);
                    intent.putExtra("RESULT" ,tester.getPoints());
                    intent.putExtra("AT_ALL", tester.getWordsSize());
                    intent.putExtra("MISTAKES" , (Serializable)tester.getMistakes());
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
                    Intent intent = new Intent(TestInternetActivity.this, InternetActivity.class);
                    intent.putExtra("RESULT" ,tester.getPoints());
                    intent.putExtra("AT_ALL", tester.getWordsSize());
                    intent.putExtra("MISTAKES" , (Serializable)tester.getMistakes());
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
                    Intent intent = new Intent(TestInternetActivity.this, InternetActivity.class);
                    intent.putExtra("RESULT" ,tester.getPoints());
                    intent.putExtra("AT_ALL", tester.getWordsSize());
                    intent.putExtra("MISTAKES" , (Serializable)tester.getMistakes());
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
                    Intent intent = new Intent(TestInternetActivity.this, InternetActivity.class);
                    intent.putExtra("RESULT" ,tester.getPoints());
                    intent.putExtra("AT_ALL", tester.getWordsSize());
                    intent.putExtra("MISTAKES" , (Serializable)tester.getMistakes());
                    startActivity(intent);
                }
            }
        });

        exitFromTestInternet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TestInternetActivity.this, InternetActivity.class);
                startActivity(intent);
            }
        });
    }


    protected void setInitData(){
        WordList wl = new WordList();
        wl.ForTestInternet();
        words = wl.getWordList();
    }
}
