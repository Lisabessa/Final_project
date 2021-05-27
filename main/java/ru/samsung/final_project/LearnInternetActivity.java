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

public class LearnInternetActivity extends AppCompatActivity {

    long userId = 0; // ID текущего пользователя

    ListView listInternet;
    private List<Word> words = new ArrayList<>();
    Button exitFromLearnInternet;
    EditText searchWord;
    WordAdapter wordAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_internet);
        setInitData();
        Bundle extras = getIntent().getExtras();
        if(extras.get("id") != null){
            userId = extras.getLong("id");
        }
        listInternet = findViewById(R.id.listInternet);
        wordAdapter = new WordAdapter(this, R.layout.list_item, words);
        exitFromLearnInternet = findViewById(R.id.exitFromLearnInternet);
        searchWord = findViewById(R.id.SearchWordInternet);
        listInternet.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word selectedWord = (Word)parent.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(), "" + selectedWord.getName(), Toast.LENGTH_SHORT).show();
            }
        });

        exitFromLearnInternet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LearnInternetActivity.this, InternetActivity.class);
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
        listInternet.setAdapter(wordAdapter);
    }

    void setInitData(){
        WordList wl = new WordList();
        wl.ForLearnInternet();
        words = wl.getWordList();
    }

}
