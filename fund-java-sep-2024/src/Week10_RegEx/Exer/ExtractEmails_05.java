package Week10_RegEx.Exer;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractEmails_05 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String emailRegex = "(^|\\s)([\\dA-Za-z]([\\.\\-_]*[\\dA-Za-z])*)@([A-Za-z]+([-]*[\\dA-Za-z])*(\\.[A-Za-z]+([-]*[\\dA-Za-z])*)+)";

        String input = scan.nextLine();
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            System.out.println(matcher.group().substring(1));
        }
    }
}
