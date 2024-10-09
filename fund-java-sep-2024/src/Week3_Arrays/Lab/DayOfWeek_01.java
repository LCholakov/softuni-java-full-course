package Week3_Arrays.Lab;

import java.util.Scanner;

public class DayOfWeek_01
{
    public static void main(String[] args)
    {
        String [] daysOfWeek = { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday" };

        Scanner scanner = new Scanner(System.in);
        short n = Short.parseShort(scanner.nextLine());
        if (1 <= n && n <= 7)
            System.out.println(daysOfWeek[n-1]);
        else
            System.out.println("Invalid day!");

    }
}
