package org.example;

import java.math.BigDecimal;
import java.util.List;

public class BankService {
    public BankAccount createAccount(User user, String accountNumber) {
        BankAccount account = new BankAccount(accountNumber, user);
        user.addAccount(account);
        return account;
    }

    public void transfer(BankAccount source, BankAccount target, BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) < 0) {
            System.out.println("Некорректная сунна для перевода");
        } else if (source.getBalance().compareTo(amount) < 0) {
            System.out.println("Недостаточно средств для перевода");
        }
        source.withdraw(amount);
        target.deposit(amount);
        Transaction transaction = new Transaction(amount, "TRANSFER", source, target);
        source.addTransaction(transaction);
        target.addTransaction(transaction);
    }

    public List<Transaction> getTransactionHistory(BankAccount account) {
        return account.getTransactions();
    }

    public BigDecimal getTotalBalance(User user) {
        List<BankAccount> userAccounts = user.getAccounts();
        BigDecimal total = BigDecimal.ZERO;
        for (BankAccount account : userAccounts) {
            total = total.add(account.getBalance());
        }
        return total;
    }
}
