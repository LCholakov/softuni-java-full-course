package Week3_Arrays.More;

import java.util.Arrays;
import java.util.Scanner;

public class EncryptSortAndPrintArray_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int [] sumArr = new int[n];
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            for (int j = 0; j < input.length(); j++) {
                char c = input.charAt(j);
                if (c == 'A' || c == 'a' ||
                    c == 'E' || c == 'e' ||
                    c == 'I' || c == 'i' ||
                    c == 'O' || c == 'o' ||
                    c == 'U' || c == 'u') {
                    sumArr[i] += c * input.length();
//                    System.out.print(c + " = " + (int) c + " => ");
//                    System.out.println(c * input.length());
                } else {
                    sumArr[i] += c / input.length();
//                    System.out.print(c + " = " + (int) c + " => ");
//                    System.out.println(c / input.length());
                }
            }
        }
        Arrays.sort(sumArr);
        for (int i : sumArr) {
            System.out.println(i);
        }
    }
}
