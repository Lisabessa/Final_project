package ru.samsung.final_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class LearnSoftwareActivity extends AppCompatActivity {

    ListView listSoftware;
    private List<Word> words = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_software);
        setInitData();
        listSoftware = findViewById(R.id.listSoftware);
        WordAdapter wordAdapter = new WordAdapter(this, R.layout.list_item, words);
        listSoftware.setAdapter(wordAdapter);

        listSoftware.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word selectedWord = (Word)parent.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(), "Слово: " + selectedWord.getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    void setInitData(){
        words.add(new Word("a compiler", "[ɑ kəmˈpaɪlə]", "компилятор"));
        words.add(new Word("a database", "[ɑ ˈdeɪtəbeɪs]", "база данных"));
        words.add(new Word("a debugger", "[ɑ diːˈbʌɡə(r)]", "отладчик"));
        words.add(new Word("a desktop application/app", "[ɑ ˈdesktɒp æplɪˈkeɪʃn/æp]", "приложение для настольного компьютера"));
        words.add(new Word("a device driver", "[ɑ dɪˈvaɪs ˈdraɪvə]", "драйвер устройства"));
        words.add(new Word("a graphical user interface (GUI)", "[ɑ 'græfɪkl ˈjuːzər ˈɪntəfeɪs]", "графический пользовательский интерфейс"));
        words.add(new Word("a kernel", "[ɑ kɜːnl]", "ядро"));
        words.add(new Word("a mobile application/app", "[ɑ ˈməʊbaɪl æplɪˈkeɪʃn/æp]", "мобильное приложение"));
        words.add(new Word("a plug-in (plugin)", "[ɑ ˈplʌgɪn]", "плагин, расширение, дополнительный программный модуль"));
        words.add(new Word("a programming language", "[ɑ ˈprəʊgræm ˈlæŋgwɪʤ]", "язык программирования"));
        words.add(new Word("a query", "[ɑ ˈkwɪərɪ]", "запрос"));
        words.add(new Word("a scroll bar", "[ɑ skrəʊl bɑː]", "полоса прокрутки"));
        words.add(new Word("a snapshot", "[ɑ snæpʃɒt]", "снимок состояния системы"));



    }
}