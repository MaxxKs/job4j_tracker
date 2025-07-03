package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает модель пользователя банковской системы.
 * Содержит приватные поля пользователя: пасспортные данные и имя.
 * @author Maksim
 * @version 1.0
 */
public class User {
    /**
     * Паспортные данные пользователя.
     */
    private String passport;
    /**
     * Имя пользователя.
     */
    private String username;

    /**
     * Конструктор создает объект User с указанными паспортными данными и именем.
     * @param passport пасспортные данные текущего пользователя
     * @param username имя текущего пользователя
     */
    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * Метод позволяет получить паспортные данные текущего пользователя.
     * @return паспортные данные пользователя.
     */
    public String getPassport() {
        return passport;
    }

    /**
     * Метод принимает на вход новые паспортные данные пользователя.
     * @param passport новые паспортные данные, которые присваиваются текущему пользователю
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * Метод позволяет получить имя текущего пользователя.
     * @return имя пользователя
     */
    public String getUsername() {
        return username;
    }

    /**
     * Метод принимает на вход новое имя пользователя.
     * @param username новое имя, которое присваивается текущему пользователю
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Сравнивает текущего пользователя с переданным пользователем на равенство по паспортным данным .
     * @param o другой пользователь для сравнения
     * @return {@code true}, если объекты представляют одиного и тогоже пользователя по паспорту,
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
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    /**
     * Вычисляет хеш-код пользователя на основе его паспортных данных.
     * @return хеш-код паспортных данных
     */
    @Override
    public int hashCode() {
        return Objects.hashCode(passport);
    }
}