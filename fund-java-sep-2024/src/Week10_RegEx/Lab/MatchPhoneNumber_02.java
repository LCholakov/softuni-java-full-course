package Week10_RegEx.Lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchPhoneNumber_02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        String regex = "\\+359([ -])2\\1[\\d]{3}\\1[\\d]{4}\\b";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        String output = "";
        List<String> matchedPhoneNums = new ArrayList<>();
        while(matcher.find()) {
//            output = output + matcher.group() + ", ";
            matchedPhoneNums.add(matcher.group());
        }

//        output = output.substring(0, output.length()-2);
//        System.out.println(output);

        System.out.println(String.join(", ", matchedPhoneNums));
    }
}
