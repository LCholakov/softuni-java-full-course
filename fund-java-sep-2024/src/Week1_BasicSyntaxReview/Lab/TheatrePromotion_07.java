package Week1_BasicSyntaxReview.Lab;

import java.util.Scanner;

public class TheatrePromotion_07
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        String type = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());
        int ticketPrice = -1;
        switch (type) {
            case "Weekday" -> {
                if ((0 <= age && age <= 18) || (64 < age && age <= 122))
                    ticketPrice = 12;
                else if (18 < age && age <= 64)
                    ticketPrice = 18;
            }
            case "Weekend" -> {
                if ((0 <= age && age <= 18) || (64 < age && age <= 122))
                    ticketPrice = 15;
                else if (18 < age && age <= 64)
                    ticketPrice = 20;
            }
            case "Holiday" -> {
                if (0 <= age && age <= 18)
                    ticketPrice = 5;
                else if (18 < age && age <= 64)
                    ticketPrice = 12;
                else if (64 < age && age <= 122)
                    ticketPrice = 10;
            }
        }

        if (ticketPrice == -1)
            System.out.println("Error!");
        else
            System.out.println(ticketPrice + "$");
    }
}
