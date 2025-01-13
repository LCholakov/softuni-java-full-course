package Week9_Bitwise_And_Text_Processing.Lab;

import java.util.Scanner;

public class RepeatStrings_02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] strArr = scan.nextLine().split(" ");

        String output = "";

        for (String w : strArr) {
            for (int i = 0; i < w.length(); i++) {
                output = output + w;
            }
        }

        System.out.println(output);
    }
}
