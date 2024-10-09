package Week3_Arrays.Exer;

import java.util.Scanner;

public class CommonElements_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String [] strArr1 = scanner.nextLine().split(" ");
        String [] strArr2 = scanner.nextLine().split(" ");

        for (String s1 : strArr2) {
            for (String s2 : strArr1) {
                if (s1.equals(s2))
                    System.out.print(s1 + " ");
            }
        }
    }
}
