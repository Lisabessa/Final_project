package ru.samsung.final_project;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class UserRedactor extends Activity {
    Button btn_save, btn_delete, btn_choice;
    EditText name;

    DatabaseHelper sqlHelper;
    SQLiteDatabase db;
    Cursor userCursor;
    long userId = 0;
    float res_software = 0, res_hardware = 0, res_genverbs = 0,  res_internet = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_redactor);

        name = findViewById(R.id.NewUsername);
        btn_save = findViewById(R.id.btn_saveUser);
        btn_delete = findViewById(R.id.btn_deleteUser);
        btn_choice = findViewById(R.id.btn_chosen_one);
        sqlHelper = new DatabaseHelper(this);

        db = sqlHelper.open();
        Bundle extras = getIntent().getExtras();
        if (extras != null){
            userId = extras.getLong("id");
        }
        if(userId > 0){
            userCursor = db.rawQuery("select * from " + DatabaseHelper.TABLE + " where "+DatabaseHelper.COLUMN_ID + " =?", new String[]{String.valueOf(userId)});

            userCursor.moveToFirst();
            name.setText(userCursor.getString(1));
            res_software = userCursor.getFloat(2);
            res_hardware = userCursor.getFloat(3);
            res_genverbs = userCursor.getFloat(4);
            res_internet = userCursor.getFloat(5);

        }

        if(extras == null || userId==0){
            btn_save.setText(R.string.save);
            btn_delete.setVisibility(View.GONE);
            btn_choice.setVisibility(View.GONE);
        }

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues cv = new ContentValues();
                cv.put(DatabaseHelper.COLUMN_NAME, name.getText().toString()); // заполнение полей
                cv.put(DatabaseHelper.COLUMN_RES_SOFTWARE, res_software);
                cv.put(DatabaseHelper.COLUMN_RES_HARDWARE, res_hardware);
                cv.put(DatabaseHelper.COLUMN_RES_GENVERBS, res_genverbs);
                cv.put(DatabaseHelper.COLUMN_RES_INTERNET, res_internet);
                if(userId > 0){
                    db.update(DatabaseHelper.TABLE, cv, DatabaseHelper.COLUMN_ID + " = " + String.valueOf(userId), null);
                }
                else{
                    db.insert(DatabaseHelper.TABLE, null, cv);
                }
                goHome();
            }
        });

        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.delete(DatabaseHelper.TABLE, "_id = ?", new String[]{String.valueOf(userId)});
                goHome();
            }
        });

        btn_choice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.close();
                Intent intent = new Intent(UserRedactor.this, MainActivity.class);
                intent.putExtra("id", userId); // id выбранного пользователя в main
                startActivity(intent);

            }
        });
    }

    private void goHome(){
        db.close();
        //userCursor.close();
        Intent intent = new Intent(this, RegisterUser.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
    }
}
