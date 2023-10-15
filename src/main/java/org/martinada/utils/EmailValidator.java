package org.martinada.utils;

import java.util.regex.Pattern;

public class EmailValidator {
    private Pattern p;

    public EmailValidator() {
    }

    public boolean isEmailAddressValid(String emailAddress) {
        if (p.matches("^([a-z0-9_\\.\\+-]+)@([\\da-z\\.-]+)\\.([a-z\\.]{2,6})$", emailAddress)) { return true; };
        return false;
    }
}
