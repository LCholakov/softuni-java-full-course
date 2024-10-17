package Week6_Mid_Exam.Prep1;

import java.util.Scanner;

public class CounterStrike_01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int energy = Integer.parseInt(scan.nextLine());
        int wonCount = 0;
        String input  = scan.nextLine();

        while (!input.equals("End of battle")) {
            int dist = Integer.parseInt(input);
            if (dist <= energy) {
                energy -= dist;
                wonCount++;
                if (wonCount % 3 == 0) {
                    energy += wonCount;
                }
            } else {
                System.out.printf("Not enough energy! Game ends with %d won battles and %d energy", wonCount, energy);
                break;
            }

            input  = scan.nextLine();
        }
        if (input.equals("End of battle")) {
            System.out.printf("Won battles: %d. Energy left: %d", wonCount, energy);
        }
    }
}
