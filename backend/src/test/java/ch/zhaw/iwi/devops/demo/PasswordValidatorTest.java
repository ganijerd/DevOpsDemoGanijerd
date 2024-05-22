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
    @Test
    void testContainsLowerCase() {
        assertTrue(PasswordValidator.containsLowerCase("abc"));
        assertFalse(PasswordValidator.containsLowerCase("ABC"));
        assertFalse(PasswordValidator.containsLowerCase("1234567890"));
    }
    @Test
    void testContainsDigit() {
        assertTrue(PasswordValidator.containsDigit("abc123"));
        assertFalse(PasswordValidator.containsDigit("abc"));
        assertFalse(PasswordValidator.containsDigit("ABCDEFGH"));
    }
    @Test
    void testContainsSpecialChar() {
        assertTrue(PasswordValidator.containsSpecialChar("abc@"));
        assertFalse(PasswordValidator.containsSpecialChar("abc"));
        assertFalse(PasswordValidator.containsSpecialChar("1234567890"));
    }
    @Test
    void testIsValidPassword() {
        assertTrue(PasswordValidator.isValidPassword("Abc123@xyz"));
        assertFalse(PasswordValidator.isValidPassword("abc"));
        assertFalse(PasswordValidator.isValidPassword("ABC123"));
        assertFalse(PasswordValidator.isValidPassword("abc123"));
        assertFalse(PasswordValidator.isValidPassword("ABC@XYZ"));
    }
}
