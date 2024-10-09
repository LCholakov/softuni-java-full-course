package Week1_BasicSyntaxReview.Exer;

import java.util.Scanner;

public class Vacation_03
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String type = scanner.nextLine();
        String day = scanner.nextLine();

        double price = 0.0;
        double total = 0.0;


        switch (type) {
            case "Students" -> {
                if (day.equals("Friday")) { price = 8.45; }
                else if (day.equals("Saturday")) { price = 9.8; }
                else if (day.equals("Sunday")) { price = 10.46; }
                if (n >= 30) { price *= 0.85; }
            }
            case "Business" -> {
                if (day.equals("Friday")) { price = 10.9; }
                else if (day.equals("Saturday")) { price = 15.6; }
                else if (day.equals("Sunday")) { price = 16.0; }
                if (n >= 100) { n -= 10; }
            }
            case "Regular" -> {
                if (day.equals("Friday")) { price = 15.0; }
                else if (day.equals("Saturday")) { price = 20.0; }
                else if (day.equals("Sunday")) { price = 22.5; }
                if (10 <= n && n <= 20) { price *= 0.95; }
            }
        }

        total = n * price;

        System.out.printf("Total price: %.2f", total);
    }
}
