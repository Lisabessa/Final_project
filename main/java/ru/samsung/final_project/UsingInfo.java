package ru.samsung.final_project;

import android.content.Intent;

import java.util.ArrayList;

public class UsingInfo {

    private ArrayList<Integer> usingWords = new ArrayList<>();
    private ArrayList<Integer> usingButtons = new ArrayList<>();
    private Integer AnswerButton;

    public UsingInfo() {
    }

    public void AddWord(int num){
        usingWords.add(num);
    }

    public void AddButton(int num){
        usingButtons.add(num);
    }

    public ArrayList<Integer> getUsingWords() {
        return usingWords;
    }

    public ArrayList<Integer> getUsingButtons() {
        return usingButtons;
    }

    public void setAnswerButton(Integer answerButton) {
        AnswerButton = answerButton;
    }

    public boolean CheckButton(int btn){
        if (btn == AnswerButton){
            return true;
        }
        return false;
    }

}
