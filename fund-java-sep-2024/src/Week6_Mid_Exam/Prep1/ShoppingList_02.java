package Week6_Mid_Exam.Prep1;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ShoppingList_02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<String> list = Arrays.stream(scan.nextLine().split("!")) .collect(Collectors.toList());
        String input = scan.nextLine();

        while (!input.equals("Go Shopping!")) {
            String[] command = input.split(" ");

            switch (command[0]) {
                case "Urgent" -> addUrgentItem(list, command[1]);
                case "Unnecessary" -> removeUnnecessaryItem(list, command[1]);
                case "Correct" -> EditItem(list, command[1], command[2]);
                case "Rearrange" -> rearrangeItem(list, command[1]);
            }

            input = scan.nextLine();
        }
        System.out.println(list.toString().replaceAll("[\\[\\]]", ""));
    }

    private static void addUrgentItem(List<String> list, String s) {
        if (!list.contains(s)) {
            list.add(0, s);
        }
    }

    private static void removeUnnecessaryItem(List<String> list, String s) {
        list.remove(s);
    }

    private static void EditItem(List<String> list, String s, String s1) {
        if (list.contains(s)) {
            list.set(list.indexOf(s), s1);
        }
    }

    private static void rearrangeItem(List<String> list, String s) {
        if (list.contains(s)) {
            list.remove(s);
            list.add(s);
        }
    }
}
