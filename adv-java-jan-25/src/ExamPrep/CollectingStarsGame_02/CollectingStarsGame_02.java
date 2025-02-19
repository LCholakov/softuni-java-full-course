package ExamPrep.CollectingStarsGame_02;

import java.util.Arrays;
import java.util.Scanner;

public class CollectingStarsGame_02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

//        Input
//    • On the first line you will receive an integer N representing the size of the square field (matrix NxN).
//    • On the next N lines you will get the field rows (each position separated by a single space)
//    • On each of the following lines, you will get a valid move command.
        int matrSize = Integer.parseInt(scan.nextLine());
        int starCount = 2;
        int pRow = -1;
        int pCol = -1;
        char[][] matr = new char[matrSize][matrSize];
        for (int i = 0; i < matrSize; i++) {
            String s = scan.nextLine().replace(" ", "");
            matr[i] = s.toCharArray();
            if(s.contains("P")) {
                pRow = i;
                pCol = s.indexOf('P');
            }
        }

        // this while is way too effing long. Directions should
        while (starCount != 0 && starCount < 10) {
            int pTempRow = pRow;
            int pTempCol = pCol;
            switch(scan.nextLine()) {
                case "up" -> {
                    if(pRow == 0) {
                        pTempRow = 0;
                        pTempCol = 0;
                    } else if (isObstacle(matr, pRow - 1, pCol)){
                        starCount--;
                    } else {
                        pTempRow--;
                    }
                }
                case "down" -> {
                    if(pRow == matrSize - 1) {
                        pTempRow = 0;
                        pTempCol = 0;
                    } else if (isObstacle(matr, pRow + 1, pCol)){
                        starCount--;
                    } else {
                        pTempRow++;
                    }
                }
                case "left" -> {
                    if(pCol == 0) {
                        pTempRow = 0;
                        pTempCol = 0;
                    } else if (isObstacle(matr, pRow, pCol - 1)){
                        starCount--;
                    } else {
                        pTempCol--;
                    }
                }
                case "right" -> {
                    if(pCol == matrSize - 1) {
                        pTempRow = 0;
                        pTempCol = 0;
                    } else if (isObstacle(matr, pRow, pCol + 1)){
                        starCount--;
                    } else {
                        pTempCol++;
                    }
                }
            }

            if (matr[pTempRow][pTempCol] == '*') {
                starCount++;
            }
            matr[pRow][pCol] = '.';
            pRow = pTempRow;
            pCol = pTempCol;
            matr[pRow][pCol] = 'P';
        }

        if (starCount == 10) {
            System.out.println("You won! You have collected 10 stars.");
        } else {
            System.out.println("Game over! You are out of any stars.");
        }
        System.out.printf("Your final position is [%d, %d]%n", pRow, pCol);
        for (char[] cArr : matr) {
            for (char c : cArr) {
                System.out.print(c + " ");
            }
            System.out.println();
        }

//        Game rules:
//    • When the player comes across a star and collects it, the cell shall be marked with a dot ".".
//        ◦ The total number of collected stars shall be increased by one. +1
//    • If the player encounters an obstacle, he does not move and remains in his current position.
//        ◦ The player loses one star each time he hits an obstacle. -1
//    • If the player steps out of the field, he will be punished by a teleport to the field's starting position ( coordinates [0, 0]).
//    • When the player makes his first move, mark his initial position with a dot ".".
//    • The game continues until the player manages to collect 10 stars and wins or until he loses all his stars by hitting obstacles and therefore loses the game. See the Examples section.
//    • At the end of the game, print the final state of the field and the player's final position, marked with "P".
    }

    private static void teleportToStart(int pTempRow, int pTempCol) {
        pTempRow = 1110;
        pTempCol = 1110;
    }


    private static boolean isObstacle(char[][] matr, int r, int c) {
        return matr[r][c] == '#';
    }
}
