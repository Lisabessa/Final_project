package ru.samsung.final_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class HardwareActivity extends AppCompatActivity {

    long userId = 0; // ID текущего пользователя
    DatabaseHelper databaseHelper;
    SQLiteDatabase db;
    Cursor userCursor;

    Button learnhardware, testhardware, backToListOfModuls;
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
        setContentView(R.layout.activity_hardware);

        learnhardware = findViewById(R.id.learnhardware);
        testhardware = findViewById(R.id.testhardware);
        results = findViewById(R.id.ResHardware);
        total = findViewById(R.id.TotalHardware);
        tvmistakes = findViewById(R.id.TextViewMistakesHardware);
        backToListOfModuls = findViewById(R.id.exitFromHardware);

        databaseHelper = new DatabaseHelper(this);
        db = databaseHelper.open();

        Bundle extras = getIntent().getExtras();
        if(extras.get("id") != null){
            userId = extras.getLong("id");
        }

        if(extras.get("RESULT") != null && extras.get("AT_ALL") != null && extras.get("MISTAKES") != null){
            try {
                listOfMistakes = (ArrayList<Word>)extras.getSerializable("MISTAKES");
                Result = extras.getInt("RESULT");
                General_count = extras.getInt("AT_ALL");

            }
            catch (Exception e){}
        }

        mistakes = findViewById(R.id.listOfMistakesHardware);
        WordAdapter mistakesAdapter = new WordAdapter(this, R.layout.list_item, listOfMistakes);
        mistakes.setAdapter(mistakesAdapter);

        if(General_count != 0 && userId > 0){
            userCursor = db.rawQuery("select * from " + DatabaseHelper.TABLE + " where "+DatabaseHelper.COLUMN_ID + " =?", new String[]{String.valueOf(userId)});
            userCursor.moveToFirst();

            results.setText("Ваши результаты:\n"+ Result + " из "+General_count+ " ");
            Percentage = Double.parseDouble(String.valueOf(Result)) / Double.parseDouble(String.valueOf(General_count)) * 100;
            results.append("(" + Math.round(Percentage)+"%)");

            ContentValues cv = new ContentValues();
            cv.put(DatabaseHelper.COLUMN_NAME, userCursor.getString(1)); // заполнение полей
            cv.put(DatabaseHelper.COLUMN_RES_SOFTWARE, userCursor.getFloat(2));
            cv.put(DatabaseHelper.COLUMN_RES_HARDWARE, Math.round(Percentage));
            cv.put(DatabaseHelper.COLUMN_RES_GENVERBS, userCursor.getFloat(4));
            cv.put(DatabaseHelper.COLUMN_RES_INTERNET, userCursor.getFloat(5));

            db.update(DatabaseHelper.TABLE, cv, DatabaseHelper.COLUMN_ID + " = " + String.valueOf(userId), null);

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

        learnhardware.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HardwareActivity.this, LearnHardwareActivity.class);
                intent.putExtra("id", userId); // id выбранного пользователя
                startActivity(intent);
            }
        });

        testhardware.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HardwareActivity.this, TestHardwareActivity.class);
                intent.putExtra("id", userId); // id выбранного пользователя
                startActivity(intent);
            }
        });

        backToListOfModuls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HardwareActivity.this, ListActivity.class);
                intent.putExtra("id", userId); // id выбранного пользователя
                startActivity(intent);
            }
        });
    }
}