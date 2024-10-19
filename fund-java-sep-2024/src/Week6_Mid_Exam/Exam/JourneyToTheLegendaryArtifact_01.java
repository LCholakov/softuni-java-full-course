package Week6_Mid_Exam.Exam;

import java.util.Scanner;

public class JourneyToTheLegendaryArtifact_01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double energy = Double.parseDouble(scan.nextLine());
        int pieceCounter = 0;
        int mtnCounter = 0;
        String input = scan.nextLine();
        while (!input.equals("Journey ends here!")) {
            switch (input) {
                case "mountain" -> {
                    energy -= 10;
                    ++mtnCounter;
                    if (mtnCounter % 3 == 0) {
                        ++pieceCounter;
                    }
                }
                case "desert" -> energy -= 15;
                case "forest" -> energy += 7;
            }
            if (pieceCounter == 3 || energy <= 0) {
                break;
            }
            input = scan.nextLine();
        }

        if (pieceCounter == 3) {
            System.out.printf("The character reached the legendary artifact with %.2f energy left.", energy);
        } else if (energy <= 0) {
            System.out.println("The character is too exhausted to carry on with the journey.");
        } else {
            System.out.printf("The character could not find all the pieces and needs %d more to complete the legendary artifact.", 3 - pieceCounter);
        }
    }
}
