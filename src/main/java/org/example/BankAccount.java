package org.example;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    /**
     * Номер счета
     */
    String accountNumber;
    /**
     * Баланс пользователя
     */
    BigDecimal balance;
    /**
     * Владелец счета
     */
    User owner;
    /**
     * История транзакций
     */
    List<Transaction> transactions;

    public BankAccount(String accountNumber, User user) {
        this.accountNumber = accountNumber;
        this.balance = BigDecimal.ZERO;
        this.owner = user;
        this.transactions = new ArrayList<>();

    }

    public void deposit(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            System.out.println("Сумма должна быть >0");
        }
        balance = balance.add(amount);
        Transaction transaction = new Transaction(amount, "DEPOSIT", null, this);
        addTransaction(transaction);
    }

    public void withdraw(BigDecimal amount) {
        if (balance.compareTo(BigDecimal.ZERO) <= 0) {
            System.out.println("Недостаточно средств");
            balance = balance.subtract(amount);
            Transaction transaction = new Transaction(amount, "WITHDRAWAL", this, null);
            addTransaction(transaction);
        }
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
}