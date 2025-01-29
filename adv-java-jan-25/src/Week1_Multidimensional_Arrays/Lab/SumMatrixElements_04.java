package Week1_Multidimensional_Arrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class SumMatrixElements_04 {
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

        int sum = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                sum += numArr[i][j];
            }
        }
        System.out.println(rows);
        System.out.println(cols);
        System.out.println(sum);
    }
}
