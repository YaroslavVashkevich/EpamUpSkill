package com.epam.upskill;

public class Sentence {

    private String sentence = "";

    public Sentence(Word... words) {
        for (Word word : words) {
            sentence += word;
        }
    }

    @Override
    public String toString() {
        return sentence + ".";
    }
}
