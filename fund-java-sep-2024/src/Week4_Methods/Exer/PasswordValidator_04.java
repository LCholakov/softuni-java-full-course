package Week4_Methods.Exer;

import java.util.Scanner;

public class PasswordValidator_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        validatePassword(scanner.nextLine());
    }

    private static void validatePassword(String s) {
         boolean pwdIsValid = true;
        if(s.length() < 6 || s.length() > 10) {
            pwdIsValid = false;
            System.out.println("Password must be between 6 and 10 characters");
        }

        byte digitCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isAlphabetic(s.charAt(i)) && !Character.isDigit(s.charAt(i))) {
                pwdIsValid = false;
                System.out.println("Password must consist only of letters and digits");
                break;
            }
            if (Character.isDigit(s.charAt(i))) {
                digitCount++;
            }
        }
        if(digitCount < 2) {
            pwdIsValid = false;
            System.out.println("Password must have at least 2 digits");
        }

        if(pwdIsValid) {
            System.out.println("Password is valid");
        }
    }
}
