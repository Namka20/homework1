package org.example;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class Transaction {
    /**
     * id транзакции
     */
    String id;
    /**
     * Сумма транзакции
     */
    BigDecimal amount;
    /**
     * Тип транзакции
     */
    String type;
    /**
     * Дата выполнения транзакции
     */
    LocalDateTime date;
    /**
     * Источник транзакции
     */
    BankAccount sourceAccount;
    /**
     * Получатель транзакции
     */
    BankAccount targetAccount;

    public Transaction(BigDecimal amount, String type, BankAccount sourceAccount, BankAccount targetAccount) {
        this.id = UUID.randomUUID().toString();
        this.amount = amount;
        this.type = type;
        this.sourceAccount = sourceAccount;
        this.targetAccount = targetAccount;
        this.date = LocalDateTime.now();
    }

    public String toString() {
        return "Traansaction{" +
                "id= " + id +
                " amount=" + amount +
                " date=" + date +
                " sourceAccount=" + (sourceAccount != null ? sourceAccount.getAccountNumber() : "null") +
                " targetAccount=" + (targetAccount != null ? targetAccount.getAccountNumber() : "null") + "}";
    }
}