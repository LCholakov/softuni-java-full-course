package Week3_Arrays.Exer;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayRotation_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numsArr = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e)).toArray();
        int rotationCount = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < rotationCount; i++) {
            int temp = numsArr[0];
            for (int j = 0; j < numsArr.length - 1; j++) {
                numsArr[j] = numsArr[j + 1];
            }
            numsArr[numsArr.length - 1] = temp;
        }

        for (int n : numsArr) {
            System.out.print(n + " ");
        }
    }
}
