package Week5_Lists.Lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationBasics_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numList = Arrays
                                .stream(scanner.nextLine().split(" "))
                                .map(Integer::parseInt).collect(Collectors.toList());


        while (true) {
            String input = scanner.nextLine();
            if(input.equals("end")) { break; }
            String[] tokens = input.split(" ");

            switch (tokens[0]) {
                case "Add" -> numList.add(Integer.parseInt(tokens[1]));
                case "Remove" -> numList.remove(Integer.valueOf(Integer.parseInt(tokens[1])));
                case "RemoveAt" -> numList.remove(Integer.parseInt(tokens[1]));
                case "Insert" -> numList.add(Integer.parseInt(tokens[2]), Integer.parseInt(tokens[1]));
            }
        }

        System.out.println(numList.toString()
                .replaceAll("[\\[\\],]", ""));
    }
}
