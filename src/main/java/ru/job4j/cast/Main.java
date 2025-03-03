package ru.job4j.cast;

public class Main {
    public static void main(String[] args) {
        Vehicle airplane = new Airplane();
        Vehicle internationalPplane = new Airplane();
        Vehicle bus = new Bus();
        Vehicle internationalBus = new Bus();
        Vehicle train = new Train();
        Vehicle internationalTrain = new Train();
        Vehicle cityTrain = new Train();

        Vehicle[] vehicles = new Vehicle[] {airplane, internationalPplane, bus, internationalBus,
                train, internationalTrain, cityTrain};

        for (Vehicle object : vehicles) {
            object.move();
        }
    }
}
