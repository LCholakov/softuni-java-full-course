package Week1_Multidimensional_Arrays.Exer;

import java.util.Scanner;

public class HeiganDance_08 {
        public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);

            double heiganHP = 3 * 1000 * 1000; // seems more readable this way
            int playerHP = 18500;
            double playerDamage = Double.parseDouble(scan.nextLine());
            int cloudDamage = 3500;
//            int cloudDamageCounter = 0;
            int eruptionDamage = 6000;
            String lastSpell = "";
            int playerX = 7;
            int playerY = 7;
            int boardSize = 15;
            char [][] boardMtrx = new char[boardSize][boardSize];
            // populateBoard(boardMtrx, boardSize);
            // boardMtrx[playerX][playerY] = 'P';
            // printBoard(boardMtrx, boardSize);

            while(true) {
//                heiganHP -= playerDamage;
//                if (heiganHP <= 0) { break; } // "If Heigan is dead, the spell he would have cast is ignored."

                if (playerHP >= 0) {
                    heiganHP -= playerDamage;
                }
                if (lastSpell.equals("Plague Cloud")) {
                    playerHP -= cloudDamage;
                }
                if (heiganHP <= 0 || playerHP <= 0) {
                    break;
                }
                String [] input = scan.nextLine().split("\\s+");
                String currSpell = input[0];
                int spellX = Integer.parseInt(input[1]);
                int spellY = Integer.parseInt(input[2]);


                if(isInDamageArea(spellX, spellY, playerX, playerY)) {
                    // System.out.println("Player is in Cloud range");

                    if (playerX - 1 >= 0 && playerX - 1 < spellX - 1) {                 // go up
                        playerX--;
                        lastSpell = "";
                    } else if (playerY + 1 < boardSize && playerY + 1 > spellY + 1) {   // go right
                        playerY++;
                        lastSpell = "";
                    } else if (playerX + 1 < boardSize && playerX + 1 > spellX + 1) {   // go down
                        playerX++;
                        lastSpell = "";
                    } else if (playerY - 1 >= 0 && playerY - 1 < spellY - 1) {          // go left
                        playerY--;
                        lastSpell = "";

//                        if (!isInDamageArea(spellX, spellY, playerX - 1, playerY) && isInBounds(playerX - 1)) {                 // go up
//                            playerX--;
//                            lastSpell = "";
//                        } else if (!isInDamageArea(spellX, spellY, playerX, playerY + 1) && isInBounds(playerY + 1)) {   // go right
//                            playerY++;
//                            lastSpell = "";
//                        } else if (!isInDamageArea(spellX, spellY, playerX + 1, playerY) && isInBounds(playerX + 1)) {   // go down
//                            playerX++;
//                            lastSpell = "";
//                        } else if (!isInDamageArea(spellX, spellY, playerX, playerY - 1) && isInBounds(playerY - 1)) {          // go left
//                            playerY--;
//                            lastSpell = "";


                    } else {
//                        if (cloudDamageCounter == 1) {
//                            playerHP -= cloudDamage;
//                            cloudDamageCounter = 0;
//                        }
                        switch (currSpell) {
                            case "Cloud" -> {
                                lastSpell = "Plague Cloud";
                                playerHP -= cloudDamage;
//                                cloudDamageCounter = 1;
                            }
                            case "Eruption" -> {
                                lastSpell = "Eruption";
                                playerHP -= eruptionDamage;
                            }
                        }
                    }
                }

                // boardMtrx[playerX][playerY] = 'P';

                // printBoard(boardMtrx, boardSize);

                // System.out.println("Player: " + playerHP + "   Heigan: " + heiganHP);
            }

            // the print is the problem!
            // it excludes printing that both are dead !
            // output
            if (heiganHP <= 0) {
                System.out.println("Heigan: Defeated!");
            } else {
                System.out.printf("Heigan: %.2f%n", heiganHP);
            }
            if (playerHP <= 0) {
                System.out.println("Player: Killed by " + lastSpell);
            } else {
                System.out.println("Player: " + playerHP);
            }
            System.out.printf("Final position: %d, %d", playerX, playerY);
        }

    private static boolean isInBounds(int newCell) {
        return newCell >= 0 || newCell < 15;
    }

    private static boolean isInDamageArea(int targetRow, int targetCol, int newX, int newY) {
        return ((targetRow - 1 <= newX && newX <= targetRow + 1)
                && (targetCol - 1 <= newY && newY <= targetCol + 1));
    }

        // private static void populateBoard(char[][] boardMtrx, int size) {
        //     for (int i = 0; i < size; i++) {
        //         for (int j = 0; j < size; j++) {
        //             boardMtrx[i][j] = '.';
        //         }
        //     }
        // }

        // private static void printBoard (char[][] boardMtrx, int size) {
        //     for (int i = 0; i < size; i++) {
        //         for (int j = 0; j < size; j++) {
        //             System.out.print(boardMtrx[i][j] + " ");
        //         }
        //         System.out.println();
        //     }
        //     System.out.println();
        // }

        // private static boolean isInBounds(int x, int y, char[][] boardMtrx) {
        //     return x >= 0 && x < boardMtrx.length && y >= 0 && y < boardMtrx[0].length;
        // }
    }


