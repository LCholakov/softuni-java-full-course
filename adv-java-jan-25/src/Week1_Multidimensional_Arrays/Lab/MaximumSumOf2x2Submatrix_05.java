package Week1_Multidimensional_Arrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class MaximumSumOf2x2Submatrix_05 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String [] inputRowsCols = scan.nextLine().split(",\\s+");
        int rows = Integer.parseInt(inputRowsCols[0]);
        int cols = Integer.parseInt(inputRowsCols[1]);
        int [][] numArr = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            numArr[i] = Arrays.stream(scan.nextLine().split(",\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        int sumMax = Integer.MIN_VALUE;
        int[] upLeftCoordinate = { -1, -1 };

        for (int i = 0; i < rows - 1; i++) {
            for (int j = 0; j < cols - 1; j++) {
                // better solution below
//                int tempSum = get2x2Sum(numArr, i, j);
                int tempSum = numArr[i][j] + numArr[i][j + 1] + numArr[i + 1][j] + numArr[i + 1][j + 1];
                if ( tempSum > sumMax) {
                    sumMax = tempSum;
                    upLeftCoordinate = new int[]{ i, j };
                }
            }
        }

        for (int i = upLeftCoordinate[0]; i <= upLeftCoordinate[0] + 1; i++) {
            for (int j = upLeftCoordinate[1]; j <= upLeftCoordinate[1] + 1; j++) {
                System.out.print(numArr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(sumMax);
    }

//    private static int get2x2Sum(int[][] numArr, int row, int col) {
//        int returnVal = 0;
//        for (int i = row; i <= row + 1; i++) {
//            for (int j = col; j <= col + 1 ; j++) {
//                returnVal += numArr[i][j];
//            }
//        }
//        return returnVal;
//    }
}
