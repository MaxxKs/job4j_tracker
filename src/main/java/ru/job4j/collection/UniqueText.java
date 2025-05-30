package ru.job4j.collection;

import java.util.HashSet;

public class UniqueText {
    public boolean isEquals(String originText, String duplicateText) {
        boolean result = true;
        String[] origin = originText.split(" ");
        String[] duplicate = duplicateText.split(" ");
        HashSet<String> check = new HashSet<>();
        for (String words : origin) {
            check.add(words.toLowerCase());
        }
        for (String duplicats : duplicate) {
            if (!check.contains(duplicats.toLowerCase())) {
                result = false;
                break;
            }
        }
        return result;
    }
}