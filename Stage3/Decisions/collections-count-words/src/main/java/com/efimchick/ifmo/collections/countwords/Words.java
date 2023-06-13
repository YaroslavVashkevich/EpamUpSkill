package com.efimchick.ifmo.collections.countwords;

import java.util.*;

public class Words {

    public String countWords(List<String> lines) {
        String allWord = "";
        for (String word : lines) {
            allWord += word + " ";
        }

        String[] array = (allWord.replaceAll("(?U)[^\\p{L}\\p{N}\\s]+", " ").replaceAll("\\d", " ").replaceAll("\\s+", " ").strip().toLowerCase()).split("[ ]");
        List<Word> list = new ArrayList<>();
        HashMap<String, Integer> hashMap = new HashMap<>();

        Integer value;
        for (String word : array) {
            value = hashMap.get(word);
            hashMap.put(word, value == null ? 1 : value + 1);
        }

        for (Map.Entry<String, Integer> map : hashMap.entrySet()) {
            if (map.getValue() >= 10 & map.getKey().length() >= 4) {
                list.add(new Word(map.getKey(), map.getValue()));
            }
        }
        Collections.sort(list, new Comparator<Word>() {
            @Override
            public int compare(Word o1, Word o2) {
                int flag = o2.getCount() - o1.getCount();
                if (flag == 0) flag = o1.getWord().compareTo(o2.getWord());
                return flag;
            }
        });

        String result = "";
        for (Word word : list) {
            result = result + word.getWord() + " - " + word.getCount() + "\n";
        }
        return result.substring(0, result.length() - 1);
    }


}

