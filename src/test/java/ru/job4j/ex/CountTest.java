package ru.job4j.ex;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CountTest {
    @Test
    public void whenException() {
        int start = 1;
        int finish = 4;
        int expected = 6;
        int result = Count.add(start, finish);
        assertThat(result).isEqualTo(expected);
    }
}