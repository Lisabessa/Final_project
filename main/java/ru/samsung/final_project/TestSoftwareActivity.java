package ru.samsung.final_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static ru.samsung.final_project.R.string.QuestionNumber;
import static ru.samsung.final_project.R.string.start;

public class TestSoftwareActivity extends AppCompatActivity {

    private int Points = 0;
    Random random = new Random();

    Button btn1, btn2, btn3, btn4;
    TextView num, question, wordQuestion;

    private List<Word> words = new ArrayList<>();
    private List<Word> mistakes = new ArrayList<>();

    int currentNum = -1; // Номер текущего слова из списка, с которым в данный момент происходит работа.
    UsingInfo spisok = new UsingInfo();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_software);
        btn1 = findViewById(R.id.answer1Software);
        btn2 = findViewById(R.id.answer2Software);
        btn3 = findViewById(R.id.answer3Software);
        btn4 = findViewById(R.id.answer4Software);
        num = findViewById(R.id.numOfQuestionSoftware);
        question = findViewById(R.id.questionSoftware);
        wordQuestion = findViewById(R.id.wordForQuestionSoftware);
        setInitData();
        Change();

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (spisok.CheckButton(1)){
                    Points++;
                }
                else{
                    mistakes.add(new Word(words.get(currentNum).getName(), words.get(currentNum).getTranscription(), words.get(currentNum).getTranslation()));
                }
                Change();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(spisok.CheckButton(2)){
                    Points++;//Если правильно ответил
                }
                else{ //Если неправильно, то добавляю в список ошибок.
                    mistakes.add(new Word(words.get(currentNum).getName(), words.get(currentNum).getTranscription(), words.get(currentNum).getTranslation()));
                }
                Change();
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(spisok.CheckButton(3)){
                    Points++;
                }
                else{
                    mistakes.add(new Word(words.get(currentNum).getName(), words.get(currentNum).getTranscription(), words.get(currentNum).getTranslation()));
                }
                Change();
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (spisok.CheckButton(4)){
                    Points++;
                }
                else{
                    mistakes.add(new Word(words.get(currentNum).getName(), words.get(currentNum).getTranscription(), words.get(currentNum).getTranslation()));
                }
                Change();
            }
        });

    }

    private void Change(){ //Метод изменения вопроса.
        currentNum ++;
        btn1.setText("");
        btn2.setText("");
        btn3.setText("");
        btn4.setText("");
        if(currentNum < words.size()){
            spisok = new UsingInfo();

            num.setText(QuestionNumber);
            num.append(""+(currentNum +1));
            wordQuestion.setText(words.get(currentNum).getName());
            int btn = random.nextInt(4) + 1;
            spisok.AddWord(currentNum);
            spisok.AddButton(btn);
            switch (btn){
                case 1:
                    btn1.setText(words.get(currentNum).getTranslation());
                    break;
                case 2:
                    btn2.setText(words.get(currentNum).getTranslation());
                    break;
                case 3:
                    btn3.setText(words.get(currentNum).getTranslation());
                    break;
                case 4:
                    btn4.setText(words.get(currentNum).getTranslation());
                    break;
            }
            spisok.setAnswerButton(btn);
            for(int i=0; i<4; i++){
                if(!spisok.getUsingButtons().contains(i+1)){
                    int numForIncorrect = random.nextInt(words.size());
                    while(spisok.getUsingWords().contains(numForIncorrect)){
                        numForIncorrect = random.nextInt(words.size());
                    }
                    switch (i+1){
                        case 1:
                            btn1.setText(words.get(numForIncorrect).getTranslation());
                            break;
                        case 2:
                            btn2.setText(words.get(numForIncorrect).getTranslation());
                            break;
                        case 3:
                            btn3.setText(words.get(numForIncorrect).getTranslation());
                            break;
                        case 4:
                            btn4.setText(words.get(numForIncorrect).getTranslation());
                            break;
                    }
                    spisok.AddWord(numForIncorrect);
                    spisok.AddButton(i+1);
                }
            }

        }

        else{
            Toast.makeText(getApplicationContext(), "Подсчёт результата...", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(TestSoftwareActivity.this, SoftwareActivity.class);
            intent.putExtra("RESULT" ,Points);
            intent.putExtra("AT_ALL", words.size());
            intent.putExtra("MISTAKES" , (Serializable) mistakes);
            startActivity(intent);
        }


    }

    void setInitData(){ // 55 слов
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
        words.add(new Word("a spreadsheet", "[ɑ ˈspredʃiːt]", "электронная таблица"));
        words.add(new Word("a status bar", "[ɑ ˈsteɪtəs bɑː]", "строка состояния"));
        words.add(new Word("a template", "[ɑ ˈtemplɪt]", "шаблон"));
        words.add(new Word("a version control system (VCS)", "[ɑ vɜːʃn kɒnˈtrəʊl ˈsɪstɪm]", "система контроля версий"));
        words.add(new Word("a web application", "[ɑ web æplɪˈkeɪʃn]", "веб-приложение"));
        words.add(new Word("a word processor", "[ɑ wɜːd ˈprəʊsesə]", "текстовый процессор"));
        words.add(new Word("a text editor", "[ɑ tekst ˈedɪtə]", "текстовый редактор"));
        words.add(new Word("a utility", "[ɑ juːˈtɪlɪtɪ]", "утилита (служебная программа)"));
        words.add(new Word("acceptance testing", "[əkˈseptəns ˈtestɪŋ]", "приемочное тестирование"));
        words.add(new Word("agile methodology", "[ˈæʤaɪl meθəˈdɒləʤɪ]", "гибкая методология разработки"));
        words.add(new Word("an algorithm", "[ɑn ˈælgərɪðm]", "алгоритм"));
        words.add(new Word("an array", "[ɑn əˈreɪ]", "массив"));
        words.add(new Word("an encoding", "[ɑn ɪnˈkəʊdɪŋ]", "кодировка"));
        words.add(new Word("an enterprise application", "[ɑn ˈentəpraɪz æplɪˈkeɪʃn]", "корпоративное приложение"));
        words.add(new Word("an executable (file)", "[ɑn ɪgˈzekjʊtəbl faɪl]", "исполняемый (файл)"));
        words.add(new Word("an interpreter", "[ɑn ɪnˈtɜːprɪtə]", "интерпретатор"));
        words.add(new Word("an operating system (OS)", "[ɑn ˈɒpə()reɪtɪŋ ()sɪstəm]", "операционная система"));
        words.add(new Word("application software", "[æplɪˈkeɪʃn ˈsɒftweə]", "прикладное программное обеспечение"));
        words.add(new Word("aspect-oriented programming (AOP)", "[ˈæspekt-ˈɔːrɪentɪd ˈprəʊgræmɪŋ]", "аспектно-ориентированное программирование"));
        words.add(new Word("binary data", "[ˈbaɪnərɪ ˈdeɪtə]", "двоичные данные"));
        words.add(new Word("commercial software", "[kəˈmɜːʃəl ˈsɒftweə]", "платное программное обеспечение"));
        words.add(new Word("data", "[ˈdeɪtə]", "данные, информация"));
        words.add(new Word("data processing", "[ˈdeɪtə ˈprəʊsesɪŋ]", "обработка данных"));
        words.add(new Word("extreme programming", "[ɪksˈtriːm ˈprəʊgræmɪŋ]", "экстремальное программирование"));
        words.add(new Word("firmware", "[ˈfɜːmweə]", "прошивка, микропрограмма"));
        words.add(new Word("freeware", "[ˈfriːweər]", "бесплатное программное обеспечение"));
        words.add(new Word("incremental development", "[ɪnkrəˈmentl dɪˈveləpmənt]", "инкрементная модель разработки"));
        words.add(new Word("integrated development environment (IDE)", "[ˈɪntɪgreɪtɪd dɪˈveləpmənt ɪnˈvaɪərənmənt]", "интегрированная среда разработки"));
        words.add(new Word("iterative development", "[ˈɪtərətɪv dɪˈveləpmənt]", "итеративная модель разработки"));
        words.add(new Word("malicious software (malware)", "[məˈlɪʃəs ˈsɒftweə]", "вредоносное программное обеспечение"));
        words.add(new Word("object-oriented programming (OOP)", "[ˈɒbʤɛkt-ˈɔːrɪentɪd ˈprəʊgræmɪŋ]", "объектно-ориентированное программирование"));
        words.add(new Word("open source software", "[ˈəʊpən sɔːs ˈsɒftweə]", "программное обеспечение с открытым исходным кодом"));
        words.add(new Word("prototyping", "[ˈprəʊtətaɪpɪŋ]", "создание прототипа, прототипирование"));
        words.add(new Word("rapid application development (RAD)", "[ˈræpɪd æplɪˈkeɪʃn dɪˈveləpmənt]", "быстрая разработка приложений (методология)"));
        words.add(new Word("regression testing", "[rɪˈgreʃn ˈtestɪŋ]", "регрессионное тестирование"));
        words.add(new Word("runtime (runtime environment)", "[rʌnˈtaɪm]", "среда выполнения кода"));
        words.add(new Word("server software", "[ˈsɜːvə ˈsɒftweə]", "серверное программное обеспечение"));
        words.add(new Word("spiral development", "[ˈspaɪərəl dɪˈveləpmənt]", "спиральная модель разработки"));
        words.add(new Word("spyware", "[ˈspaɪəweər]", "программа-шпион, шпионское программное обеспечение"));
        words.add(new Word("system software", "[ˈsɪstɪm ˈsɒftweə]", "системное программное обеспечение"));
        words.add(new Word("unit testing", "[ˈjuːnɪt ˈtestɪŋ]", "модульное (блочное, компонентное) тестирование"));
        words.add(new Word("waterfall model", "[ˈwɔːtəfɔːl mɒdl]", "каскадная модель разработки"));

    }
}