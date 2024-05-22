package ch.zhaw.iwi.devops.demo;

public class PasswordValidator {
    public static boolean isValidLength(String password) {
        return password.length() >= 8;
    }
}
