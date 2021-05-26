package ru.samsung.final_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    long userId = 0; // ID текущего пользователя
    Button start, userChoice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start = findViewById(R.id.buttonstart);
        userChoice = findViewById(R.id.button_user_choice);

        Bundle extras = getIntent().getExtras();
        if (extras != null){
            userId = extras.getLong("id");
            start.setEnabled(true);
            userChoice.setEnabled(false);
        }
        else{
            start.setEnabled(false);
            userChoice.setEnabled(true);
        }

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListActivity.class);
                startActivity(intent);

            }
        });

        userChoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RegisterUser.class);
                startActivity(intent);
            }
        });

    }
}