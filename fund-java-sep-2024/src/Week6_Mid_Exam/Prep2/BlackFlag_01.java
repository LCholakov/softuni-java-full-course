package Week6_Mid_Exam.Prep2;

import java.util.Scanner;

public class BlackFlag_01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int duration = Integer.parseInt(scan.nextLine());
        int dailyQty = Integer.parseInt(scan.nextLine());
        double targetQty = Double.parseDouble(scan.nextLine());
        double plunderQty = 0.0;

        for (int i = 1; i <= duration; i++) {
            plunderQty += dailyQty;
            if (i % 3 == 0)
                plunderQty += dailyQty * 0.5;
            if (i % 5 == 0)
                plunderQty *= 0.7;
        }

        if (plunderQty < targetQty) {
            System.out.printf("Collected only %.2f%% of the plunder.", 100.0 * plunderQty / targetQty);
        } else {
            System.out.printf("Ahoy! %.2f plunder gained.", plunderQty);
        }
    }
}
