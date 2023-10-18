package org.martinada.account;

import org.martinada.exceptions.InsufficientFundsException;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.util.Date;

@Configuration
@ComponentScan("com.martinada")
public class Account {
    private final Integer accId;
    protected BigDecimal balance;
    private static Integer totalAccounts = 0;
    Date dateAccountCreated;

    public Account(BigDecimal balance) {
        totalAccounts++;
        this.accId = totalAccounts + 1;
        this.balance = balance;
    }

    public Integer getAccId() {
        return accId;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    protected void setBalance(BigDecimal newBalance) { this.balance = newBalance; }

    public void deposit(BigDecimal amountToDeposit) {
        this.balance = amountToDeposit.add(this.balance);
    }

    public void withdraw(BigDecimal amountToWithdraw) throws InsufficientFundsException {
        this.balance = this.balance.subtract(amountToWithdraw);
    }
}
