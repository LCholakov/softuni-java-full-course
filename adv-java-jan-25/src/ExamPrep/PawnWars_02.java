package ExamPrep;

import java.util.Scanner;

public class PawnWars_02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
//        while (true) {
            char[][] chessMatrix = new char[8][8];
            int[] posW = {-1, -1};
            int[] posB = {-1, -1};

            // populate matrix
            for (int i = 0; i < chessMatrix[0].length; i++) {
                char[] charTemp = scan.nextLine().toCharArray();
                for (int j = 0; j < charTemp.length; j++) {
                    chessMatrix[i][j] = charTemp[j];
                    if (charTemp[j] == 'w') {
                        posW[0] = i;
                        posW[1] = j;
                    } else if (charTemp[j] == 'b') {
                        posB[0] = i;
                        posB[1] = j;
                    }
                }
            }

            // check for more than 1 col diff -> winner is the closer one or white if equal dist
            if (Math.abs(posW[1] - posB[1]) > 1) {
                if (posW[0] <= 7 - posB[0]) {
                    System.out.printf("Game over! White pawn is promoted to a queen at %s.%n", getPosAnnotation(0, posW[1]));
                } else {
                    System.out.printf("Game over! Black pawn is promoted to a queen at %s.%n", getPosAnnotation(7, posB[1]));
                }
            } else {
                while (true) {

                    // White moves
                    int[] newPosW = {posW[0] - 1, posW[1]};

                    if (isWithinBounds(newPosW[0], newPosW[1] - 1) && chessMatrix[newPosW[0]][newPosW[1] - 1] == 'b') {
                        chessMatrix[posW[0]][posW[1]] = '-';
                        posW = new int[] { newPosW[0], posW[1] - 1};
                        chessMatrix[posW[0]][posW[1]] = 'w';
                        String annotatedPos = getPosAnnotation(posW[0], posW[1]);
                        System.out.printf("Game over! White capture on %s.%n", annotatedPos);
                        break;
                    } else if (isWithinBounds(newPosW[0], newPosW[1] + 1) && chessMatrix[newPosW[0]][newPosW[1] + 1] == 'b') {
                        chessMatrix[posW[0]][posW[1]] = '-';
                        posW = new int[]{newPosW[0], newPosW[1] + 1};
                        chessMatrix[posW[0]][posW[1]] = 'w';
                        String annotatedPos = getPosAnnotation(posW[0], posW[1]);
                        System.out.printf("Game over! White capture on %s.%n", annotatedPos);
                        break;
                    }
                    else {
                        chessMatrix[posW[0]][posW[1]] = '-';
                        posW = newPosW;
                        chessMatrix[posW[0]][posW[1]] = 'w';
                        if (posW[0] == 0) {
                            String annotatedPos = getPosAnnotation(posW[0], posW[1]);
                            System.out.printf("Game over! White pawn is promoted to a queen at %s.%n", annotatedPos);
                            break;
                        }
                    }
//                    printChessBoard(chessMatrix);
//                    System.out.println();

                    // Black moves
                    int[] newPosB = {posB[0] + 1, posB[1]};

                    if (isWithinBounds(newPosB[0], newPosB[1] - 1) && chessMatrix[newPosB[0]][newPosB[1] - 1] == 'w') {
                        chessMatrix[posB[0]][posB[1]] = '-';
                        posB = new int[]{newPosB[0], posB[1] - 1};
                        chessMatrix[posB[0]][posB[1]] = 'b';
                        String annotatedPos = getPosAnnotation(posB[0], posB[1]);
                        System.out.printf("Game over! Black capture on %s.%n", annotatedPos);
                        break;
                    } else if (isWithinBounds(newPosB[0], newPosB[1] + 1) && chessMatrix[newPosB[0]][newPosB[1] + 1] == 'w') {
                        chessMatrix[posB[0]][posB[1]] = '-';
                        posB = new int[]{newPosB[0], newPosB[1] + 1};
                        chessMatrix[posB[0]][posB[1]] = 'b';
                        String annotatedPos = getPosAnnotation(posB[0], posB[1]);
                        System.out.printf("Game over! Black capture on %s.%n", annotatedPos);
                        break;
                    }
                    else {
                        chessMatrix[posB[0]][posB[1]] = '-';
                        posB = newPosB;
                        chessMatrix[posB[0]][posB[1]] = 'b';
                        if (posB[0] == 7) {
                            String annotatedPos = getPosAnnotation(posB[0], posB[1]);
                            System.out.printf("Game over! Black pawn is promoted to a queen at %s.%n", annotatedPos);
                            break;
                        }
                    }
//                    printChessBoard(chessMatrix);
//                    System.out.println();
                }
//                printChessBoard(chessMatrix);
//                System.out.println();
            }
//        }
    }

    private static void printChessBoard(char[][] chessMatrix) {
        for (int i = 0; i <= 7; i++) {
            for (int j = 0; j <= 7; j++) {
                System.out.print(chessMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static String getPosAnnotation(int row, int col) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            if (col == i) {
                stringBuilder.append((char) (col + 97));
            }
        }
//        for (int j = 0; j < 8; j++) {
//            if (row == j) {
//                stringBuilder.append(j + 1);
//            }
//        }
        stringBuilder.append(8 - row);
        return stringBuilder.toString();
    }

    private static boolean isWithinBounds(int i, int j) {
        return (i >= 0 && i <= 7) && (j >= 0 && j <= 7);
    }
}

