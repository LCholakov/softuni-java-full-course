package Week3_Arrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class EvenAndOddSubtraction_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numsArr = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e)).toArray();

        int sumOdd = 0;
        int sumEven = 0;

        for (int num : numsArr) {
            if (num % 2 == 0)
                sumEven += num;
            else
                sumOdd += num;
        }
        System.out.println(sumEven - sumOdd);
    }
}
