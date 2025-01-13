package Week8_Maps_Lambda_Stream.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class WordFilter_04 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] strArr = Arrays.stream(scan.nextLine().split(" "))
                                    .filter(w -> w.length() % 2 == 0)
                                    .toArray(String[]::new);
        for (int i = 0; i < strArr.length; i++) {
            System.out.println(strArr[i]);
        }
    }
}
