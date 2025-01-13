package Week9_Bitwise_And_Text_Processing.Lab;

import java.sql.PseudoColumnUsage;
import java.util.Scanner;

public class DigitsLettersAndOther_05 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        StringBuilder digitChars = new StringBuilder();
        StringBuilder alphabeticChars = new StringBuilder();
        StringBuilder miscellaneousChars = new StringBuilder();

        for (char c : input.toCharArray()) {
            if(Character.isDigit(c)) {
                digitChars.append(c);
            } else if (Character.isAlphabetic(c)) {
                alphabeticChars.append(c);
            } else {
                miscellaneousChars.append(c);
            }
        }
        System.out.println(digitChars);
        System.out.println(alphabeticChars);
        System.out.println(miscellaneousChars);
    }
}
