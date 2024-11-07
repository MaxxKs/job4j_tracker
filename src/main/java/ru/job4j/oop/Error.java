package ru.job4j.oop;

public class Error {
    private boolean active;
    private int status;
    private String message;

    public Error() {
    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void info() {
        System.out.println(active);
        System.out.println(status);
        System.out.println(message);
        System.out.println();
    }

    public static void main(String[] args) {
        Error error = new Error();
        error.info();

        Error errorParameters = new Error(true, 12, "Без ошибок");
        errorParameters.info();

        Error parameters = new Error(false, 2, "Ошибка");
        parameters.info();
    }
}
