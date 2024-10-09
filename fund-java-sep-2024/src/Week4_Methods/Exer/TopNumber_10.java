package Week4_Methods.Exer;

import java.util.Scanner;

public class TopNumber_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        printTopNums(Integer.parseInt(scanner.nextLine()));

    }

    private static void printTopNums(int n) {
        for (int i = 1; i <= n; i++) {
            int tempi = i;
            int sumDigits = 0;
            boolean containsOddDigit = false;
            while (tempi > 0) {
                int digit = tempi % 10;
                tempi /= 10;
                sumDigits += digit;
                if (!containsOddDigit && digit % 2 != 0) {
                    containsOddDigit = true;
                }
            }
            if (sumDigits % 8 == 0 && containsOddDigit) {
                System.out.println(i);
            }
        }
    }
}
