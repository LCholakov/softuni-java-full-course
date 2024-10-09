package Week4_ForLoop.More;

import java.util.Scanner;

public class FootballLeague_07
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int capacity = Integer.parseInt(scanner.nextLine());
        int visitorsCount = Integer.parseInt(scanner.nextLine());

        double countA = 0.0;
        double countB = 0.0;
        double countC = 0.0;
        double countD = 0.0;

        double percA = 0.0;
        double percB = 0.0;
        double percC = 0.0;
        double percD = 0.0;
        double percFromCapacity = 100.0 * visitorsCount / capacity;

        for (int i = 0; i < visitorsCount; i++)
        {
            switch (scanner.nextLine().charAt(0))
            {
                case 'A':
                    ++countA;
                    break;
                case 'B':
                    ++countB;
                    break;
                case 'V':
                    ++countC;
                    break;
                case 'G':
                    ++countD;
                    break;
            }
        }

        percA = 100.0 * countA / visitorsCount;
        percB = 100.0 * countB / visitorsCount;
        percC = 100.0 * countC / visitorsCount;
        percD = 100.0 * countD / visitorsCount;

        System.out.printf("%.2f%%%n", percA);
        System.out.printf("%.2f%%%n", percB);
        System.out.printf("%.2f%%%n", percC);
        System.out.printf("%.2f%%%n", percD);
        System.out.printf("%.2f%%%n", percFromCapacity);
    }
}
