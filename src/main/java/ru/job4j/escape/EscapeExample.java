package ru.job4j.escape;

public class EscapeExample {
    public static void main(String[] args) {
        String string = "Я изучаю на \n Job4j экранирование символов";
        System.out.println(string);
        System.out.println("Старый длинный текст\r");
        System.out.print("Старый длинный текст\r");
        System.out.println("Новый текст");
    }
}

