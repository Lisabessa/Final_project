package ru.samsung.final_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ListActivity  extends AppCompatActivity {

    LinearLayout activity;
    Button software, hardware, genverbs, internet, backToMENU;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_of_moduls);
        software = findViewById(R.id.software);
        hardware = findViewById(R.id.hardware);
        internet = findViewById(R.id.internet);
        genverbs = findViewById(R.id.genverbs);
        activity = findViewById(R.id.linlaylist);
        backToMENU = findViewById(R.id.exitFromListOfModuls);

        activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), R.string.hint_modul, Toast.LENGTH_SHORT).show();
            }
        });

        software.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListActivity.this, SoftwareActivity.class);
                startActivity(intent);
            }
        });

        hardware.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListActivity.this, HardwareActivity.class);
                startActivity(intent);
            }
        });

        genverbs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListActivity.this, GenVerbsActivity.class);
                startActivity(intent);
            }
        });

        internet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListActivity.this, InternetActivity.class);
                startActivity(intent);
            }
        });

        backToMENU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
