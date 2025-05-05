package org.example;

import java.util.ArrayList;
import java.util.List;

public class User {
    /**
     * id пользователя
     */
    String id;
    /**
     * Имя пользователя
     */
    String name;
    /**
     * Список счетов пользователя
     */
    List<BankAccount> accounts;

    public User(String id, String name) {
        this.id = id;
        this.name = name;
        this.accounts = new ArrayList<>();
    }

    public void addAccount(BankAccount account) {
        accounts.add(account);
    }

    public List<BankAccount> getAccounts() {
        return new ArrayList<>(accounts);
    }
}
