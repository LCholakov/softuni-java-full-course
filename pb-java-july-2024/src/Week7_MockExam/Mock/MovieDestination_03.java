package Week7_MockExam.Mock;

import java.util.Scanner;

public class MovieDestination_03
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        String location = scanner.nextLine();
        String season = scanner.nextLine();
        int duration = Integer.parseInt(scanner.nextLine());
        double totalCost = 0.0;

        if (location.equals("Dubai"))
        {
            if(season.equals("Winter"))
                totalCost = 0.7 * 45000 * duration;
            else
                totalCost = 0.7 * 40000 * duration;
        }
        else if (location.equals("Sofia"))
        {
            if(season.equals("Winter"))
                totalCost = 1.25 * 17000 * duration;
            else
                totalCost = 1.25 * 12500 * duration;
        }
        else if (location.equals("London"))
        {
            if(season.equals("Winter"))
                totalCost = 24000 * duration;
            else
                totalCost = 20250 * duration;
        }

        double  result = budget - totalCost;

        if (result < 0)
            System.out.printf("The director needs %.2f leva more!", Math.abs(result));
        else
            System.out.printf("The budget for the movie is enough! We have %.2f leva left!", result);
    }
}
