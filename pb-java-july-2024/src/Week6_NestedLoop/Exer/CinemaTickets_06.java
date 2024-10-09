package Week6_NestedLoop.Exer;

import java.util.Scanner;

public class CinemaTickets_06
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        String movieTitle = scanner.nextLine();
        String ticketType = "";
        int availSeats = 0;
        int currTicketCount = 0;
        double currMoviePercent = 0.0;
        int studentCount = 0;
        int standardCount = 0;
        int kidCount = 0;
        int totalTicketCount = 0;

        while (!movieTitle.equals("Finish"))
        {
            availSeats = Integer.parseInt(scanner.nextLine());
            ticketType = scanner.nextLine();
            while (!ticketType.equals("End"))
            {
                switch (ticketType)
                {
                    case "student":
                        ++studentCount;
                        break;
                    case "standard":
                        ++standardCount;
                        break;
                    case "kid":
                        ++kidCount;
                        break;
                }
                ++currTicketCount;
                if (currTicketCount == availSeats) { break; }
                ticketType = scanner.nextLine();
            }
            System.out.printf("%s - %.2f%% full.%n", movieTitle, 100.0 * currTicketCount / availSeats);

            currTicketCount = 0;
            movieTitle = scanner.nextLine();
        }

        totalTicketCount = studentCount + standardCount + kidCount;

        System.out.println("Total tickets: " + totalTicketCount);
        System.out.printf("%.2f%% student tickets.%n", 100.0 * studentCount / totalTicketCount);
        System.out.printf("%.2f%% standard tickets.%n", 100.0 * standardCount / totalTicketCount);
        System.out.printf("%.2f%% kids tickets.%n", 100.0 * kidCount / totalTicketCount);
    }
}
