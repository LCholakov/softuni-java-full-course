package Week3_Conditionals2.Exer;

import java.util.Scanner;

public class Journey_05
{
    public static void main(String[] args)
    {
        // inputs
        Scanner scanner = new Scanner(System.in);
        double budget = Double.parseDouble(scanner.nextLine());
        String season = scanner.nextLine();

        // globals
        String destination = "";
        String accomodation = "";
        double totalPrice = 0.0;

        // set accomodation
        if(season.equals("summer")) { accomodation = "Camp"; }
        else if(season.equals("winter")) { accomodation = "Hotel"; }

        // set destination and total price (and reset accomodation for europe)
        if (budget <= 100)
        {
            destination = "Bulgaria";
            if (season.equals("summer"))
                totalPrice = budget * 0.3;
            else if (season.equals("winter"))
                totalPrice = budget * 0.7;
        }
        else if (budget <= 1000)
        {
            destination = "Balkans";
            if (season.equals("summer"))
                totalPrice = budget * 0.4;
            else if (season.equals("winter"))
                totalPrice = budget * 0.8;
        }
        else
        {
            destination = "Europe";
            accomodation = "Hotel";
            totalPrice = budget * 0.9;
        }

        // output
        System.out.printf("Somewhere in %s\n", destination);
        System.out.printf("%s - %.2f", accomodation, totalPrice);
    }
}