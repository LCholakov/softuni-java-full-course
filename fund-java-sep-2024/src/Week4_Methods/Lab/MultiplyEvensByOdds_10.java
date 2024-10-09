package Week4_Methods.Lab;

import java.util.Scanner;

public class MultiplyEvensByOdds_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(sumOddEvenDigits(Integer.parseInt(scanner.nextLine())));
    }

    private static int sumOddEvenDigits(int n) {
        n = Math.abs(n);
        int sumOdd = 0;
        int sumEven = 0;
        while (n > 0) {
            int digit = n % 10;
            if (digit % 2 == 0) {
                sumEven += digit;
            } else {
                sumOdd += digit;
            }
            n /= 10;
        }
        return sumEven * sumOdd;
    }
}
