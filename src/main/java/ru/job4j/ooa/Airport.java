package ru.job4j.ooa;

public class Airport {
    public static void main(String[] args) {
        final Airbus airbus = new Airbus("A320");
        System.out.println(airbus);
        airbus.printModel();
        airbus.printCountEngine();
        System.out.println();
        Airbus a380 = new Airbus("A380");
        System.out.println(a380);
        a380.printModel();
        a380.printCountEngine();
    }
}