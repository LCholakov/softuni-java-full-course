package Week1_Multidimensional_Arrays.Exer;

import java.util.Scanner;

public class HeiganDance_08_v2 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int pRow = 7;
        int pCol = 7;

        int pHP = 18500;
        double heigHP = 3 * 1000 * 1000;
        double pDmg = Double.parseDouble(scan.nextLine());
        String lastSpell = " ";

        while (true) {
            if (pHP > 0) {
                heigHP -= pDmg;
            }
            if (lastSpell.equals("Plague Cloud")) {
                pHP -= 3500;
            }
            if (heigHP <= 0 || pHP <= 0) {
                break;
            }

            String[] input = scan.nextLine().split("\\s+");    // should it be split by one space " "
            String currSpell = input[0];
            int spellR = Integer.parseInt(input[1]);
            int spellC = Integer.parseInt(input[2]);

            if (isInDamageArea(spellR, spellC, pRow,pCol)) {
                lastSpell = " ";
                if (!isInDamageArea(spellR, spellC, pRow - 1, pCol) && !isWall(pRow - 1)) {
                    pRow--;
                } else if (!isInDamageArea(spellR, spellC, pRow, pCol + 1) && !isWall(pCol + 1)) {
                    pCol++;
                } else if (!isInDamageArea(spellR, spellC, pRow + 1, pCol) && !isWall(pRow + 1)) {
                    pRow++;
                } else if (!isInDamageArea(spellR, spellC, pRow, pCol - 1) && !isWall(pCol - 1)) {
                    pCol--;
                } else {
                    if (currSpell.equals("Cloud")) {
                        pHP -= 3500;
                        lastSpell = "Plague " + currSpell;
                    } else if (currSpell.equals("Eruption")) {
                        pHP -= 6000;
                        lastSpell = currSpell;
                    }
                }
            }
        }
        // output
        if (heigHP <= 0) {
            System.out.println("Heigan: Defeated!");
        } else {
            System.out.printf("Heigan: %.2f%n", heigHP);
        }

        if (pHP <= 0) {
            System.out.println("Player: Killed by " + lastSpell);
        } else {
            System.out.println("Player: " + pHP);
        }
        System.out.printf("Final position: %d, %d", pRow, pCol);
    }

    private static boolean isWall(int moveCell) {
        return moveCell < 0 || moveCell >= 15;
    }

    private static boolean isInDamageArea(int targetRow, int targetCol, int moveRow, int moveCol) {
        return ((targetRow - 1 <= moveRow && moveRow <= targetRow + 1)
                && (targetCol - 1 <= moveCol && moveCol <= targetCol + 1));
    }
}
