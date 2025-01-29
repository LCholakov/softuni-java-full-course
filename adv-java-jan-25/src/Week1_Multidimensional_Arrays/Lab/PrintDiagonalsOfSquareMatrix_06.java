package Week1_Multidimensional_Arrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class PrintDiagonalsOfSquareMatrix_06 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in); //

        int n = Integer.parseInt(scan.nextLine());
        int [][] numArr = new int[n][n];

        for (int i = 0; i < n; i++) {
            numArr[i] = Arrays.stream(scan.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        for (int i = 0; i < n; i++) {
            System.out.print(numArr[i][i] + " ");
        }
        System.out.println();
        for (int i = 0; i < n; i++) {
            System.out.print(numArr[n - 1 - i][i] + " ");
        }
    }
}
