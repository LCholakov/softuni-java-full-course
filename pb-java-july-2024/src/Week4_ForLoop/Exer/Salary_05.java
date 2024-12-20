package Week4_ForLoop.Exer;

import java.util.Scanner;

public class Salary_05
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int salary = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; ++i)
        {
            switch (scanner.nextLine())
            {
                case "Facebook":
                    salary -= 150;
                    break;
                case "Instagram":
                    salary -= 100;
                    break;
                case "Reddit":
                    salary -= 50;
                    break;
                default:
                    break;
            }

            if (salary <= 0)
            {
                System.out.println("You have lost your salary.");
                return;
            }
        }
        if(salary > 0)
        {
            System.out.println(salary);
        }
    }
}
