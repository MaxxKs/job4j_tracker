package ru.job4j.stream;

import java.util.List;
import java.util.Arrays;

public class ForEachExample {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("ОДИН", "ДВА", "ТРИ");
        strings.stream()
                .map(String::toLowerCase)
                .forEach(System.out::println);
    }
}
