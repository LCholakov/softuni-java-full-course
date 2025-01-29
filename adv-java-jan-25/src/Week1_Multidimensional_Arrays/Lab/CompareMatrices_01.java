package Week1_Multidimensional_Arrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrices_01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int [][] num2dArr_A = new int[scan.nextInt()][scan.nextInt()];

        // Move cursor down if populating with v2
//        scan.nextLine();
        populateMatrix(num2dArr_A, scan);

        int [][] num2dArr_B = new int[scan.nextInt()][scan.nextInt()];

        // Move cursor down if populating with v2
//        scan.nextLine();
        populateMatrix(num2dArr_B, scan);

        if (matricesAreEqual(num2dArr_A, num2dArr_B)) {
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }
    }

    private static void populateMatrix(int[][] matrix2d, Scanner scan) {
        for (int i = 0; i < matrix2d.length; i++) {
            for (int j = 0; j < matrix2d[0].length; j++) {
                matrix2d[i][j] = scan.nextInt();
            }
        }
    }
    private static void populateMatrixV2(int[][] matrix2d, Scanner scan) {
        for (int i = 0; i < matrix2d.length; i++) {
            matrix2d[i] = Arrays.stream(scan.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
    }

    private static boolean matricesAreEqual(int[][] num2dArrA, int[][] num2dArrB) {
        if (num2dArrA.length != num2dArrB.length || num2dArrA[0].length != num2dArrB[0].length) {
            return false;
        }

        for (int i = 0; i < num2dArrA.length; i++) {
            for (int j = 0; j < num2dArrA[0].length; j++) {
                if (num2dArrA[i][j] != num2dArrB[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }
}
