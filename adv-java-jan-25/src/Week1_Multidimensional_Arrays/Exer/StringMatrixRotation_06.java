package Week1_Multidimensional_Arrays.Exer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class StringMatrixRotation_06 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<StringBuilder> linesList = new ArrayList<>();

        String cmd = scan.nextLine();
        int lineLength = 0;

        String input = scan.nextLine();
        while (!input.equals("END")) {
            linesList.add(new StringBuilder(input));
            if (linesList.getLast().length() > lineLength) {
                lineLength = linesList.getLast().length();
            }
            input = scan.nextLine();
        }

        char[][] cMatr = new char[linesList.size()][lineLength];

        for (int i = 0; i < linesList.size(); i++) {
            for (int j = 0; j < lineLength - linesList.get(i).length(); j++) {
                linesList.get(i).append(" ");
            }
            linesList.get(i).getChars(0, linesList.get(i).length(), cMatr[i], 0);
        }

        for (char [] c: cMatr) {
            System.out.println(Arrays.toString(c).replace("[\\[\\],]", ""));
        }

        System.out.println();
    }
}
