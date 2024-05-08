package gsPractice;

import java.util.Set;

public class PasswordStrength {
    public static void main(String[] args) {
        // String password ="Gfg!@12";
        String password = "Sient@1";
        int score = score(password);
        System.out.println(score);

        if (score == 6 && password.length() > 8) {
            System.out.println("strong");
        } else if (score >= 5) {
            System.out.println("moderate");
        } else {
            System.out.println("weak");
        }
    }


    public static int score(String password) {
        Set<Character> specialCharacters = Set.of(':', '!', '@', '#', '$', '%', '^', '&', '*', '(', ')');
        int score = 0;
        boolean hasSpecialCharacters = false;
        boolean hasDigit = false;
        boolean hasUppercase = false;
        boolean isGreaterThan6 = false;

        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);
            if (!hasSpecialCharacters && specialCharacters.contains(ch)) {
                score += 2;
                hasSpecialCharacters = true;
            }
            if (!hasUppercase && ch >= 65 && ch <= 90) {
                score += 2;
                hasUppercase = true;
            }

            if (!isGreaterThan6 && password.length() >= 6) {
                score += 1;
                isGreaterThan6 = true;
            }
            if (!hasDigit && ch >= 48 && ch <= 57) {
                score += 1;
                hasDigit = true;
            }
        }
        return score;
    }
}
