package org.example.service;

import org.example.entity.BankAccount;
import org.example.entity.Transaction;
import org.example.entity.User;
import org.example.enums.TransactionType;
import org.example.utils.validators.ValidateBalance;

import java.math.BigDecimal;
import java.util.List;


public class BankService {
    ValidateBalance validateBalance = new ValidateBalance();

    /**
     * Метод создания нового счета для пользователя.
     *
     * @param user пользователь
     * @param accountNumber номер счета
     * @return новый счет пользователя
     */
    public BankAccount createAccount(User user, String accountNumber) {
        BankAccount account = new BankAccount(accountNumber, user);
        user.addAccount(account);
        return account;
    }

    /**
     * Метод перевода средств между счетами
     *
     * @param source источник транзакции
     * @param target получатель транзакции
     * @param amount сумма транзакции
     */
    public void transfer(BankAccount source, BankAccount target, BigDecimal amount) {
        validateBalance.checkBalanceCompareToAmountAndOnPositiveSum(source.getBalance(), amount);
        source.withdraw(amount);
        target.deposit(amount);
        Transaction transaction = new Transaction(amount, TransactionType.TRANSFER, source, target);
        source.addTransaction(transaction);
        target.addTransaction(transaction);
    }

    /**
     * Метод возвращает историю транзакций для указанного счета.
     *
     * @param account сумма транзакции
     * @return списко транзакций
     */
    public List<Transaction> getTransactionHistory(BankAccount account) {
        return account.getTransactions();
    }

    /**
     * Метод возвращения общего баланса всех счетов пользователя.
     *
     * @param user пользователь
     * @return баланс со всех счетов
     */
    public BigDecimal getTotalBalance(User user) {
        List<BankAccount> userAccounts = user.getAccounts();
        BigDecimal total = BigDecimal.ZERO;
        for (BankAccount account : userAccounts) {
            total = total.add(account.getBalance());
        }
        return total;
    }
}
