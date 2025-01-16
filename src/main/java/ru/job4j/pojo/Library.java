package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book cleanCode = new Book("Clean code", 250);
        Book java = new Book("Java", 900);
        Book c = new Book("C", 650);
        Book kotlin = new Book("Kotlin", 750);
        Book[] books = new Book[4];
        books[0] = cleanCode;
        books[1] = java;
        books[2] = c;
        books[3] = kotlin;
        for (int index = 0; index < books.length; index++) {
            Book book = books[index];
            System.out.println(book.getName() + " - " + book.getNumberOfPages());
        }
        System.out.println();
        System.out.println("Book cleanCode we change with Book kotlin");
        Book temp = books[0];
        books[0] = books[3];
        books[3] = temp;
        for (int index = 0; index < books.length; index++) {
            Book book = books[index];
            System.out.println(book.getName() + " - " + book.getNumberOfPages());
        }
        System.out.println();
        System.out.println("Name book equals Clean code");
        for (int index = 0; index < books.length; index++) {
            Book book = books[index];
            if (book.getName().equals("Clean code")) {
                System.out.println(book.getName() + " - " + book.getNumberOfPages());
            }
        }
    }
}