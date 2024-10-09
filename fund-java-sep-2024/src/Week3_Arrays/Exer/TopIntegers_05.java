package Week3_Arrays.Exer;

import java.util.Arrays;
import java.util.Scanner;

public class TopIntegers_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numsArr = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e)).toArray();


        for (int i = 0; i < numsArr.length; i++) {
            boolean isTop = true;
            for (int j = i + 1; j < numsArr.length; j++) {
                if(numsArr[i] < numsArr[j]) {
                    isTop = false;
                    break;
                }
            }

            if (isTop)
                System.out.print(numsArr[i] + " ");
        }
    }
}
