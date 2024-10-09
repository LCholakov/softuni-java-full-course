package Week1_BasicSyntaxReview.Exer;

import java.util.Scanner;

public class RageExpenses_11
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

//        1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37
//          m   m   m   m    m     m     m     m     m     m     m     m     m     m     m     m     m     m
//            h     h     h        h        h        h        h        h        h        h        h        h
//                  k              k                 k                 k                 k                 k
//                                 d                                   d                                   d

        int n = Integer.parseInt(scanner.nextLine());
        double hsetPrice = Double.parseDouble(scanner.nextLine());
        double mousePrice = Double.parseDouble(scanner.nextLine());
        double kboardPrice = Double.parseDouble(scanner.nextLine());
        double displayPrice = Double.parseDouble(scanner.nextLine());

        double total = (n / 2) * hsetPrice
                    + (n / 3) * mousePrice
                    + (n / 6) * kboardPrice
                    + (n / 12) * displayPrice;

        System.out.printf("Rage expenses: %.2f lv.", total);
    }
}
