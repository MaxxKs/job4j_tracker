package ru.job4j.oop;

public class Calculator {
    private static int x = 5;

    public static int sum(int a) {
        return x + a;
    }

    public static int minus(int b) {
        return x - b;
    }

    public int multiply(int c) {
        return x * c;
    }

    public int divide(int d) {
        return d / x;
    }

    public int sumAllOperation(int a, int b, int c, int d) {
        return sum(a) + minus(b) + multiply(c) + divide(d);
    }

    public static void main(String[] args) {
        int resultSum = sum(10);
        System.out.println("result sum: " + resultSum);

        int resultMinus = minus(15);
        System.out.println("result minus: " + resultMinus);

        Calculator calculator = new Calculator();
        int result = calculator.multiply(5);
        System.out.println(result);

        int resultDivide = calculator.divide(20);
        System.out.println("result divide: " + resultDivide);

        int resultSumAll = calculator.sumAllOperation(10, 15, 5, 20);
        System.out.println("result sumAll: " + resultSumAll);
        }
    }
