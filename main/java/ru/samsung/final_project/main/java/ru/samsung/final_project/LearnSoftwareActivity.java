package ru.samsung.final_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LearnSoftwareActivity extends AppCompatActivity {

    long userId = 0; // ID текущего пользователя
    ListView listSoftware;
    private List<Word> words = new ArrayList<>();
    Button exitFromLearnSoftware;
    EditText searchWord;
    WordAdapter wordAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_software);
        setInitData();
        Bundle extras = getIntent().getExtras();
        if(extras.get("id") != null){
            userId = extras.getLong("id");
        }
        listSoftware = findViewById(R.id.listSoftware);
        wordAdapter = new WordAdapter(this, R.layout.list_item, words);
        //listSoftware.setAdapter(wordAdapter);
        exitFromLearnSoftware = findViewById(R.id.exitFromLearnSoftware);
        searchWord = findViewById(R.id.SearchWordSoftware);
        listSoftware.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word selectedWord = (Word)parent.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(), "" + selectedWord.getName(), Toast.LENGTH_SHORT).show();
            }
        });

        exitFromLearnSoftware.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LearnSoftwareActivity.this, SoftwareActivity.class);
                intent.putExtra("id", userId); // id выбранного пользователя
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        if(!searchWord.getText().toString().isEmpty()){
            wordAdapter.getFilter().filter(searchWord.getText().toString());
        }
        searchWord.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                wordAdapter.getFilter().filter(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        listSoftware.setAdapter(wordAdapter);
    }

    void setInitData(){
        WordList wl = new WordList();
        wl.ForLearnSoftware();
        words = wl.getWordList();
    }
}