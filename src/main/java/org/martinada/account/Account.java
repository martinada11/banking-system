package org.martinada.account;

import org.martinada.exceptions.InsufficientFundsException;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.time.LocalDate;

@Configuration
@ComponentScan("com.martinada")
public class Account {
    private Integer accId = 0;
    protected BigDecimal balance;
    private static Integer totalAccounts = 0;
    LocalDate dateAccountCreated;

    public Account() {}

    public Account(BigDecimal balance) {
        totalAccounts++;
        this.accId = totalAccounts + 1;
        this.balance = balance;

        this.dateAccountCreated = LocalDate.now();
    }

    public Integer getAccId() {
        return accId;
    }

    public LocalDate getDateAccountCreated() {
        return dateAccountCreated;
    }

    public void setDateAccountCreated(LocalDate dateAccountCreated) {
        this.dateAccountCreated = dateAccountCreated;
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

    @Override
    public String toString() {
        return "Account{" +
                "accId=" + accId +
                ", balance=" + balance +
                ", dateAccountCreated=" + dateAccountCreated +
                '}';
    }
}
