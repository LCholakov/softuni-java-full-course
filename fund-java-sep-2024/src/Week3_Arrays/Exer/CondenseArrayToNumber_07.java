package Week3_Arrays.Exer;

import java.util.Arrays;
import java.util.Scanner;

public class CondenseArrayToNumber_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numsArr = Arrays
                        .stream(scanner.nextLine().split(" "))
                        .mapToInt(e -> Integer.parseInt(e)).toArray();

        for (int i = 0; i < numsArr.length - 1; i++) {
            for (int j = 0; j < numsArr.length - 1; j++) {
                numsArr[j] = numsArr[j] + numsArr[j + 1];
            }
            numsArr[numsArr.length - i - 1] = 0;
//            System.out.println(Arrays.toString(numsArr));
        }
        System.out.println(numsArr[0]);
    }
}
