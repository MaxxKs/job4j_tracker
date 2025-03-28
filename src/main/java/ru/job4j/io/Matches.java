package ru.job4j.io;

import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Игра 11");
        boolean turn = true;
        int count = 11;
        while (count > 0) {
            String player = turn ? "Первый игрок " : "Второй игрок ";
            System.out.println(player + "введите число от 1 до 3:");
            int matches = Integer.parseInt(input.nextLine());
            if (matches > 3 || matches > count || matches < 1) {
                System.out.println(player + "Можно ввести число от 1 до 3 и не более остатка: " + count);
            } else {
                count = count - matches;
                System.out.println("Остаток спичек: " + count);
                if (count == 0) {
                    System.out.println(player + "победил!");
                } else {
                    turn = !turn;
                }
            }
        System.out.println();
        }
    }
}