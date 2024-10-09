package Week1_BasicSyntaxReview.More;

import java.util.Scanner;

public class GamingStore_03
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        float budget = Float.parseFloat(scanner.nextLine());
        float totalSpent = 0.0f;

        float outfall4Price = 39.99f;
        float csogPrice = 15.99f;
        float zplinterzellPrice = 19.99f;
        float honored2Price = 59.99f;
        float roverwatchPrice = 29.99f;
        float roverwatchoriginsPrice = 39.99f;


        while (true) {
            String input = scanner.nextLine();
            if (input.equals("Game Time")) {
                System.out.printf("Total spent: $%.2f. Remaining: $%.2f", totalSpent, budget - totalSpent);
                break;
            }

            float tempPrice;

            switch (input) {
                case "OutFall 4" -> tempPrice = outfall4Price;
                case "CS: OG" -> tempPrice = csogPrice;
                case "Zplinter Zell" -> tempPrice = zplinterzellPrice;
                case "Honored 2" -> tempPrice = honored2Price;
                case "RoverWatch" -> tempPrice = roverwatchPrice;
                case "RoverWatch Origins Edition" -> tempPrice = roverwatchoriginsPrice;
                default -> {
                    System.out.println("Not Found");
                    continue;
                }
            }

            if (tempPrice > budget - totalSpent) {
                System.out.println("Too Expensive");
                continue;
            }

            totalSpent += tempPrice;
            System.out.printf("Bought %s%n", input);

            if (budget - totalSpent == 0) {
                System.out.println("Out of money!");
                break;
            }
        }
    }
}
