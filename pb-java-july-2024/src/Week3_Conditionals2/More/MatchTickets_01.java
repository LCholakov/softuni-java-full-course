package Week3_Conditionals2.More;

import java.util.Scanner;

public class MatchTickets_01
{
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        String type = scanner.nextLine();
        int headCount = Integer.parseInt(scanner.nextLine());

        double ticketPrice = 0.0;
        if (type.equals("VIP")) { ticketPrice = 499.99; }
        else if (type.equals("Normal")) { ticketPrice = 249.99; }

        double totalPrice = headCount * ticketPrice;

        double travelCost = 0.0;
        double result = 0.0;

        if (1 <= headCount && headCount <= 4)
            travelCost = budget * 0.75;
        else if (5 <= headCount && headCount <= 9)
            travelCost = budget * 0.6;
        else if (10 <= headCount && headCount <= 24)
            travelCost = budget * 0.5;
        else if (25 <= headCount && headCount <= 49)
            travelCost = budget * 0.4;
        else if (50 <= headCount)
            travelCost = budget * 0.25;

        result = budget - ticketPrice * headCount - travelCost;

        if (result >= 0)
        {
            System.out.printf("Yes! You have %.2f leva left.", result);
        }
        else
        {
            System.out.printf("Not enough money! You need %.2f leva.", Math.abs(result));
        }
    }
}