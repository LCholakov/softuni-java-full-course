package Week3_Conditionals2.Exer;

import java.util.Scanner;

public class SkiTrip_09
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int duration = Integer.parseInt(scanner.nextLine()) - 1; // num days - 1 = num of nights
        String roomType = scanner.nextLine();
        String review = scanner.nextLine();

        double totalPrice = 0.0;

        if (roomType.equals("room for one person"))
        {
            totalPrice = duration * 18.0;
        }
        else if (roomType.equals("apartment"))
        {
            totalPrice = duration * 25.0;
            if (duration > 15)
                totalPrice *= 0.5;
            else if (duration >= 10)
                totalPrice *= 0.65;
            else
                totalPrice *= 0.7;
        }
        else if (roomType.equals("president apartment"))
        {
            totalPrice = duration * 35.0;
            if (duration > 15)
                totalPrice *= 0.8;
            else if (duration >= 10)
                totalPrice *= 0.85;
            else
                totalPrice *= 0.9;
        }

        if (review.equals("positive"))
            totalPrice *= 1.25;
        else if (review.equals("negative"))
            totalPrice *= 0.9;

        System.out.printf("%.2f", totalPrice);
    }
}