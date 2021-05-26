package ru.samsung.final_project;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FilterQueryProvider;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;


public class RegisterUser extends Activity {

    ListView listOfUsers;
    EditText searchUser;
    DatabaseHelper databaseHelper;
    SQLiteDatabase db;
    Cursor userCursor;
    SimpleCursorAdapter userAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_choice);

        listOfUsers = findViewById(R.id.listOfUsers);
        searchUser = findViewById(R.id.SearchUser);

        databaseHelper = new DatabaseHelper(getApplicationContext());
        databaseHelper.Create_db();

        listOfUsers.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), UserRedactor.class);
                intent.putExtra("id", id);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        try{

            super.onResume();
            db = databaseHelper.open();

            userCursor = db.rawQuery("select * from " + databaseHelper.TABLE, null);
            String [] headers = new String[] {DatabaseHelper.COLUMN_NAME, DatabaseHelper.COLUMN_RES_SOFTWARE, DatabaseHelper.COLUMN_RES_HARDWARE, DatabaseHelper.COLUMN_RES_GENVERBS, DatabaseHelper.COLUMN_RES_INTERNET};
            userAdapter = new SimpleCursorAdapter(this, android.R.layout.activity_list_item, userCursor, headers, new int[]{android.R.id.text1}, 0);
            listOfUsers.setAdapter(userAdapter);
            if(!searchUser.getText().toString().isEmpty()){
                userAdapter.getFilter().filter(searchUser.getText().toString());
            }
            searchUser.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    userAdapter.getFilter().filter(s.toString());
                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            });
            userAdapter.setFilterQueryProvider(new FilterQueryProvider() {
                @Override
                public Cursor runQuery(CharSequence constraint) {
                    if(constraint == null || constraint.length() == 0){
                        return db.rawQuery("SELECT * FROM " + DatabaseHelper.TABLE, null);
                    }
                    else{
                        return db.rawQuery("SELECT * FROM " + DatabaseHelper.TABLE + " WHERE " + DatabaseHelper.COLUMN_NAME + " like ?", new String[]{"%"+constraint.toString()+"%"});
                    }
                }
            });
            listOfUsers.setAdapter(userAdapter);

        }
        catch (SQLException E){

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        db.close();
        userCursor.close();
    }

    public void add(View view) {

        Intent intent = new Intent(getApplicationContext(), UserRedactor.class);
        startActivity(intent);
    }
}
