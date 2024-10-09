package Week7_MockExam.Exam1;

import java.util.Scanner;

public class ExcursionCalculator_03
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int nSouls = Integer.parseInt(scanner.nextLine());
        String season = scanner.nextLine();
        double result = 0.0;

        if (nSouls > 5)
        {
            if (season.equals("spring"))
                result = nSouls * 48;
            else if (season.equals("summer"))
                result = nSouls * 45.0 * 0.85;
            else if (season.equals("autumn"))
                result = nSouls * 49.5;
            else if (season.equals("winter"))
                result = nSouls * 85.0 * 1.08;
        }
        else
        {
            if (season.equals("spring"))
                result = nSouls * 50;
            else if (season.equals("summer"))
                result = nSouls * 48.5 * 0.85;
            else if (season.equals("autumn"))
                result = nSouls * 60;
            else if (season.equals("winter"))
                result = nSouls * 86.0 * 1.08;
        }

        System.out.printf("%.2f leva.", result);
    }
}
