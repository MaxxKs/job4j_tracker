package ru.job4j.oop;

public class Jukebox {
    public void music(int position) {
        if (position == 1) {
            System.out.println("Пусть бегут неуклюже");
        } else if (position == 2) {
            System.out.println("Спокойной ночи");
        } else {
            System.out.println("Песня не найдена");
        }
    }

    public static void main(String[] args) {
        Jukebox alex = new Jukebox();
        int one = 1;
        int two = 2;
        int three = 3;
        alex.music(one);
        alex.music(two);
        alex.music(three);
        alex.music(1);
        alex.music(2);
        alex.music(3);
    }
}

