package com.epam.upskill;

//1. Создать объект класса Текст, используя классы Предложение, Слово. Методы: дополнить текст,
// вывести на консоль текст, заголовок текста.

public class Main {
    public static void main(String[] args) {
        Sentence sentence1 = new Sentence(new Word("Равным"), new Word("образом,"), new Word("внедрение"), new Word("современных"), new Word("подходов,"),
                new Word("вынуждает"), new Word("нас"), new Word("объективно"), new Word("потребовать"),new Word("несандартных"), new Word("решений"));

        Sentence sentence2 = new Sentence(new Word("Необходимо"), new Word("отметить,"), new Word("что"), new Word("оптимизация"), new Word("основных"),
                new Word("целей"), new Word("способствует"), new Word("подготовке"), new Word("и"), new Word("реализации"), new Word("системы"),
                new Word("массового"), new Word("участия"));

        Sentence sentence3 = new Sentence(new Word("Таким"), new Word("образом"), new Word("постоянный"), new Word("количественный"),new Word("рост"), new Word("и"),
                new Word("сфера"), new Word("нашей"), new Word("активности"), new Word("требуют"), new Word("уточнения"));

        Sentence sentence4 = new Sentence(new Word("Также"), new Word("как"), new Word("внедрение"), new Word("современных"), new Word("подходов"),
                new Word("играет"), new Word("определяющее"), new Word("значение"), new Word("для"), new Word("инновационных"), new Word("методов"));

        Text text = new Text(sentence1, sentence2, sentence3);

        text.addSentence(sentence4);
        text.header("Генератор текста.");
        System.out.println(text.toString());

    }
}
