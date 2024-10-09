package Week3_Conditionals2.Exer;

import java.util.Scanner;

public class HotelRoom_07
{
    public static void main(String[] args)
    {
        // inputs
        Scanner scanner = new Scanner(System.in);
        String month = scanner.nextLine();
        int duration = Integer.parseInt(scanner.nextLine());

        double apartmentTotal = 0.0;
        double studioTotal = 0.0;

        if (month.equals("May") || month.equals("October"))
        {
            apartmentTotal = duration * 65.0;
            studioTotal = duration * 50.0;
            if (duration > 14) { studioTotal *= 0.7; }
            else if (duration > 7) { studioTotal *= 0.95; }
        }
        else if (month.equals("June") || month.equals("September"))
        {
            apartmentTotal = duration * 68.7;
            studioTotal = duration * 75.2;
            if (duration > 14) { studioTotal *= 0.8; }
        }
        else if (month.equals("July") || month.equals("August"))
        {
            apartmentTotal = duration * 77.0;
            studioTotal = duration * 76.0;
        }

        if (duration > 14) { apartmentTotal *= 0.9; }

        System.out.printf("Apartment: %.2f lv.\n", apartmentTotal);
        System.out.printf("Studio: %.2f lv.\n", studioTotal);
    }
}