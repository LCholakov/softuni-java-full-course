package Week3_Arrays.More;

import java.util.Arrays;
import java.util.Scanner;

public class LongestIncreasingSubsequence_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numsArr = Arrays
                        .stream(scanner.nextLine().split(" "))
                        .mapToInt(e -> Integer.parseInt(e)).toArray();
        int [] len = new int[numsArr.length];
        int [] prev = new int[numsArr.length];

        for (int i = 0; i < numsArr.length; ++i) {
            if (numsArr.length < 2) {
                System.out.println(numsArr[0]);
                break;
            }
            for (int j = i + 1; j < numsArr.length; j++) {
                if (numsArr[i] < numsArr[j]) {

                }
            }

        }


    }
}
