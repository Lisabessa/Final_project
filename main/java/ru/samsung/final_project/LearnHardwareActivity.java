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

public class LearnHardwareActivity extends AppCompatActivity {
    long userId = 0; // ID текущего пользователя
    ListView listHardware;
    private List<Word> words = new ArrayList<>();
    Button exitFromLearnHardware;
    EditText searchWord;
    WordAdapter wordAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_hardware);
        setInitData();
        Bundle extras = getIntent().getExtras();
        if(extras.get("id") != null){
            userId = extras.getLong("id");
        }
        listHardware = findViewById(R.id.listHardware);
        wordAdapter = new WordAdapter(this, R.layout.list_item, words);
        exitFromLearnHardware = findViewById(R.id.exitFromLearnHardware);
        searchWord = findViewById(R.id.SearchWordHardware);
        listHardware.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word selectedWord = (Word)parent.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(), "" + selectedWord.getName(), Toast.LENGTH_SHORT).show();
            }
        });

        exitFromLearnHardware.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LearnHardwareActivity.this, HardwareActivity.class);
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
        listHardware.setAdapter(wordAdapter);
    }

    void setInitData(){
        WordList wl = new WordList();
        wl.ForLearnHardware();
        words = wl.getWordList();
    }
}
