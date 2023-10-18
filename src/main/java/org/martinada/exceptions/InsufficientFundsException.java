package org.martinada.exceptions;

import java.math.BigDecimal;

public class InsufficientFundsException extends Throwable {

    private BigDecimal accountBalance;
    private BigDecimal withdrawalAmount;

    public InsufficientFundsException(BigDecimal accountBalance, BigDecimal withdrawalAmount) {
        super(String.format("Withdrawal attempt of %s not possible. /nCurrent balance: %s", withdrawalAmount.toString(), accountBalance.toString()));
        this.accountBalance = accountBalance;
        this.withdrawalAmount = withdrawalAmount;
    }

}
