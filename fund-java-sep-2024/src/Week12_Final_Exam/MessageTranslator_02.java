package Week12_Final_Exam;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MessageTranslator_02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Pattern pattern = Pattern.compile("!(?<command>[A-Z][a-z]{2,})!:\\[(?<message>[A-Za-z]{8,})\\]");
        for (int i = Integer.parseInt(scan.nextLine()); i > 0; i--) {
            String input = scan.nextLine();
            Matcher matcher = pattern.matcher(input);
            if(matcher.find()) {
                String cmd = matcher.group("command");
                String msg = matcher.group("message");
                System.out.print(cmd + ": ");
                for (char c : msg.toCharArray()) {
                    System.out.print((int)c + " ");
                }
                System.out.println();
            } else {
                System.out.println("The message is invalid");
            }
        }
    }
}
