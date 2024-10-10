package Week5_Lists.Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationAdvanced_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numList = Arrays
                .stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());


        while (true) {
            String input = scanner.nextLine();
            if (input.equals("end")) {
                break;
            }
            String[] tokens = input.split(" ");

            switch (tokens[0]) {
                case "Contains" -> printContains(numList, Integer.parseInt(tokens[1]));
                case "Print" -> {
                    if (tokens[1].equals("even")) {
                        printEven(numList);
                    } else if (tokens[1].equals("odd")) {
                        printOdd(numList);
                    }
                }
                case "Get" -> printSum(numList);
                case "Filter" -> printFiltered(numList, tokens[1], Integer.parseInt(tokens[2]));
            }
        }
    }

    private static void printFiltered(List<Integer> list, String condition, int num) {
        switch (condition) {
            case ">" -> {
                for (int i = 0; i < list.size(); i++) {
                    if(list.get(i) > num)
                        System.out.print(list.get(i) + " ");
                }
            }
            case ">=" -> {
                for (int i = 0; i < list.size(); i++) {
                    if(list.get(i) >= num)
                        System.out.print(list.get(i) + " ");
                }
            }
            case "<" -> {
                for (int i = 0; i < list.size(); i++) {
                    if(list.get(i) < num)
                        System.out.print(list.get(i) + " ");
                }
            }
            case "<=" -> {
                for (int i = 0; i < list.size(); i++) {
                    if(list.get(i) <= num)
                        System.out.print(list.get(i) + " ");
                }
            }
        }
        System.out.println();
    }

    private static void printSum(List<Integer> list) {
        int sum = 0;
        for (int n : list) {
            sum += n;
        }
        System.out.println(sum);
    }

    private static void printEven(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % 2 == 0) {
                System.out.print(list.get(i) + " ");
            }
        }
        System.out.println();
    }

    private static void printOdd(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % 2 != 0) {
                System.out.print(list.get(i) + " ");
            }
        }
        System.out.println();
    }

    private static void printContains(List<Integer> list, int n) {
        if (list.contains(n)) {
            System.out.println("Yes");
        } else {
            System.out.println("No such number");
        }
    }
}
