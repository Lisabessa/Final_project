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

public class TestGenVerbsActivity extends AppCompatActivity {

    Button btn1, btn2, btn3, btn4, exitFromTestGenVerbs;
    TextView num, question, wordQuestion;

    private List<Word> words = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_gen_verbs);
        exitFromTestGenVerbs = findViewById(R.id.exitFromTestGenVerbs);
        btn1 = findViewById(R.id.answer1GenVerbs);
        btn2 = findViewById(R.id.answer2GenVerbs);
        btn3 = findViewById(R.id.answer3GenVerbs);
        btn4 = findViewById(R.id.answer4GenVerbs);
        num = findViewById(R.id.numOfQuestionGenVerbs);
        question = findViewById(R.id.questionGenVerbs);
        wordQuestion = findViewById(R.id.wordForQuestionGenVerbs);
        setInitData();
        final Tester tester = new Tester(words, btn1, btn2, btn3, btn4, num, question, wordQuestion);

        boolean resOfQuery = tester.Change();
        if (!resOfQuery){
            Toast.makeText(getApplicationContext(), "Подсчёт результата...", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(TestGenVerbsActivity.this, GenVerbsActivity.class);
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
                    Intent intent = new Intent(TestGenVerbsActivity.this, GenVerbsActivity.class);
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
                    Intent intent = new Intent(TestGenVerbsActivity.this, GenVerbsActivity.class);
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
                    Intent intent = new Intent(TestGenVerbsActivity.this, GenVerbsActivity.class);
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
                    Intent intent = new Intent(TestGenVerbsActivity.this, GenVerbsActivity.class);
                    intent.putExtra("RESULT" ,tester.getPoints());
                    intent.putExtra("AT_ALL", tester.getWordsSize());
                    intent.putExtra("MISTAKES" , (Serializable)tester.getMistakes());
                    startActivity(intent);
                }
            }
        });

        exitFromTestGenVerbs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TestGenVerbsActivity.this, GenVerbsActivity.class);
                startActivity(intent);
            }
        });
    }


    protected void setInitData(){
        WordList wl = new WordList();
        wl.ForTestGenVerbs();
        words = wl.getWordList();
    }

}
