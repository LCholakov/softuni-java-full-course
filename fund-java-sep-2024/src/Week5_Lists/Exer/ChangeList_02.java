package Week5_Lists.Exer;

import java.util.*;
import java.util.stream.Collectors;

public class ChangeList_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numList = Arrays.stream(scanner.nextLine().split(" "))
                                        .map(Integer::parseInt).collect(Collectors.toList());

        while(true) {
            String[] input = scanner.nextLine().split(" ");
            if (input[0].equals("end")) { break; }

            switch (input[0]) {
//                case "Delete" -> numList.removeAll(Collections.singleton(Integer.parseInt(input[1])));
                case "Delete" -> numList.removeIf(e -> e == Integer.parseInt(input[1]));
                case "Insert" -> numList.add(Integer.parseInt(input[2]), Integer.parseInt(input[1]));
            }
        }
        System.out.println(numList.toString().replaceAll("[\\[\\],]", ""));
    }
}
