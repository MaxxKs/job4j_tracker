package ru.job4j.format;

import java.util.Calendar;

public class Format {

    public static void getGreeting(String name, int age) {
        System.out.println(String.format("Привет! Я %s, мой возраст: %d лет", name, age));
        System.out.println(String.format("Аргумент передан? %b", null));
        System.out.format("Строка1%nСтрока2%n");
        System.out.println(String.format("Строка1%nСтрока 2"));
        System.out.printf("1%nСтрока2%n");
        System.out.println(String.format("%1$,+020.10f", 5000000.0000));
    }

    public static void getGreetingAndTime(String name) {
        Calendar instance = Calendar.getInstance();
        System.out.println(String.format("Привет, %s! Текущая дата: %tF, текущее время: %tT", name, instance, instance));
    }

    public static void main(String[] args) {
        Format.getGreeting("Елена", 35);
        Format.getGreetingAndTime("Анна");
    }
}
