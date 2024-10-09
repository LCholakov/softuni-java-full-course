package Week4_ForLoop.Exer;

import java.util.Scanner;

public class TennisRanklist_08
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int numTournaments = Integer.parseInt(scanner.nextLine());
        int initialPoints = Integer.parseInt(scanner.nextLine());

        int pointsTotal = 0;
        int pointsEarned = 0;
        int avgPoints = 0;
        double winRate = 0.0;
        int numWins = 0;

        for (int i = 0; i < numTournaments; ++i)
        {
            switch (scanner.nextLine())
            {
                case "W":
                    pointsEarned += 2000;
                    numWins += 1;
                    break;
                case "F":
                    pointsEarned += 1200;
                    break;
                case "SF":
                    pointsEarned += 720;
                    break;
                default:
                    break;
            }
        }
        avgPoints = pointsEarned / numTournaments;
        winRate = 100.0 * numWins / numTournaments;
        pointsTotal = initialPoints + pointsEarned;

        System.out.printf("Final points: %d%n", pointsTotal);
        System.out.printf("Average points: %d%n", avgPoints);
        System.out.printf("%.2f%%", winRate);
    }
}
