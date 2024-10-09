package Week1.Exer;

import java.util.Scanner;

public class VacationBooksList_04
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int pageCount = Integer.parseInt(scanner.nextLine());
        int pagesPerHour = Integer.parseInt(scanner.nextLine());
        int maxDayCount = Integer.parseInt(scanner.nextLine());

        int hoursPerDay = pageCount / pagesPerHour / maxDayCount;

        System.out.println(hoursPerDay);
    }
}
