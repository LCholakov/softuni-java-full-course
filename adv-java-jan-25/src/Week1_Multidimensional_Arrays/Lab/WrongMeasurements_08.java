package Week1_Multidimensional_Arrays.Lab;

import javax.xml.namespace.QName;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class WrongMeasurements_08 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int size = Integer.parseInt(scan.nextLine());
        // take first row separately to identify the number of columns
        String [] firstRow = scan.nextLine().split("\\s+");
        int [][] nMtrx = new int[size][firstRow.length];
        int [][] resultMtrx = new int[size][firstRow.length];

        nMtrx[0] = Arrays.stream(firstRow)
                .mapToInt(Integer::parseInt)
                .toArray();

        // populate copy matrix manually since assignment causes reference to a single object
        resultMtrx[0] = Arrays.stream(firstRow)
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int i = 1; i < size; i++) {
            nMtrx[i] = Arrays.stream(scan.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            // populate copy matrix
            for (int j = 0; j < nMtrx[i].length; j++) {
                resultMtrx[i][j] = nMtrx[i][j];

            }
        }

        int badVal = nMtrx[scan.nextInt()][scan.nextInt()];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < nMtrx[i].length; j++) {
                if (nMtrx[i][j] == badVal) {
                    resultMtrx[i][j] = getNewVal(nMtrx, badVal, i, j);
                }
                System.out.print(resultMtrx[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int getNewVal(int[][] nMtrx, int badVal, int i, int j) {
        return getUpVal(nMtrx, badVal, i, j)
                + getRightVal(nMtrx, badVal, i, j)
                + getDowmVal(nMtrx, badVal, i, j)
                + getLeftVal(nMtrx, badVal, i, j);
    }

//    private static boolean isInMatrix(int x, int y, int sizeX, int sizeY) {
//        return x >= 0 && x < sizeX && y >=  0 && y < sizeY;
//    }

    private static int getRightVal(int[][] nMtrx, int badVal, int i, int j) {
        int x = i;
        int y = j + 1;
        return y < nMtrx[i].length && nMtrx[x][y] != badVal
                ? nMtrx[x][y]
                : 0;
    }

    private static int getLeftVal(int[][] nMtrx, int badVal, int i, int j) {
        int x = i;
        int y = j - 1;
        return y >= 0 && nMtrx[x][y] != badVal
                ? nMtrx[x][y]
                : 0;
    }

    private static int getUpVal(int[][] nMtrx, int badVal, int i, int j) {
        int x = i - 1;
        int y = j;
        return x >= 0 && nMtrx[x][y] != badVal
                ? nMtrx[x][y]
                : 0;
    }

    private static int getDowmVal(int[][] nMtrx, int badVal, int i, int j) {
        int x = i + 1;
        int y = j;
        return x < nMtrx.length && nMtrx[x][y] != badVal
                ? nMtrx[x][y]
                : 0;
    }
}
