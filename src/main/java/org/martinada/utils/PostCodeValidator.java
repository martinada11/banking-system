package org.martinada.utils;

import java.util.regex.Pattern;

public class PostCodeValidator {
    private Pattern p;
    public boolean isPostCodeValid(String postCode) {
        String regexPattern = "^[A-Z]{1,2}\\d[A-Z\\d]? ?\\d[A-Z]{2}$";

        if (postCode == null ) { return false; }

        return p.matches(regexPattern, postCode);

    }
}
