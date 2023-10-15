package org.martinada.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class PostCodeValidatorTest {
    private PostCodeValidator pv;

    @BeforeEach
    void setUp() { pv = new PostCodeValidator(); }

    @ParameterizedTest
    @DisplayName("PostCode Validation Test")
    @CsvSource({
            "E1 2NN, true",
            "WC1N 4DI, true",
            "SE7 7DG, true",
            "WC1N 4DI, true",
            "CW3 9SS, true",
            "SE5 0EG, true",
            "se5 0eg, false",
            "aWC2H 7LT, false",
            "WC2H 7LTa, false",
            "WC2H, false",
            "wc2h, false"
    })
    void shouldReturnValidatePostCodeCorrectly(String postCode, boolean expected) {
        boolean result = pv.isPostCodeValid(postCode);

        assertEquals(result, expected);
    }
}