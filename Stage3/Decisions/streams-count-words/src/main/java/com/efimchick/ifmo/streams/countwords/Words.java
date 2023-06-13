package com.efimchick.ifmo.streams.countwords;

import java.util.*;

public class Words {
    List<Word> list = new ArrayList<>();
    Map<String, Integer> hashMap = new HashMap<>();
    Integer value;

    public String countWords(List<String> lines) {
        String allWord = lines.stream().reduce((accumulator, element) -> accumulator + " " + element).get();

        String[] array = (allWord.replaceAll("(?U)[^\\p{L}\\p{N}\\s]+", " ").replaceAll("\\d", " ").replaceAll("\\s+", " ").strip().toLowerCase()).split("[ ]");

        Arrays.stream(array).forEach(element -> count(element));

        hashMap.forEach((word, count) ->  list.add(new Word(word, count)));
        list.removeIf(element -> element.getWord().length() < 4 || element.getCount() < 10);

        Collections.sort(list, Comparator.comparing(Word::getCount).reversed().thenComparing(Word::getWord));

        String result = list.stream().map(element -> element.getWord() + " - " + element.getCount() + "\n").reduce((accumulator, element) -> accumulator + element).get();
        return result.substring(0, result.length() - 1);
    }
    public void count(String element){
        value = hashMap.get(element);
        hashMap.put(element, value == null ? 1 : value + 1);
    }
}

