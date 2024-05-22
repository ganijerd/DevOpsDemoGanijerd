package ch.zhaw.iwi.devops.demo;

public class PasswordValidator {
    public static boolean isValidLength(String password) {
        return password.length() >= 8;
    }
    public static boolean containsUpperCase(String password) {
        return password.matches(".*[A-Z].*");
    }
    public static boolean containsLowerCase(String password) {
        return password.matches(".*[a-z].*");
    }
}
