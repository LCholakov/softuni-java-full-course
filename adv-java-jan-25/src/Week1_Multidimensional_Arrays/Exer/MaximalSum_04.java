package Week1_Multidimensional_Arrays.Exer;

import java.util.Arrays;
import java.util.Scanner;

public class MaximalSum_04 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int [] size = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        
        int [][] nMatr = new int[size[0]][size[1]];

        for (int i = 0; i < size[0]; i++) {
            nMatr[i] = Arrays.stream(scan.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();            
        }

        int maxSum = Integer.MIN_VALUE;
        int sumTemp = 0;
        int idxR = -1;
        int idxC = -1;
        for (int i = 0; i < size[0] - 2; i++) {
            for (int j = 0; j < size[1] - 2; j++) {
                sumTemp = nMatr[i][j]
                        + nMatr[i][j + 1]
                        + nMatr[i][j + 2]
                        + nMatr[i + 1][j]
                        + nMatr[i + 1][j + 1]
                        + nMatr[i + 1][j + 2]
                        + nMatr[i + 2][j]
                        + nMatr[i + 2][j + 1]
                        + nMatr[i + 2][j + 2];

                if (sumTemp > maxSum) {
                    maxSum = sumTemp;
                    idxR = i;
                    idxC = j;
                }
                sumTemp = 0;
            }
        }
        System.out.println("Sum = " + maxSum);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(nMatr[idxR + i][idxC + j] + " ");
            }
            System.out.println();
        }
    }
}
