package Week2_Conditionals1.Exer;

import java.util.Scanner;

public class BonusScore_02
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int input = Integer.parseInt(scanner.nextLine());

        double score = 0;

        if (input <= 100)
        {
            score = 5;
        }
        else if (input <= 1000)
        {
            score = input * 0.2;
        }
        else
        {
            score = input * 0.1;
        }

        if (input % 2 == 0)
        {
            score += 1;
        }

        if (input % 5 == 0 && (input / 5) % 2  == 1)    // nums ending in 5 are odd divisors
        {
            score += 2;
        }

        System.out.println(score);
        System.out.println(input + score);
    }
}
