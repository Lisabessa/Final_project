package ru.samsung.final_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class InternetActivity extends AppCompatActivity {

    Button learninternet, testinternet, backToListOfModuls;
    ListView mistakes;
    TextView tvmistakes, total;
    TextView results;
    double Percentage = 0;
    int Result = 0;
    int General_count = 0;
    ArrayList<Word> listOfMistakes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internet);

        learninternet = findViewById(R.id.learninternet);
        testinternet = findViewById(R.id.testinternet);
        results = findViewById(R.id.ResInternet);
        total = findViewById(R.id.TotalInternet);
        tvmistakes = findViewById(R.id.TextViewMistakesInternet);
        backToListOfModuls = findViewById(R.id.exitFromInternet);


        Bundle extras = getIntent().getExtras();
        if(extras != null){
            try {
                listOfMistakes = (ArrayList<Word>)extras.getSerializable("MISTAKES");
                Result = extras.getInt("RESULT");
                General_count = extras.getInt("AT_ALL");
            }
            catch (Exception e){}
        }
        mistakes = findViewById(R.id.listOfMistakesInternet);
        WordAdapter mistakesAdapter = new WordAdapter(this, R.layout.list_item, listOfMistakes);
        mistakes.setAdapter(mistakesAdapter);

        if(General_count != 0){
            results.setText("Ваши результаты:\n"+ Result + " из "+General_count+ " ");
            Percentage = Double.parseDouble(String.valueOf(Result)) / Double.parseDouble(String.valueOf(General_count)) * 100;
            results.append("(" + Math.round(Percentage)+"%)");
            if(Math.round(Percentage) == 100){
                total.setBackgroundResource(R.color.Col1);
                total.setText("Отлично! Тема полностью усвоена!");
            }
            else {
                if(Math.round(Percentage) >= 95){
                    total.setText("Хорошая работа! Так держать!");
                    total.setBackgroundResource(R.color.Col2);
                }
                else{
                    total.setText("Попробуйте ещё раз!");
                    total.setBackgroundResource(R.color.Col4);
                }
                tvmistakes.setText("Слова, которые Вам нужно повторить:");
            }

        }

        learninternet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InternetActivity.this, LearnInternetActivity.class);
                startActivity(intent);
            }
        });

        testinternet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InternetActivity.this, TestInternetActivity.class);
                startActivity(intent);
            }
        });

        backToListOfModuls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InternetActivity.this, ListActivity.class);
                startActivity(intent);
            }
        });
    }
}