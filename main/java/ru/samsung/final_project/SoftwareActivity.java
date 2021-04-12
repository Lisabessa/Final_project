package ru.samsung.final_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SoftwareActivity extends AppCompatActivity {

    Button learnsoftware, testsoftware;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_software);

        learnsoftware = findViewById(R.id.learnsoftware);
        testsoftware = findViewById(R.id.testsoftware);

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

            }
        });

    }
}