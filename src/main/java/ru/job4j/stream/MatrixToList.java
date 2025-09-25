package ru.job4j.stream;

import java.util.List;
import java.util.stream.Stream;
import java.util.stream.Collectors;

public class MatrixToList {

    public static List<Integer> convert(Integer[][] matrix) {
        return Stream.of(matrix)
                .flatMap(Stream::of)
                .collect(Collectors.toList());
    }
}