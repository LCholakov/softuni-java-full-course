package Week1_BasicSyntaxReview.Exer;

import java.util.Scanner;

public class VendingMachine_07
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        double sum = 0.0;

        while (true) {
            String s = scanner.nextLine();
            if (s.equals("Start")) { break; }

            double d = 0.0;
            d = Double.parseDouble(s);
            if (d != 0.1 && d != 0.2 && d != 0.5 && d != 1 && d != 2) {
                System.out.printf("Cannot accept %.2f%n", d);
            }
            else {
                sum += d;
            }
        }

        double nutsPrice = 2.0;
        double waterPrice = 0.7;
        double crispsPrice = 1.5;
        double sodaPrice = 0.8;
        double cokePrice = 1.0;

        while (true) {
            String s = scanner.nextLine();
            if (s.equals("End")) { break; }
            double itemPrice = 0.0;
            boolean isValidProd = true;
            switch (s) {
                case "Nuts" -> {
                    itemPrice = nutsPrice;
                }
                case "Water" -> {
                    itemPrice = waterPrice;
                }
                case "Crisps" -> {
                    itemPrice = crispsPrice;
                }
                case "Soda" -> {
                    itemPrice = sodaPrice;
                }
                case "Coke" -> {
                    itemPrice = cokePrice;
                }
                default -> {
                    System.out.println("Invalid product");
                    continue;
                }
            }

            if (itemPrice <= sum) {
                sum -= itemPrice;
                System.out.printf("Purchased %s%n", s);
            }
            else {
                System.out.println("Sorry, not enough money");
            }
        }

        System.out.printf("Change: %.2f", sum);
    }
}
