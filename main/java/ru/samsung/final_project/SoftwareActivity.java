package ru.samsung.final_project;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class SoftwareActivity extends AppCompatActivity {

    Button learnsoftware, testsoftware;
    ListView mistakes;
    TextView tvmistakes, total;
    TextView results;
    double Percentage = 0;
    int Result = 0;
    int General_count = 0;
    ArrayList<Word> listOfMistakes = new ArrayList<>();

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_software);


        learnsoftware = findViewById(R.id.learnsoftware);
        testsoftware = findViewById(R.id.testsoftware);
        results = findViewById(R.id.ResSoftware);
        total = findViewById(R.id.TotalSoftware);
        tvmistakes = findViewById(R.id.TextViewMistakesSoftware);


        Bundle extras = getIntent().getExtras();
        if(extras != null){
            try {
                listOfMistakes = (ArrayList<Word>)extras.getSerializable("MISTAKES");
                Result = extras.getInt("RESULT");
                General_count = extras.getInt("AT_ALL");
            }
            catch (Exception e){}
        }
        mistakes = findViewById(R.id.listOfMistakesSoftware);
        WordAdapter mistakesAdapter = new WordAdapter(this, R.layout.list_item, listOfMistakes);
        mistakes.setAdapter(mistakesAdapter);

        if(General_count != 0){
            results.setText("Ваши результаты:\n"+ Result + " из "+General_count+ " ");
            Percentage = Double.parseDouble(String.valueOf(Result)) / Double.parseDouble(String.valueOf(General_count)) * 100;
            results.append("(" + Math.round(Percentage)+"%)");
            if(Math.round(Percentage) == 100){
                total.setBackgroundColor(R.color.Col1); //  ЦВЕТ НЕ УСТАНАВЛИВАЕТСЯ
                total.setText("Отлично! Тема полностью усвоена!");
            }
            else {
                if(Math.round(Percentage) >= 95){
                    total.setText("Хорошая работа! Так держать!");
                    total.setBackgroundColor(R.color.Col2);
                }
                else{
                    total.setText("Попробуйте ещё раз!");
                    total.setBackgroundColor(R.color.Col3);
                }
                tvmistakes.setText("Слова, которые Вам нужно повторить:");
            }

        }

        learnsoftware.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SoftwareActivity.this, LearnSoftwareActivity.class);
                startActivity(intent);
            }
        });

        testsoftware.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SoftwareActivity.this, TestSoftwareActivity.class);
                startActivity(intent);
            }
        });

    }
}