package org.martinada.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class PhoneNumberValidatorTest {
    private PhoneNumberValidator pnv;

    @BeforeEach
    void setUp() { pnv = new PhoneNumberValidator(); }

    @ParameterizedTest
    @DisplayName("Phone Number Validator Test")
    @CsvSource({
            "+447983726126, true",
            "+4479837uyjy56y26126, false",
            "+447342, false",
            "hdishhaysgt, false"
    })
    void shouldBeValidWhenValidPhoneNumberIsParsed(String phoneNumber, boolean expected) {
        boolean result = pnv.isPhoneNumberValid(phoneNumber);
        assertEquals(result, expected);
    }
}