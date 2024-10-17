package Week6_Mid_Exam.Prep2;

import java.util.Arrays;
import java.util.Scanner;

public class ShootForTheWin_02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] numsArr = Arrays
                        .stream(scan.nextLine().split(" "))
                        .mapToInt(e -> Integer.parseInt(e)).toArray();
        int shotCount = 0;

        String input = scan.nextLine();

        while (!input.equals("End")) {
            int idx = Integer.parseInt(input);
            if (idx >= 0 && idx < numsArr.length) {
                int tempVal = numsArr[idx];
                if (tempVal != -1) {
                    numsArr[idx] = -1;
                    shotCount++;

                    for (int i = 0; i < numsArr.length; i++) {
                        if (numsArr[i] == -1) continue;
                        if (numsArr[i] > tempVal) {
                            numsArr[i] -= tempVal;
                        } else {
                            numsArr[i] += tempVal;
                        }
                    }
                }
            }

            input = scan.nextLine();
        }

        System.out.printf("Shot targets: %d -> ", shotCount);
        System.out.println(Arrays.toString(numsArr).replaceAll("[\\[\\],]", ""));
    }
}
