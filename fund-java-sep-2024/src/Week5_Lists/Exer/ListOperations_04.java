package Week5_Lists.Exer;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListOperations_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numList = Arrays.stream(scanner.nextLine().split(" "))
                                        .map(Integer::parseInt).collect(Collectors.toList());

        while (true) {
            String[] input = scanner.nextLine().split(" ");
            if(input[0].equals("End")) { break; }

            switch (input[0]) {
                case "Add" -> numList.add(Integer.parseInt(input[1]));
                case "Insert" -> {
                    int idx = Integer.parseInt(input[2]);
                    if(idx < 0 || idx >= numList.size()) {
                        System.out.println("Invalid index");
                    } else {
                        numList.add(idx, Integer.parseInt(input[1]));
                    }
                }
                case "Remove" -> {
                    int idx = Integer.parseInt(input[1]);
                    if(idx < 0 || idx >= numList.size()) {
                        System.out.println("Invalid index");
                    } else {
                        numList.remove(idx);
                    }
                }
                case "Shift" -> numList = shiftNum(numList, input[1] , Integer.parseInt(input[2]));
            }
        }

        System.out.println(numList.toString()
                .replaceAll("[\\[\\],]", ""));
    }

    private static List<Integer> shiftNum(List<Integer> list, String direction, int count) {
        if (direction.equals("left")) {
            for (int i = 0; i < count; i++) {
                list.add(list.get(0));
                list.remove(0);
            }
            return list;
        } else if (direction.equals("right")) {
            list.add(0, list.get(list.size() - 1));
            list.remove(list.size() - 1);
        }
        return list;
    }
}
