package ru.job4j.tracker;

public class Item {
    private int id;
    private String name;

    public Item() {
    }

    public Item(String name) {
        this.name = name;
    }

    public Item(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void info() {
        System.out.println(id);
        System.out.println(name);
        System.out.println();
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        Item empty = new Item();
        empty.info();

        Item justName = new Item("Alexander");
        justName.info();

        Item idAndName = new Item(1, "Petr");
        idAndName.info();
    }
}