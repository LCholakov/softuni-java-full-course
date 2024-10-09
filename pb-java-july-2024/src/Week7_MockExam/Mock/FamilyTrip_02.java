package Week7_MockExam.Mock;

import java.util.Scanner;

public class FamilyTrip_02
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        int duration = Integer.parseInt(scanner.nextLine());
        double price = Double.parseDouble(scanner.nextLine());
        double extraExpense = Double.parseDouble(scanner.nextLine()) / 100.0;

        if (duration > 7)
            price *= 0.95;

        double result = budget - (duration * price + budget * extraExpense);

        if (result < 0)
            System.out.printf("%.2f leva needed.", Math.abs(result));
        else
            System.out.printf("Ivanovi will be left with %.2f leva after vacation.", result);
    }
}
