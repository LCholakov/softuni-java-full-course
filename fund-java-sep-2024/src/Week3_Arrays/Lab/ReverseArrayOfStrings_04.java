package Week3_Arrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class ReverseArrayOfStrings_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strArr = scanner.nextLine().split(" ");

        for (int i = 0; i < strArr.length / 2; i++) {
            String temp = strArr[i];
            strArr[i] = strArr[strArr.length - 1 - i];
            strArr[strArr.length - 1 - i] = temp;
        }
        for (String s : strArr) {
            System.out.print(s + " ");
        }
    }
}
