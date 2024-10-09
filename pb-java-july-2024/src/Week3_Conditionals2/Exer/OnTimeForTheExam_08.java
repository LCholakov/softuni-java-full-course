package Week3_Conditionals2.Exer;

import java.util.Scanner;

public class OnTimeForTheExam_08
{
    public static void main(String[] args)
    {
        // inputs
        Scanner scanner = new Scanner(System.in);
        int examHH = Integer.parseInt(scanner.nextLine());
        int examMM = Integer.parseInt(scanner.nextLine());
        int arriveHH = Integer.parseInt(scanner.nextLine());
        int arriveMM = Integer.parseInt(scanner.nextLine());


        int examTimeFromMidnight = examHH * 60 + examMM;        // minutes from midnight
        int arriveTimeFromMidnight = arriveHH * 60 + arriveMM;  // minutes from midnight

        int deltaTimeInMin = examTimeFromMidnight - arriveTimeFromMidnight;

        // convert delta to hh and mm
        int diffHH = 0;
        int diffMM = 0;

        if (Math.abs(deltaTimeInMin) >= 60)
        {
            diffHH = Math.abs(deltaTimeInMin) / 60;
            diffMM = Math.abs(deltaTimeInMin) - diffHH * 60;
        }
        else
        {
            diffMM = Math.abs(deltaTimeInMin);
        }

        if (deltaTimeInMin == 0)
        {
            System.out.println("On time");
        }
        else if (deltaTimeInMin > 0)
        {
            if (deltaTimeInMin > 30)
                System.out.println("Early");
            else
                System.out.println("On time");

            if (diffHH == 0)
                System.out.printf("%d minutes before the start", diffMM);
            else
                System.out.printf("%d:%02d hours before the start", diffHH, diffMM);
        }
        else
        {
            System.out.println("Late");
            if (diffHH == 0)
                System.out.printf("%d minutes after the start", diffMM);
            else
                System.out.printf("%d:%02d hours after the start", diffHH, diffMM);
        }
    }
}