package Week10_RegEx.Lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchDates_03 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        String regex = "\\b(?<day>\\d{2})([-./])(?<month>[A-Z][a-z]{2})\\2(?<year>\\d{4})\\b";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

//        List<String> matchedDates = new ArrayList<>();
        while(matcher.find()) {
//            matchedDates.add(matcher.group());

            String day = matcher.group("day");
            String month = matcher.group("month");
            String year = matcher.group("year");

            System.out.printf("Day: %s, Month: %s, Year: %s%n", day, month, year);
        }
//        for (String s : matchedDates) {
//            printDate(s);
//        }
    }

//    static void printDate(String s) {
//        String[] dateArr = s.split("[-./]");
//        System.out.printf("Day: %s, Month: %s, Year: %s%n", dateArr[0], dateArr[1], dateArr[2]);
//
//    }
}
