package Week6_Mid_Exam.Exam2;

import java.util.Arrays;
import java.util.Scanner;

public class ArcheryChampion_03 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] numsArr = Arrays
                        .stream(scan.nextLine().split("\\|"))
                        .mapToInt(e -> Integer.parseInt(e)).toArray();
        int pointsTotal = 0;

        String input = scan.nextLine();
        while (!input.equals("Game over")) {
            String[] instruction = input.split("@");

            switch  (instruction[0]) {
                case "Shoot Left" -> {
                    if (Integer.parseInt(instruction[1]) >= 0
                            && Integer.parseInt(instruction[1]) < numsArr.length) {
                        int idx = Integer.parseInt(instruction[1]) - Integer.parseInt(instruction[2]);
                        while (idx < 0)
                            idx = numsArr.length + idx;
                        if (numsArr[idx] < 5) {
                            pointsTotal += numsArr[idx];
                            numsArr[idx] = 0;
                        } else {
                            pointsTotal += 5;
                            numsArr[idx] -= 5;
                        }
                    }
                }
                case "Shoot Right" -> {
                    if (Integer.parseInt(instruction[1]) >= 0
                            && Integer.parseInt(instruction[1]) < numsArr.length) {
                        int idx = Integer.parseInt(instruction[1]) + Integer.parseInt(instruction[2]);
                        while (idx > numsArr.length - 1)
                            idx = idx - numsArr.length;
                        if (numsArr[idx] < 5) {
                            pointsTotal += numsArr[idx];
                            numsArr[idx] = 0;
                        } else {
                            pointsTotal += 5;
                            numsArr[idx] -= 5;
                        }
                    }
                }
                case "Reverse" -> {
                    int temp;
                    for (int i = 0; i < numsArr.length / 2; i++) {
                        temp = numsArr[i];
                        numsArr[i] = numsArr[numsArr.length - i - 1];
                        numsArr[numsArr.length - i - 1] = temp;
                    }
                }
            }

            input = scan.nextLine();
        }

        System.out.println(Arrays.toString(numsArr).replaceAll("[\\[\\]]", "").replaceAll("[,]", " -"));
        System.out.printf("John finished the archery tournament with %d points!", pointsTotal);
    }
}
