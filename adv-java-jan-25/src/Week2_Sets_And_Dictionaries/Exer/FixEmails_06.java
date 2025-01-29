package Week2_Sets_And_Dictionaries.Exer;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails_06 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, String> mailMap = new LinkedHashMap<>();

        String input = scan.nextLine();
        while (!input.equals("stop")) {
            String mailAddr = scan.nextLine();
            String [] mailAddrArr = mailAddr.split("\\.");
            String domain = mailAddrArr[mailAddrArr.length - 1];
            if (!domain.equals("us") && !domain.equals("uk") && !domain.equals("com")) {
                mailMap.put(input, mailAddr);
            }
            input = scan.nextLine();
        }

        mailMap.forEach((k, v) -> System.out.println(k + " -> " + v));
    }
}
