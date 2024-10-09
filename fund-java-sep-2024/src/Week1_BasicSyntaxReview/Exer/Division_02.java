package Week1_BasicSyntaxReview.Exer;

import java.util.Scanner;

public class Division_02
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int result = -1;

        if (n % 2 == 0)
            result = 2;
        if (n % 3 == 0)
            result = 3;
        if (n % 6 == 0)
            result = 6;
        if (n % 7 == 0)
            result = 7;
        if (n % 10 == 0)
            result = 10;

        if (result == -1)
            System.out.println("Not divisible");
        else
            System.out.printf("The number is divisible by %d", result);
    }
}
