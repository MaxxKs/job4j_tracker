package ru.job4j.oop;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.withPrecision;

class PointTest {

    @Test
    public void when000and040Then4() {
        Point first = new Point(0, 0, 0);
        Point second = new Point(0, 4, 0);
        double result = first.distance3d(second);
        double expected = 4;
        assertThat(result).isEqualTo(expected, withPrecision(0.01));
    }

    @Test
    public void when234012and32214Then26dot98() {
        Point first = new Point(23, 40, 12);
        Point second = new Point(3, 22, 14);
        double result = first.distance3d(second);
        double expected = 26.98;
        assertThat(result).isEqualTo(expected, withPrecision(0.01));
    }

    @Test
    public void when20100and1050Then11dot18() {
        Point first = new Point(20, 10, 0);
        Point second = new Point(10, 5, 0);
        double result = first.distance3d(second);
        double expected = 11.18;
        assertThat(result).isEqualTo(expected, withPrecision(0.01));
    }
}