package Week2_Conditionals1.More;

import java.util.Scanner;

public class SleepyTomCat_02
{
    public static void main(String[] args)
    {
        // input
        Scanner scanner = new Scanner(System.in);
        int restDays = Integer.parseInt(scanner.nextLine());

        int tomMaxPlayTime = 30000;
        int workDays = 365 - restDays;
        int playTime = workDays * 63 + restDays * 127;

        int result = tomMaxPlayTime - playTime;
        int h = Math.abs(result) / 60;
        int m = Math.abs(result) - (h * 60);
        if (result >= 0)
        {
            System.out.println("Tom sleeps well");
            System.out.printf("%d hours and %d minutes less for play", h, m);
        }
        else
        {
            System.out.println("Tom will run away");
            System.out.printf("%d hours and %d minutes more for play", h, m);
        }
    }
}
