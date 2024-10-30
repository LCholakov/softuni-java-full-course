package Week6_Mid_Exam.Exam2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PaintingsNumbers_03 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> numList = Arrays.stream(scan.nextLine().split(" "))
                                        .map(Integer::parseInt).collect(Collectors.toList());

        String[] input = scan.nextLine().split(" ");
        while (!input[0].equalsIgnoreCase("end")) {
            switch (input[0]) {
                case "Change" -> {
                    int num1 = Integer.parseInt(input[1]);
                    if (numList.contains(num1))
                        numList.set(numList.indexOf(num1), Integer.parseInt(input[2]));
                }
                case "Hide" -> {
                    int num = Integer.parseInt(input[1]);
                    if (numList.contains(num)) {
                        numList.remove((Integer) num);
                    }
                }
                case "Switch" -> {
                    int num1 = Integer.parseInt(input[1]);
                    int num2 = Integer.parseInt(input[2]);
                    if (numList.contains(num1) && numList.contains(num2)) {
                        int idx1 = numList.indexOf(num1);
                        int idx2 = numList.indexOf(num2);
                        numList.set(idx1, num2);
                        numList.set(idx2, num1);
                    }
                }
                case "Insert" ->{
                    int idx = Integer.parseInt(input[1]);
                    if (idx >= 0 && idx < numList.size()) {
                        numList.add(idx + 1, Integer.parseInt(input[2]));
                    }
                }
                case "Reverse" -> {
                    Collections.reverse(numList);
                }
            }

            input = scan.nextLine().split(" ");
        }

        System.out.println(numList.toString().replaceAll("[\\[\\],]", ""));
    }
}
