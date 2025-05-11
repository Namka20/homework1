package org.example.utils.validators;

import org.example.exception.BalanceException;

import java.math.BigDecimal;

/**
 * Утильный класс для валидации баланса
 */
public class ValidateBalance {
    /**
     * Метой для проверки средств на отрицательную приходящую сумму
     *
     * @param amount сумма транзакции
     */
    public void checkAmountOnPositiveSum(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new BalanceException("Сумма должна быть положительной");
        }
    }

    /**
     * Метой проверки денежных средств при совершении операции
     *
     * @param amount сумма транзакции
     */
    public void checkBalanceCompareToAmount(BigDecimal balance, BigDecimal amount) {
        if (balance.compareTo(amount) < 0) {
            throw new BalanceException("Недостаточно средств на счете");
        }
    }

    /**
     * Объединенный метод для проверки денежных средств при совершении операции
     *
     * @param balance текущий баланс
     * @param amount  сумма транзакции
     */
    public void checkBalanceCompareToAmountAndOnPositiveSum(BigDecimal balance, BigDecimal amount) {
        checkAmountOnPositiveSum(amount);
        checkBalanceCompareToAmount(balance, amount);
    }
}
