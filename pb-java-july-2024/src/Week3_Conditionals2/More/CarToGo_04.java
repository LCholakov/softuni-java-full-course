package Week3_Conditionals2.More;

import java.util.Scanner;

public class CarToGo_04
{
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        String season = scanner.nextLine();

        String rentalClass = "";
        String vehicleType = "";
        double rentalPrice = 0.0;

        if (budget <= 100)
        {
            rentalClass = "Economy class";
            if (season.equals("Summer"))
            {
                vehicleType = "Cabrio";
                rentalPrice = budget * 0.35;
            }
            else if (season.equals("Winter"))
            {
                vehicleType = "Jeep";
                rentalPrice = budget * 0.65;
            }
        }
        else if (budget <= 500)
        {
            rentalClass = "Compact class";
            if (season.equals("Summer"))
            {
                vehicleType = "Cabrio";
                rentalPrice = budget * 0.45;
            }
            else if (season.equals("Winter"))
            {
                vehicleType = "Jeep";
                rentalPrice = budget * 0.8;
            }
        }
        else
        {
            rentalClass = "Luxury class";
            vehicleType = "Jeep";
            rentalPrice = budget * 0.9;
        }

        System.out.printf("%s\n", rentalClass);
        System.out.printf("%s - %.2f", vehicleType, rentalPrice);
    }
}