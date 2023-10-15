package org.martinada.utils;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.regex.Pattern;

public class PhoneNumberValidator {
    @Autowired
    private Pattern p;

    public boolean isPhoneNumberValid(String phoneNumber) {
        String regexPattern = "^\\+(?:[0-9] ?){6,14}[0-9]$";

        if ( phoneNumber == null ) { return false; } //guard clause

        return p.matches(regexPattern, phoneNumber);
    }
}
