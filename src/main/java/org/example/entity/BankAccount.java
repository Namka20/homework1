package org.example.entity;

import lombok.Getter;
import org.example.enums.TransactionType;
import org.example.utils.validators.ValidateBalance;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
public class BankAccount {
    /**
     * Номер счета
     */
    private final String accountNumber;
    /**
     * Баланс пользователя
     */
    private BigDecimal balance;
    /**
     * Владелец счета
     */
    private User owner;
    /**
     * История транзакций
     */
    private List<Transaction> transactions;

    ValidateBalance validateBalance = new ValidateBalance();

    /**
     * Констуктор
     *
     * @param accountNumber номер счета
     * @param user          пользователь
     */
    public BankAccount(String accountNumber, User user) {
        this.accountNumber = accountNumber;
        this.balance = BigDecimal.ZERO;
        this.owner = user;
        this.transactions = new ArrayList<>();
    }

    /**
     * Метод пополнения счета
     *
     * @param amount сумма транзакции
     */
    public void deposit(BigDecimal amount) {
       validateBalance.checkAmountOnPositiveSum(amount);
        balance = balance.add(amount);
        Transaction transaction = new Transaction(amount, TransactionType.DEPOSIT, null, this);
        addTransaction(transaction);
    }

    /**
     * Метод снятия средств со счета
     *
     * @param amount сумма снятия
     */
    public void withdraw(BigDecimal amount) {
        validateBalance.checkBalanceCompareToAmountAndOnPositiveSum(balance, amount);
        balance = balance.subtract(amount);
        Transaction transaction = new Transaction(amount, TransactionType.WITHDRAWAL, this, null);
        addTransaction(transaction);
    }

    /**
     * Метод получения текущего баланса
     *
     * @return текущий баланс
     */
    public BigDecimal getBalance() {
        return balance;
    }

    /**
     * Метод добавления транзакцию в историю.
     *
     * @param transaction список транзакций
     */
    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    /**
     * @return
     */
    public List<Transaction> getTransactions() {
        return transactions;
    }

    /**
     * @return
     */
    public String getAccountNumber() {
        return accountNumber;
    }
}