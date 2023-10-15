package org.martinada.utils;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class EmailValidatorTest {
    private EmailValidator emailValidator;

    @BeforeEach
    void setUp() { emailValidator = new EmailValidator();}

    @Test
    @DisplayName("Valid email address test")
    public void shouldPassWhenGivenAValidEmailAddress() {
        String emailAddress = "testaddress@outlook.com";

        boolean result = emailValidator.isEmailAddressValid(emailAddress);

        assertTrue(result);
    }

    @ParameterizedTest
    @DisplayName("Invalid email address test")
    @CsvSource({
            "@outlook.com",
            "test_testout@lookcom",
            "test_testoutlook.com",
            "test_testoutlookcom"
    })
    public void shouldFailWhenGivenAnInvalidEmailAddress(String emailAddress) {
        boolean result = emailValidator.isEmailAddressValid(emailAddress);

        assertFalse(result);
    }

}
