package Week6_Mid_Exam.Exam2;

import java.util.Scanner;

public class SpringVacation_01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int duration = Integer.parseInt(scan.nextLine());
        double budget = Double.parseDouble(scan.nextLine());
        int headCount = Integer.parseInt(scan.nextLine());
        double fuelPrice = Double.parseDouble(scan.nextLine());
        double foodPrice = Double.parseDouble(scan.nextLine());
        double accomPrice = Double.parseDouble(scan.nextLine());

        double totalExpenses = 0.0;

        if (headCount > 10)
            accomPrice *= 0.75;

        totalExpenses = headCount * duration * (foodPrice + accomPrice);
        if (totalExpenses > budget) {
            System.out.printf("Not enough money to continue the trip. You need %.2f$ more.", totalExpenses - budget);
            return;
        }

        for (int i = 1; i <= duration; i++) {
            double currDist = Double.parseDouble(scan.nextLine());

            totalExpenses += currDist * fuelPrice;

            if (i % 3 == 0 || i % 5 == 0) {
                totalExpenses *= 1.4;
            }

            if (i % 7 == 0) {
                totalExpenses -= totalExpenses/headCount;
            }
            if (totalExpenses > budget) {
                System.out.printf("Not enough money to continue the trip. You need %.2f$ more.", totalExpenses - budget);
                break;
            }
        }

        if (totalExpenses <= budget) {
            System.out.printf("You have reached the destination. You have %.2f$ budget left.", budget - totalExpenses);
        }
    }
}
