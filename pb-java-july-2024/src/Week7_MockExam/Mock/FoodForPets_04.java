package Week7_MockExam.Mock;

import java.util.Scanner;

public class FoodForPets_04
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int duration = Integer.parseInt(scanner.nextLine());
        double totalFood = Double.parseDouble(scanner.nextLine());
        double dogFoodSum = 0.0;
        double catFoodSum = 0.0;
        double biscuitQty = 0.0;
        for (int i = 1; i <= duration; i++)
        {
            int dailyDogFood = Integer.parseInt(scanner.nextLine());
            int dailyCatFood = Integer.parseInt(scanner.nextLine());

            dogFoodSum += dailyDogFood;
            catFoodSum += dailyCatFood;

            if (i % 3 == 0)
                biscuitQty += 0.1 * (dailyDogFood + dailyCatFood);
        }

        System.out.printf("Total eaten biscuits: %.0fgr.%n", biscuitQty);
        System.out.printf("%.2f%% of the food has been eaten.%n", 100.0 * (dogFoodSum + catFoodSum) / totalFood);
        System.out.printf("%.2f%% eaten from the dog.%n", 100.0 * dogFoodSum / (dogFoodSum + catFoodSum));
        System.out.printf("%.2f%% eaten from the cat.%n", 100.0 * catFoodSum / (dogFoodSum + catFoodSum));
    }
}
