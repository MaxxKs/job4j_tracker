package ru.job4j.collection;

import java.util.ArrayList;

public class UsageArrayList {
    public static void main(String[] args) {
        ArrayList<String> arrayLists = new ArrayList<>();
        arrayLists.add("Petr");
        arrayLists.add("Ivan");
        arrayLists.add("Stepan");

        for (String arrayList: arrayLists) {
            System.out.println(arrayList);
        }
    }
}
