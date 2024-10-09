package Week3_Conditionals2.Lab;

import java.util.Scanner;

public class CinemaTicket_08
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        String dow = scanner.nextLine();

        switch (dow)
        {
            case "Monday":
            case "Tuesday":
            case "Friday":
                System.out.println(12);
                break;
            case "Wednesday":
            case "Thursday":
                System.out.println(14);
                break;
            case "Saturday":
            case "Sunday":
                System.out.println(16);
                break;
            default:
                break;
        }
    }
}
