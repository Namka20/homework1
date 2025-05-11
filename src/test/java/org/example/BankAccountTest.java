package org.example;
import org.example.entity.BankAccount;
import org.example.entity.Transaction;
import org.example.entity.User;
import org.example.enums.TransactionType;
import org.example.exception.BalanceException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Unit test for simple App.
 */
public class BankAccountTest {
    private User user;
    private BankAccount account;

    @BeforeEach
    public void setUp() {
        User user = new User("user1", "John Doe");
        account = new BankAccount("ACC123", user);
    }
@Test
    public void deposit_ShouldIncreaseBalance() {
        account.deposit(new BigDecimal("1000"));
        assertEquals(new BigDecimal("1000"), account.getBalance());
    }
@Test
    public void deposit_NegativeAmount_ShouldThrowException() {
        assertThrows(BalanceException.class, () -> {
            account.deposit(new BigDecimal("-100"));
        });
    }
    @Test
    public void withdraw_ShouldDecreaseBalanced () {
        account.deposit(new BigDecimal("1000"));
        account.withdraw(new BigDecimal("500"));
        assertEquals(new BigDecimal("500"), account.getBalance());
    }
    @Test
    public void withdren_InsufficientFunds_ShouldThrowException() {
        account.deposit(new BigDecimal("100"));
        assertThrows(BalanceException.class, () -> {
            account.withdraw(new BigDecimal("200"));
        });
    }
    @Test
    public void addTransaction_ShouldIncreaseTransactionHistorySize() {
        Transaction transaction = new Transaction(
                new BigDecimal("100"),
                TransactionType.DEPOSIT,
                null,
                account);
        account.addTransaction(transaction);
        assertEquals(1, account.getTransactions().size());
    }
}