package Week10_RegEx.Exer;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SoftUniBarIncome_02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

//        Pattern pattern = Pattern.compile("%(?<name>[A-Z][a-z]+)[^\\$]*%[^\\$]*<[^\\$]*(?<item>[A-Z][a-z]+)>[^\\$]*\\|[^\\$]*(?<qty>\\d+)[^\\$]*\\|[^\\$0-9]*(?<price>\\d+(\\.\\d+)?)\\$");
        Pattern pattern = Pattern.compile("(?<name>%[A-Z][a-z]+%)[^\\$]*[^\\$]*<[^\\$]*(?<item>[A-Z][a-z]+)>[^\\$]*\\|[^\\$^0-9]*(?<qty>\\d+)[^\\$]*\\|[^\\$0-9]*(?<price>\\d+(\\.\\d+)?)\\$");

        double sum = 0.0;
        String input = scan.nextLine();
        while (!input.equals("end of shift")) {
            Matcher matcher = pattern.matcher(input);
            if(matcher.find()) {
//                String name = matcher.group("name");
                String name = matcher.group("name");
                name = name.substring(1, name.length() - 1);
                String item = matcher.group("item");
                int qty = Integer.parseInt(matcher.group("qty"));
                double price = Double.parseDouble(matcher.group("price"));
                System.out.printf("%s: %s - %.2f%n", name, item, 1.0 * qty * price);

                sum += qty * price;
            }

            input = scan.nextLine();
        }
        System.out.printf("Total income: %.2f", sum);
    }
}
