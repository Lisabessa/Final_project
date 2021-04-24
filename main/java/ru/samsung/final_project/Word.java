package ru.samsung.final_project;

import java.io.Serializable;

public class Word implements Comparable<Word>, Serializable{
    private String name;
    private String transcription;
    private String translation;

    public Word(String name, String transcription, String translation) {
        this.name = name;
        this.transcription = transcription;
        this.translation = translation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTranscription() {
        return transcription;
    }

    public void setTranscription(String transcription) {
        this.transcription = transcription;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    @Override
    public int compareTo(Word o) {
        return o.getName().compareTo(this.name);
    }
}
