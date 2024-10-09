package Week3_Conditionals2.More;

import java.util.Scanner;

public class Vacation_05
{
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        String season = scanner.nextLine();

        String destination = "";
        String accomodation = "";
        double totalPrice = 0.0;

        if (budget <= 1000)
        {
            accomodation = "Camp";
            if (season.equals("Summer"))
                totalPrice = budget * 0.65;
            else if (season.equals("Winter"))
                totalPrice = budget * 0.45;
        }
        else if (budget <= 3000)
        {
            accomodation = "Hut";
            if (season.equals("Summer"))
                totalPrice = budget * 0.8;
            else if (season.equals("Winter"))
                totalPrice = budget * 0.6;
        }
        else
        {
            accomodation = "Hotel";
            totalPrice = budget * 0.9;
        }

        if (season.equals("Summer"))
            destination = "Alaska";
        else if (season.equals("Winter"))
            destination = "Morocco";

        System.out.printf("%s - %s - %.2f", destination, accomodation, totalPrice);
    }
}