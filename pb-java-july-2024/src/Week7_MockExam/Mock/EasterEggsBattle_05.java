package Week7_MockExam.Mock;

import java.util.Scanner;

public class EasterEggsBattle_05
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int p1eggs = Integer.parseInt(scanner.nextLine());
        int p2eggs = Integer.parseInt(scanner.nextLine());
        String str = scanner.nextLine();

        while (!str.equals("End"))
        {
            switch (str)
            {
                case "one":
                    --p2eggs;
                    break;
                case "two":
                    --p1eggs;
                    break;
                default:
                    break;
            }
            if(p1eggs == 0 || p2eggs == 0) { break; }

            str = scanner.nextLine();
        }

        if (p1eggs == 0)
            System.out.printf("Player one is out of eggs. Player two has %d eggs left.", p2eggs);
        else if (p2eggs == 0)
            System.out.printf("Player two is out of eggs. Player one has %d eggs left.", p1eggs);
        else
        {
            System.out.printf("Player one has %d eggs left.%n", p1eggs);
            System.out.printf("Player two has %d eggs left.%n", p2eggs);
        }
    }
}
