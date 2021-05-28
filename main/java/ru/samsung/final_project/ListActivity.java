package ru.samsung.final_project;

import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.FilterQueryProvider;
import android.widget.LinearLayout;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ListActivity  extends AppCompatActivity {

    DatabaseHelper databaseHelper;
    SQLiteDatabase db;
    Cursor userCursor;

    long userId = 0;
    LinearLayout activity;
    Button software, hardware, genverbs, internet, backToMENU;
    TextView userInfo, userName;

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

        databaseHelper = new DatabaseHelper(this);
        db = databaseHelper.open();

        userInfo = findViewById(R.id.info_about_app);
        userName = findViewById(R.id.Username);
        Bundle extras = getIntent().getExtras();
        if (extras != null){
            userId = extras.getLong("id");
        }

        if(userId > 0){
            userCursor = db.rawQuery("select * from " + DatabaseHelper.TABLE + " where "+DatabaseHelper.COLUMN_ID + " =?", new String[]{String.valueOf(userId)});

            userCursor.moveToFirst();
            userName.setText(userCursor.getString(1));
            userInfo.setText("Software: " + userCursor.getString(2) +
                    "%\nHardware: " + userCursor.getString(3) +
                    "%\nGeneral verbs: " + userCursor.getString(4) +
                    "%\nInternet: " + userCursor.getString(5)+"%");

        }


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
                intent.putExtra("id", userId); // id выбранного пользователя
                startActivity(intent);
            }
        });

        hardware.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListActivity.this, HardwareActivity.class);
                intent.putExtra("id", userId); // id выбранного пользователя
                startActivity(intent);
            }
        });

        genverbs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListActivity.this, GenVerbsActivity.class);
                intent.putExtra("id", userId); // id выбранного пользователя
                startActivity(intent);
            }
        });

        internet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListActivity.this, InternetActivity.class);
                intent.putExtra("id", userId); // id выбранного пользователя
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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        db.close();
        userCursor.close();
    }
}
