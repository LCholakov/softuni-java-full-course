package Week7_MockExam.Exam1;

import java.util.Scanner;

public class MaidenParty_02
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        double partyCost = Double.parseDouble(scanner.nextLine());
        int nLoveMessage = Integer.parseInt(scanner.nextLine());
        int nWaxRose = Integer.parseInt(scanner.nextLine());
        int nKeychain = Integer.parseInt(scanner.nextLine());
        int nCaricature = Integer.parseInt(scanner.nextLine());
        int nSurprise = Integer.parseInt(scanner.nextLine());

        double totalSum = nLoveMessage * 0.6
                        + nWaxRose * 7.2
                        + nKeychain * 3.6
                        + nCaricature * 18.2
                        + nSurprise * 22;
        if (nLoveMessage + nWaxRose + nKeychain + nCaricature + nSurprise >= 25)
            totalSum *= 0.65;

        double result = 0.9 * totalSum - partyCost;

        if (result < 0)
            System.out.printf("Not enough money! %.2f lv needed.", Math.abs(result));
        else
            System.out.printf("Yes! %.2f lv left.", result);
    }
}
