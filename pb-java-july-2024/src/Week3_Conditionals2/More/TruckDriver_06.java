package Week3_Conditionals2.More;

import java.util.Scanner;

public class TruckDriver_06
{
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String season = scanner.nextLine();
        double monthlyDistance = Double.parseDouble(scanner.nextLine());

        double wagePerKm = 0.0;
        double result = 0.0;

        if (season.equals("Spring") || season.equals("Autumn"))
        {
            if (monthlyDistance <= 5000)
                wagePerKm = 0.75;
            else if (monthlyDistance <= 10000)
                wagePerKm = 0.95;
        }
        else if (season.equals("Summer"))
        {
            if (monthlyDistance <= 5000)
                wagePerKm = 0.9;
            else if (monthlyDistance <= 10000)
                wagePerKm = 1.1;
        }
        else if (season.equals("Winter"))
        {
            if (monthlyDistance <= 5000)
                wagePerKm = 1.05;
            else if (monthlyDistance <= 10000)
                wagePerKm = 1.25;
        }

        if (monthlyDistance > 10000)
        {
            wagePerKm = 1.45;
        }

        result = (4 * monthlyDistance * wagePerKm) * 0.9;        // subtract 10% for taxes

        System.out.printf("%.2f", result);
    }
}