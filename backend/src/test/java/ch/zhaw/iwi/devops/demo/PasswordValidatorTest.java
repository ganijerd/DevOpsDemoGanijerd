package ch.zhaw.iwi.devops.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class PasswordValidatorTest {
    @ParameterizedTest
    @CsvSource({
        "Abc123@xyz, true",
        "abc, false",
        "ABC123, false",
        "abc123, false",
        "ABC@XYZ, false",
        "12345678, false",
        "ABCDEFGH, false",
        "abcdefgh, false",
        "@#$%^&*(), false",
        "1234567890, false"
    })
    void testIsValidPassword(String password, boolean expected) {
        assertEquals(expected, PasswordValidator.isValidPassword(password));
    }
}
