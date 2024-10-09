package Week3_Arrays.Exer;

import java.util.Arrays;
import java.util.Scanner;

public class ZigZagArrays_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int nArr1[] = new int[n];
        int nArr2[] = new int[n];

        for (int i = 0; i < n; i++) {
            int tempArr[] = { scanner.nextInt(), scanner.nextInt() };
            if (i % 2 == 0) {
                nArr1[i] = tempArr[0];
                nArr2[i] = tempArr[1];
            } else {
                nArr1[i] = tempArr[1];
                nArr2[i] = tempArr[0];
            }
        }
//        Arrays.stream(nArr1).forEach(System.out::print);
//        Arrays.stream(nArr2).forEach(System.out::print);
        for (int i : nArr1) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i : nArr2) {
            System.out.print(i + " ");
        }
    }
}
