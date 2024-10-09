package Week2_Conditionals1.More;

import java.util.Scanner;

public class Pets_05
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int tripTime = Integer.parseInt(scanner.nextLine());
        int preppedFoodQty = Integer.parseInt(scanner.nextLine());
        double dailyDogFood = Double.parseDouble(scanner.nextLine());
        double dailyCatFood = Double.parseDouble(scanner.nextLine());
        double dailyTurtleFood = Double.parseDouble(scanner.nextLine());

        double minFoodQty = tripTime * (dailyDogFood + dailyCatFood + dailyTurtleFood / 1000.0);
        double result = preppedFoodQty - minFoodQty;
        if (result >= 0)
        {
            System.out.printf("%.0f kilos of food left.", Math.floor(result));
        }
        else
        {
            System.out.printf("%.0f more kilos of food are needed.", Math.ceil(Math.abs(result)));
        }
    }
}
