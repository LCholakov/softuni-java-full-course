package Week2_Conditionals1.Exer;

import java.util.Scanner;

public class WorldSwimmingRecord_06
{
    public static void main(String[] args)
    {
        // inputs
        Scanner scanner = new Scanner(System.in);
        double currRecord = Double.parseDouble(scanner.nextLine());
        double distance = Double.parseDouble(scanner.nextLine());
        double time1meter = Double.parseDouble(scanner.nextLine());

        // calcs
        double numDelays = Math.floor(distance / 15);
        double totalDelay = numDelays * 12.5;

        double totalSwimTime = distance * time1meter + totalDelay;

        double result = totalSwimTime - currRecord;
        if (result < 0)
        {
            System.out.printf("Yes, he succeeded! The new world record is %.2f seconds.", totalSwimTime);
        }
        else
        {
            System.out.printf("No, he failed! He was %.2f seconds slower.", result);
        }

    }
}
