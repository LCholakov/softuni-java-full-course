package Week3_Conditionals2.More;

import java.util.Scanner;

public class SchoolCamp_07
{
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String season = scanner.nextLine();
        String groupType = scanner.nextLine();
        int headCount = Integer.parseInt(scanner.nextLine());
        int duration = Integer.parseInt(scanner.nextLine());    //num nights

        String sportType = "";
        double accommodationPrice = 0.0;
        double result = 0.0;

        if (season.equals("Winter"))
        {
            switch (groupType)
            {
                case "boys":
                    accommodationPrice = 9.6;
                    sportType = "Judo";
                    break;
                case "girls":
                    accommodationPrice = 9.6;
                    sportType = "Gymnastics";
                    break;
                case "mixed":
                    accommodationPrice = 10.0;
                    sportType = "Ski";
                    break;
                default:
                    break;
            }

        }
        else if (season.equals("Spring"))
        {
            switch (groupType)
            {
                case "boys":
                    accommodationPrice = 7.2;
                    sportType = "Tennis";
                    break;
                case "girls":
                    accommodationPrice = 7.2;
                    sportType = "Athletics";
                    break;
                case "mixed":
                    accommodationPrice = 9.5;
                    sportType = "Cycling";
                    break;
                default:
                    break;
            }
        }
        else if (season.equals("Summer"))
        {
            switch (groupType)
            {
                case "boys":
                    accommodationPrice = 15.0;
                    sportType = "Football";
                    break;
                case "girls":
                    accommodationPrice = 15.0;
                    sportType = "Volleyball";
                    break;
                case "mixed":
                    accommodationPrice = 20.0;
                    sportType = "Swimming";
                    break;
                default:
                    break;
            }
        }

        if (headCount >= 50) { accommodationPrice *= 0.5; }
        else if (headCount >= 20) { accommodationPrice *= 0.85; }
        else if (headCount >= 10) { accommodationPrice *= 0.95; }

        result = headCount * duration * accommodationPrice;

        System.out.printf("%s %.2f lv.", sportType, result);
    }
}