package ru.job4j.polymorphism;

public class Bus implements Transport {

    @Override
    public void move() {
        System.out.println("Автобус начинает движение.");
    }

    @Override
    public void passengers(int count) {
        System.out.println("Вместимость салона: " + count + " пассажир(ов).");
    }

    public int refuel(int fuel) {
        int price = fuel * 71;
        System.out.println("Автобус заправлен на: " + fuel  + " литров. "
                + "\nСтоимость заправки: " + price + " рублей.");
        return price;
    }
}
