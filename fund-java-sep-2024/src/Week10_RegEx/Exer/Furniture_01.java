package Week10_RegEx.Exer;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Furniture_01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
//        String itemRegEx;
//        String priceRegEx;
//        String qtyRegEx;
//
//        Pattern itemPattern = Pattern.compile(itemRegEx);
//        Pattern pricePattern = Pattern.compile(priceRegEx);
//        Pattern qtyPattern = Pattern.compile(qtyRegEx);

        Pattern pattern = Pattern.compile(">>(?<item>[A-Za-z]+)<<(?<price>\\d+(\\.\\d+)?)[!](?<quantity>\\d+)");

        double sum = 0.0;
        System.out.println("Bought furniture:");
        String input = scan.nextLine();
        while (!input.equals("Purchase")) {
            Matcher matcher = pattern.matcher(input);
            if(matcher.find()) {
                String item = matcher.group("item");
                double price = Double.parseDouble(matcher.group("price"));
                int qty = Integer.parseInt(matcher.group("quantity"));

                System.out.println(item);
                sum += price * qty;
            }
            input = scan.nextLine();
        }

        System.out.printf("Total money spend: %.2f", sum);
    }
}