//    0. > 10000							Player		Heigan
// 									18500		3 000 000
//   0 1 2 3 4 5 6 7 8 91011121314
//  0 . . . . . . . . . . . . . . .
//  1 . . . . . . . . . . . . . . .
//  2 . . . . . . . . . . . . . . .
//  3 . . . . . . . . . . . . . . .
//  4 . . . . . . . . . . . . . . .
//  5 . . . . . . . . . . . . . . .
//  6 . . . . . . . . . . . . . . .
//  7 . . . . . . . P . . . . . . .
//  8 . . . . . . . . . . . . . . .
//  9 . . . . . . . . . . . . . . .
// 10 . . . . . . . . . . . . . . .
// 11 . . . . . . . . . . . . . . .
// 12 . . . . . . . . . . . . . . .
// 13 . . . . . . . . . . . . . . .
// 14 . . . . . . . . . . . . . . .

// 1. > Cloud 7 7 						18500		3 000 000
// 									-3500         -10 000
// 								  =	15000       2 990 000
//   0 1 2 3 4 5 6 7 8 91011121314
//  0 . . . . . . . . . . . . . . .
//  1 . . . . . . . . . . . . . . .
//  2 . . . . . . . . . . . . . . .
//  3 . . . . . . . . . . . . . . .
//  4 . . . . . . . . . . . . . . .
//  5 . . . . . . . . . . . . . . .
//  6 . . . . . . c c c . . . . . .
//  7 . . . . . . c o c . . . . . .
//  8 . . . . . . c c c . . . . . .
//  9 . . . . . . . . . . . . . . .
// 10 . . . . . . . . . . . . . . .
// 11 . . . . . . . . . . . . . . .
// 12 . . . . . . . . . . . . . . .
// 13 . . . . . . . . . . . . . . .
// 14 . . . . . . . . . . . . . . .



// 2. > Eruption 6 7 					15000		2 990 000
// 									-3500         -10 000
// 								  =	11500       2 980 000

//   0 1 2 3 4 5 6 7 8 91011121314
//  0 . . . . . . . . . . . . . . .
//  1 . . . . . . . . . . . . . . .
//  2 . . . . . . . . . . . . . . .
//  3 . . . . . . . . . . . . . . .
//  4 . . . . . . . . . . . . . . .
//  5 . . . . . . e e e . . . . . .
//  6 . . . . . . e e e . . . . . .
//  7 . . . . . . e e e . . . . . .
//  8 . . . . . . . p . . . . . . .
//  9 . . . . . . . . . . . . . . .
// 10 . . . . . . . . . . . . . . .
// 11 . . . . . . . . . . . . . . .
// 12 . . . . . . . . . . . . . . .
// 13 . . . . . . . . . . . . . . .
// 14 . . . . . . . . . . . . . . .

// 3. > Eruption 8 7 					11500		2 980 000
// 									-6000
// 								  =	 5500       2 970 000

//   0 1 2 3 4 5 6 7 8 91011121314
//  0 . . . . . . . . . . . . . . .
//  1 . . . . . . . . . . . . . . .
//  2 . . . . . . . . . . . . . . .
//  3 . . . . . . . . . . . . . . .
//  4 . . . . . . . . . . . . . . .
//  5 . . . . . . . . . . . . . . .
//  6 . . . . . . . . . . . . . . .
//  7 . . . . . . e e e . . . . . .
//  8 . . . . . . e B e . . . . . .
//  9 . . . . . . e e e . . . . . .
// 10 . . . . . . . . . . . . . . .
// 11 . . . . . . . . . . . . . . .
// 12 . . . . . . . . . . . . . . .
// 13 . . . . . . . . . . . . . . .
// 14 . . . . . . . . . . . . . . .

// 4. > Eruption 8 7 				     5500		2 970 000
// 									-6000
// 								  =	 -500       2 960 000

//   0 1 2 3 4 5 6 7 8 91011121314
//  0 . . . . . . . . . . . . . . .
//  1 . . . . . . . . . . . . . . .
//  2 . . . . . . . . . . . . . . .
//  3 . . . . . . . . . . . . . . .
//  4 . . . . . . . . . . . . . . .
//  5 . . . . . . . . . . . . . . .
//  6 . . . . . . . . . . . . . . .
//  7 . . . . . . e e e . . . . . .
//  8 . . . . . . e B e . . . . . .
//  9 . . . . . . e e e . . . . . .
// 10 . . . . . . . . . . . . . . .
// 11 . . . . . . . . . . . . . . .
// 12 . . . . . . . . . . . . . . .
// 13 . . . . . . . . . . . . . . .
// 14 . . . . . . . . . . . . . . .
