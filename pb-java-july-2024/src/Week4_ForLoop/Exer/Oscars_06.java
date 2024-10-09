package Week4_ForLoop.Exer;

import java.util.Scanner;

public class Oscars_06
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        String actorName = scanner.nextLine();
        double academyPoints = Double.parseDouble(scanner.nextLine());
        int judgeCount = Integer.parseInt(scanner.nextLine());

        double pointsTotal = academyPoints;
        double nominationThreshold = 1250.5;

        for (int i = 0; i < judgeCount; ++i)
        {
            String judgeName = scanner.nextLine();
            double judgePoints = Double.parseDouble(scanner.nextLine());

            pointsTotal += 1.0 * (judgeName.length() * judgePoints) / 2;

            if (pointsTotal > nominationThreshold)
            {
                System.out.printf("Congratulations, %s got a nominee for leading role with %.1f!", actorName, pointsTotal);
                return;
            }
        }

        if (pointsTotal < nominationThreshold)
        {
            System.out.printf("Sorry, %s you need %.1f more!", actorName, nominationThreshold - pointsTotal);
        }
    }
}
