package Week1_Multidimensional_Arrays.Exer;

import java.util.Scanner;

public class FillTheMatrix_01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String [] input = scan.nextLine().split(",\\s");
        int size = Integer.parseInt(input[0]);
        char type = input[1].charAt(0);
        int [][] intMatrix = new int[size][size];

        switch (type) {
            case 'A' -> populateMatrixTypeA(intMatrix);
            case 'B' -> populateMatrixTypeB(intMatrix);
        }

        printMatrix(intMatrix);
    }

    private static void printMatrix(int[][] intMatrix) {
        for (int i = 0; i < intMatrix.length; i++) {
            for (int j = 0; j < intMatrix.length; j++) {
                System.out.print(intMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void populateMatrixTypeA(int[][] intMatrix) {
        int cellData = 1;

        for (int i = 0; i < intMatrix.length; i++) {
            for (int j = 0; j < intMatrix.length; j++) {
                intMatrix[j][i] = cellData;
                cellData++;
            }
        }
    }

    private static void populateMatrixTypeB(int[][] intMatrix) {
        int cellData = 1;

        for (int i = 0; i < intMatrix.length; i++) {
            for (int j = 0; j < intMatrix.length; j++) {
                if(i % 2 == 0) {
                    intMatrix[j][i] = cellData;
                } else {
                    intMatrix[intMatrix.length - 1 - j][i] = cellData;
                }
                cellData++;
            }
        }
    }
}
