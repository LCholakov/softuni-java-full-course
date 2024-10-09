package Week3_Arrays.Exer;

import java.util.Arrays;
import java.util.Scanner;

public class EqualSums_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numsArr = Arrays
                        .stream(scanner.nextLine().split(" "))
                        .mapToInt(e -> Integer.parseInt(e)).toArray();

        int sumL = 0;
        int sumR = 0;

        for (int i = 0; i < numsArr.length; i++) {

            for (int j = 0; j < i; j++) {
                sumL += numsArr[j];
            }
            for (int j = i + 1; j < numsArr.length; j++) {
                sumR += numsArr[j];
            }
            if (sumL == sumR) {
                System.out.println(i);
                break;
            } else {
                sumL = 0;
                sumR = 0;
            }
            if (i == numsArr.length - 1)
                System.out.println("no");
        }
    }
}
