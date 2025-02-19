package Week3_Generics.Exer.CustomList_07;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        CustomList <String> custList = new CustomList<>();

        while(true) {
            String[] tokens = scan.nextLine().split("\\s+");
            if (tokens[0].equals("END")) { break; }
            switch(tokens[0]) {
                case "Add" -> custList.add(tokens[1]);
                case "Remove" -> custList.remove(Integer.parseInt(tokens[1]));
                case "Contains" -> System.out.println(custList.contains(tokens[1]));
                case "Swap" -> custList.swap(Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]));
                case "Greater" -> System.out.println(custList.countGreaterThan(tokens[1]));
                case "Max" -> System.out.println(custList.getMax());
                case "Min" -> System.out.println(custList.getMin());
                case "Print" -> {
                    System.out.println(custList.toString());
//                    for (int i = 0; i < custList.size; i++) {
//
//                    }
                }

            }
        }
    }
}
