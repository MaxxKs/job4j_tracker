package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item[] findAll() {
        Item[] result = new Item[items.length];
        size = 0;
        for (int i = 0; i < items.length; i++) {
            Item item = items[i];
            if (item != null) {
                result[size] = item;
                size++;
            }
        }
        result = Arrays.copyOf(result, size);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
        return result;
    }

    public Item[] findByName(String key) {
        size = 0;
        Item[] result1 = new Item[items.length];
        for (int i = 0; i < items.length; i++) {
            Item item = items[i];
            if (item != null && item.getName().equals(key)) {
                result1[size] = item;
                size++;
            }
        }
        result1 = Arrays.copyOf(result1, size);
        for (int i = 0; i < result1.length; i++) {
            System.out.println(result1[i].getName());
        }
        return result1;
    }

    public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }
}