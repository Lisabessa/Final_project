package ru.samsung.final_project;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static ru.samsung.final_project.R.string.QuestionNumber;

public class Tester {
    private int Points = 0;
    Random random = new Random();

    String alpha = "abcdefghijklmnopqrstuvwxyz- ";

    private Button btn1, btn2, btn3, btn4;
    private TextView num, question, wordQuestion;

    private List<Word> words;
    private List<Word> mistakes = new ArrayList<>();

    int btn;
    private UsingInfo spisok = new UsingInfo();
    int currentNum = -1; // Номер текущего слова из списка, с которым в данный момент происходит работа.

    public Tester(List<Word> words, Button btn1, Button btn2, Button btn3, Button btn4, TextView num, TextView question, TextView wordQuestion) {
        this.words = words;
        this.btn1 = btn1;
        this.btn2 = btn2;
        this.btn3 = btn3;
        this.btn4 = btn4;
        this.num = num;
        this.question = question;
        this.wordQuestion = wordQuestion;
        BigMix(); // Перемешка для того, чтоб каждый раз слова шли в другом порядке.
    }

    public void CheckAnswer(int btn_num){
        if (spisok.CheckButton(btn_num)){
            Points++;
        }
        else{
            mistakes.add(new Word(words.get(currentNum).getName(), words.get(currentNum).getTranscription(), words.get(currentNum).getTranslation()));
        }
    }

    public boolean Change(){
        btn1.setVisibility(View.VISIBLE);
        btn2.setVisibility(View.VISIBLE);
        btn3.setVisibility(View.VISIBLE);
        btn4.setVisibility(View.VISIBLE);
        btn1.setText("");
        btn2.setText("");
        btn3.setText("");
        btn4.setText("");
        currentNum ++;
        if(currentNum < words.size()){
            spisok = new UsingInfo();
            num.setText(QuestionNumber);
            num.append(""+(currentNum +1));

            int taskCode = random.nextInt(4);
            switch (taskCode){
                case 0:
                    question.setText(R.string.question1);
                    wordQuestion.setText(words.get(currentNum).getName());
                    btn = random.nextInt(4) + 1;
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
                    break;

                case 1:
                    question.setText(R.string.question1);
                    wordQuestion.setText(words.get(currentNum).getTranslation());
                    btn = random.nextInt(4) + 1;
                    spisok.AddWord(currentNum);
                    spisok.AddButton(btn);
                    switch (btn){
                        case 1:
                            btn1.setText(words.get(currentNum).getName());
                            break;
                        case 2:
                            btn2.setText(words.get(currentNum).getName());
                            break;
                        case 3:
                            btn3.setText(words.get(currentNum).getName());
                            break;
                        case 4:
                            btn4.setText(words.get(currentNum).getName());
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
                                    btn1.setText(words.get(numForIncorrect).getName());
                                    break;
                                case 2:
                                    btn2.setText(words.get(numForIncorrect).getName());
                                    break;
                                case 3:
                                    btn3.setText(words.get(numForIncorrect).getName());
                                    break;
                                case 4:
                                    btn4.setText(words.get(numForIncorrect).getName());
                                    break;
                            }
                            spisok.AddWord(numForIncorrect);
                            spisok.AddButton(i+1);
                        }
                    }
                    break;

                case 2:
                    question.setText(R.string.question2);
                    char []ar = words.get(currentNum).getName().toCharArray();
                    int missed = random.nextInt(ar.length);
                    ar[missed] = '_';
                    String resString = new String(ar);
                    wordQuestion.setText(resString);
                    btn = random.nextInt(4) + 1;

                    String SymbRight = String.valueOf(words.get(currentNum).getName().toCharArray()[missed]);
                    char [] alphabet = alpha.toCharArray();
                    spisok.AddWord(SymbRight.hashCode());
                    spisok.AddButton(btn);
                    switch (btn){
                        case 1:
                            btn1.setText(SymbRight.toLowerCase());
                            break;
                        case 2:
                            btn2.setText(SymbRight.toLowerCase());
                            break;
                        case 3:
                            btn3.setText(SymbRight.toLowerCase());
                            break;
                        case 4:
                            btn4.setText(SymbRight.toLowerCase());
                            break;
                    }
                    spisok.setAnswerButton(btn);

                    for(int i=0; i<4; i++){
                        if(!spisok.getUsingButtons().contains(i+1)){
                            int numForIncorrect = random.nextInt(alpha.length());
                            while(spisok.getUsingWords().contains(String.valueOf(alphabet[numForIncorrect]).hashCode())){
                                numForIncorrect = random.nextInt(alpha.length());
                            }
                            String symb = String.valueOf(alphabet[numForIncorrect]);
                            switch (i+1){
                                case 1:
                                    btn1.setText(symb);
                                    break;
                                case 2:
                                    btn2.setText(symb);
                                    break;
                                case 3:
                                    btn3.setText(symb);
                                    break;
                                case 4:
                                    btn4.setText(symb);
                                    break;
                            }
                            spisok.AddWord(String.valueOf(alphabet[numForIncorrect]).hashCode());
                            spisok.AddButton(i+1);
                        }
                    }

                    break;

                case 3:
                    question.setText(R.string.question3);
                    btn3.setVisibility(View.GONE);
                    btn4.setVisibility(View.GONE);
                    btn1.setText(R.string.AnswerYES);
                    btn2.setText(R.string.AnswerNO);

                    btn = random.nextInt(2) + 1;
                    switch (btn){
                        case 1:
                            //верно
                            wordQuestion.setText(words.get(currentNum).getName() +" - "+ words.get(currentNum).getTranslation());

                            break;

                        case 2:
                            //ложь
                            String incorrectTranslation = words.get(random.nextInt(words.size())).getTranslation();
                            while (incorrectTranslation.equals(words.get(currentNum).getTranslation())){
                                incorrectTranslation = words.get(random.nextInt(words.size())).getTranslation();
                            }
                            wordQuestion.setText(words.get(currentNum).getName() +" - "+ incorrectTranslation);
                            break;
                    }
                    spisok.setAnswerButton(btn);
                    break;
            }

            return true;
        }
        return false; // если ложь => в активности  запрос три  параметра

    }

    public int getPoints() {
        return Points;
    }

    public List<Word> getMistakes() {
        return mistakes;
    }

    public int getWordsSize() {
        return words.size();
    }

    public void BigMix(){
        Collections.shuffle(words);
    }
}
