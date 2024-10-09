package Week2_Conditionals1.More;

import java.util.Scanner;

public class FuelTank_07
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        String fuelType = scanner.nextLine();
        double remainingFuel = Double.parseDouble(scanner.nextLine());

        if (fuelType.equals("Diesel") || fuelType.equals("Gasoline") || fuelType.equals("Gas"))
        {
            if (remainingFuel >= 25)
            {
                System.out.printf("You have enough %s.", fuelType.toLowerCase());
            }
            else
            {
                System.out.printf("Fill your tank with %s!", fuelType.toLowerCase());
            }
        }
        else
        {
            System.out.println("Invalid fuel!");
        }
    }
}
