package Week1_Multidimensional_Arrays.Exer;

import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference_03 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int size = Integer.parseInt(scan.nextLine());
        int[][] nMatr = new int[size][size];
        for (int i = 0; i < size; i++) {
            nMatr[i] = Arrays.stream(scan.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        int sumPrim = 0;
        int sumSec = 0;

        for (int i = 0; i < size; i++) {
            sumPrim += nMatr[i][i];
            sumSec += nMatr[i][size - 1 - i];
        }
        System.out.println(Math.abs(sumPrim -sumSec));
    }
}
