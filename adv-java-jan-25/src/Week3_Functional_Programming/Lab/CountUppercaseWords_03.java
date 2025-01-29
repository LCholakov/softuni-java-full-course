package Week3_Functional_Programming.Lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class CountUppercaseWords_03 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Predicate<String> isUpCaseWord = s -> Character.isUpperCase(s.toCharArray()[0]);

        List<String> upCaseList = new ArrayList<>();

        List<String> strList = Arrays.stream(scan.nextLine().split("\\s+"))
        .filter(s -> isUpCaseWord.test(s))
                .toList();

        System.out.println(strList.size());
        strList.forEach(System.out::println);
    }
}
