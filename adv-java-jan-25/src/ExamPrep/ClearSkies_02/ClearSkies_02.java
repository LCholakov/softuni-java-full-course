package ExamPrep.ClearSkies_02;

import java.util.Scanner;

public class ClearSkies_02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        byte matrSize = Byte.parseByte(scan.nextLine());
        byte remainingEnemy = 4;   //4 starting, last one is unarmed and does no damage.
        short enemyDmg = 100;
        short jetArmour = 300;
        byte jetRow = -1;
        byte jetCol = -1;
        char[][] matr = new char[matrSize][matrSize];
        for (byte i = 0; i < matrSize; i++) {
            String s = scan.nextLine().replace(" ", "");
            matr[i] = s.toCharArray();
            if(s.contains("J")) {
                jetRow = i;
                jetCol = (byte) s.indexOf('J');
//                matr[jetRow][jetCol] = '-';
            }
        }

        while (jetArmour != 0 && remainingEnemy != 0) {
            byte jTempRow = jetRow;
            byte jTempCol = jetCol;
            switch(scan.nextLine()) {
                case "up" -> jTempRow--;
                case "down" -> jTempRow++;
                case "left" -> jTempCol--;
                case "right" -> jTempCol++;
            }

            if (matr[jTempRow][jTempCol] == 'R') {
                // reset armour
                jetArmour = 300;
                matr[jTempRow][jTempCol] = '-';
            } else if (matr[jTempRow][jTempCol] == 'E') {
                matr[jTempRow][jTempCol] = '-';
                if(remainingEnemy > 1) {
                    jetArmour -= enemyDmg;
                }
                remainingEnemy--;
            }

            matr[jetRow][jetCol] = '-';
            jetRow = jTempRow;
            jetCol = jTempCol;
            matr[jetRow][jetCol] = 'J';

            // live debug (found I wasn't newline-ing in failed mission before matr print
//            for (char[] cArr : matr) {
//                for (char c : cArr) {
//                    System.out.print(c + " ");
//                }
//                System.out.println();
//            }
//            System.out.println(">>>>>>>>>>> " + jetArmour);
        }

        if (jetArmour > 0) {
            System.out.println("Mission accomplished, you neutralized the aerial threat!");
        } else {
            System.out.printf("Mission failed, your jetfighter was shot down! Last coordinates [%d, %d]!%n", jetRow, jetCol);
        }

        for (char[] cArr : matr) {
            System.out.println(cArr);
        }
    }
}
