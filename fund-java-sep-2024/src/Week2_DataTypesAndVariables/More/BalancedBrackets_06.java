package Week2_DataTypesAndVariables.More;

import java.util.Scanner;

public class BalancedBrackets_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int openCount = 0;
        int closedCount = 0;
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            if(input.length() == 1 && input.charAt(0) == '(') {
                ++openCount;
            } else if (input.length() == 1 && input.charAt(0) == ')') {
                ++closedCount;
            }
            if (openCount > 1 || closedCount > 1 || closedCount > openCount) {
                break;
            }
            if (openCount == 1 && closedCount == 1) {
                openCount = 0;
                closedCount = 0;
            }
        }

        if (openCount == 0 && closedCount == 0) {
            System.out.println("BALANCED");
        } else {
            System.out.println("UNBALANCED");
        }
    }
}
