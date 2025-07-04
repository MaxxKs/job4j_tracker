package ru.job4j.hashmap;

public record Label(String name, Double score) implements Comparable<Label> {
    @Override
    public int compareTo(Label o) {
        return Double.compare(this.score, o.score);
    }
}
