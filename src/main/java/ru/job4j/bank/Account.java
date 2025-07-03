package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает модель банковского счета.
 * Эта модель содержит два приватных поля: баланс и реквизиты.
 * @author Maksim
 * @version 1.0
 */
public class Account {
    /**
     * Реквизиты банковского счета.
     */
    private String requisite;
    /**
     * Баланс на счете.
     */
    private double balance;

    /**
     * Конструктор создает объкт Account с указанными реквизитами и начальным балансом.
     * @param requisite реквизиты текущего счета
     * @param balance начальный баланс текущего счета
     */
    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * Метод позволяет получить реквизиты текщего счета.
     * @return возвращает реквизиты счета
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * Метод принимает на вход новые реквизиты счета пользователя.
     * @param requisite новые реквизиты счета, которые присваиваются текущему счету
     */
    public void setRrquisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * Метод позволяет получить баланс текущего счета.
     * @return возвращает баланс счета
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Метод принимает на вход новый баланс счета.
     * @param balance новый баланс, который присваивается текущему счету
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Сравнивает текущий счёт с переданным счетом на равенство по реквизитам.
     * @param o другой счет для сравнения
     * @return {@code true}, если объекты представляют один и тот же счёт по реквизитам,
     * иначе {@code false}
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    /**
     * Вычисляет хеш-код счёта на основе его реквизитов.
     * @return хеш-код реквизитов счёта
     */
    @Override
    public int hashCode() {
        return Objects.hashCode(requisite);
    }
}