package org.example.entity;

import java.util.ArrayList;
import java.util.List;

public class User {
    /**
     * Индифкатор пользователя
     */
    private String id;
    /**
     * Имя пользователя
     */
    private String name;
    /**
     * Список счетов пользователя
     */
    private List<BankAccount> accounts;

    /**
     * Конструктор
     *
     * @param id   индивификатор пользователя
     * @param name имя пользователя
     */
    public User(String id, String name) {
        this.id = id;
        this.name = name;
        this.accounts = new ArrayList<>();
    }

    /**
     * Метод добавления нового счета пользователю
     *
     * @param account счет пользователя
     */
    public void addAccount(BankAccount account) {
        accounts.add(account);
    }

    /**
     * Метод возвращения списока счетов пользователя.
     *
     * @return список счетов позователя
     */
    public List<BankAccount> getAccounts() {
        return new ArrayList<>(accounts);
    }
}
