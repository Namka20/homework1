package org.example.enums;

public enum TransactionType {
    DEPOSIT("Пополнение"),
    WITHDRAWAL("Снятие"),
    TRANSFER("Перевод");
    private String description;

    TransactionType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public boolean isDeposit() {
        return this == DEPOSIT;
    }

    public boolean isWithdrawal() {
        return this == WITHDRAWAL;
    }

    public boolean isTransfer() {
        return this == TRANSFER;
    }
}
