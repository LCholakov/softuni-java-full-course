package Week1_BasicSyntaxReview.Lab;

import java.util.Scanner;

public class EvenNumber_11
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int n;

        while (true)
        {
            n = Integer.parseInt(scanner.nextLine());
            if (n % 2 == 0) { break; }
            System.out.println("Please write an even number.");
        }
        System.out.printf("The number is: %d", Math.abs(n));
    }
}
