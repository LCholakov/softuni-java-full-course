package Week10_RegEx.Lab;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchFullName_01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

//        String[] nameArr = scan.nextLine().split(", ");
//
//        for(String s : nameArr) {
//            if (s.matches("\\b[A-Z][a-z]+ [A-Z][a-z]+\\b"))
//                System.out.print(s + " ");
//        }

        String input = scan.nextLine();

        String regex = "\\b[A-Z][a-z]+ [A-Z][a-z]+\\b";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        while(matcher.find()) {
            System.out.print(matcher.group() + ' ');
        }
    }
}
