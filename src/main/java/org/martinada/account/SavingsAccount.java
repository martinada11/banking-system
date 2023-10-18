package org.martinada.account;

import org.martinada.exceptions.InsufficientFundsException;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;

@Configuration
@ComponentScan
public class SavingsAccount extends Account {
    public SavingsAccount(BigDecimal balance) {
        super(balance);
    }

    @Override
    public void withdraw(BigDecimal amountToWithdraw) throws InsufficientFundsException {
        BigDecimal finalBalance = this.balance.subtract(amountToWithdraw);
        if (finalBalance.compareTo(BigDecimal.valueOf(0)) == -1) {
            throw new InsufficientFundsException(super.getBalance(), amountToWithdraw);
        } else {
            super.setBalance(finalBalance);
        }
    }
}
