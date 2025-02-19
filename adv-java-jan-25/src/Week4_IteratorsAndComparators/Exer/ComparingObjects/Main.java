package Week4_IteratorsAndComparators.Exer.ComparingObjects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Person> persList = new ArrayList<>();

        String [] input = scan.nextLine().split("\\s+");
        while (!input[0].equals("END")) {
            String name = input[0];
            int age = Integer.parseInt(input[1]);
            String town = input[2];
            Person p = new Person(name, age, town);
            persList.add(p);

            input = scan.nextLine().split("\\s+");
        }

        int targetIdx = Integer.parseInt(scan.nextLine());
        if(targetIdx < persList.size()) {
            Person target = persList.get(targetIdx);
            int matchCount = 0;
            for (Person p : persList) {
                if (p.compareTo(target) == 0) {
                    matchCount++;
                }
            }
            if (matchCount > 1) {
                System.out.printf("%d %d %d", matchCount, persList.size() - matchCount, persList.size());
            } else {
                System.out.println("No matches");
            }
        } else {
            System.out.println("No matches");
        }
        System.out.println();
    }
}
