package Week1_BasicSyntaxReview.Lab;

import java.util.Scanner;

public class TimeAfter30Minutes_04
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int h = Integer.parseInt(scanner.nextLine());
        int m = Integer.parseInt(scanner.nextLine()) + 30;

        if (m > 59)
        {
            ++h;
            m -= 60;
        }
        if (h > 23)
        {
            h -= 24;
        }

        System.out.printf("%d:%02d", h, m);
    }
}
