package Week2_Sets_And_Dictionaries.Lab;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SoftUniParty_02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Set<String> vip = new TreeSet<>();
        Set<String> regular = new TreeSet<>();

        String input = scan.nextLine();

        while (!input.equals("PARTY")) {

            char c = input.charAt(0);

            if (Character.isDigit(c)) {
                vip.add(input);
            } else {
                regular.add(input);
            }
            input = scan.nextLine();
        }

        input = scan.nextLine();

        while (!input.equals("END")) {

            vip.remove(input);
            regular.remove(input);
            input = scan.nextLine();
        }

        System.out.println(vip.size() + regular.size());
        vip.forEach(System.out::println);
        regular.forEach(System.out::println);
    }
}
