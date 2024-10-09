package Week3_Arrays.More;

import java.util.Arrays;
import java.util.Scanner;

public class PascalTriangle_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        byte n = Byte.parseByte(scanner.nextLine());
        String firstLine = "1";
        String secondLine = "1 1";
        String prevLine = "";
        int[] numPrevArrTest = Arrays
                .stream(secondLine.split(" "))
                .mapToInt(e -> Integer.parseInt(e))
                .toArray();

        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                System.out.println(firstLine);
                prevLine = firstLine;
                continue;
            } else if (i == 2) {
                System.out.println(secondLine);
                prevLine = secondLine;
                continue;
            }

            int[] numCurrArr = new int[i];
            int [] numPrevArr = Arrays
                                .stream(prevLine.split(" "))
                                .mapToInt(e -> Integer.parseInt(e))
                                .toArray();

            numCurrArr[0] = 1;
            for (int j = 1; j < numCurrArr.length - 1; j++) {
                numCurrArr[j] = numPrevArr[j-1] + numPrevArr[j];
            }
            numCurrArr[numCurrArr.length-1] = 1;

            prevLine = "";
            for (int j : numCurrArr) {
                System.out.print(j + " ");
                if (prevLine.length() == 0) {
                    prevLine = Integer.toString(j);
                } else {
                    prevLine = prevLine + " " + j;
                }
            }
            System.out.println();
        }
    }
}
