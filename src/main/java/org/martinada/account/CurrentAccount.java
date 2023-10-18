package org.martinada.account;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
@Configuration
@ComponentScan("com.martinada")
public class CurrentAccount extends Account {
    public CurrentAccount(BigDecimal balance) {
        super(balance);
    }
}
