package ru.job4j.oop;

public class DummyDic {

    public String engToRus(String eng) {
       String result = "Неизвестное слово. " + eng;
       return result;
    }

    public static void main(String[] args) {
        DummyDic translate = new DummyDic();
        String speak = "unknown words";
        System.out.println(translate.engToRus(speak));

    }
}

