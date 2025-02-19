package Week1_Multidimensional_Arrays.Exer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringMatrixRotation_06 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<StringBuilder> linesList = new ArrayList<>();

        int rotation = normalizeInput(Integer.parseInt(scan.nextLine().split("[()]")[1]));

        int lineLength = 0;

        String input = scan.nextLine();
        while (!input.equals("END")) {
            linesList.add(new StringBuilder(input));
            if (linesList.getLast().length() > lineLength) {
                lineLength = linesList.getLast().length();
            }
            input = scan.nextLine();
        }

        char[][] inputMatr = new char[linesList.size()][lineLength];

        for (int i = 0; i < linesList.size(); i++) {
            int curLineTxtLen = linesList.get(i).length();
            for (int j = 0; j < lineLength - curLineTxtLen; j++) {
                linesList.get(i).append(" ");
            }
            linesList.get(i).getChars(0, linesList.get(i).length(), inputMatr[i], 0);
        }

        switch (rotation) {
            case 0 -> printRotation0(inputMatr);
            case 90 -> printRotation90(inputMatr);
            case 180 -> printRotation180(inputMatr);
            case 270 -> printrotation270(inputMatr);
        }
    }

    private static void printrotation270(char[][] inputMatr) {
        for (int i = inputMatr[0].length - 1; i >= 0; i--) {
            for (int j = 0; j <  inputMatr.length; j++) {
                System.out.print(inputMatr[j][i]);
            }
            System.out.println();
        }
    }

    private static void printRotation180(char[][] inputMatr) {
        for (int i = inputMatr.length - 1; i >= 0; i--) {
            for (int j = inputMatr[0].length - 1; j >=  0; j--) {
                System.out.print(inputMatr[i][j]);
            }
            System.out.println();
        }
    }

    private static void printRotation90(char[][] inputMatr) {
        for (int i = 0; i < inputMatr[0].length; i++) {
            for (int j = inputMatr.length -1 ; j >=  0; j--) {
                System.out.print(inputMatr[j][i]);
            }
            System.out.println();
        }
    }

    private static void printRotation0(char[][] matrix) {
        for (char [] cArr: matrix) {
            for (char c : cArr) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    private static int normalizeInput(int degrees) {
        if (degrees > 270) {
            return degrees % 360;
        }
        return degrees;
    }
}
