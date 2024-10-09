package Week3_Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayModifier_09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numsArr = Arrays
                        .stream(scanner.nextLine().split(" "))
                        .mapToInt(e -> Integer.parseInt(e)).toArray();

        String command[] = scanner.nextLine().split(" ");
        while (!command[0].equals("end")){
            switch (command[0]) {
                case "swap" -> {
                    int idx1 = Integer.parseInt(command[1]);
                    int idx2 = Integer.parseInt(command[2]);
                    int temp = numsArr[idx1];
                    numsArr[idx1] = numsArr[idx2];
                    numsArr[idx2] = temp;
                }
                case "multiply" -> {
                    int idx1 = Integer.parseInt(command[1]);
                    int idx2 = Integer.parseInt(command[2]);
                    numsArr[idx1] = numsArr[idx1] * numsArr[idx2];
                }
                case "decrease" -> {
                    for (int i = 0; i < numsArr.length; i++) {
                        --numsArr[i];
                    }
                }
            }

            command = scanner.nextLine().split(" ");
        }
//        for (int n : numsArr) {
//            System.out.print(n + ", ");
//        }
//        System.out.println(Arrays.toString(numsArr).replaceAll("\\[|\\]|,|\\s", ""));
        System.out.println(Arrays
                .stream(numsArr)
                .mapToObj(String::valueOf)
                .reduce((a, b) -> a.concat(", ").concat(b))
                .get());
    }
}
