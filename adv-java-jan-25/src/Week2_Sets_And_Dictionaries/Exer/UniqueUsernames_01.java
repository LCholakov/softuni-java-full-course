package Week2_Sets_And_Dictionaries.Exer;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class UniqueUsernames_01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Set<String> strSet = new LinkedHashSet<>();
        for (int i = Integer.parseInt(scan.nextLine()); i > 0; i--) {
            strSet.add(scan.nextLine());
        }

        strSet.forEach(System.out::println);
    }
}
