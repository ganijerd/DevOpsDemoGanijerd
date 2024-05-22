package ch.zhaw.iwi.devops.demo;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class PasswordValidatorTest {
    @Test
    void testIsValidLength() {
        assertTrue(PasswordValidator.isValidLength("12345678"));
        assertFalse(PasswordValidator.isValidLength("123"));
        assertTrue(PasswordValidator.isValidLength("1234567890123456"));
    }
    @Test
    void testContainsUpperCase() {
        assertTrue(PasswordValidator.containsUpperCase("Abc"));
        assertFalse(PasswordValidator.containsUpperCase("abc"));
        assertFalse(PasswordValidator.containsUpperCase("1234567890"));
    }
}
