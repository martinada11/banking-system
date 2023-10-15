package org.martinada.account;

import java.math.BigDecimal;

public class Account {
    private final Integer accId;
    private BigDecimal balance;
    private static Integer totalAccounts = 0;

    public Account(BigDecimal balance) {
        totalAccounts++;
        this.accId = totalAccounts;
        this.balance = balance;
    }

    public Integer getAccId() {
        return accId;
    }

    public BigDecimal getBalance() {
        return balance;
    }
}
