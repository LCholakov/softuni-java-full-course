package Week3_Conditionals2.Lab;

import java.util.Scanner;

public class WorkingHours_07
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int tod = Integer.parseInt(scanner.nextLine());     // time of day
        String dow = scanner.nextLine();                    // day of week

        if (tod >= 10 && tod <= 18 && !dow.equals("Sunday"))
        {
            System.out.println("open");
        }
        else
        {
            System.out.println("closed");
        }

    }
}
