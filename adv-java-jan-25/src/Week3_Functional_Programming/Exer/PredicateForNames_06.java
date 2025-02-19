package Week3_Functional_Programming.Exer;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class PredicateForNames_06 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int lenLimit = Integer.parseInt(scan.nextLine());
        Predicate<String> isLongerThan = (s) -> s.length() <= lenLimit;

        List<String> strList = Arrays
                .stream(scan.nextLine().split("\\s+"))
                .filter(isLongerThan)
                .toList();

        strList.forEach(System.out::println);
    }
}
