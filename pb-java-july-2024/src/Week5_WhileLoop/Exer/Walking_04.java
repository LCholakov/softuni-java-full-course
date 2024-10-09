package Week5_WhileLoop.Exer;

import java.util.Scanner;

public class Walking_04

{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int sum = 0;
        int goal = 10000;
        int steps = 0;
        while (sum < goal)
        {
            String str = scanner.nextLine();
            if (str.equals("Going home"))
            {
                steps = Integer.parseInt(scanner.nextLine());
                sum += steps;
                break;
            }
            else
            {
                steps = Integer.parseInt(str);
                sum += steps;
            }
        }

        if (sum >= goal)
        {
            System.out.println("Goal reached! Good job!");
            System.out.printf("%d steps over the goal!", sum - goal);
        }
        else
        {
            System.out.printf("%d more steps to reach goal.", goal - sum);
        }
    }
}
