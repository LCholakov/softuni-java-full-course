package Week1_BasicSyntaxReview.Exer;

import java.util.Scanner;

public class Orders_09
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        double total = 0.0;

        for (int i = 0; i < n; i++)
        {
            double price = Double.parseDouble(scanner.nextLine());
            int dayCount = Integer.parseInt(scanner.nextLine());
            int capCount = Integer.parseInt(scanner.nextLine());

            double orderAmount = price * dayCount * capCount;
            total += orderAmount;
            System.out.printf("The price for the coffee is: $%.2f%n", orderAmount);
        }
        System.out.printf("Total: $%.2f", total);
    }
}
