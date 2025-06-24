package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Arrays;
import static org.assertj.core.api.Assertions.assertThat;

class ItemTest {
    @Test
    public void whenNameAscendingOrder() {
        List<Item> items = Arrays.asList(
                new Item(3, "Sasha"),
                new Item(2, "Fedr"),
                new Item(4, "Max"),
                new Item(1, "Petr"),
                new Item(5, "Egor")
        );
        items.sort(new ItemAscByName());
        List<Item> expected = Arrays.asList(
                new Item(5, "Egor"),
                new Item(2, "Fedr"),
                new Item(4, "Max"),
                new Item(1, "Petr"),
                new Item(3, "Sasha")
        );
        assertThat(items).isEqualTo(expected);
    }

    @Test
    public void whenNameDescendingOrder() {
        List<Item> items = Arrays.asList(
                new Item(3, "Sasha"),
                new Item(2, "Fedr"),
                new Item(4, "Max"),
                new Item(1, "Petr"),
                new Item(5, "Egor")
        );
        items.sort(new ItemDescByName());
        List<Item> expected = Arrays.asList(
                new Item(3, "Sasha"),
                new Item(1, "Petr"),
                new Item(4, "Max"),
                new Item(2, "Fedr"),
                new Item(5, "Egor")
        );
        assertThat(items).isEqualTo(expected);
    }
}