package Week3_Conditionals2.More;

import java.util.Scanner;

public class BikeRace_02
{
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int juniorCount = Integer.parseInt(scanner.nextLine());
        int seniorCount = Integer.parseInt(scanner.nextLine());
        String type = scanner.nextLine();

        double entryFeeJun = 0.0;
        double entryFeeSen = 0.0;
        double result = 0.0;


        if (type.equals("trail"))
        {
            entryFeeJun = 5.5;
            entryFeeSen = 7.0;

        }
        else if (type.equals("cross-country"))
        {
            entryFeeJun = 8.0;
            entryFeeSen = 9.5;
            if (juniorCount + seniorCount >= 50)
            {
                entryFeeJun *= 0.75;
                entryFeeSen *= 0.75;
            }

        }
        else if (type.equals("downhill"))
        {
            entryFeeJun = 12.25;
            entryFeeSen = 13.75;

        }
        else if (type.equals("road"))
        {
            entryFeeJun = 20.0;
            entryFeeSen = 21.5;
        }

        result = (juniorCount * entryFeeJun + seniorCount * entryFeeSen) * 0.95;

        System.out.printf("%.2f", result);
    }
}