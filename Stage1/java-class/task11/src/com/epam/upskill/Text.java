package com.epam.upskill;

public class Text {
    private String header;
    private String text = "";

    public Text(Sentence... sentences) {
        for (Sentence sentence : sentences) {
            text += sentence + "\n";
        }
    }

    public void addSentence(Sentence sentence) {
        text += sentence;
    }

    public void header(String header) {
        this.header = header;
    }

    @Override
    public String toString() {
        return header + "\n" + text;
    }


}
