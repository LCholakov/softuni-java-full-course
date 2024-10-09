package Week1.Exer;

import java.util.Scanner;

public class DepositCalculator_03
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        double depositAmount = Double.parseDouble(scanner.nextLine());
        int depositPeriod = Integer.parseInt(scanner.nextLine());
        double interestRate = Double.parseDouble(scanner.nextLine());

        double returnTotal = depositAmount + (depositPeriod * ((depositAmount * interestRate / 100) / 12));

        System.out.println(returnTotal);
    }
}
