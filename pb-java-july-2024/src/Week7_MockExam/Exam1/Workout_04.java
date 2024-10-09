package Week7_MockExam.Exam1;

import java.util.Scanner;

public class Workout_04
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int nDays = Integer.parseInt(scanner.nextLine());
        double nKm = Double.parseDouble(scanner.nextLine());
        double totalKm = nKm;

        for (int i = 0; i < nDays; i++)
        {
            nKm *= (1 + Double.parseDouble(scanner.nextLine()) / 100.0);
            totalKm += nKm;
        }

        double result = totalKm - 1000;
        if (result < 0)
            System.out.printf("Sorry Mrs. Ivanova, you need to run %.0f more kilometers", Math.ceil(Math.abs(result)));
        else
            System.out.printf("You've done a great job running %.0f more kilometers!", Math.ceil(result));
    }
}
