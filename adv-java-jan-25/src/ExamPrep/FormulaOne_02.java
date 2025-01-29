package ExamPrep;

import java.util.Scanner;

public class FormulaOne_02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int size = Integer.parseInt(scan.nextLine());
        int turnCount = Integer.parseInt(scan.nextLine());
        char [][] f1Matrix = new char[size][size];
        int [] posP = new int [2];


        // populate matrix
        for (int i = 0; i < size; i++) {
            char[] charTemp = scan.nextLine().toCharArray();
            for (int j = 0; j < charTemp.length; j++) {
                f1Matrix[i][j] = charTemp[j];
                if (charTemp[j] == 'P') {
                    posP[0] = i;
                    posP[1] = j;
                }
            }
        }

        boolean hasWon = false;

        for (int i = 0; i < turnCount; i++) {
            int [] newPosP = {posP[0], posP[1]};
            switch  (scan.nextLine()) {
                case "up" -> {
                    moveUp(newPosP, size);
                    if (f1Matrix[newPosP[0]][newPosP[1]] == 'B') {
                        moveUp(newPosP, size);
                    }
                }
                case "down" -> {
                    moveDown(newPosP, size);
                    if (f1Matrix[newPosP[0]][newPosP[1]] == 'B') {
                        moveDown(newPosP, size);
                    }
                }
                case "left" -> {
                    moveLeft(newPosP, size);
                    if (f1Matrix[newPosP[0]][newPosP[1]] == 'B') {
                        moveLeft(newPosP, size);
                    }

                }
                case "right" -> {
                    moveRight(newPosP,size);
                    if (f1Matrix[newPosP[0]][newPosP[1]] == 'B') {
                        moveRight(newPosP, size);
                    }
                }
            }
            if (f1Matrix[newPosP[0]][newPosP[1]] == 'T') {
                newPosP = posP;
            } else if (f1Matrix[newPosP[0]][newPosP[1]] == 'F') {
                hasWon = true;
            }
            f1Matrix[posP[0]][posP[1]] = '.';
            f1Matrix[newPosP[0]][newPosP[1]] = 'P';
            posP = newPosP;
        }

        if (hasWon) {
            System.out.println("Well done, the player won first place!");
        } else {
            System.out.println("Oh no, the player got lost on the track!");
        }
        printMatrix(f1Matrix);
    }

    private static void printMatrix(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    private static void moveRight(int[] newPosP, int size) {
        ++newPosP[1];
        if (newPosP[1] > size - 1) {
            newPosP[1] = 0;
        }
    }

    private static void moveLeft(int[] newPosP, int size) {
        --newPosP[1];
        if(newPosP[1] < 0) {
            newPosP[1] = size - 1;
        }
    }

    private static void moveDown(int[] newPosP, int size) {
        ++newPosP[0];
        if(newPosP[0] > size - 1) {
            newPosP[0] = 0;
        }
    }

    private static void moveUp(int[] newPosP, int size) {
        --newPosP[0];
        if(newPosP[0] < 0) {
            newPosP[0] = size - 1;
        }
    }
}
