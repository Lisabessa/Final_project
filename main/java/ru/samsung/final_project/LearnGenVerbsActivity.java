package ru.samsung.final_project;

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

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class LearnGenVerbsActivity extends AppCompatActivity {
    ListView listGenVerbs;
    private List<Word> words = new ArrayList<>();
    Button exitFromLearnGenVerbs;
    EditText searchWord;
    WordAdapter wordAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_gen_verbs);
        setInitData();
        listGenVerbs = findViewById(R.id.listGenVerbs);
        wordAdapter = new WordAdapter(this, R.layout.list_item, words);
        exitFromLearnGenVerbs = findViewById(R.id.exitFromLearnGenVerbs);
        searchWord = findViewById(R.id.SearchWordGenVerbs);
        listGenVerbs.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word selectedWord = (Word)parent.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(), "" + selectedWord.getName(), Toast.LENGTH_SHORT).show();
            }
        });

        exitFromLearnGenVerbs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LearnGenVerbsActivity.this, GenVerbsActivity.class);
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
        listGenVerbs.setAdapter(wordAdapter);
    }

    void setInitData(){
        WordList wl = new WordList();
        wl.ForLearnGenVerbs();
        words = wl.getWordList();
    }
}
