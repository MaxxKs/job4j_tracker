package ru.job4j.bank;

import ru.job4j.bank.Account;
import ru.job4j.bank.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает работу сервиса для управления пользователями банка и
 * их банковскими счетами.
 * Класс предоставляет методы для добавления и удаления пользователей,
 * добавления пользовательского банковского счета, перевода денежных средств
 * с одного банковского счета на другой счет.
 * @author Maksim
 * @version 1.0
 */
public class BankService {
    /**
     * Хранение осуществляется в коллекции типа HashMap, где ключем является
     * пользователь (User),а значением коллекция типа List, содержащая его счета (Account).
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод принимает на вход пользователя, которого добавляет в систему,
     * если он не был добавлен ранее.
     * @param user пользователь для добавления в систему
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Метод принимает на вход паспортные данные, по которым будет
     * производить поиск и удаление.
     * Если пользователь с указанным паспортом отсутствует, операция игнорируется.
     * @param passport паспортные данные пользователя для удаления
     */
    public void deleteUser(String passport) {
        users.remove(new User(passport, ""));
    }

    /**
     * Метод принимает на вход паспортные данные, по которым производит поиск пользователя
     * и добаление ему передаваемого в параметрах счета.
     * Если счёт с такими реквизитами уже существует, добавление не происходит.
     * @param passport паспортные данные владельца счета
     * @param account счет, который добавляется, при его отсутвии у пользователя
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            if (!accounts.contains(account))  {
                accounts.add(account);
            }
        }
    }

    /**
     * Метод принимает на вход паспортные данные, по которым
     * производит поиск пользователя в системе.
     * @param passport паспортные данные для поиска
     * @return возвращает пользователя при его наличии в системе, в
     * остальных случаях null
     */
    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
               return user;
            }
        }
        return null;
    }

    /**
     * Метод принимает на вход паспортные данные и реквизиты счета, по которым
     * производит производит поиск счета пользователя.
     * @param passport паспортные данные владельца счета
     * @param requisite реквизиты счета для поиска
     * @return возвращает счет пользователя при его наличии у данного пользователя,
     * иначе null
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            for (Account account : users.get(user)) {
                if (account.getRequisite().equals(requisite)) {
                    return account;
                }
            }
        }
        return null;
    }

    /**
     * Метод принимает на вход паспортны данные и реквизиты счета отправителя, который
     * переводит переданную в параметрах сумму по реквизитам и паспорту получателя.
     * Проверяет наличие обоих счетов и достаточность средств на источнике.
     * @param sourcePassport паспортные даныне отправителя
     * @param sourceRequisite реквизиты счета отправителя
     * @param destinationPassport паспортные данные получателя
     * @param destinationRequisite реквизиты счета получателя
     * @param amount сумма перевода
     * @return если перевод выполнен успешно, то возвращает true, иначе false
     */
    public boolean transferMoney(String sourcePassport, String sourceRequisite,
                                 String destinationPassport, String destinationRequisite,
                                 double amount) {
        Account sourceAccount = findByRequisite(sourcePassport, sourceRequisite);
        Account destinationAccount = findByRequisite(destinationPassport, destinationRequisite);
        if (sourceAccount != null && destinationAccount != null
                && sourceAccount.getBalance() >= amount) {
            sourceAccount.setBalance(sourceAccount.getBalance() - amount);
            destinationAccount.setBalance(destinationAccount.getBalance() + amount);
            return true;
        }
        return false;
    }

    /**
     * Метод принимает на вход пользователя, по которому возвращает список
     * всех значений (счетов).
     * @param user передаваемый для поиска пользователь
     * @return возвращает список счетов пользователя, но если
     * пользователь не найден метод вернет null
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}