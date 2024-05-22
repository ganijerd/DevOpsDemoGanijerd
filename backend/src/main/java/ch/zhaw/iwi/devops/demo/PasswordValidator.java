package ch.zhaw.iwi.devops.demo;

public class PasswordValidator {
    private static final int MIN_LENGTH = 8;
    private static final String UPPER_CASE = "[A-Z]";
    private static final String LOWER_CASE = "[a-z]";
    private static final String DIGIT = "\\d";
    private static final String SPECIAL_CHAR = "[!@#$%^&*()_+=\\-\\[\\]\\{\\};':\",.<>\\/?]";

    public static boolean isValidPassword(String password) {
        if (password.length() < MIN_LENGTH) return false;
        
        boolean hasUpperCase = false;
        boolean hasLowerCase = false;
        boolean hasDigit = false;
        boolean hasSpecialChar = false;

        for (char c : password.toCharArray()) {
            String ch = String.valueOf(c);
            if (!hasUpperCase && ch.matches(UPPER_CASE)) hasUpperCase = true;
            if (!hasLowerCase && ch.matches(LOWER_CASE)) hasLowerCase = true;
            if (!hasDigit && ch.matches(DIGIT)) hasDigit = true;
            if (!hasSpecialChar && ch.matches(SPECIAL_CHAR)) hasSpecialChar = true;

            if (hasUpperCase && hasLowerCase && hasDigit && hasSpecialChar) return true;
        }
        
        return false;
    }
}
