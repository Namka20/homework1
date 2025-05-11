package org.example.entity;

import org.example.enums.TransactionType;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class Transaction {
    /**
     * Идентификатор транзакции
     */
    private final String id;
    /**
     * Сумма транзакции
     */
    private final BigDecimal amount;
    /**
     * Тип транзакции
     */
    private final TransactionType type;
    /**
     * Дата выполнения транзакции
     */
    private final LocalDateTime date;
    /**
     * Источник транзакции
     */
    private final BankAccount sourceAccount;
    /**
     * Получатель транзакции
     */
    private final BankAccount targetAccount;

    /**
     * Конструктор
     *
     * @param amount        сумма транзакции
     * @param type          тип транзакции
     * @param sourceAccount источник транзакции
     * @param targetAccount получатель транзакции
     */
    public Transaction(BigDecimal amount, TransactionType type, BankAccount sourceAccount, BankAccount targetAccount) {
        this.id = UUID.randomUUID().toString();
        this.amount = amount;
        this.type = type;
        this.sourceAccount = sourceAccount;
        this.targetAccount = targetAccount;
        this.date = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id='" + id + '\'' +
                ", amount=" + amount +
                ", type=" + type.getDescription() + '\'' +
                ", date=" + date +
                ", sourceAccount=" + (sourceAccount != null ? sourceAccount.getAccountNumber() : "null") +
                ", targetAccount=" + (targetAccount != null ? targetAccount.getAccountNumber() : "null") +
                '}';
    }
}