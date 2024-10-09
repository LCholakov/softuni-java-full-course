package Week3_Arrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class EqualArrays_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numsArr1 = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e)).toArray();
        int[] numsArr2 = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e)).toArray();

        int sum = 0;
        for (int i = 0; i < numsArr1.length; i++) {
            if (numsArr1[i] == numsArr2[i]) {
                sum += numsArr1[i];
                if(i == numsArr1.length - 1) {
                    System.out.printf("Arrays are identical. Sum: %d", sum);
                }
            } else {
                System.out.printf("Arrays are not identical. Found difference at %d index.", i);
                break;
            }
        }
    }
}
