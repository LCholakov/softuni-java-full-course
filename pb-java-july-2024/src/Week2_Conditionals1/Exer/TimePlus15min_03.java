package Week2_Conditionals1.Exer;

import java.util.Scanner;

public class TimePlus15min_03
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int hour = Integer.parseInt(scanner.nextLine());
        int min = Integer.parseInt(scanner.nextLine());

        int addedTime = 15;

        if (min < 45)
        {
            min += addedTime;
        }
        else
        {
            hour ++;
            if (hour > 23)
            {
                hour = 0;
            }
            min = Math.abs(60 - min - addedTime);

        }

        System.out.printf("%d:%02d", hour, min);
    }
}
